# spring-boot-cassandra-example

Java 17 LTS / spring-boot 2.6.6 / bootstrap 4.6.1 / jquery 3.6.0 / single module version ...

## Docker Cassandra Container

1. Run/prepare docker image and container


    docker run -p 9042:9042 --rm --name cassandra -d cassandra:3.11

 
3. Start Cassandra DB console in interactive mode


    docker exec -it cassandra cqlsh

4. Create KEYSPACE from Cassandra DB console


    CREATE KEYSPACE spring_cassandra WITH replication = {'class' : 'SimpleStrategy', 'replication_factor' : 1};

## Spring-Boot-Application
- Start application with maven target sequence ``clean`` then ``package`` or ``install`` and ``spring-boot:start`` or ``spring-boot:run``

- Open web-app inside a browser on localhost and port ``8080``

- Stop application when needed with maven target ``spring-boot:stop``
