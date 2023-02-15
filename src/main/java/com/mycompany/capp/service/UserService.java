package com.mycompany.capp.service;

import com.mycompany.capp.domain.User;
/**
 * This interface declares user-cases or business logic for User entity
 * @author amanm
 *
 */
public interface UserService {
	/**
	 * register a new user in application
	 * 
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
	public User editProfile(User u);
	/**
	 * change the user login Status active or block
	 * @param uId
	 * @param newStatus active:1 or block:2
	 */
	public void changeLoginStatus(Integer uId,Integer newStatus);
	
}
