package com.epam.dmrval.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/** Author - Damir_Valeev */
@Converter
public class SexAttributeConverter implements AttributeConverter<Sex, Integer> {
  @Override
  public Integer convertToDatabaseColumn(Sex attribute) {
    if (attribute == null) {
      return null;
    }
    switch (attribute) {
      case MR:
        return 1;
      case MRS:
        return 2;
      default:
        return -1;
    }
  }

  @Override
  public Sex convertToEntityAttribute(Integer dbData) {
    if (dbData == null) {
      return null;
    }
    switch (dbData) {
      case 1:
        return Sex.MR;
      case 2:
        return Sex.MRS;
      default:
        throw new IllegalArgumentException(dbData + " not supported.");
    }
  }
}
