package com.yangyu.study.user.repository;

import com.yangyu.study.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by youz on 2017/10/25.
 */
@Repository
public interface UserReponsitory extends JpaRepository<User,Long>{

}
