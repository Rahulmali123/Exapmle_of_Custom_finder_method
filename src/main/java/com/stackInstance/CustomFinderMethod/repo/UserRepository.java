package com.stackInstance.CustomFinderMethod.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stackInstance.CustomFinderMethod.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	public List<User> findByCity(String city);
	
	public List<User> findByAge(int age);
	
	public List<User> findByPass(String pass);
	
	public List<User> findByphNum(String phNum);
	
	List<User> findByFirstnameAndLastname(String firstname, String lastname);
	
	List<User> findByFirstnameOrLastname(String firstname, String lastname);
	
	//find the complex data JPQL NATIVE Quary
	@Query("select u from User u")
	public List<User> getAllUsersUsingJPQL();
	
	//find city using JPQL
	@Query("select u from User u where u.city=:c")
	public List<User> getUserByCityUsingJPQL(@Param("c") String city);
	
	
	//findNameOrcity using JPQL
	@Query("select u from User u where u.city=:c or u.firstname=:n")
	public List<User> getUserByCityOrFirstnameUsingJPQL(@Param("c") String city,@Param("n")String firstname);
	
	//find by Pass and age
	@Query("select u from User u where u.pass=:p And u.age=:a")
	public List<User> getUserByPassAndAgeUsingJPQL(@Param("p") String pass,@Param("a") int age);
	
	//firstname,city,phNum
	@Query("select u from User u where u.firstname=:f or u.city=:c or u.phNum=:p")
	public List<User> getUserByFirstnameOrCityOrphNumUsingJPQL(@Param("f") String firstname,@Param("c")String city,@Param("p")String phNum);
	
	
	//  find the data Using native Quary
	@Query(value = "select * from users",nativeQuery=true)
	public List<User> getAllUserNativeQuaery();
	
//	@Query(value = "SELECT DISTINCT firstname FROM users",nativeQuery=true)
//	public List<User> getAllUserFirstNameNativeQuaery();
	
	@Query(value = "SELECT id, CONCAT(firstname, ' ', lastname) AS name FROM users", nativeQuery = true)
   public  List<User> getByAllFirstNameLastName();
	
	//rahul branch
	
}
