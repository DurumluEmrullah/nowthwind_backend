package com.edurumluemrullah.northwind_backend.services.abstracts;

import com.edurumluemrullah.northwind_backend.models.pojos.UserRole;

public interface UserRoleService {

    UserRole getByRole(String role);

}
