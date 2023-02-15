package com.mycompany.capp.service;

import java.util.List;

import com.mycompany.capp.domain.Contact;

/**
 * This interface declares user-cases or business logic contact entity
 * 
 * @author amanm
 *
 */
public interface ContactService {
	public void save(Contact c);

	public void update(Contact c);

	public void delete(Integer cId);

	public void bulkDelete(Integer[] cId);

	/**
	 * find contact in given userId based on input text
	 * 
	 * @param uId logged in user
	 * @param txt input free text
	 * @return
	 */

	public List<Contact> search(Integer uId, String txt);

	/**
	 * find all contact of logged in user
	 * 
	 * @param uId
	 * @return
	 */
	public List<Contact> findUserContact(Integer uId);

	public Contact findById(Integer cId);

}
