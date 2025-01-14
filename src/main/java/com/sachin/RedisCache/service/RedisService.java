package com.sachin.RedisCache.service;
import com.sachin.RedisCache.model.RedisEmployee;
import com.sachin.RedisCache.repository.RedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RedisService
{
    @Autowired
    private RedisRepository redisRepository;

    @Cacheable(value="RedisEmp")
    public List<RedisEmployee> getAll()
    {
        return redisRepository.findAll();
    }

    @Cacheable(value="RedisEmp", key="#id")
    public RedisEmployee getEmployeeById(Long id)
    {
        return redisRepository.findById(id).orElse(null);
    }

    @Caching(evict = {@CacheEvict(value="RedisEmp", key="#id")})
    public void delete(Long id)
    {
        redisRepository.deleteById(id);
    }

    @CachePut(value = "RedisEmp", key="#emp.id")
    @Caching(evict = {@CacheEvict(value="RedisEmp", key="#emp.id")})
    public void update(RedisEmployee emp)
    {
        redisRepository.saveAndFlush(emp);
    }

    @Cacheable(value="RedisEmp", key="#emp.id")
    public void create(RedisEmployee emp)
    {
        redisRepository.save(emp);
    }
}
