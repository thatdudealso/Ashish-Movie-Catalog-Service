package com.movies;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
		
		
		// get all rated movies ids
		UserRating ratings  = restTemplate.getForObject("http://Rating-Data-Service/ratingdata/users/" +userId, UserRating.class);
		
		return ratings.getUserRating().stream().map(rating -> {
			// for each movie ID, call movie info service and get details

			Movie movie = restTemplate.getForObject("http://Movie-Info-Service/movies/" + rating.getMovieId(), Movie.class);
			// Put them all together
			return new CatalogItem( movie.getName(),  "Test1234", rating.getRating());
				

		})
			.collect(Collectors.toList());
		
		
		// Put them all together
		
		
	}

}



//Movie movie = webClientBuilder.build()
//.get()
//.uri("http://localhost:8082/movies/" + rating.getMovieId())
//.retrieve()
//.bodyToMono(Movie.class)
//.block();