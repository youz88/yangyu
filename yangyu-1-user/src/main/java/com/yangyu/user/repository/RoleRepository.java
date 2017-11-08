package com.yangyu.user.repository;

import com.yangyu.user.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by youz on 2017/11/8.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role,Long>{

    @Query("select r from UserRole ur ,Role r  where  ur.roleId=r.id and ur.userId=:userId")
    List<Role> selectByUser(@Param("userId") Long userId);
}
