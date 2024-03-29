package com.specialist.code.application.productcreation.model.request;

public class TechnicalProductRequestModel {
    private String id;
    private String name;
    private String description;
    private double price;
    private String technicalInformation;
    private String instructionManual;

    public TechnicalProductRequestModel(String id, String name, String description, double price, String technicalInformation, String instructionManual) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.technicalInformation = technicalInformation;
        this.instructionManual = instructionManual;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTechnicalInformation() {
        return technicalInformation;
    }

    public void setTechnicalInformation(String technicalInformation) {
        this.technicalInformation = technicalInformation;
    }

    public String getInstructionManual() {
        return instructionManual;
    }

    public void setInstructionManual(String instructionManual) {
        this.instructionManual = instructionManual;
    }
}
