package com.example.onride.util;

import com.example.onride.dao.UserDAO;
import com.example.onride.model.User;

public class DatabaseInitializer {
    
    public static void createDemoUsers() {
        UserDAO userDAO = new UserDAO();
        
        // Create Admin user
        User admin = new User();
        admin.setName("Admin User");
        admin.setEmail("admin@demo.com");
        admin.setPhone("1234567890");
        admin.setRole("ADMIN");
        admin.setActive(true);
        
        if (!userDAO.emailExists(admin.getEmail())) {
            userDAO.signUp(admin, "admin123");
            System.out.println("Created admin user: admin@demo.com / admin123");
        }
        
        // Create Renter user
        User renter = new User();
        renter.setName("Renter User");
        renter.setEmail("renter@demo.com");
        renter.setPhone("0987654321");
        renter.setRole("RENTER");
        renter.setActive(true);
        
        if (!userDAO.emailExists(renter.getEmail())) {
            userDAO.signUp(renter, "renter123");
            System.out.println("Created renter user: renter@demo.com / renter123");
        }
        
        // Create Customer user
        User customer = new User();
        customer.setName("Customer User");
        customer.setEmail("customer@demo.com");
        customer.setPhone("5555555555");
        customer.setRole("CUSTOMER");
        customer.setActive(true);
        
        if (!userDAO.emailExists(customer.getEmail())) {
            userDAO.signUp(customer, "customer123");
            System.out.println("Created customer user: customer@demo.com / customer123");
        }
    }
}
