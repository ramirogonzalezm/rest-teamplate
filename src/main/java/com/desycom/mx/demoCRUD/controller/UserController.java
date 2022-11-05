package com.desycom.mx.demoCRUD.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.desycom.mx.demoCRUD.model.UserDTO;
import com.desycom.mx.demoCRUD.service.UserService;


@RestController
@RequestMapping("/api/v1/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> getAll(){
		return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void saveUser(@RequestBody UserDTO userDTO) {
		userService.saveUser(userDTO);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateUser(@PathVariable("id") Integer id, @RequestBody UserDTO userDTO) {
		userService.updateUser(id, userDTO);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") Integer id) {
		userService.deleteUser(id);
	}
	

}
