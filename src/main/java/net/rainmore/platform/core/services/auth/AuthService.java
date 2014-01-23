package net.rainmore.platform.core.services.auth;

import net.rainmore.platform.core.models.auth.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional(readOnly=true)
public class AuthService implements UserDetailsService {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        net.rainmore.platform.core.models.auth.User domainUser = userService.findByName(username);
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        return new User(
                domainUser.getUsername(),
                domainUser.getPassword(),
                enabled,
                accountNonExpired,
                credentialsNonExpired,
                accountNonLocked,
                getAuthorities(domainUser.getRole())
        );
    }

    public Collection<GrantedAuthority> getAuthorities(Role role) {
        List<GrantedAuthority> list = getGrantedAuthorities(role);
        return list;

    }

    public static List<GrantedAuthority> getGrantedAuthorities(Role role) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(role.getRole()));
        return authorities;
    }
}
