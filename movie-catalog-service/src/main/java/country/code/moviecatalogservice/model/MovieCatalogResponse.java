package country.code.moviecatalogservice.model;

import java.util.List;

public class MovieCatalogResponse {

	private List<MovieCatalog> response;
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<MovieCatalog> getResponse() {
		return response;
	}

	public void setResponse(List<MovieCatalog> response) {
		this.response = response;
	}
	
}
