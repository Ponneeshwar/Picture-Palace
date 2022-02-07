package country.code.moviecatalogservice.services;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import country.code.moviecatalogservice.model.MovieCatalog;
import country.code.moviecatalogservice.model.MovieCatalogResponse;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {
	
	@Autowired
	public RestTemplate restTemplate;
	
	@Value("${infoServiceUrl}")
	private String infoServiceUrl;
	
	@Value("${ratingServiceUrl}")
	private String ratingServiceUrl;
	
	@GetMapping("/{userId}")
	public MovieCatalogResponse getCatalogList(@PathVariable("userId") String userId){
		
		MovieCatalogResponse response = new MovieCatalogResponse();
		
		//Getting value from Ratings Info Service
		ResponseEntity<MovieCatalog[]> ratingResp = restTemplate.getForEntity(ratingServiceUrl+userId, MovieCatalog[].class);
		StringBuilder movieIdsList = new StringBuilder();
		Map<Integer,Integer> ratingMap= new HashMap<Integer, Integer>();
		Arrays.asList(ratingResp.getBody()).forEach(a -> {
			movieIdsList.append(a.getMovieId()).append(",");
			ratingMap.put(a.getMovieId(),a.getRatings());
			});
		
		if (StringUtils.hasText(movieIdsList)) { 
			movieIdsList.deleteCharAt(movieIdsList.length()-1);
			System.out.println(movieIdsList);
		}
		else {
			System.out.println("User has not rated any movies.");
			response.setMessage("User has not rated any movies.");
			return response;
		}
		
		//Getting value from Movie Details Service
		ResponseEntity<MovieCatalog[]> infoResp = restTemplate.getForEntity(infoServiceUrl+movieIdsList, MovieCatalog[].class);
		
		//Combining data from both services.
		Arrays.asList(infoResp.getBody()).forEach(a -> {
			a.setRatings(ratingMap.get(a.getMovieId()));
		});
		
		response.setMessage("Success");
		response.setResponse(Arrays.asList(infoResp.getBody()));
		return response;
	}
}
