package de.struktuhr.isdemo.control;

import de.struktuhr.isdemo.Constants;
import de.struktuhr.isdemo.model.City;
import de.struktuhr.isdemo.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@CacheConfig(cacheNames = Constants.CUSTOMERS_CACHE)
public class CustomerRepo {

    private final static Logger log = LoggerFactory.getLogger(CustomerRepo.class);

    private final Map<String, Customer> data = new HashMap<>();

    public CustomerRepo() {
        initTestData();
    }

    @Cacheable
    public Customer findCustomer(String id) {
        log.info("read customer {} from repo", id);
        return data.get(id);
    }


    private void initTestData() {
        data.put("1", new Customer("1", "Peter Pan", City.LONDON, 43));
        data.put("2", new Customer("2", "Linda Love", City.NEW_YORK, 25));
        data.put("3", new Customer("3", "John Doe", City.PARIS, 30));
        data.put("4", new Customer("4", "Lucy Lu", City.PARIS, 19));
        data.put("5", new Customer("5", "Paul Panther", City.LONDON, 22));
    }
}
