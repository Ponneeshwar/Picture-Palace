package country.code.ratingsdataservice.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import country.code.ratingsdataservice.entity.RatingsInfo;

public class RatingsInfoResultSetExtractor implements ResultSetExtractor<List<RatingsInfo>> {

	@Override
	public List<RatingsInfo> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<RatingsInfo> ratingslist = new ArrayList<RatingsInfo>();
		while(rs.next()) {
			RatingsInfo ratings = new RatingsInfo();
			ratings.setMovieId(rs.getInt("movieId"));
			ratings.setRatings(rs.getInt("ratings"));
			ratingslist.add(ratings);
		}
		return ratingslist;
	}

}
