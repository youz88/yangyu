package com.yangyu.news.user.repository;

import com.yangyu.news.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by youz on 2017/10/27.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long>{

    @Query("from User where userName=:userName and password=:password")
    User login(@Param("userName") String userName, @Param("password")String password);

}
