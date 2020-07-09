Vending Machine Inventory Management API
-

#### Task

Please write the Java code for a system that would control the inventory inside the vending machine.

The inventory system should keep track of the number and type of drinks inside the vending machine. 
For example, it would be queried by other systems to know how many bottles of Coca-Cola are in the machine.

Requirements:
- All interactions (CRUD operations) with the inventory system from other systems are done via REST APIs.
- The inventory data must be persistent at the end of every interaction with the system.
- Ability to demonstrate and explain your code live during a second interview.

#### How to build

    gradlew jar
    
and then find a jar in `build/libs`

#### How to run

Option 1: run the JAR using 
    
    java -jar [jar_file_name]
    
Option 2: from Gradle directly

    gradlew run
    
When started you can acess Swagger console at http://localhost:8080/swagger-ui.html