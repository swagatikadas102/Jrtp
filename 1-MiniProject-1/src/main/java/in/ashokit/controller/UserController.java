package in.ashokit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.ashokit.entity.UserAccount;
import in.ashokit.service.UserServiceImple;

@Controller
public class UserController {
	
	@Autowired
	private UserServiceImple service;

	@GetMapping("/")
	public String indexPage(Model model) {
		
		model.addAttribute("user",new UserAccount());
		return "index";
	}
	
	@PostMapping("/save-user")
     public String submitButtonHandel(@ModelAttribute("user") UserAccount user,Model model){
		System.out.println(user);
    	String saveUserAcc = service.saveUserAcc(user);
    	model.addAttribute("msg",saveUserAcc);
	   return "index";
	}
	
	 @GetMapping("/viewusers")
	 public String getUsers(Model model){
		 List<UserAccount> userList = service.getAllUserAccounts();
		 model.addAttribute("users", userList);
		 return "view";
   }
}
