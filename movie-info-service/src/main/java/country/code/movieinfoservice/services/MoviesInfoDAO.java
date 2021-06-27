package country.code.movieinfoservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import country.code.movieinfoservice.entity.MovieDetails;


@Service
public class MoviesInfoDAO {

	
	@Autowired
	JdbcTemplate jdbc;
	
	public List<MovieDetails> getMovieDeatils(String movieIds){
		return this.jdbc.query("select * from movies_info where movieId in ("+movieIds+")", new MoviesInfoResultSetExtractor());
	}
}
