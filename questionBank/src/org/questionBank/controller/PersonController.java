package org.questionBank.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class PersonController {

	@RequestMapping(value="/TeacherSignup",method=RequestMethod.POST)
	public ModelAndView createPerson(@RequestParam String username,@RequestParam String password,@RequestParam String firstname,@RequestParam String rpassword,@RequestParam String lastname){
		ModelAndView modelAndView =  null;
		System.out.println("teacher-user="+username +",pass="+password + ",r pass -="+rpassword);
		if(username==null){
			modelAndView=new ModelAndView("/teachersignup");
			modelAndView.addObject("message", "username empty");
			return modelAndView;
		}	
		if(password==null){
			modelAndView=new ModelAndView("/teachersignup");
			modelAndView.addObject("message", "password empty");
			return modelAndView;
		}
		if(firstname==null){
			modelAndView=new ModelAndView("/teachersignup");
			modelAndView.addObject("message", "email empty");
			return modelAndView;
		}	
		if(rpassword==null){
			modelAndView=new ModelAndView("/teachersignup");
			modelAndView.addObject("message", "repeat password empty");
			return modelAndView;
		}
		if(lastname==null){
			modelAndView=new ModelAndView("/teachersignup");
			modelAndView.addObject("message", "contact no empty");
			return modelAndView;
		}
		if(!rpassword.equals(password)){
			modelAndView=new ModelAndView("/teachersignup");
			modelAndView.addObject("message", "password not matching");
			return modelAndView;
		}
		if(!username.equals("teacher")){
			modelAndView=new ModelAndView("/teacherdashboard");
		}else{
			modelAndView=new ModelAndView("/teachersignup");
			modelAndView.addObject("message", "user name not available");
		}
		return modelAndView;
	}

	@RequestMapping(value="/teacherlogin",method=RequestMethod.POST)
	public ModelAndView teacherLogin(@RequestParam String username,@RequestParam String password){
		ModelAndView modelAndView =null; 
		System.out.println("teacher-user="+username +",pass="+password);
		if(username==null){
			modelAndView=new ModelAndView("/teacherlogin");
			modelAndView.addObject("message", "username empty");
			return modelAndView;
		}	
		if(password==null){
			modelAndView=new ModelAndView("/teacherlogin");
			modelAndView.addObject("message", "password empty");
			return modelAndView;
		}
		if(username.equals("teacher")&&password.equals("teacher")){
			modelAndView=new ModelAndView("/teacherdashboard");
		}else{
			modelAndView=new ModelAndView("/teacherlogin");
			modelAndView.addObject("message", "user name or password incorrect");
		}
		return modelAndView;
	}
	@RequestMapping(value="/AdminLogin",method=RequestMethod.POST)
	public ModelAndView adminLogin(@RequestParam String username,@RequestParam String password){
		ModelAndView modelAndView =null; 
		System.out.println("user-"+username +",pass="+password);
		if(username==null){
			modelAndView=new ModelAndView("/adminlogin");
			modelAndView.addObject("message", "username empty");
			return modelAndView;
		}	
		if(password==null){
			modelAndView=new ModelAndView("/adminlogin");
			modelAndView.addObject("message", "password empty");
			return modelAndView;
		}
		if(username.equals("admin")&&password.equals("admin")){
			modelAndView=new ModelAndView("/admindashboard");
			return modelAndView;
		}else{
			modelAndView=new ModelAndView("/adminlogin");
			modelAndView.addObject("message", "user name or password incorrect");
		}
		return modelAndView;
	}
}
