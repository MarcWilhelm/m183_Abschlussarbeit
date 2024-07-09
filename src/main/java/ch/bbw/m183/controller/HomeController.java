package ch.bbw.m183.controller;

import ch.bbw.m183.UserService.UserService;
import ch.bbw.m183.model.User;
import ch.bbw.m183.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public String home() {
        User user = userRepository.findByUsername("AdminUser");
        System.out.println("Im Controller: " + user.getRoles().isEmpty());

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getName());
        System.out.println(authentication.getAuthorities());
        return "Hello World";
    }
}
