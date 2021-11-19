package steps;


import com.consol.citrus.http.client.HttpClient;
import com.consol.citrus.http.client.HttpClientBuilder;
import com.consol.citrus.variable.GlobalVariables;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


	@Configuration
	@PropertySource("classpath:citrus.properties")
	public class EndpointConfig {

	    @Bean
	    public GlobalVariables globalVariables() {
	        GlobalVariables variables = new GlobalVariables();
	        variables.getVariables().put("project.name", "Citrus Integration Tests");
	        return variables;
	    }

	    @Bean
	    public HttpClient toEndpoint() {
	        return new HttpClientBuilder()
	                .requestUrl("https://reqres.in/api")
	            .build();
	    }
	}