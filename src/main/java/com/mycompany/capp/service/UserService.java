package com.mycompany.capp.service;

import com.mycompany.capp.domain.User;
/**
 * This interface declares user-cases or business logic for User entity
 * @author aman
 *
 */
public interface UserService {
	
	
	public static final Integer ROLE_ADMIN=1;
	public static final Integer ROLE_USER=2;
	
	
	public static final Integer LOGIN_STATUS_ACTIVE=1;
	public static final Integer LOGIN_STATUS_BLOCK=2;
	
	
	/**
	 * register a new user in application
	 * @param u
	 */
	public void register(User u);

	/**
	 * This method authenticate the user based on input credential if success return
	 * user object .If failed then return null.
	 * 
	 * @param userName unique user name
	 * @param password to validate
	 * @return null or user
	 */
	public User login(String userName, String password);
	/**
	 * Update user profile
	 * @param u u contain updated value of an object
	 * @return
	 */
	public void editProfile(User u);
	/**
	 * change the user login Status active or block
	 * @param uId
	 * @param newStatus active:1 or block:2
	 */
	public void changeLoginStatus(Integer uId,Integer newStatus);
	
}
