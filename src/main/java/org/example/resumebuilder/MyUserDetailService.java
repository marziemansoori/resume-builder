package org.example.resumebuilder;

import org.example.resumebuilder.entities.MyUserDetails;
import org.example.resumebuilder.entities.User;
import org.example.resumebuilder.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService {

    final
    UserRepository userRepository;

    public MyUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(username);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found " + username));

        return user.map(MyUserDetails::new).get();
    }
}
