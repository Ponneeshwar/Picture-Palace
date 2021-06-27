package country.code.ratingsdataservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import country.code.ratingsdataservice.entity.RatingsInfo;

@RestController
@RequestMapping("/catalog")
public class RatingsController {
	
	@Autowired
	RatingsInfoDAO dao;
	
	@GetMapping("/ratings")
	public List<RatingsInfo> getRatingsforUserName(@RequestParam("userId") String userId){
		return dao.getRatingsforUserName(userId);
	}
}
