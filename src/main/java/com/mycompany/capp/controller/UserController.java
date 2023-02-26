package com.mycompany.capp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.capp.command.UserCommand;
import com.mycompany.capp.domain.User;
import com.mycompany.capp.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping(value = { "/", "/login" })
	public String loginForm() {
		return "login";

	}

	@PostMapping(value = { "/login-action" })
	public String loginAction(@RequestParam String userName, @RequestParam String password, Model m,HttpSession session) {

		User u = userService.login(userName, password);
		if (u == null) {
			m.addAttribute("err", "User Not Exist,Please Enter Vailed User.");
			return "login";// back to login from
		} else {
			if(u.getLoginStatus()==userService.LOGIN_STATUS_ACTIVE) {
				//active
				
				
				session.setAttribute("userId", u.getUserId());
				session.setAttribute("role", u.getRole());
				session.setAttribute("user", u);
				
				
				if(u.getRole()==userService.ROLE_USER) {
					return "redirect:user/dashboard";
				}
				else if(u.getRole()==userService.ROLE_ADMIN) {
					return "redirect:admin/dashboard";
				}
				else {
					m.addAttribute("err", "Unexcepted Role.Please Contact to admin.");
					return "login";//back to login page
				}
			}
			else {
				//blocked
				m.addAttribute("err", "Your Account is blocked,Please contact to admin");
			}
			return "login";// Dashboard
		}
	}

	@GetMapping(value = { "/register-form" })
	public String regForm(Model m) {
		m.addAttribute("ucmd", new UserCommand());
		return "reg_form";// page
	}

	@GetMapping(value = { "/register-action" })
	public String register(@ModelAttribute("ucmd") UserCommand cmd, Model m) {
		if (cmd.getTnc()) {
			try {
				User user = cmd.getUser();
				user.setRole(userService.ROLE_USER);
				user.setLoginStatus(userService.LOGIN_STATUS_ACTIVE);
				userService.register(user);
			} catch (Exception e) {
				e.printStackTrace();
				m.addAttribute("err", "Fail to register User.Please try Again");
				return "reg_form";
			}
		} else {
			// tnc denied
			m.addAttribute("err", "Please Agree With Terms And Condition.");
			return "reg_form";
		}
		return "redirect:login?act=reg";// TODO
	}
	
	@GetMapping(value = { "/logout" })
	public String regForm(HttpSession session) {
		session.invalidate();
		return "redirect:login?act=lo";// home
	}
	
	@GetMapping(value = { "/user/dashboard" })
	public String userDashboard(HttpSession session) {
		return "user_dashboard";// html
	}
	
	@GetMapping(value = { "/admin/dashboard" })
	public String adminDashboard(HttpSession session) {
		return "admin_dashboard";// html
	}

}
