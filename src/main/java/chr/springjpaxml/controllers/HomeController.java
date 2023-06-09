package chr.springjpaxml.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import chr.springjpaxml.entities.Pet;
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
		
		model.addAttribute("pets", petDao.getPets());
		Pet pet = new Pet();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		Set<String> roles = authentication.getAuthorities().stream()
		     .map(r -> r.getAuthority()).collect(Collectors.toSet());
		for(String rol : roles) {
			System.out.println(rol);
		}
		
		return new ModelAndView("home", "petModel",pet);
	}
	
	@RequestMapping(value = "/pet", method = RequestMethod.POST)
	public RedirectView pet(@ModelAttribute("petModel")Pet pet) {
		System.out.println(pet.getName());
		return new RedirectView("home");
	}
}
