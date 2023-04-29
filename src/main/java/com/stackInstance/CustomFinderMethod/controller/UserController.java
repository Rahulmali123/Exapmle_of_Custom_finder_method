package com.stackInstance.CustomFinderMethod.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackInstance.CustomFinderMethod.model.User;
import com.stackInstance.CustomFinderMethod.service.UserService;

@RestController
@RequestMapping("/api/user/")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("/")
	public ResponseEntity<User> createUserNew(@RequestBody User user) {
		userService.createUser(user);

		return new ResponseEntity<User>(HttpStatus.CREATED);
	}

	@GetMapping("/getall/")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = userService.getAllUsers();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	@GetMapping("/getByid/{id}")
	public ResponseEntity<Optional<User>> getByid(@PathVariable("id") int id) {
		Optional<User> userid = userService.getByid(id);
		return new ResponseEntity<Optional<User>>(userid, HttpStatus.OK);

	}

	@GetMapping("/get/by/city/{city}")
	public ResponseEntity<List<User>> getByUserCityName(@PathVariable("city") String city) {
		List<User> userByCity = userService.getUserByCity(city);
		return new ResponseEntity<List<User>>(userByCity, HttpStatus.OK);
	}

	@GetMapping("/get/by/ageshow/{age}")
	public ResponseEntity<List<User>> getUserByAges(@PathVariable("age") int age) {
		List<User> userByAge = userService.getUserByAge(age);
		return new ResponseEntity<List<User>>(userByAge, HttpStatus.OK);
	}

	@GetMapping("/get/by/passshow/{pass}")
	public ResponseEntity<List<User>> getUserByAges(@PathVariable("pass") String pass) {
		List<User> userByPass = userService.getUserByPass(pass);
		return new ResponseEntity<List<User>>(userByPass, HttpStatus.OK);
	}

	@GetMapping("/get/by/phNumshow/{phNum}")
	public ResponseEntity<List<User>> getUserByPhone(@PathVariable("phNum") String phNum) {
		List<User> userByPhone = userService.getUserByphNum(phNum);
		return new ResponseEntity<List<User>>(userByPhone, HttpStatus.OK);
	}

	@GetMapping("/get/by/phNumshow/{firstname}/{lastname}")
	public ResponseEntity<List<User>> getUserByfirstnameAndlastnames(@PathVariable("firstname") String firstname,
			@PathVariable("lastname") String lastname) {
		List<User> userByfirstnameAndlastname = userService.getUserByfirstnameAndlastname(firstname, lastname);
		return new ResponseEntity<List<User>>(userByfirstnameAndlastname, HttpStatus.OK);
	}

	@GetMapping("/get/by/phNumshowOr/{firstname}/{lastname}")
	public ResponseEntity<List<User>> getUserByfirstnameORlastnames(@PathVariable("firstname") String firstname,
			@PathVariable("lastname") String lastname) {
		List<User> userByfirstnameAndlastname = userService.findUsersByFirstnameOrLastname(firstname, lastname);
		return new ResponseEntity<List<User>>(userByfirstnameAndlastname, HttpStatus.OK);
	}

	@GetMapping("/getAllUserUsingJPQL")
	public ResponseEntity<List<User>> getAllUserUsingJPQL() {
		List<User> allUserUsingJPQL = userService.getAllUserUsingJPQL();
		return new ResponseEntity<List<User>>(allUserUsingJPQL, HttpStatus.OK);
	}
	
	@GetMapping("/getUserByCityUsingJPQL/{city}")
	public ResponseEntity<List<User>> getUserByCityUsingJPQL(@PathVariable("city") String city) {
		List<User> userByCityUsingJPQL = userService.getUserByCityUsingJPQL(city);
		return new ResponseEntity<List<User>>(userByCityUsingJPQL, HttpStatus.OK);
	}
	
	@GetMapping("/getUserByCityOrfirstnameUsingJPQL/{city}/{firstname}")
	public ResponseEntity<List<User>> getUserByCityOrfirstnameUsingJPQL(@PathVariable("city") String city,@PathVariable("firstname") String firstname) {
		List<User> userByCityOrfirstnameUsingJPQL = userService.getUserByCityOrfirstnameUsingJPQL(city, firstname);
		return new ResponseEntity<List<User>>(userByCityOrfirstnameUsingJPQL, HttpStatus.OK);
	}
	
	
	@GetMapping("/getUserByPassAndAgeUsingJPQL/{city}/{age}")
	public ResponseEntity<List<User>> getUserByPassAndAgeUsingJPQL(@PathVariable("city") String city,@PathVariable("age") int age) {
		List<User> userByPassAndAgeUsingJPQL = userService.getUserByPassAndAgeUsingJPQL(city, age);
		return new ResponseEntity<List<User>>(userByPassAndAgeUsingJPQL, HttpStatus.OK);
	}
	
	@GetMapping("/getUserByFirstnameOrCityOrphNumUsingJPQL/{firstname}/{city}/{phNum}")
	public ResponseEntity<List<User>> getUserByFirstnameOrCityOrphNumUsingJPQL(@PathVariable("firstname") String firstname,@PathVariable("city") String city,@PathVariable("phNum") String phNum) {
		List<User> userByFirstnameOrCityOrphNumUsingJPQL = userService.getUserByFirstnameOrCityOrphNumUsingJPQL(firstname, city, phNum);
		return new ResponseEntity<List<User>>(userByFirstnameOrCityOrphNumUsingJPQL, HttpStatus.OK);
	}
	
	//NativeQuery
	@GetMapping("/getAllUserNativeQuaery")
	public ResponseEntity<List<User>> getAllUserNativeQuaery() {
		List<User> allUserNativeQuaery = userService.getAllUserNativeQuaery();
		return new ResponseEntity<List<User>>(allUserNativeQuaery, HttpStatus.OK);
	}
	
	
	// NativeQuery
	@GetMapping("/findByAllName")
	public ResponseEntity<List<User>> getByAllFirstNameLastName() {
		 List<User> findByAllUserNames = userService.getByAllFirstNameLastName();
		return new ResponseEntity<List<User>>(findByAllUserNames, HttpStatus.OK);
	}

	
}
