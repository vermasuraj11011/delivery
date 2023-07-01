# Delivery Backend System

## Intro
The Delivery App is a web-based application that allows users to order food from various restaurants and track the estimated delivery time. Administrators can add restaurants to the platform to expand the available options for users.

## Features
User Registration: Users can create an account or log in to their existing account.
Restaurant Listing: Users can view a list of restaurants available on the platform.
Food Menu: Users can browse the menu of each restaurant and add items to their cart.
Order Placement: Users can place an order by providing delivery details and making the payment.
Order Tracking: Users can track the status of their orders and see the estimated delivery time.
Restaurant Management (Admin): Administrators can log in to the admin panel to add new restaurants to the platform.

## Technologies Used
Java
Spring Boot
Spring MVC
Spring Data JPA
MySQL
Hibernate
Maven

## Installation
1. Clone the repository: git clone https://github.com/your-username/delivery-app.git
2. Import the project into your preferred IDE (e.g., IntelliJ, Eclipse).
3. Set up your database connection details in the application.properties file.
4. Build the project and resolve the dependencies using Maven.
5. Run the application.

## Folder Structure
- src/main/java/com/delivery/Delivery_app: Contains the main application code.
  - config: Configuration files and classes for Spring Boot configuration.
  - controller: Controller classes for handling different routes and business logic.
  - entity: Defines the data models and entities.
  - repository: Contains the repository interfaces for data access.
  - service: Service classes for implementing business logic.
  - exception: Exception classes for handling custom exceptions.
    
