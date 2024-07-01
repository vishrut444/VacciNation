# VacciNation

VacciNation is a Vaccine Appointment Management Backend

This project involves the development of a Spring Boot backend for managing vaccine appointments using REST APIs. It provides a comprehensive solution for user registration, appointment booking, dose tracking, and doctor management, ensuring a streamlined vaccination process. 

Below are the key functionalities and their detailed workings:

## Features

**1) User Registration**

- **Unique UUID Generation:** Upon registration, each user is assigned a unique UUID application number.
- **Real-Time Email Notifications:** A confirmation email is sent to the user immediately upon registration, containing the UUID application number. This number is crucial for booking vaccine appointments.
  
**2) Appointment Booking**

- **Using Application Number:** Users can use their unique application number to book an appointment for their vaccine dose.
- **Doctor Registration:** Doctors are registered in the system with a unique Doctor ID, categorized by their specializations.
- **Specialization-Based Booking:** When booking an appointment, users can select a doctor based on the desired specialization. The system checks for available doctors in that specialization and books the appointment accordingly.
- **Real-Time Email Notifications:* Upon successful booking, the user receives an email containing the booking confirmation, doctor's details, and a unique booking ID.
  
**3) Dose Administration**
- **Tracking Dose Details:** When a user receives a vaccine dose, the system records the dose details, including information about the doctor who administered the vaccine.
- **Cancellation and Hold Options:** Users have the flexibility to cancel their appointments or put them on hold if needed.
  
## Tech Stack

- **JAVA**
- **Spring Boot**
- **JPA & Hibernate**
- **SQL Database**
- **REST API's**
- **DBeaver**
- **IntelliJ IDE**

This backend system ensures a seamless and efficient vaccination process by integrating user-friendly features, real-time notifications, and robust data management capabilities. It aims to enhance the overall experience for users and healthcare providers involved in the vaccination process.
