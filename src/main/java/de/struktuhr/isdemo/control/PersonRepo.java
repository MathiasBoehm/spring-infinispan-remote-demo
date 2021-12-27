package de.struktuhr.isdemo.control;

import de.struktuhr.isdemo.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Component
public class PersonRepo {

    private final static Logger log = LoggerFactory.getLogger(PersonRepo.class);

    private final Map<String, Person> data = new HashMap<>();

    public PersonRepo() {
        initTestData();
    }

    @Cacheable(value = "persons", cacheManager = "localCacheManager")
    public Person findPerson(String id) {
        log.info("read person {} from repo", id);
        return data.get(id);
    }


    private void initTestData() {
        data.put("1", new Person("Paul", LocalDateTime.now()));
        data.put("2", new Person("Clara", LocalDateTime.now()));
        data.put("3", new Person("Lucy", LocalDateTime.now()));
        data.put("4", new Person("Peter", LocalDateTime.now()));
        data.put("5", new Person("John", LocalDateTime.now()));
    }
}
