<h2>Gmail Backup Service</h2>

<h3>Requirements</h3>
For building and running the application you would require:<br>

<ul>
<li>JDK 1.8</li>
</ul>

<h3>Running the application</h3>
<ul>
<li>Run following command to build and run the application <b>./mvnw clean spring-boot:run</b></li>
</ul>

<h3>REST Endpoints Documentation</h3>
<ul>
Swagger - Documentation & Testing <b>http://localhost:8080/swagger-ui.html</b>
</ul>

<h3>Technologies and Frameworks used</h3>
For building and running the application you need:<br>

<ul>
<li>Language: Java 8</li>
<li>Build and Packaging: Maven</li>
<li>Application Framework: Spring Boot</li>
<li>Application Documentation: Swagger</li>
<li>Unit Testing: Junit, Mockito</li>
<li>Integration Testing: Spring Test</li>
<li>Test coverage: Jacoco</li>
</ul>

<h3>Test cases</h3>
<ul>
Application has following test cases covering 100% of application
  <li>Unit test cases</li>
  <li>Controller test cases</li>
  <li>Integration test cases</li>
</ul>

<h3>Running test cases and checking coverage</h3>
<ul>
<li>Run following command to run unit and integration test cases <b>./mvnw clean test</b></li>
<li>Run following command to generate test coverage in html format <b>./mvnw clean site</b></li>
</ul>

<h3>Layers and packaging of application</h3>
<ul>

<li><b>model</b> — to hold our models</li>
<li><b>service</b> — to hold our business logic</li>
<li><b>controller</b> — to listen to the client</li>
<li><b>enums</b> — to define fixed set of constants to be used application wide</li>
<li><b>test/</b> - contains unit and integration tests</li>



