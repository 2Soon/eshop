package org.xianghao.eshop.common.util;

import org.springframework.cglib.beans.BeanCopier;

import java.util.HashMap;
import java.util.Map;

/**
 * 工具类，复制元素
 */
public class BeanCopierUtils {
    public static Map<String, BeanCopier> beanCopierCacheMap = new HashMap<String, BeanCopier>();

    /**
     * 将source对象的属性拷贝到target对象中去
     */
    public static void copyProperties(Object source, Object target) {
        String cacheKey = source.getClass().toString() + target.getClass().toString();
        BeanCopier beanCopier = null;
        if (!beanCopierCacheMap.containsKey(cacheKey)) {
            synchronized (BeanCopierUtils.class) {
                if (!beanCopierCacheMap.containsKey(cacheKey)) {
                    beanCopier = BeanCopier.create(source.getClass(), target.getClass(), false);
                    beanCopierCacheMap.put(cacheKey, beanCopier);
                }
            }

        } else {
            beanCopier = beanCopierCacheMap.get(cacheKey);
        }
        beanCopier.copy(source, target, null);

    }

//    private static String generateKey(Class<?>class1,Class<?>class2){
//        return class1.toString() + class2.toString();
//    }
}
