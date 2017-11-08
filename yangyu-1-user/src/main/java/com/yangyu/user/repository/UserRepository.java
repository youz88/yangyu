package com.yangyu.user.repository;

import com.yangyu.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/**
 * Created by youz on 2017/10/27.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long>{

    @Query("from User where isDelete=0 and (email=:username or phone=:username)")
    User selectByName(@Param("username") String username);
}
