package com.test.visitor_auth.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.test.visitor_auth.model.Role;

public interface RoleDao extends JpaRepository<Role, Integer> {
    @Query(value = "select * from role r, user_role ur where r.id=ur.rid and ur.uid=:id", nativeQuery=true)
    List<Role> getUserRoleByUid(@Param("id") Integer id);
}
