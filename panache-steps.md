* Add maven
```xml
 <dependency>
      <groupId>io.quarkus</groupId>
      <artifactId>quarkus-jdbc-postgresql</artifactId>
    </dependency>
    <dependency>
      <groupId>io.quarkus</groupId>
      <artifactId>quarkus-hibernate-orm-panache</artifactId>
    </dependency>
```

* greeting entity

```java
@Entity
public class GreetingEntity extends PanacheEntity {

   public String message;

}
```

* meessage resource

```java
@Path("/messages")
public class MessagesResource {

    @GET
    @Path("/{id}")
    public Response getMessageById(@PathParam("id") Long id) {
        GreetingEntity entity = GreetingEntity.findById(id);
        return Response.ok(entity).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<GreetingEntity> getMessages() {
        return GreetingEntity.findAll().list();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(GreetingEntity message) {
        GreetingEntity.persist(message);
        return Response.ok(message).build();
    }
}
```