package com.codegym.controller;
import com.codegym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/")
  public String showHomeForm(){
    return "home";
  }

  @GetMapping("/login")
  public String showLoginForm(){
    return "login";
  }

  @PostMapping("/userLogin")
  public String userLogin(@RequestParam("email") String email, @RequestParam("password") String password, Model model){
      Long indexOfLogin = userService.checkLogin(email, password);
        if (indexOfLogin > 0) return "success";
        if (indexOfLogin == 0) model.addAttribute("falsePassword", "You entered wrong your password!");
        else model.addAttribute("falseEmail","You entered wrong your email!");
        return "login";
  }

  @RequestMapping("/register")
  String showCreateForm() {
    return "register";
  }

  @RequestMapping("/forgot-password")
  String showForgotPasswordForm() {
    return "forgot-password";
  }

}
