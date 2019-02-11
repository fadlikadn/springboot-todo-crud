package com.okta.springbootvue.repository;

import com.okta.springbootvue.model.Role;
import com.okta.springbootvue.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}
