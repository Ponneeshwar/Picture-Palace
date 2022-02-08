package country.code.movieinfoservice.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Dbconfig {

	
	@Bean
	public DataSource dataSource() {
		DataSourceBuilder<?> source = DataSourceBuilder.create();
		source.driverClassName("com.mysql.cj.jdbc.Driver");
		source.url("jdbc:mysql://localhost/pictureparadise");
		source.username("root");
		source.password("admin@123");
		return source.build();
	}
	
	/*@Bean
	@DependsOn("dataSource")
	public JdbcTemplate getTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}*/
}
