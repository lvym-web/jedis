package com.lvym.jedis;

import com.lvym.jedis.util.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

import javax.annotation.PostConstruct;

@SpringBootTest
class JedisDemoApplicationTests {

    @Autowired
    private RedisUtil redisUtil;


    @Autowired
    StringRedisTemplate redisTemplate;

     ValueOperations<String, String> stringRedis;

    @PostConstruct
    public void init() {
        stringRedis = redisTemplate.opsForValue();
    }
    @Test
    void contextLo() {

        String kk = stringRedis.get("kk");
        System.out.println(kk);

    }

    @Test
    void contextLoads() {


        Jedis jedis = redisUtil.getJedis();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            jedis.hset("k" + i,"f"+i, "v" + i);

        }
        long end = System.currentTimeMillis();
        System.err.println(end - start);
        jedis.close();

    }

    @Test
    void contextLoads2() {


        Jedis jedis = redisUtil.getJedis();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {

            Pipeline pipelined = jedis.pipelined();
            for (int j = i * 10; j < (i + 1) * 10; j++) {
                pipelined.hset("pk" + j,"f"+j, "pv" + j);
            }
            pipelined.syncAndReturnAll();

        }
        long end = System.currentTimeMillis();
        System.err.println(end - start);
        jedis.close();

    }
}
