package chr.springjpaxml.controllers;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import chr.springjpaxml.repository.PetDao;
import chr.springjpaxml.service.PetManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Controller
public class HomeController {
	 protected final Log logger = LogFactory.getLog(getClass());
	
	 @Autowired
	 private PetDao petDao;
	 
	 
	@RequestMapping(value = "/home")
	public ModelAndView home(HttpServletRequest req, HttpServletResponse res, Model model) throws IOException, ServletException{
		logger.info("return view home");
		String now = (new Date()).toString();
		model.addAttribute("pets", petDao.getPets());
		System.out.print( petDao.getPets());
		return new ModelAndView("home", "now",now);
	}
}
