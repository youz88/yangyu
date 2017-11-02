package com.yangyu.config.repository;

import com.yangyu.config.model.SysConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by youz on 2017/11/2.
 */
public interface SysConfigRepository extends JpaRepository<SysConfig,Long>{

    @Query("from SysConfig where key=:key and isDelete=0")
    SysConfig selectByKey(@Param("key") String key);
}
