package com.test.visitor_auth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.test.visitor_auth.dao.RoleDao;
import com.test.visitor_auth.dao.UserDao;
import com.test.visitor_auth.model.Role;
import com.test.visitor_auth.model.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    
    @Autowired
    UserDao userDao;
    @Autowired
    RoleDao roleDao;
    
    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("账户不存在");
        }
        Integer id = user.getId();
        user.setRoles(roleDao.getUserRoleByUid(id));
        return user;
    }
    
    public List<Role> loadUserRoleByUid(Integer id) {
        return roleDao.getUserRoleByUid(id);
    }
}
