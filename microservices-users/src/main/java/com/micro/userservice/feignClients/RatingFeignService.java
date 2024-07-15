package com.micro.userservice.feignClients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.micro.userservice.entity.Rating;
import com.micro.userservice.entity.User;

@FeignClient(name="MICROSERVICES-RATING")
public interface RatingFeignService {

	@GetMapping("ratings/ByUserId/{id}")
	 List<Rating> getRating(@PathVariable int id);
	
	@PatchMapping("ratings/updateRatingByPatch")
	ResponseEntity<?>  updateRatingByPatch(@RequestBody Rating ratings);
}
