package country.code.movieinfoservice.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class Dbconfig {

	
	@Bean
	public DataSource dataSource() {
		DataSourceBuilder source = DataSourceBuilder.create();
		source.driverClassName("com.mysql.cj.jdbc.Driver");
		source.url("jdbc:mysql://localhost/pictureparadise");
		source.username("root");
		source.password("xxxx");
		return source.build();
	}
	
	@Bean
	@DependsOn("dataSource")
	public JdbcTemplate getTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
}
