package org.example;

enum VehicleType {
    LARGE, CAR, MOTORCYCLE
}

public class ParkingSpot {
    private VehicleType type;
    private boolean isReserved;
    private String reservedLicensePlate;
    private double fee;

    public ParkingSpot(VehicleType type, double fee) {
        this.type = type;
        this.fee = fee;
        this.isReserved = false;
    }

    public VehicleType getType() {
        return type;
    }

    public boolean isAvailable() {
        return !isReserved;
    }

    public void reserverSpot(String licensePlate) {
        this.isReserved = true;
        this.reservedLicensePlate = licensePlate;
    }

    public void freeSpot() {
        this.isReserved = false;
        this.reservedLicensePlate = null;
    }

    public double getFee() {
        return fee;
    }

    public String getReservedLicensePlate() {
        return reservedLicensePlate;
    }
}
