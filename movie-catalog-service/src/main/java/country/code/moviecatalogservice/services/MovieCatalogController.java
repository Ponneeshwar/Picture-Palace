package country.code.moviecatalogservice.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import country.code.moviecatalogservice.model.MovieCatalog;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {
	
	@GetMapping("/{userId}")
	public List<MovieCatalog> getCatalogList(@PathVariable("userId") String userId){
		List<MovieCatalog> response =  new ArrayList<MovieCatalog>();
		response.add(new MovieCatalog("Seven pounds", 9, "Eternity is in giving away."));
		response.add(new MovieCatalog("Swadesi", 9, "Let the change start from home."));
		
		return response;
	}
}
