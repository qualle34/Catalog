package com.senla.catalog.service.security;

import com.senla.catalog.daoapi.IUserDao;
import com.senla.catalog.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private IUserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String login) throws AuthenticationException {

        try {
            User user = userDao.getWithCredsByLogin(login);
            return new UserDetail(user);

        } catch (RuntimeException e){
            throw new UsernameNotFoundException("User not found");
        }
    }
}
