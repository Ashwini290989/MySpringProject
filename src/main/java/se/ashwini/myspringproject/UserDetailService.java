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

    private final AppUserRepository appUserRepository; //Dependency injection with constructors.
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
    /**
     * method loadUserByUsername()is overriding from userDetailsService. It takes username as a input.
     * fetches an instance of application user,using the user name.
     * if user not found, it will through an exception user not found.
     * If the user is found, their role is retrieved and converted to a format Spring Security understands (ROLE_USER, ROLE_ADMIN).
     * creating a list of user authorities,based on user role.
     * SimpleGrantedAuthority class wraps each role into a format that Spring Security understands, like "ROLE_USER" or "ROLE_ADMIN".
     * Creates a new instance of the User class from Spring Security, which implements UserDetails.
     * finally, the user data is wrapped in a User object and returned for authentication.
     */


}
