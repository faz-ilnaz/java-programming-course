package com.springapp.mvc;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {

	List<Student> list = new LinkedList<>();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView student() {
		return new ModelAndView("index", "command", new Student());
	}

	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public String addStudent(@ModelAttribute("SpringWeb") Student student,
			ModelMap model) {
		
		student.setId(list.size() + 1);
		list.add(student);
		model.addAttribute("lists", list);
		return "result";
	}
}