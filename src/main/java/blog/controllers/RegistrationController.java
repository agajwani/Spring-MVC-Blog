package blog.controllers;

import blog.forms.RegistrationForm;
import blog.models.User;
import blog.services.NotificationService;
import blog.services.RegistrationService;
import blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


@Controller
public class RegistrationController {


    @Autowired
    private NotificationService notificationService;

    @Autowired
    private UserService userService;


    @RequestMapping("/users/register")
    public String displayRegistrationForm(Model model) {
        model.addAttribute("RegistrationForm", new RegistrationForm());
        return "users/register";
    }

    @RequestMapping(value = "/users/register",
            method = RequestMethod.POST)
    public String register(@Valid RegistrationForm registrationForm, BindingResult result){
        if (result.hasErrors()){
            notificationService.addErrorMessage(
                    "Please fill in the Registration Form correctly!");
            return ("users/register");
        }
// Add this user into the database
        User user = new User();
        user.setUsername(registrationForm.getUsername());
        user.setPassword(registrationForm.getPassword());
        user.setFullName(registrationForm.getFullName());
        save(user);
        return "redirect:/";
        }


//        if (! registrationService.create(RegistrationForm.getUsername(),
//                RegistrationForm.getPassword())) {
//            notificationService.addErrorMessage("Invalid login");
//            return "users/login";
//        }
//
//        // Login successful
//        notificationService.addInfoMessage("Registration Successful!");
//        return "redirect:/";
//    }
}

