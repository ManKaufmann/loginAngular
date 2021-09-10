package com.example.loginangular.service;

import java.util.ArrayList;
import java.util.List;

import com.example.loginangular.dao.UserAngularRepository;
import com.example.loginangular.model.User_FrontendAngular;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

// TODO: 09.09.21


@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserAngularRepository userDao;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("javainuse".equals(username)) {
            return new User("javainuse", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

    public User_FrontendAngular save(User_FrontendAngular user) {

        User_FrontendAngular newUser = new User_FrontendAngular();
        newUser.setUsername(user.getUsername());
        /*newUser.setUserpassword(bcryptEncoder.encode(user.getUserpassword()));*/
        newUser.setUserpassword(user.getUserpassword());


        try {

            newUser = this.userDao.save(newUser);
        }catch (Exception e){
            System.out.println("Datenbank input save new User Failed");
            e.printStackTrace();
        }

        return newUser;
    }

    public List<User_FrontendAngular> getall(){
        List<User_FrontendAngular> all = this.userDao.findAll();
        return all;
    }

}