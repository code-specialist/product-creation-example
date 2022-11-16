package com.specialist.code.domain;

public class TechnicalProduct implements ITechnicalProduct{
    private String id;
    private String name;
    private String description;
    private double price;

    private long createdAt;
    private String technicalInformation;
    private String instructionManual;



    public TechnicalProduct(String id, String name, String description, double price, String technicalInformation, String instructionManual, long createdAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.technicalInformation = technicalInformation;
        this.instructionManual = instructionManual;
        this.createdAt = createdAt;
    }
    @Override
    public String getId() {
        return id;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public long getCreatedAt() { return createdAt; }

    @Override
    public double getPrice() {
        return price;
    }
    @Override
    public boolean nameIsValid() {
        return name != null && name.length() > 5;
    }
    @Override
    public String getTechnicalInformation() {
        return technicalInformation;
    }
    @Override
    public String getInstructionManual() {
        return instructionManual;
    }

    @Override
    public boolean technicalInformationIsValid() {
        return !this.technicalInformation.isEmpty();
    }
}
