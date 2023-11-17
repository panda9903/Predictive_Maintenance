package com.example.myapplication;

public class VehicleData {
    private int UDI;
    private String productID ;
    private String type;
    private double airTemp;
    private double processTemp;
    private int rpm;
    private double torque;
    private int toolWear;
    private int target;
    private String failureType;

    public int getUDI() {
        return UDI;
    }

    public void setUDI(int UDI) {
        this.UDI = UDI;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAirTemp() {
        return airTemp;
    }

    public void setAirTemp(double airTemp) {
        this.airTemp = airTemp;
    }

    public double getProcessTemp() {
        return processTemp;
    }

    public void setProcessTemp(double processTemp) {
        this.processTemp = processTemp;
    }

    public int getRpm() {
        return rpm;
    }

    public void setRpm(int rpm) {
        this.rpm = rpm;
    }

    public double getTorque() {
        return torque;
    }

    public void setTorque(double torque) {
        this.torque = torque;
    }

    public int getToolWear() {
        return toolWear;
    }

    public void setToolWear(int toolWear) {
        this.toolWear = toolWear;
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public String getFailureType() {
        return failureType;
    }

    public void setFailureType(String failureType) {
        this.failureType = failureType;
    }
}
