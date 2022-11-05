package com.desycom.mx.demoCRUD.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.desycom.mx.demoCRUD.model.UserDTO;

@Service
public class UserService {
	
	@Value("${spring.external.service.base-url}")
	private String basePath;
	
	@Autowired
	public RestTemplate restTemplate;
	
	public List<UserDTO> getUsers(){
		UserDTO[] response =  restTemplate.getForObject(basePath+"users", UserDTO[].class);
		return Arrays.asList(response);
	}
	
	public void saveUser(UserDTO user) {
		restTemplate.postForObject(basePath+"users", user, UserDTO.class);		
	}
	
	public void updateUser(Integer id, UserDTO userDTO) {
		restTemplate.put(basePath+"users/"+id, userDTO);
	}
	
	public void deleteUser(Integer id) {
		restTemplate.delete(basePath+"users/"+id);
	}

}
