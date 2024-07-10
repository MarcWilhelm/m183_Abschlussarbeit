/*package ch.bbw.m183.data;

import ch.bbw.m183.model.Role;
import ch.bbw.m183.model.User;
import ch.bbw.m183.repository.RoleRepository;
import ch.bbw.m183.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;


    Wichtig: NACHDEM DIE APP EINMAL AUSGEFÜHRT WURDE DIESE KLASSE AUSKOMMENTIEREN.
    DIE GLEICHEN USER WERDEN SONST MEHRMALS GENERIERT WAS ZU EINEM FEHLER BEIM LOGIN FÜHRT.

@Component
public class DatabaseInitializer implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public void run(String... args) {
        Role roleUser = new Role("USER");
        Role roleAdmin = new Role("ADMIN");

        roleRepository.save(roleUser);
        roleRepository.save(roleAdmin);

        User adminUser = new User("AdminUser", BCrypt.hashpw("admin123", BCrypt.gensalt()));
        adminUser.getRoles().add(roleAdmin);
        userRepository.save(adminUser);

        User normalUser = new User("User1", BCrypt.hashpw("user123", BCrypt.gensalt()));
        normalUser.getRoles().add(roleUser);
        userRepository.save(normalUser);
    }
}*/
