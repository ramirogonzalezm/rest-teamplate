package com.desycom.mx.demoCRUD.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String username;
	private String email;
	private String avatar;	
	
}
