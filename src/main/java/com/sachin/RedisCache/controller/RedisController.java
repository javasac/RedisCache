package com.sachin.RedisCache.controller;
import com.sachin.RedisCache.model.RedisEmployee;
import com.sachin.RedisCache.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/redis")
public class RedisController
{
    @Autowired
    private RedisService redisService;

    @GetMapping("/emp/{id}")
    public RedisEmployee getEmployeeById(@PathVariable("id") Long id)
    {
        return redisService.getEmployeeById(id);
    }

    @GetMapping("/all")
    public List<RedisEmployee> getAll()
    {
        return redisService.getAll();
    }

    @DeleteMapping("/dropCache")
    public void deleteAll()
    {
        redisService.clearCache();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id)
    {
        redisService.delete(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody RedisEmployee emp)
    {
        redisService.update(emp);
    }

    @PostMapping("/create")
    public void create(@RequestBody RedisEmployee emp)
    {
        redisService.create(emp);
    }
}
