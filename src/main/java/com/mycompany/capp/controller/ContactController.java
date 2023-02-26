package com.mycompany.capp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.capp.domain.Contact;
import com.mycompany.capp.service.ContactService;

@Controller
public class ContactController {

	@Autowired
	ContactService contactService;

	@GetMapping("/user/contact-form")
	public String contactForm(Model m) {
		m.addAttribute("contact", new Contact());

		return "contact_form";// html
	}

	@PostMapping("/user/save-contact")
	public String contactSave(@ModelAttribute Contact c, HttpSession session) {
		Integer id = (Integer) session.getAttribute("userId");
		c.setUserId(id);
		if (c.getContactId() == null) {
			//save
			contactService.save(c);
			return "redirect:/user/contact-list?act=sv";
		}
		else {
			//update
			contactService.update(c);
			return "redirect:/user/contact-list?act=ed";
		}
	}

	@GetMapping("/user/contact-list")
	public String contactList(Model m, HttpSession session) {
		Integer id = (Integer) session.getAttribute("userId");
		m.addAttribute("contactList", contactService.findUserContact(id));
		return "contact_list";// html
	}

	@GetMapping("/user/contact/delete/{contactId}/")
	public String deleteContact(@PathVariable Integer contactId) {
		contactService.delete(contactId);
		return "redirect:/user/contact-list?act=del";

	}

	@GetMapping("/user/contact/edit-from/{contactId}/")
	public String editContact(@PathVariable Integer contactId, Model m) {
		m.addAttribute("contact", contactService.findById(contactId));

		return "contact_form";// html
	}
	
	@GetMapping("/user/contact/search")
	public String contactSearch(@RequestParam("freeText") String freeText ,Model m, HttpSession session) {
		Integer id = (Integer) session.getAttribute("userId");
		m.addAttribute("contactList", contactService.search(id, freeText));
		return "contact_list";// html
	}
	
	@GetMapping("/user/contact/bulk-delete")
	public String bulkDeleteContact(@RequestParam("cIds") Integer[] contactIds) {
		contactService.bulkDelete(contactIds);
		return "redirect:/user/contact-list?act=del";

	}
}
