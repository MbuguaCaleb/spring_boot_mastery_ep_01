**Apache Maven**

```agsl
Helps programmers manage their projects and all the things they 
need to build their programmes.
```

**Important MVN Concepts**

**Maven Phases**

```agsl
Maven has three important phases,

mvn clean phase

Clears everything from a previous compile

(a)Clean - Removes temporary directories and files
(b)Default - Where the most useeful goals live
(c)Site - Where documentation is generated

mvnw clean has three phases as well

(a)pre-clean - hook before cleaning
(b)clean - does actual cleaning
(c)post-clean - hook after cleaning

sample command 
 ./mvnw clean

mvnw [default] phase 

(a)compile - Compiles your code into bytecode
(b)test- runs unit tests
(c)package - creates a jar or war file
(d)verify - runs and checks integration tests

runs in order (a)---> (b)---> (c)---> (d)
./mvnw verify

```

**Maven directory structure**

```agsl
For you to use maven, your project must be scaffolded in the maven
directory structure,

Spring starter does a very excellent Job at this

when we arrange projects in the maven directory stucture, spring boot can easily manage them
for us.

```

**Testing**

```agsl
We can have src-->test-->resources where we add our test configuration resources

We can have different configurations for testing

```

**Maven Workflow**

```agsl

Using it from the commandline,

./mvnw verify
./mvnw compile
 ./mvnw clean test
./ mvn clean verify
 cd target
 java -jar spring_boot_mastery_001-0.0.1-SNAPSHOT.jar
 mvn clean verify

```


**3 ways of running a maven project**
```agsl

1.IDE

2.Bulding a Jar file

./ mvn clean verify
 cd target
 java -jar spring_boot_mastery_001-0.0.1-SNAPSHOT.jar
 
 3.Running via command line

 ./mvnw spring-boot:run

```

**What is spring boot**

```agsl
A framework for building Java applications

A framework is a chunk of code written on top of a programming language
to solve common probles.

common problems that a framework can solve are

(a)Connecting to a database

(b)Exposing a rest API ,

A framework simplifies or work

```

**Spring Boot Vs Spring**

```agsl

Spring Boot is built on top of the spring framework.

The spring framework used by itself is highly configurable,we can configure anything
to be what we want it to be, but downside is that this takes a lot of develper effort,

Spring Boot which lies on top of spring framework simplifies this even further.

```

**Spring App Layers**

```agsl
1. Peristence Layer

Handles all your database logic,

we have repositories, enitities and DAO(s)

2.Services Layer

supplies the data and logic to the presentation layer.

The presentation Layer should not talk to the Database directly.

3.Presentation Layer

contoller, graphQL Api, Web sockets API

When we want to make any changes i.e from REST to GraphQL.
We /should only change the logic in the presentation Layer.

NOT Service Layer.
```


**Key Spring concepts**

**Inversion of Control**

```agsl

This is whereby spring boot takes the ownership of classes and dependencies.If we did not use spring for 
instance we would have to entirely handle how our classes interact with each other

Spring takes the ownership of providing dependencies a phenomenon refereed to as depencency injection.

As we write our code, we declare interfaces then let spring provide the classes to the declared interfaces

Classes in the sping ecosytem are referred to as Beans.

Spring first of all begins running by adding all the beans and configuraton in its context.

I make my classes more declarative, where i just put the depencies they will
use in the constructor and let spring inject them for me.

We no longer use the keyword new className when calling a class.
new BluePrinter();

```

**Declaring Beans **
```agsl

1.Bean Declaration inside a configuartion class.

@Configuration
public class sampleCONF{

@Bean
private final RabbitMQ rabbitMQ{}
}

2.@Component declaration inside an implementing class.

Where we place @Component inside a class

In spring i declare my classes with @Component so that i can easily call them inside other classes.

If a class i am calling has arguments in a method, i can just pass the parameters
inside the injected class

Friends of @Component are @Service, these are more desciptive into 
what the class is doing.


```

**Component Scanning**

```agsl
It is a process that starts when you application starts up

During Component Scanning Spring Boot looks for the beans as well as where the beans are needed.

It puts all the beans and component classes inside our context and provided them when needed.

If we have complex classes that needs dependencies /other classes
it will pluck them inside the spring context and put them where they
are needed.

If you find that you have a dependency needed it will get it from the application
context and put it inside your class. (Depency Injection)

```

**How does a Spring Boot Application run**

```agsl

It first starts by component scanning, where it checks all the beans
and adds them to the spring context, then finally does depedency injection
when it finds classes that need other depencies

if spring does not find the beans it needs it fails to start Up.

```

**ComponentScan Annotation**

