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

```