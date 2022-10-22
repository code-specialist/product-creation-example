package com.specialist.code.domain;

public interface ITechnicalProduct extends IProduct{
    String getTechnicalInformation();
    String getInstructionManual();

    boolean technicalInformationIsValid();
}
