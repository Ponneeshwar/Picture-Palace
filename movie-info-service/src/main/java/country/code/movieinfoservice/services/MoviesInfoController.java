package country.code.movieinfoservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import country.code.movieinfoservice.entity.MovieDetails;


@RestController
@RequestMapping("/catalog")
public class MoviesInfoController {
	
	@Autowired
	MoviesInfoDAO dao;
	
	@GetMapping("/movieInfo")
	public List<MovieDetails> getRatingsforUserName(@RequestParam("movieIds") String movieIds){
		return dao.getMovieDeatils(movieIds);
	}
}
