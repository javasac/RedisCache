package com.sachin.RedisCache.repository;
import com.sachin.RedisCache.model.RedisEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedisRepository extends JpaRepository<RedisEmployee, Long>
{
}
