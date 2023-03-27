package com.kltn.api.service;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.kltn.api.entity.Role;
import com.kltn.api.entity.User;

public interface AuthService {
	 List<User> getUsers();

	
	    Map<String, String> authenticateUser(ObjectNode userData);
	    Map<String, String> getNewToken(String refreshToken);

		




	


		Map<String, String> registerUser(User userRegister);
}
