package geektime.spring.springbucks.waiter.service;

import geektime.spring.springbucks.waiter.model.Coffee;
import geektime.spring.springbucks.waiter.repository.CoffeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@CacheConfig(cacheNames = "CoffeeCache")
public class CoffeeService {
    @Autowired
    private CoffeeRepository coffeeRepository;

    @Cacheable
    public List<Coffee> getAllCoffees() {
        return coffeeRepository.findAll(Sort.by("id"));
    }

    public List<Coffee> getCoffeesByName(List<String> names) {
        return coffeeRepository.findByNameInOrderById(names);
    }
}
