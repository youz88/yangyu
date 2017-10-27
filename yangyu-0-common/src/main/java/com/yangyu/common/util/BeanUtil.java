package com.yangyu.common.util;

import com.google.common.collect.Maps;
import org.springframework.cglib.beans.BeanCopier;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by youz on 2017/10/27.
 */
public class BeanUtil {

    public static Map<String, BeanCopier> beanCopierMap = Maps.newConcurrentMap();

    /**
     * bean属性复制
     * @param source 资源类
     * @param target 目标类
     * @param clazz
     */
    public static <T> T copyProperties(Object source, Object target, Class<T> clazz) {
        String beanKey = generateKey(source.getClass(), clazz);
        BeanCopier copier = null;
        if (!beanCopierMap.containsKey(beanKey)) {
            copier = BeanCopier.create(source.getClass(), clazz, false);
            beanCopierMap.put(beanKey, copier);
        } else {
            copier = beanCopierMap.get(beanKey);
        }
        copier.copy(source, target, null);
        return (T) target;
    }

    private static String generateKey(Class<?> class1, Class<?> class2) {
        return class1.toString() + class2.toString();
    }

}
