package se.ashwini.myspringproject;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import se.ashwini.myspringproject.model.ApplicationUser;
import se.ashwini.myspringproject.repository.AppUserRepository;
import java.util.List;

@Service
public class UserDetailService implements UserDetailsService {

    private final AppUserRepository appUserRepository;
    public UserDetailService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser applicationUser = appUserRepository.findByUsername(username);
        if (applicationUser == null) {
            throw new UsernameNotFoundException("User not found");
        }
        //ROLE_USER
        List<GrantedAuthority>authorities = List.of(new SimpleGrantedAuthority("ROLE_" + applicationUser.getRole()));
        return new org.springframework.security.core.userdetails.User(
                applicationUser.getUsername(),
                applicationUser.getPassword(),
                true,
                true,
                true,
                true,
                authorities
        );
    }


}
