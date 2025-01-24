package cars.service;
import cars.home.AppUser;
import cars.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Bean
    private PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder();}

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AppUser user = userRepository.findBynameUser(username);

                if (user == null) {
                    throw new UsernameNotFoundException("Not Found User");
                }
            return user;
    }

    public List<AppUser> findAllUser() {
        return userRepository.findAll();
    }

    public void saveUser(AppUser user) {
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        this.userRepository.save(user);
    }

}