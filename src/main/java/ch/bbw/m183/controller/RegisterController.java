package ch.bbw.m183.controller;

import ch.bbw.m183.model.User;
import ch.bbw.m183.repository.UserRepository;
import ch.bbw.m183.utils.BadPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid User user, BindingResult result) {
        if (result.hasErrors() || !BadPassword.passwordIsValid(user.getPassword())) {
            if (!BadPassword.passwordIsValid(user.getPassword())) {
                result.addError(new FieldError("user", "password", "Schwaches Passwort"));
            }
            return "register";
        }

        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));

        userRepository.save(user);
        return "redirect:/login";
    }
}
