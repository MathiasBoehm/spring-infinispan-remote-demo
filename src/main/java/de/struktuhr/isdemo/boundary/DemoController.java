package de.struktuhr.isdemo.boundary;

import de.struktuhr.isdemo.control.CustomerRepo;
import de.struktuhr.isdemo.control.PersonRepo;
import de.struktuhr.isdemo.model.Customer;
import de.struktuhr.isdemo.model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private final CustomerRepo customerRepo;
    private final PersonRepo personRepo;

    public DemoController(CustomerRepo customerRepo, PersonRepo personRepo) {
        this.customerRepo = customerRepo;
        this.personRepo = personRepo;
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable String id) {
        return customerRepo.findCustomer(id);
    }

    @GetMapping("/persons/{id}")
    public Person getPerson(@PathVariable String id) {
        return personRepo.findPerson(id);
    }
}
