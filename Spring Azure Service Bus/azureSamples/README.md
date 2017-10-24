# Azure Service Bus with SpringBoot
This project will show you how to use Azure Service Bus with SpringBoot.

You will be sending a JSON message to the queue and picking it up and parsing it to the console.

## What you need to run this project. 

You will need to add the following dependencies:

#### Spring JMS
```
<dependency>
  <groupId>org.springframework</groupId>
  <artifactId>spring-jms</artifactId>
</dependency>

<dependency>
    <groupId>org.apache.qpid</groupId>
    <artifactId>qpid-jms-client</artifactId>
</dependency>
```
#### Simple JSON
```
<dependency>
  <groupId>com.googlecode.json-simple</groupId>
  <artifactId>json-simple</artifactId>
  <version>1.1.1</version>
</dependency>
```

### For mor info.

Tutorial Link: http://ramblingstechnical.blogspot.com/p/using-azure-service-bus-with-spring-jms.html

