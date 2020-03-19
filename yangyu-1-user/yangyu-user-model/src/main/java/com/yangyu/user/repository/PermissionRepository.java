package com.yangyu.user.repository;

import com.yangyu.user.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface PermissionRepository extends JpaRepository<Permission,Long>{

    @Query("select p from Role r,RolePermission rp ,Permission p where r.id=rp.roleId and rp.permissionId=p.id and p.isDelete=false and r.sign in (:roles) order by p.id desc")
    List<Permission> selectByRole(@Param("roles") Collection<String> authorities);
}
