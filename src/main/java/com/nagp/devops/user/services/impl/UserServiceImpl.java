package com.nagp.devops.user.services.impl;

import com.nagp.devops.user.entities.User;
import com.nagp.devops.user.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private RestTemplate restTemplate;

	@Override
    public List<User> get() {
		final String baseUrl = "http://backend-clusterip-service:8041/";
		final ResponseEntity<List<User>> fetchedUsers = restTemplate.exchange(baseUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<User>>() {
				});
		return fetchedUsers.getBody();
    }

}
