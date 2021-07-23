# Getting Started

stock-quotes-app is a web application build with Thymeleaf as UI and Spring-Boot as Server with REST API end point implementations.

This application will provide an interface for the user to select and add the stock quote to get the real time metrics for stock quote.

This application incorporate with auto load refresh mechanism say for every 60 seconds the page will be refreshed and will fetch the real time metrics for the selected quotes.

This application will provide an interface to purge the selected stock quotes.

This application incorporate the YAHOO finance API to retrieve the real time metrics.

steps to run the application at command prompt:
-----------------------------------------------

step 1) make sure the maven is setup in the current machine where the app needs to run.

step 2) mvn spring-boot:run, this command will build the spring boot app and will up the tomcat embedded server.

step 3) http://localhost:9996 navigate to this URL to view the stock quotes and metrics real time.