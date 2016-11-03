package org.questionBank.controller;


import javax.servlet.http.HttpServletRequest;

import org.questionBank.dao.InvalidCredentialException;
import org.questionBank.dao.PersonDataUtil;
import org.questionBank.dao.UserAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class PersonController {
	@Autowired
	PersonDataUtil personDataUtil;
	@RequestMapping(value="TeacherSignup",method=RequestMethod.POST)
	public ModelAndView createPerson(HttpServletRequest request,@RequestParam("username") String userName,@RequestParam String password,@RequestParam("firstname") String firstName,@RequestParam String rpassword,@RequestParam("lastname") String lastName){
		ModelAndView modelAndView =  null;
		try {
			personDataUtil.createPerson(userName, password, firstName, rpassword, lastName);
			request.getSession().setAttribute("name", userName);
			modelAndView=new ModelAndView("redirect:teacherdashboard.jsp");
		} catch (InvalidCredentialException | UserAlreadyExistException e) {
			modelAndView=new ModelAndView("redirect:teachersignup.jsp");
			modelAndView.addObject("message", e.getMessage());
		}
		return modelAndView;
	}

	@RequestMapping(value="teacherlogin",method=RequestMethod.POST)
	public ModelAndView teacherLogin(HttpServletRequest request,@RequestParam String username,@RequestParam String password){
		ModelAndView modelAndView =null; 
		try {
			personDataUtil.teacherLogin(username, password);
			request.getSession().setAttribute("name", username);
			modelAndView=new ModelAndView("redirect:teacherdashboard.jsp");
		} catch (InvalidCredentialException e) {
			modelAndView=new ModelAndView("redirect:teacherlogin.jsp");
			modelAndView.addObject("message", e.getMessage());
		}
		return modelAndView;
	}
	@RequestMapping("teachersignout")
	public ModelAndView teachersignout(HttpServletRequest request){
		ModelAndView modelAndView =null; 
		try {
			
			request.getSession().invalidate();
			modelAndView=new ModelAndView("redirect:teacherlogin.jsp");
		} catch (Exception e) {
			modelAndView=new ModelAndView("redirect:teacherlogin.jsp");
			modelAndView.addObject("message", e.getMessage());
		}
		return modelAndView;
	}
	@RequestMapping(value="AdminLogin",method=RequestMethod.POST)
	public ModelAndView adminLogin(HttpServletRequest request,@RequestParam String username,@RequestParam String password){
		ModelAndView modelAndView =null; 
		try {
			personDataUtil.adminLogin(username, password);
			request.getSession().setAttribute("name", username);
			modelAndView=new ModelAndView("redirect:admindashboard.jsp");
		} catch (InvalidCredentialException e) {
			modelAndView=new ModelAndView("redirect:adminlogin.jsp");
			modelAndView.addObject("message", e.getMessage());
		}
		return modelAndView;
	}
}
