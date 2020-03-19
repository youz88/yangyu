package com.yangyu.common.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Document {

    /**
     * ES索引(如果需要动态填加时间这需按这种格式：索引前缀-${YYYY.MM.dd})
     * @return
     */
    String index();

    /**
     * ES类型
     * @return
     */
    String type();

}
