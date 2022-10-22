package com.specialist.code.domain;

public class TechnicalProduct implements ITechnicalProduct{
    private String id;
    private String name;
    private String description;
    private double price;
    private String technicalInformation;
    private String instructionManual;

    public TechnicalProduct(String id, String name, String description, double price, String technicalInformation, String instructionManual) {
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

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public boolean nameIsValid() {
        return name != null && name.length() > 5;
    }

    public String getTechnicalInformation() {
        return technicalInformation;
    }

    public String getInstructionManual() {
        return instructionManual;
    }

    @Override
    public boolean technicalInformationIsValid() {
        return !this.technicalInformation.isEmpty();
    }
}
