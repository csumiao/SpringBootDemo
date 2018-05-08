package com.miao.firstappdemo.repository;


import com.miao.firstappdemo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * {@link User @link Respository}
 */
@Repository
public class UserRepository {

    /**
     * 采用内存型存储方式 -> Map
     *
     */
    private final ConcurrentMap<Integer, User> repository = new ConcurrentHashMap<>();

    private final static AtomicInteger iGenerator = new AtomicInteger();

    /**
     * 保存用户对象
     * @param user {@link User } 对象
     * @return 如果保存成功 返回<code>true</code>
     * 否则返回<code>false</code>
     */

    public boolean save(User user) {
//        boolean success = false;
        //id从1 开始
        Integer id = iGenerator.incrementAndGet();
        //设置id
        user.setId(id);
        return  repository.put(id, user) == null;
    }

}











