package com.stackInstance.CustomFinderMethod.service;

import java.util.List;
import java.util.Optional;

import com.stackInstance.CustomFinderMethod.model.User;

public interface UserService
{
	public User createUser(User user);
	
	List<User> getAllUsers();
	
	public Optional<User> getByid(int id);
	
	public List<User> getUserByCity(String city);
	
	public List<User> getUserByAge(int age);
	
	public List<User> getUserByPass(String pass);
	
	public List<User> getUserByphNum(String phNum);
	
	public List<User> getUserByfirstnameAndlastname(String firstname,String lastname);
	
	public List<User> findUsersByFirstnameOrLastname(String firstname,String lastname);
	
	public List<User> getAllUserUsingJPQL();
	
	public List<User> getUserByCityUsingJPQL(String city);
	
	public List<User> getUserByCityOrfirstnameUsingJPQL(String city,String firstname);
	
	public List<User> getUserByPassAndAgeUsingJPQL(String city,int age);
	
	public List<User> getUserByFirstnameOrCityOrphNumUsingJPQL(String firstname,String city,String phNum);

	public List<User> getAllUserNativeQuaery();
	
	public List<User> getByAllFirstNameLastName();
	
}
