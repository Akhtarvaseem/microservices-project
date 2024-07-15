package com.micro.userservice.feignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.micro.userservice.entity.Hotel;

@FeignClient(name="MICROSERVICES-HOTEL")
public interface HotelFeignService {
	
	
	@GetMapping("hotels/getBy/{id}")
   Hotel getHotel(@PathVariable int id);	
	
	
	@PostMapping("hotels/save")
	Hotel saveHotel(Hotel hotel);

}
