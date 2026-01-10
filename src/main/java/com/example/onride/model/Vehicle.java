package com.example.onride.model;

import java.util.Date;

public class Vehicle {

    private int vehicleId;
    private int renterId;
    private String type;
    private String brand;
    private String model;
    private int year;
    private double pricePerDay;
    private String location;
    private String status;
    private Date createdAt;
    private String registrationNumber;
    private boolean availability;
    private String imageUrl;

    public Vehicle(int vehicleId, int renterId, String type, String brand, String model, int year, double pricePerDay, String location, String status, Date createdAt, String registrationNumber, boolean availability, String imageUrl) {
        this.vehicleId = vehicleId;
        this.renterId = renterId;
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.pricePerDay = pricePerDay;
        this.location = location;
        this.status = status;
        this.createdAt = createdAt;
        this.registrationNumber = registrationNumber;
        this.availability = availability;
        this.imageUrl = imageUrl;
    }

    public Vehicle() {
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public int getRenterId() {
        return renterId;
    }

    public void setRenterId(int renterId) {
        this.renterId = renterId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
