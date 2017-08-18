package com.nttdata.estore.security;

import com.nttdata.estore.entities.Authority;
import com.nttdata.estore.entities.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

public final class JwtUserFactory {

    private JwtUserFactory() {}

    public static JwtUser create(User user) {
        return new JwtUser(user.getId(), user.getUsername(), user.getFirstname(), user.getLastname(), user.getEmail(),
                user.getPassword(), mapToGrantedAuthorities(user.getAuthorities()),
                user.getLastPasswordResetDate());
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Authority> authorities) {
        return authorities.stream().map(authority -> new SimpleGrantedAuthority(authority.getName().name()))
                .collect(Collectors.toList());
    }
}