```agsl

It is where spring will start the scanning of our application to put
the beans in the context, 

Typically it should be in a base Class, so that spring will scan all
the classes inside the package,

@SpringBootApplication implements @ComponentScan.

When component scanning puts beans where they are needed the process is called
autowiring/dependency injection.

When we declare @ComponentScan spring is going to look for beans from that point
downwards.

```
**Autowiring**

```agsl
Providing the required dependencies or beans in a class.

```
**@SpringBootApplication**

```agsl

It is an alias of three important annotations,

@Configuration
@ComponentScan
@EnableAutoConfiguration

@Configuration ->Identifies a configuration class, which is somewhere Spring Should
look for beans during its component scanning phase.

@ComponentScan->From this point to the hierachy down, look for beans needed and place them 
inside the application context.

@EnableAutoConfiguration-->SpringBoot is very powerful and makes spring easier to 
use by providing sensible defaults, This is the purpose of autoconfiguration

for example when i bring in database dependencies etc.

```

**Autoconfiguration and Spring Boot Starters**

```agsl

Creates classes with some sensible defaults and puts them in our application context.

Mechanism that springboot uses during startup to provide sensible defaults, and create all of those
dependencies.

Autoconfiguration is the process whereby those project dependencies are created and sensible defaults
are provided.

Spring Boot starters are a collection of dependencies available to solve a particular problem

SpringBoot provides a number of startes for me to be able to quickly plug in, however for them to be 
easily used it provides some sensible defaults via an autoconfiguration package,

It comes with an external package for autoconfiguration which provides these sensbile defaults,

In a spring project you will have to do and create these configurations for yourself, however in spring boot
these configurations are created on your behalf.
```


**Configuration  Files **

**How do we change these sensible defaults????**

```agsl
please note default configurations can be changed as you please,

1.application.properties-->we can be able to override where the application starts etc.

important to note is that application properties for our main application can be 
completely sepate from the ones for tests,

This comes in very handy since we do not desire to use a production DB for tests,

2.Environment variables

This is especially handy for instance when using docker

rule of thumb
server.port = 8080
SERVER_PORT = 8080

3.We can also run our environment variables via the commandline,

SERVER_PORT=8282 mvn spring-boot:run

A terminal runs in the context of what we call and environment.

export SERVER_PORT=8083
./mvnw spring-boot:run 

When building jar files, the environment variables also take effect.
```

**Configuration Properties**

```agsl
We can also create our custom configuration properties and load them into the spring context.

@Confuguration
@ConfigurationProperties(prefix="calebs_custom")
@AllArgsConstructor
@NoArgsConstructor
public class myConfigClass{

}

@Confuration-->configs clas will be injected into the spring context during component scanning
@ConfiguratioProperties(prefix="calebs_custom")-->spring will look from properties in my configuration
that are marching the provided prefix,and put them inside the class that is now globally accessible

```

**SpringBoot and Databases**

```agsl
(a)Any Major database like mysql and postgres will make a java database driver available.This enables us
interact with the database from our code.

(b)JDBC -->Low level api that helps me write custom SQL queries while in my Java code.

(c)Spring JDBC build on top of JDBC and more importanty gives us the JDBC template.The template makes it easier
interacting with SQL than just JDBC.

N/B
Disadvantage of JDBC is that i have to map java objects to and fro by myself.

i have to handle the mapping all by myself.To and from Java Objects.

Remember that data from your database must be mapped into an Object and vice versa.

(d)JPA--->Java Persistence API (Helps us interact with the database by Using Java Objects)It handles all the generation of the SQL and the mapping to 
and fro Java Objects for us.

It is built on top of JDBC.It is a high level API.

In JPA being high level we can change the database we are using and not change bits of our code.

(I can easily swap from MYSQL to PostgreSQL and Vice Versa)

Technically JPA is a specification, the actual implementation is called hibernate.

Hibernate can be referred to as an ORM, mapping from SQL to Java Objects and vice versa,

JPA is a spefication
Hiberant is the ORM
(e)Spring Data JPA builds on top of JPA adding some extra functionaly like repositories.

JPA -->Query using java objects
JDBC-->Query using SQL.
```

**DB CONFIG INFO**

```agsl
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=changemeinprod!
spring.datasource.driver-class-name=org.postgresql.Driver
spring.sql.init.mode=always

```
**Running a Database Dump File on Start Up**

**Postgres Init SQL Database**

```agsl
we add a property 

spring.sql.init.mode = always

with this property it runs the data.sql and schema.sql when initialised.

```

**JDBC Template setUp**

```agsl
Intreacting with the database using SQL,

It is a very good alternative when we want to have fine grain control of our queries.

```
**Data Access Object Pattern**


