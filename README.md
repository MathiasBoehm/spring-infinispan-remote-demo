# spring-infinispan-remote-demo
A simple Spring application demonstrating the use of an Infinispan Remote Server in Combination with multiple Spring Cache Managers

This demo is heavily inspired by the work of Katia Aresti and her protobuf demo https://github.com/karesti/infinispan-spring-boot-protobuf


# Prepare environment
Install an Infinispan Remote Server using docker or download (https://infinispan.org/download/) a bundled version with Wildfly

```
$ docker run --name infinispan -it -p 11222:11222 -e USER="admin" -e PASS="password" quay.io/infinispan/server:13.0
```

# Run Demo

Lookup customer and verify the usage of the Remote Infinispan Cache

```
http :8080/customers/1
```

Lookup a person and verify the usage of the local Caffeine Cache

```
http :8080/persons/1
```