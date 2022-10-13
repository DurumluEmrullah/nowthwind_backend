package com.edurumluemrullah.northwind_backend.auth;

import com.edurumluemrullah.northwind_backend.daos.UserDao;
import com.edurumluemrullah.northwind_backend.models.pojos.User;
import com.edurumluemrullah.northwind_backend.models.pojos.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class MyUserDetail implements UserDetailsService {

    private final UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> user = userDao.findByUsername(username);


        if (!user.isPresent() ) {
            throw new UsernameNotFoundException("User '" + username + "' not found");
        }

        Set<UserRole> userRoleList = user.get().getUserRoleList();

        String [] roles= new String[userRoleList.size()];
        for (int i =0; i<userRoleList.size();i++) {
            roles[i]=userRoleList.iterator().next().getRole();
        }

        return org.springframework.security.core.userdetails.User//
                .withUsername(username)//
                .password(user.get().getPassword())//
                .authorities(roles)//
                .accountExpired(false)//
                .accountLocked(false)//
                .credentialsExpired(false)//
                .disabled(false)//
                .build();
    }
}
