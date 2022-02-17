package com.nagp.devops.user.controllers;

import com.nagp.devops.user.entities.User;
import com.nagp.devops.user.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/")
public class UserController {

	@Resource
	UserService userService;

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@GetMapping
	public ResponseEntity<?> getAll() {
		logger.debug("Received request to fetch user details");
		try {
			final List<User> retrievedUser = userService.get();
			logger.info("Retrieved User : {}", retrievedUser);
			return new ResponseEntity<List<User>>(retrievedUser, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
