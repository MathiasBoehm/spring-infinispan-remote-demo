package de.struktuhr.isdemo.model;

import org.infinispan.protostream.annotations.ProtoDoc;
import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;

import java.util.Objects;

@ProtoDoc("@Indexed")
public class Customer {

    private final String id;
    private final String name;
    private final City city;
    private final Integer age;

    @ProtoFactory
    public Customer(String id, String name, City city, Integer age) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.age = age;
    }

    @ProtoField(value = 1, required = true)
    public String getId() {
        return id;
    }

    @ProtoField(value = 2, required = true)
    @ProtoDoc("@Field(index=Index.YES, analyze = Analyze.YES, store = Store.YES)")
    public String getName() {
        return this.name;
    }

    @ProtoField(value = 3, required = true)
    public City getCity() {
        return this.city;
    }

    @ProtoField(value = 4, required = true)
    @ProtoDoc("@Field(index=Index.YES, analyze = Analyze.NO, store = Store.YES)")
    public Integer getAge() {
        return this.age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) && Objects.equals(name, customer.name) && city == customer.city && Objects
                .equals(age, customer.age);
    }

    @Override
    public String toString() {
        return "Customer{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", city=" + city + ", age=" + age + '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, city, age);
    }
}
