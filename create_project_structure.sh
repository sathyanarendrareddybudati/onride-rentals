#!/bin/bash

# Bash script to create the OnRide Rentals project structure
# This script creates folders and empty files only (no content)

echo "Creating OnRide Rentals project structure..."

# Create root directories
mkdir -p .git/hooks
mkdir -p .git/info
mkdir -p .git/objects/00
mkdir -p .git/objects/01
mkdir -p .git/objects/02
mkdir -p .git/refs/heads
mkdir -p .git/refs/remotes
mkdir -p .git/refs/tags

mkdir -p src/main/java/com/onriderentals/controller
mkdir -p src/main/java/com/onriderentals/dao
mkdir -p src/main/java/com/onriderentals/factory
mkdir -p src/main/java/com/onriderentals/model
mkdir -p src/main/java/com/onriderentals/util

mkdir -p src/main/resources/com/onriderentals/view

# Create root files
touch .gitignore
touch CODE_EXAMPLES_GUIDE.md
touch IMPLEMENTATION_GUIDE.md
touch README.md
touch README_COMPLETION.md
touch UI_IMPLEMENTATION_SUMMARY.md
touch pom.xml
touch tables.sql

# Create .git files
touch .git/hooks/applypatch-msg.sample
touch .git/hooks/commit-msg.sample
touch .git/hooks/fsmonitor-watchman.sample
touch .git/hooks/post-update.sample
touch .git/hooks/pre-applypatch.sample
touch .git/hooks/pre-commit.sample
touch .git/hooks/pre-merge-commit.sample
touch .git/hooks/pre-push.sample
touch .git/hooks/pre-rebase.sample
touch .git/hooks/pre-receive.sample
touch .git/hooks/prepare-commit-msg.sample
touch .git/hooks/push-to-checkout.sample
touch .git/hooks/sendemail-validate.sample
touch .git/hooks/update.sample

touch .git/info/exclude

touch .git/COMMIT_EDITMSG
touch .git/FETCH_HEAD
touch .git/HEAD
touch .git/ORIG_HEAD

# Create Java source files
touch src/main/java/com/onriderentals/Launcher.java
touch src/main/java/com/onriderentals/Main.java

# Controller files
touch src/main/java/com/onriderentals/controller/AdminDashboardController.java
touch src/main/java/com/onriderentals/controller/BookingConfirmationController.java
touch src/main/java/com/onriderentals/controller/CustomerDashboardController.java
touch src/main/java/com/onriderentals/controller/FavoritesController.java
touch src/main/java/com/onriderentals/controller/HomeController.java
touch src/main/java/com/onriderentals/controller/LoginController.java
touch src/main/java/com/onriderentals/controller/MyBookingsController.java
touch src/main/java/com/onriderentals/controller/NavbarController.java
touch src/main/java/com/onriderentals/controller/NotificationsController.java
touch src/main/java/com/onriderentals/controller/RegisterController.java
touch src/main/java/com/onriderentals/controller/RenterDashboardController.java
touch src/main/java/com/onriderentals/controller/ReportsController.java
touch src/main/java/com/onriderentals/controller/ReviewsController.java
touch src/main/java/com/onriderentals/controller/VehicleCardController.java
touch src/main/java/com/onriderentals/controller/VehicleDetailsController.java
touch src/main/java/com/onriderentals/controller/VehicleRentalController.java

# DAO files
touch src/main/java/com/onriderentals/dao/BookingDAO.java
touch src/main/java/com/onriderentals/dao/Database.java
touch src/main/java/com/onriderentals/dao/FavoriteDAO.java
touch src/main/java/com/onriderentals/dao/ReviewDAO.java
touch src/main/java/com/onriderentals/dao/UserDAO.java
touch src/main/java/com/onriderentals/dao/VehicleDAO.java
touch src/main/java/com/onriderentals/dao/VehiclePhotoDAO.java

# Factory files
touch src/main/java/com/onriderentals/factory/.gitkeep

# Model files
touch src/main/java/com/onriderentals/model/AdminLog.java
touch src/main/java/com/onriderentals/model/Booking.java
touch src/main/java/com/onriderentals/model/Favorite.java
touch src/main/java/com/onriderentals/model/Notification.java
touch src/main/java/com/onriderentals/model/Payment.java
touch src/main/java/com/onriderentals/model/PaymentHistory.java
touch src/main/java/com/onriderentals/model/Report.java
touch src/main/java/com/onriderentals/model/Review.java
touch src/main/java/com/onriderentals/model/SessionManager.java
touch src/main/java/com/onriderentals/model/User.java
touch src/main/java/com/onriderentals/model/Vehicle.java
touch src/main/java/com/onriderentals/model/VehiclePhoto.java

# Util files
touch src/main/java/com/onriderentals/util/PasswordUtils.java
touch src/main/java/com/onriderentals/util/S3Service.java

# Create resource files
touch src/main/resources/aws.properties
touch src/main/resources/database.properties
touch src/main/resources/schema.sql

# FXML view files
touch src/main/resources/com/onriderentals/view/AdminDashboard.fxml
touch src/main/resources/com/onriderentals/view/BookingConfirmation.fxml
touch src/main/resources/com/onriderentals/view/CustomerDashboard.fxml
touch src/main/resources/com/onriderentals/view/Favorites.fxml
touch src/main/resources/com/onriderentals/view/Home.fxml
touch src/main/resources/com/onriderentals/view/Login.fxml
touch src/main/resources/com/onriderentals/view/MyBookings.fxml
touch src/main/resources/com/onriderentals/view/Navbar.fxml
touch src/main/resources/com/onriderentals/view/Notifications.fxml
touch src/main/resources/com/onriderentals/view/Register.fxml
touch src/main/resources/com/onriderentals/view/RenterDashboard.fxml
touch src/main/resources/com/onriderentals/view/Reports.fxml
touch src/main/resources/com/onriderentals/view/Reviews.fxml
touch src/main/resources/com/onriderentals/view/VehicleCard.fxml
touch src/main/resources/com/onriderentals/view/VehicleDetails.fxml
touch src/main/resources/com/onriderentals/view/VehicleRental.fxml

# CSS files
touch src/main/resources/com/onriderentals/view/admin.css
touch src/main/resources/com/onriderentals/view/stats.css
touch src/main/resources/com/onriderentals/view/styles.css

echo "Project structure created successfully!"
echo "Total files and directories created:"
echo "- Root files: 9"
echo "- Java source files: 41"
echo "- Resource files: 20"
echo "- Git files: 20"
echo "- Total: 90+ files and directories"
