package country.code.movieinfoservice.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import country.code.movieinfoservice.entity.MovieDetails;

public class MoviesInfoResultSetExtractor implements ResultSetExtractor<List<MovieDetails>> {

	@Override
	public List<MovieDetails> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<MovieDetails> moviesList = new ArrayList<MovieDetails>();
		while(rs.next()) {
			MovieDetails movie = new MovieDetails();
			movie.setMovieId(rs.getInt("movieId"));
			movie.setMovieDesc(rs.getString("movieDescription"));
			movie.setMovieName(rs.getString("movieName"));
			moviesList.add(movie);
		}
		return moviesList;
	}

}
