//package ch.bbw.m183.data;
//
//import ch.bbw.m183.model.User;
//import ch.bbw.m183.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.crypto.bcrypt.BCrypt;
//import org.springframework.stereotype.Component;
//
///*
//    Wichtig: NACHDEM DIE APP EINMAL AUSGEFÜHRT WURDE DIESE KLASSE AUSKOMMENTIEREN.
//    DIE GLEICHEN USER WERDEN SONST MEHRMALS GENERIERT WAS ZU EINEM FEHLER BEIM LOGIN FÜHRT.
//*/
//@Component
//public class DatabaseInitializer implements CommandLineRunner {
//    @Autowired
//    UserRepository userRepository;
//
//    @Override
//    public void run(String... args) {
//        userRepository.save(new User("Testuser", BCrypt.hashpw("test", BCrypt.gensalt())));
//        userRepository.save(new User("Testuser1", BCrypt.hashpw("test1", BCrypt.gensalt())));
//        userRepository.save(new User("Testuser2", BCrypt.hashpw("test2", BCrypt.gensalt())));
//    }
//}
