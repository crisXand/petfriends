package chr.springjpaxml.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Controller
public class HomeController {
	 protected final Log logger = LogFactory.getLog(getClass());
	@RequestMapping(value = "/home")
	public ModelAndView home(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		logger.info("return view home");
		return new ModelAndView("home.jsp");
	}
}
