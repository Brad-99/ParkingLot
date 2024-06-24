package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public class ParkingLot {
    private ArrayList<ParkingSpot> spots;
    private ArrayList<Gate> entryGates;
    private ArrayList<Gate> exitGates;
    private AutomaticPaymentMachine paymentMachine;
    private HashMap<String, ParkingSpot> parkedVehicles;


    public ParkingLot() {
        this.spots = new ArrayList<>();
        this.entryGates = new ArrayList<>();
        this.exitGates = new ArrayList<>();
        this.paymentMachine = new AutomaticPaymentMachine();
        this.parkedVehicles = new HashMap<>();
    }

    public void addParkingSpot(ParkingSpot spot) {
        this.spots.add(spot);
    }

    public void addEntryGate(ParkingSpot spot) {
        this.spots.add(spot);
    }

    public void addExitGate(Gate gate) {
        this.exitGates.add(gate);
    }

    public boolean enterVehicle(String licensePlate, VehicleType type) {
        for (Gate gate : entryGates) {
            if (gate.getType() == type && !gate.isOpen()) {
                for (ParkingSpot spot : spots) {
                    if (spot.getType() == type && spot.isAvailable()) {
                        spot.reserverSpot(licensePlate);
                        parkedVehicles.put(licensePlate, spot);
                        gate.openGate();
                        System.out.println(licensePlate + " entered through " + type + " gate.");
                        gate.closeGate();
                        return true;
                    }
                }
            }
        }
        System.out.println("No available spots for " + type);
        return false;
    }

    public boolean exitVehicle(String licensePlate, String paymentMethod) {
        ParkingSpot spot = parkedVehicles.get(licensePlate);
        if (spot != null) {
            double fee = spot.getFee();
            if (paymentMachine.processPayment(licensePlate, fee, paymentMethod)) {
                spot.freeSpot();
                parkedVehicles.remove(licensePlate);
                for (Gate gate : exitGates) {
                    if (gate.getType() == spot.getType() && !gate.isOpen()) {
                        gate.openGate();
                        System.out.println(licensePlate + " exited through " + spot.getType() + " gate");
                        gate.closeGate();
                        return true;
                    }
                }
            } else {
                System.out.println("Payment failed for " + licensePlate);
            }
        } else {
            System.out.println("Vehicle not found");
        }
        return false;
    }

    public void reservedSpotByPlate(String licensePlate, VehicleType type) {
        for (ParkingSpot spot : spots) {
            if (spot.getType() == type && spot.isAvailable()) {
                spot.reserverSpot(licensePlate);
                System.out.println("Reserved spot for " + licensePlate);
                return;
            }
        }
        System.out.println("No available spots to reserve for " + type);
    }

    public void addEntryGate(Gate gate) {
    }
}
