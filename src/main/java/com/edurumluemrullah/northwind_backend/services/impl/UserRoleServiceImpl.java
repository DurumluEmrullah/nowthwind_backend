package com.edurumluemrullah.northwind_backend.services.impl;

import com.edurumluemrullah.northwind_backend.daos.UserRoleDao;
import com.edurumluemrullah.northwind_backend.models.pojos.UserRole;
import com.edurumluemrullah.northwind_backend.services.abstracts.UserRoleService;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleDao userRoleDao;

    public UserRoleServiceImpl(UserRoleDao userRoleDao) {
        this.userRoleDao = userRoleDao;
    }

    @Override
    public UserRole getByRole(String role) {
        return userRoleDao.findByRole(role).orElse(null);
    }
}
