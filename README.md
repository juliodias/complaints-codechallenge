[![Build Status](https://travis-ci.org/juliodias/complaints-codechallenge.svg?branch=master)](https://travis-ci.org/juliodias/complaints-codechallenge)

# Guidelines

Every application can be executed independently, but to test them together make the build process in the following order:

- service-registration (load balancing and failover).
- api-gateway (routing api requests).
- complaint-service (api with services about complaints).

### Running applications:
We have 2 ways to run the applications:

<pre><strong>Running from IDE:</strong>
Run the main method inside Application classes.

<strong>Running from command line: </strong>
mvn spring-boot:run (use -Dspring.profiles.active=“cloud” when testing all applications together).

<strong>Running tests:</strong>
mvn test</pre>

The example of API requests can be found in <strong>complaints.json</strong> with your endpoints.

### Stack:
<pre>
Language: Java 8
Framework: Spring Framework (Boot and Data-REST)
Dependency management: Maven
Database: MongoDB

CI-Tools:
Docker
Travis-CI</pre>