```agsl
We do not want each and every service in our application to intereact with the database in
multiple repeated times.

For that reason we have DAO(s) whose responsibility is to interact with the database and do
the mappings to and from SQL to Java Objects.

These DAO(s) are then injected into the service which increases modularity of our application.

A DAO is a class corresponding to an entity, It is the responsibility of the DAO(s) in good
application design to know the structure of the database in relation to their entities then
handle the mapping to and fro Java Ojects.

Services can then inject the DAO(s) and ride on their behaviour through a nice ,clean interface.

```

**Database Integration Test**

```agsl
Dependecies can have scope, eg we can use different DB(s) in production and UAT,

    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
        <scope>test</scope>
    </dependency>
    
The H2 Database can be set to emulate any DB of choice,

spring.datasource.url=jdbc:h2:mem:testdb;MODE=PostgreSQL;DATABASE_TO_LOWER=TRUE;DEFAULT_NULL_ORDERING=HIGH
spring.datasource.username=sa
spring.datasource.password=password
spring.datasource.driver-class-name=org.h2.Driver

```


**Testing tips**

```
Our test packages should be a reflection of how our main packages look like.

It is good practice to seperate the test database from the production database.

It is about writing the behaviour then adding the minimal viable code,to accomplish what you desire.

```

**Integration Tests**

```agsl
They test the behavoir eg asserts.

Itegration Tests things like database connectivity etc.
Unit Tests tests our code.

UnitTests are run by the Maven Surefire PlugIn

The naming of our integration Test is important, if i run my tests with the IT prefix

@SpringBootTest-->Starts the test version of our application when our tests run

@ExtendWith(SpringExtension.class) -->Adds all the functionalities that come with spring

Note that if you have foreign key constraints integration tests will not run, if you have not
populated data from the first table

```

**Test Pollution**

```agsl
Example you have two seperate tests and both are creating/inserting data in a database.

once the first has inserted the data, the next one will raise and excpetion, this is what we call test pollution

The ideal phenomenon is that we should have a single database on each test.

we use @DirtiesContextMethod for this particular purpose

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)

It cleans down the context and makes it ready for the next test to run

```

**Spring Data JPA and Hibernate**

```agsl

It is very very high level, when using JPA, We do not need to create our dao(s) with SQL as we would do with JDBC.

(DAO The layer we were writing with JDBC ,especially for CRUD is entirely handled by hibernate)

(All the SQL is generated for US by hibernate)

@Entity Annotation

Once i label a doman with @Entity annotation when using spring JPA it is treated as a database table
This is done by the hibernate auto DDL.

If i was using jdbc the only way i would create my entities is via bringing SQL

The setting that makes hibernate to autocreate tables is,spring.jpa.hibernate.ddl-auto=update


spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=changemeinprod!
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.hibernate.ddl-auto=update

```

**Repositories**

```agsl

They are the DAO(s) when using spring data JPA, In them they have the SQL needed for our CRUD
Operations,

We do not have to provide implemenatation for them

They come with a very large number of already premade methods, this is hibernate in action,

You do not create the SQL and as well do not handle the conversion to or fro Java Objects,

extending public interface AuthorRepository extends CrudRepository<Author,Long> {

gives us a lot of methods that we can inherit.

```

**Cascade DataType**

```agsl
  
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    
    in a many to one context it means that as i create the child i out of the box i am able
    to create/fetch the one in a relationship
    
```

**Custom Queries JPA**
```agsl
Spring is clever enough to create an SQL with age less than
IS ABLE TO WORK Out custom queries depending on how i name methods in my interface

example, Iterable<Author> ageLessThan(int age);

There are times i may require more SQL hints,this is where HQL comes in,

```

**Jackson**

```agsl
Popular Java Liblary for dealing with JSON in the Java programming language

The process of turning a Java Object into JSON is ---> marshlling
The process of turning JSON into a Java Object is called --->Unmarshling

important to not on jackson.


  @JsonProperty("year")
  private String yearPublished;
  
  YearPublished will have another name
  

@JsonIgnoreProperties(ignoreUnknown = true)
public class Book {

  private String isbn;

  private String title;

  private String authorEntity;

  @JsonProperty("year")
  private String yearPublished;
}

Any propery not in the above can be ignored
```

**Rest API Tips**

```agsl

 @RequestBody--->The JSON Will be mapped into a Java Object
 The persistence layer should not have any interaction with the presentation layer
 We should never return entities in the controller/presentation layer.
```


**DTO(s)**

```agsl
 This decouples our presentation layer from our business logic       

```
**Java Todo(s)**

```agsl
(a)Stream API

Java Basics

(b)Docker Mastery
```