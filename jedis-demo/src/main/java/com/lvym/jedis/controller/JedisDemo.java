package com.lvym.jedis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.PostConstruct;

public class JedisDemo {

    @Autowired
   StringRedisTemplate redisTemplate;

   static ValueOperations<String, String> stringRedis;

    @PostConstruct
    public void init() {
        stringRedis = redisTemplate.opsForValue();
    }

    public static void main(String[] args) {
        stringRedis.set("k","v");
    }
}
