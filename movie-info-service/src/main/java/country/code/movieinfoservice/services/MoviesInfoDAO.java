package country.code.movieinfoservice.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import country.code.movieinfoservice.entity.MovieDetails;


@Repository
public interface MoviesInfoDAO extends CrudRepository<MovieDetails, Integer>{

	
	public default List<MovieDetails> getMovieDeatils(String movieIds){
		//return this.jdbc.query("select * from movies_info where movieId in ("+movieIds+")", new MoviesInfoResultSetExtractor());
		List<Integer> movies = Stream.of(movieIds.split(",")).map(a-> Integer.valueOf(a)).collect(Collectors.toList());
		List<MovieDetails> result =  new ArrayList<MovieDetails>();
		findAllById(movies).forEach(a->result.add(a));
		return result;
	}
	
	
		@Query(value="select m from MovieDetails m where m.movieId in (?1)")
		List<MovieDetails> findAllByGivenMovieIDs(List<Integer> movies);
}
