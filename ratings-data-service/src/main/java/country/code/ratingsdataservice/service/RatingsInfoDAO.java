package country.code.ratingsdataservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import country.code.ratingsdataservice.entity.RatingsInfo;

@Service
public class RatingsInfoDAO {

	
	@Autowired
	JdbcTemplate jdbc;
	
	public List<RatingsInfo> getRatingsforUserName(String userId){
		return this.jdbc.query("select movieId,ratings from ratings_info where userName = ?",new String[] {userId}, new RatingsInfoResultSetExtractor());
	}
}
