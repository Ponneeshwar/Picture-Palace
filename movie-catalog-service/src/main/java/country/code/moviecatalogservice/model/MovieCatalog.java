package country.code.moviecatalogservice.model;

public class MovieCatalog {

	private String name;
	private int rating;
	private String description;
	
	public MovieCatalog() {
		
	}
	
	public MovieCatalog(String name, int rating, String description) {
		super();
		this.name = name;
		this.rating = rating;
		this.description = description;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
