package com.specialist.code.application.model.response;

import java.util.Objects;

public class TechnicalProductResponseModel {
    private String id;
    private String name;
    private String description;
    private double price;
    private String technicalInformation;
    private String instructionManual;
    private String createdAt;

    public TechnicalProductResponseModel(String id, String name, String description, double price, String technicalInformation, String instructionManual, String createdAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.technicalInformation = technicalInformation;
        this.instructionManual = instructionManual;
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TechnicalProductResponseModel that = (TechnicalProductResponseModel) o;

        if (Double.compare(that.price, price) != 0) return false;
        if (!id.equals(that.id)) return false;
        if (!name.equals(that.name)) return false;
        if (!Objects.equals(description, that.description)) return false;
        if (!technicalInformation.equals(that.technicalInformation)) return false;
        if (!Objects.equals(instructionManual, that.instructionManual))
            return false;
        return Objects.equals(createdAt, that.createdAt);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + technicalInformation.hashCode();
        result = 31 * result + (instructionManual != null ? instructionManual.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        return result;
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
