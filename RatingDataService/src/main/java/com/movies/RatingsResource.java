package com.movies;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratingdata")
public class RatingsResource {
 
 @RequestMapping("/{movieId}")
 public Rating getRating(@PathVariable("movieId") String movieId) {
  return new Rating(movieId, 4);

}
 @RequestMapping("users/{userId}")
 public UserRating getUserRating(@PathVariable("userId") String userId) {
  List<Rating> ratings = Arrays.asList(
		  new Rating("1234", 4),
		  new Rating("123456", 4));
  UserRating userRating = new UserRating();
  userRating.setUserRating(ratings);
  return userRating;
 }}
 
