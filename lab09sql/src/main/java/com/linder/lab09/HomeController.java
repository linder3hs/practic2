package com.linder.lab09;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.linder.lab09.DAO.UserDAO;
import com.linder.lab09.DAO.UserDAPImp;
import com.linder.lab09.bean.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.linder.lab09.DAO.UserDAO;
import com.linder.lab09.DAO.UserDAPImp;
import com.linder.lab09.db.ConnectionDB;
import com.linder.lab09.bean.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ModelAndView user() {
		User user = new User();
		
		ModelAndView modelAndView = new ModelAndView("home", "command", user);
		return modelAndView;
	}
	
	@RequestMapping(value = "/consultaOracle", method = RequestMethod.POST)
	public void addUser(@ModelAttribute("SpringWeb") User user, ModelMap model) {
		UserDAO dao = new UserDAPImp();
		for (User item : dao.findAll()) {
			System.out.println(item); 
		};		
	}
	
	
	
}
