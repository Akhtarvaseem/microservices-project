package com.micro.userservice.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.micro.userservice.customException.UserNotFound;
import com.micro.userservice.entity.Hotel;
import com.micro.userservice.entity.Rating;
import com.micro.userservice.entity.User;
import com.micro.userservice.feignClients.HotelFeignService;
import com.micro.userservice.feignClients.RatingFeignService;
import com.micro.userservice.repo.UserRepository;
import com.netflix.discovery.converters.Auto;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	@Autowired
	private RestTemplate template;

	
	@Autowired
	private HotelFeignService feignService;
	
	@Autowired
	private RatingFeignService feignService2;
	
	
	
// insert into database
	public User saveUser(User user) {
		List<Rating> hotelRating = new ArrayList<>();

		List<Hotel> hotel = new ArrayList<>();

//		here save user 
		User user1 = repo.save(user);

//		getting 
		if ((user.getRating()) != null) {

			for (Rating rating : user.getRating()) {

				hotelRating.add(rating);
				hotel.add(rating.getHotel());
			}
		}

		if (!hotelRating.isEmpty() && !hotel.isEmpty()) {

			for (Rating rating1 : hotelRating) {

				Hotel hotel2 = rating1.getHotel();

				if (hotel2 != null) {
					
                      /*USING REST TEMPLET*/
//					ResponseEntity<Hotel> hotelEntity = template.postForEntity("http://MICROSERVICES-HOTEL/hotel/save",
//							hotel2, Hotel.class);
//
//					rating1.setHotelId(hotelEntity.getBody().getHotelId());
//					rating1.setHotel(hotelEntity.getBody());
					
				    /*USING FEIGN CLIENTS*/
					
					Hotel saveHotel = feignService.saveHotel(hotel2);
					rating1.setHotelId(saveHotel.getHotelId());
					rating1.setHotel(saveHotel);
					

				}
				rating1.setUserId(user1.getUserId());
				ResponseEntity<Rating> ratingEntity = template.postForEntity("http://MICROSERVICES-RATING/ratings/save",
						rating1, Rating.class);

			}

		}

		return user1;

	}

	// USING REST-TEMPLET
	public User fetchByid(int id) {
		User user = repo.findById(id).orElseThrow(() -> new UserNotFound("User not found. Please ! enter correct id"));

//		http://localhost:8083/rating/ByUserId/1
// 	HERE CALLING ALL RATING BY USER ID 
//		List user2=template.getForObject("http://localhost:8083/rating/ByUserId/1", ArrayList.class);   // static

		
		
		/*USING RESTTEMPLET */
//		Rating[] rat = template.getForObject("http://MICROSERVICES-RATING/rating/ByUserId/" + user.getUserId(),
//				Rating[].class); // dynamic
//
//		List<Rating> listUser = Arrays.asList(rat);
		
		
		 List<Rating> listUser = feignService2.getRating(user.getUserId());
		
//		System.out.println(listUser);
		
		// Calling two Micro services localhost:8082/hotel/getBy/1
		 
		for (Rating rating : listUser) {
            
			   /*USING REST TEMPLET*/
			
//			ResponseEntity<Hotel> forEntity = template
//					.getForEntity("http://MICROSERVICES-HOTEL/hotel/getBy/" + rating.getHotelId(), Hotel.class);
//			Hotel hotel = forEntity.getBody();
			
			
			   /*USING FEIGN CLIENTS*/
			Hotel hotel = feignService.getHotel(rating.getHotelId());
			
			System.out.println(hotel);

			rating.setHotel(hotel);

		}

//		SETTING ALL RATING IN USER 
		user.setRating(listUser);
		return user;
	}

//  deleting user from user list
	public boolean deleteUser(int id) {

		User user = repo.findById(id).orElseThrow(() -> new UserNotFound("sorry ! id missing "));

		if (user != null) {

			template.delete("http://MICROSERVICES-RATING/ratings/deleteUserById/" + user.getUserId());

			repo.delete(user);

			return true;
		}
		return false;
	}

	// delete rating by user

	public boolean deleteUsersRating(int id) {

		User user = repo.findById(id).orElseThrow(() -> new UserNotFound("sorry ! id missing "));

		if (user != null) {

			template.delete("http://MICROSERVICES-RATING/ratings/deleteUserById/" + user.getUserId());
			return true;
		}
		return false;
	}

	
	
	
	// update rating using rating id and throw user id
	public boolean updateRatingByUser(User user) {
		List<Rating> rating = user.getRating();

		if (user != null || !rating.isEmpty()) {

			for (Rating rating2 : rating) {

				template.put("http://MICROSERVICES-RATING/ratings/updateRating", rating2);
				
					
				
			}

			return true;
		}
		return false;

	}
	
	
	// update rating using rating id and throw user id  By Patching 
	public boolean updateRatingByUserPatch(User user) {
		List<Rating> rating = user.getRating();
		
		if (user != null || !rating.isEmpty()) {
			
			for (Rating rating2 : rating) {
				
//				RESTTEMPLET 
//				template.patchForObject("http://MICROSERVICES-RATING/ratings/updateRatingByPatch", rating2, Rating.class);
				
				feignService2.updateRatingByPatch(rating2);
				
			}
			
			return true;
		}
		return false;
		
	}

	public List<User> getAllUser() {
		return repo.findAll();

	}
}
