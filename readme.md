App Flow

<img src="https://i.ibb.co/6ZfqZtr/Untitled-Workspace.png" alt="Untitled-Workspace" border="0">

Controller makes request to API endpoint and parses data. Then, the data is passed to the Model object and rendered to the webpage. The JS block of code will alter the heading sections based on the JSON array created at the time of the request. Each refresh to the page, enables a new call to the API.


To run: 

1. Download, unzip, and navigate to project directory in cmd/terminal.
2. type "./mvnw spring-boot:run" to deploy and run application.
3. Goto "localhost:8080/api/jokes"

You may need to download + install maven:

MacOS: https://mkyong.com/maven/install-maven-on-mac-osx/
Windows: https://mkyong.com/maven/how-to-install-maven-in-windows/
Linux: https://www.journaldev.com/33588/install-maven-linux-ubuntu

Alternatively, it can be run using IntelliJ or Eclipse IDEs. 

-Roshan
