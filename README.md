# OnRide Rentals - Vehicle Rental System

A cross-platform Bike & Car Booking System built with JavaFX and MySQL.

## Features

- **Role-based Authentication**: Admin, Renter, and Customer roles
- **Vehicle Management**: Add, edit, and manage vehicle listings
- **Booking System**: Search, filter, and book vehicles
- **Admin Dashboard**: Analytics and user management
- **Secure Authentication**: BCrypt password hashing
- **Modern UI**: JavaFX with CSS styling

## Requirements

- Java 17+
- MySQL 8.0+
- Maven 3.6+

## Setup Instructions

### 1. Database Setup

1. Create a MySQL database:
```sql
CREATE DATABASE onride_rentals;
```

2. Run the database schema:
```bash
mysql -u root -p onride_rentals < tables.sql
```

3. Configure database connection:
```bash
cp src/main/resources/database.properties.example src/main/resources/database.properties
```

Edit `database.properties` with your MySQL credentials:
```properties
MASTER_DB_HOST=localhost
MASTER_DB_PORT=3306
MASTER_DB_NAME=onride_rentals
MASTER_DB_USER=root
MASTER_DB_PASSWORD=your_password
```

### 2. Build and Run

1. Compile the project:
```bash
mvn clean compile
```

2. Run the application:
```bash
mvn javafx:run
```

Or create an executable JAR:
```bash
mvn clean package
java -jar target/onride-1.0.jar
```

## Demo Accounts

The application automatically creates demo users on first run:

- **Admin**: admin@demo.com / admin123
- **Renter**: renter@demo.com / renter123  
- **Customer**: customer@demo.com / customer123

## Project Structure

```
src/main/java/com/example/onride/
├── controller/          # JavaFX controllers
├── dao/                # Data access objects
├── model/              # Entity classes
├── database/           # Database connection
└── util/               # Utility classes

src/main/resources/
├── com/example/onride/ # FXML views and CSS
└── database.properties # Database configuration
```

## User Roles

### Admin
- Manage all users
- View analytics and reports
- Approve/block vehicle listings
- System administration

### Renter
- Add and manage vehicles
- View booking requests
- Track earnings
- Manage vehicle availability

### Customer
- Search and filter vehicles
- Make bookings
- View booking history
- Manage favorites

## Security Features

- BCrypt password hashing
- Role-based access control
- SQL injection prevention with prepared statements
- Input validation

## Technologies Used

- **Frontend**: JavaFX 21
- **Backend**: Java 17
- **Database**: MySQL 8.0
- **Build Tool**: Maven
- **Security**: BCrypt
- **Logging**: SLF4J + Logback

## Future Enhancements

- Mobile applications (Android/iOS)
- Review and rating system
- Real-time GPS tracking
- Push notifications
- AI-based pricing suggestions
- Payment gateway integration
