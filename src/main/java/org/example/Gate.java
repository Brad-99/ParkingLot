package org.example;

class Gate {
    private VehicleType type;
    private boolean isOpen;

    public Gate(VehicleType type) {
        this.type = type;
        this.isOpen = false;
    }

    public void openGate() {
        this.isOpen = true;
    }

    public void closeGate() {
        this.isOpen = false;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public VehicleType getType() {
        return type;
    }
}
