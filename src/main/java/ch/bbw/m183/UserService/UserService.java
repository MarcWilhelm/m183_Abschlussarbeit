package ch.bbw.m183.UserService;

import ch.bbw.m183.model.User;
import ch.bbw.m183.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return org.springframework.security.core.userdetails.User.withUsername(username).password(user.getPassword())
                .authorities(getAuthorities(user)).build();
    }

    private Collection<? extends GrantedAuthority> getAuthorities(User user) {
        System.out.println("In UserService" + user.getRoles());
        return user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName())).toList();
    }
}
