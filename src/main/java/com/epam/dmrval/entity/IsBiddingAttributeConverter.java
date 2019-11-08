package com.epam.dmrval.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/** Author - Damir_Valeev */
@Converter
public class IsBiddingAttributeConverter implements AttributeConverter<Boolean, Integer> {

  @Override
  public Integer convertToDatabaseColumn(Boolean aBoolean) {
    if (aBoolean == null) {
      return null;
    }
    return aBoolean ? 1 : 0;
  }

  @Override
  public Boolean convertToEntityAttribute(Integer integer) {
    if (integer == null) {
      return null;
    }
    switch (integer) {
      case 1:
        return true;
      case 0:
        return false;
      default:
        throw new IllegalArgumentException(integer + " not supported.");
    }
  }
}
