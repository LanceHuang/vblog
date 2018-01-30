package com.lance.blog.util;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Lance
 * @date 2018/1/22 15:47
 */
public class Collections {

    public static <T> Set<T> set(T... items) {
        Set<T> aSet = new HashSet<T>();

        if (null != items) {
            for (T item : items) {
                aSet.add(item);
            }
        }

        return aSet;
    }
}
