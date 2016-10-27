package com.yco.util;

import java.util.*;

/**
 * Created by yuekexin on 2016/10/26.
 */
public class TransUtil {

    /**
     * 抽取集合中实体的某些属性组合成新的set
     *
     * @param collections 待转换的集合
     * @param entity      KeyGetter接口的一个实现类的对象（推荐匿名实现），需要实现getKey方法，用以获得实体中的值
     * @param <E>         待转换的集合中的对象的class
     * @param <T>         转换后set中的对象的class
     * @return Set
     */
    public static <E, T> Set<T> transToSet(Collection<E> collections, KeyGetter<E, T> entity) {
        Set<T> result = new HashSet<T>();
        Iterator<E> it = collections.iterator();
        while (it.hasNext()) {
            result.add(entity.getKey(it.next()));
        }
        return result;
    }

    /**
     * 抽取集合中实体的某些属性组合成新的list
     *
     * @param collections 待转换的集合
     * @param entity      KeyGetter接口的一个实现类的对象（推荐匿名实现），需要实现getKey方法，用以获得实体中的值
     * @param <E>         待转换的集合中的对象的class
     * @param <T>         转换后set中的对象的class
     * @return List
     */
    public static <E, T> List<T> transToList(Collection<E> collections, KeyGetter<E, T> entity) {
        List<T> result = new ArrayList<T>();
        Iterator<E> it = collections.iterator();
        while (it.hasNext()) {
            result.add(entity.getKey(it.next()));
        }
        return result;
    }

    /**
     * 抽取map中value或value的某些属性组合成新的set
     *
     * @param map    待转换的map
     * @param entity KeyGetter接口的一个实现类的对象（推荐匿名实现），需要实现getKey方法，用以获得实体中的值
     * @param <T>    转换后set中的对象的class
     * @param <K>    map的key的class
     * @param <V>    map的value的class
     * @return Set
     */
    public static <T, K, V> Set<T> transMapToValueSet(Map<K, V> map, KeyGetter<V, T> entity) {
        Set<T> result = new HashSet<T>();
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            result.add(entity.getKey(it.next().getValue()));
        }
        return result;
    }

    /**
     * 抽取map中value或value的某些属性组合成新的set
     *
     * @param map    待转换的map
     * @param entity KeyGetter接口的一个实现类的对象（推荐匿名实现），需要实现getKey方法，用以获得实体中的值
     * @param <T>    转换后set中的对象的class
     * @param <K>    map的key的class
     * @param <V>    map的value的class
     * @return list
     */
    public static <T, K, V> List<T> transMapToValueList(Map<K, V> map, KeyGetter<V, T> entity) {
        List<T> result = new ArrayList<T>();
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            result.add(entity.getKey(it.next().getValue()));
        }
        return result;
    }


    /**
     * 抽取集合中的实体的某些属性组合成map的key和value
     *
     * @param collections 待转换的集合
     * @param entity      EntryGetter接口的一个实现类的对象（推荐匿名实现），需要实现getKey, getValue方法，用以获得转换map中的key和value
     * @param <E>         集合中的对象的class
     * @param <K>         转换后map的class
     * @param <V>         转换后map的value的class
     * @return map
     */
    public static <E, K, V> Map<K, V> extractTransToMap(Collection<E> collections, EntryGetter<E, K, V> entity) {
        Map<K, V> result = new HashMap<K, V>();
        Iterator<E> it = collections.iterator();
        while (it.hasNext()) {
            E item = it.next();
            result.put(entity.getKey(item), entity.getValue(item));
        }
        return result;
    }
}

/**
 * Created by yuekexin on 2016/10/26.
 */
interface EntryGetter<E, K, V> {
    K getKey(E entry);
    V getValue(E entry);
}

/**
 * Created by yuekexin on 2016/10/26.
 */
interface KeyGetter<E, K> {
    K getKey(E entity);
}
