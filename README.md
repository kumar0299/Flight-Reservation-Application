# Flight-Reservation-Application


It is a web based Flight Reservation Application using SpringBoot where a user can book a flight and track their process using their login credentials also it gives the flight authority to perform the checkin using checkIn module.

I have divided this project into 2 modules. The first project is flight Reservation and the Second module is checkIn module.

In this application, I have used MVC Architecture to develop the application.
To develop the view i have used JSP & JSTL tags. Used Controllers to interact with view and backend business logic, entity classes and repositories to perform MySQL database operations in spring boot. 


FLIGHT RESERVATION

This application will be availible to the passenger for flight booking. 
In this application when a registered user logins and book a flight to a destination city a pdf of ticket is generated and is emailed to the passenger using the passenger's Email address provided at the time of booking the flight using the itext pdf API and Spring Boot Starter Mail API to generate pdf and send the ticket. And A confirm booking page will be displayed at the end showing the Reservation ID of the passenger.


FLIGHT CHECKIN 

This application will be availible to the Airport authority for checkIn purpose.
When a person at the airport enters the flight reservation ID in checkin web page then the details of the passenger, flight and departure details and a form asking for the number of bags for checkin is displayed. upon checkingIn a message will be displayed to the authority showing boarding is completed message.


I have Integrated Flight Reservation and Flight CheckIn application based on micro services and i am using restful web services for Exposing the Web Services as well as consuming the Web Services . 
