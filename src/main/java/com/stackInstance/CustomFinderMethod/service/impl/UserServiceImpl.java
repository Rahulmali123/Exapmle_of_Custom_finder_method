package com.stackInstance.CustomFinderMethod.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackInstance.CustomFinderMethod.model.User;
import com.stackInstance.CustomFinderMethod.repo.UserRepository;
import com.stackInstance.CustomFinderMethod.service.UserService;
@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserRepository userRepository;

	@Override
	public User createUser(User user) {
		User save = userRepository.save(user);
		return save;
		
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = userRepository.findAll();
		return users;
	}
	
	public Optional<User> getByid(int id)
	{
		Optional<User> optional = userRepository.findById(id);
		return optional;
	}

	@Override
	public List<User> getUserByCity(String city) {
		List<User> findByCity = userRepository.findByCity(city);
		return findByCity;
	}

	@Override
	public List<User> getUserByAge(int age) {
		List<User> findByAge = userRepository.findByAge(age);
		
		return findByAge;
	}

	@Override
	public List<User> getUserByPass(String pass) {
		List<User> findByPass = userRepository.findByPass(pass);
		
		return findByPass;
	}

	@Override
	public List<User> getUserByphNum(String phNum) {
		List<User> findByphone = userRepository.findByphNum(phNum);
		return findByphone;
	}

	@Override
	public List<User> getUserByfirstnameAndlastname(String firstname, String lastname)
	{
		List<User> findByFirstnameAndLastname = userRepository.findByFirstnameAndLastname(firstname, lastname);
		return findByFirstnameAndLastname;
	}

	@Override
	public List<User> findUsersByFirstnameOrLastname(String firstname, String lastname) {
		List<User> findByFirstnameORLastname = userRepository.findByFirstnameOrLastname(firstname, lastname);
		return findByFirstnameORLastname;
	}

	@Override
	public List<User> getAllUserUsingJPQL() 
	{
		return userRepository.getAllUsersUsingJPQL();
	}

	@Override
	public List<User> getUserByCityUsingJPQL(String city)
	{
		List<User> userByCityUsingJPQL = userRepository.getUserByCityUsingJPQL(city);
		return userByCityUsingJPQL;
	}

	@Override
	public List<User> getUserByCityOrfirstnameUsingJPQL(String city, String firstname) {
		List<User> userByCityOrFirstnameUsingJPQL = userRepository.getUserByCityOrFirstnameUsingJPQL(city, firstname);
		return userByCityOrFirstnameUsingJPQL;
	}

	@Override
	public List<User> getUserByPassAndAgeUsingJPQL(String city, int age) {
		List<User> userByPassAndAgeUsingJPQL = userRepository.getUserByPassAndAgeUsingJPQL(city, age);
		return userByPassAndAgeUsingJPQL;
	}

	@Override
	public List<User> getUserByFirstnameOrCityOrphNumUsingJPQL(String firstname, String city, String phNum) {
		List<User> userByFirstnameOrCityOrphNumUsingJPQL = userRepository.getUserByFirstnameOrCityOrphNumUsingJPQL(firstname, city, phNum);
		return userByFirstnameOrCityOrphNumUsingJPQL;
	}

	@Override
	public List<User> getAllUserNativeQuaery() {
		List<User> allUserNativeQuaery = userRepository.getAllUserNativeQuaery();
		return allUserNativeQuaery;
	}

	@Override
	public List<User> getByAllFirstNameLastName() {
		List<User> findByAllName = userRepository.getByAllFirstNameLastName();
		return findByAllName;
	}
	


	

}
