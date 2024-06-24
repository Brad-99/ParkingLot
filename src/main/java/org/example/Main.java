package org.example;

import java.lang.reflect.ParameterizedType;

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot();

        parkingLot.addParkingSpot(new ParkingSpot(VehicleType.CAR, 10.0));
        parkingLot.addParkingSpot(new ParkingSpot(VehicleType.LARGE, 20.0));
        parkingLot.addParkingSpot(new ParkingSpot(VehicleType.MOTORCYCLE, 5.0));

        parkingLot.addEntryGate(new Gate(VehicleType.CAR));
        parkingLot.addEntryGate(new Gate(VehicleType.LARGE));
        parkingLot.addEntryGate(new Gate(VehicleType.MOTORCYCLE));
        parkingLot.addExitGate(new Gate(VehicleType.CAR));
        parkingLot.addExitGate(new Gate(VehicleType.LARGE));
        parkingLot.addExitGate(new Gate(VehicleType.MOTORCYCLE));

        // Entry
        parkingLot.enterVehicle("ABC123,", VehicleType.CAR);
        parkingLot.enterVehicle("XYZ789", VehicleType.LARGE);

        // Reserveation
        parkingLot.reservedSpotByPlate("MN0456", VehicleType.MOTORCYCLE);

        // Payment and exit
        parkingLot.exitVehicle("ABC123", "credit card");
        parkingLot.exitVehicle("XYZ789", "cash");



    }








}