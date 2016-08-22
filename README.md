This sample project demonstrates a bug in Spring Cloud Netflix as of this writing.
It causes feign clients to behave incorrectly when both nonSecurePortEnabled and
securePortEnabled are true for a service registered with Eureka.

For more information: https://github.com/spring-cloud/spring-cloud-netflix/issues/1270

To build the registry, client, and service subprojects:
* gradle clean build
To run each:
* java -jar registry/build/libs/registry.jar
* java -jar service/build/libs/service.jar
* java -jar client/build/libs/client.jar

Point your browser to http://localhost:8080/test

Until the bug is resolved, expect the following response:
Unrecognized SSL message, plaintext connection? executing GET http://SAMPLESERVICE/test

Note: You can receive a successfully response from the service by disabling its
eureka.instance.securePortEnabled property.
