# AutomatedParkingSystem
Solution for White Clark group Sydney

# How to run the solution
In order to run the solution please follow these steps

1. Unzip the project, this is a Maven project
2. Run mvn clean install inside AutomatedParkingSystem
3. Open any IDE preferably eclipse, import project as maven project in any IDE and run mvn clean install through IDE

Test run with example: For the given test inputs please find the following details

Test class - AutomatedParkingHandlerTest.java 
1. Scenario 1: "5,5:RFLFRFLF" - AutomatedParkingHandlerTest.testScenario1
2. Scenario 2: "6,6:FFLFFLFFLFF" - AutomatedParkingHandlerTest.testScenario2
3. Scenario 3: "5,5:FLFLFFRFFF" - AutomatedParkingHandlerTest.testScenario3

Note:- Note that AutomatedParkingHandlerTest.java also contains unit test for AutomatedParkingHandler class

# How to pass parameters from mvn command line
Commands:
1. mvn clean install -D<property_name>=<property_value> OR
2. mvn clean test -D<property_name>=<property_value>

Example:
1. mvn clean install -DserviceUrl=https://localhost:9090 -DdbConn=jdbc.aws1919:9090.au OR
2. mvn clean test -DserviceUrl=https://localhost:9090 -DdbConn=jdbc.aws1919:9090.au
