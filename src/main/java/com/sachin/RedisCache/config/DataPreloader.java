package com.sachin.RedisCache.config;
import com.sachin.RedisCache.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataPreloader implements CommandLineRunner
{
    @Autowired
    private RedisService redisService;

    @Override
    public void run(String...args)
    {
        redisService.getAll();
    }
}
