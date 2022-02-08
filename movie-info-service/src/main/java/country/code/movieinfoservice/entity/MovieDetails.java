package country.code.movieinfoservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movies_info")
public class MovieDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="movieid")
	private Integer movieId;
	@Column(name = "moviename")
	private String movieName;
	@Column(name = "moviedescription")
	private String movieDesc;
	
	
	public Integer getMovieId() {
		return movieId;
	}
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieDesc() {
		return movieDesc;
	}
	public void setMovieDesc(String movieDesc) {
		this.movieDesc = movieDesc;
	}
	
	
}
