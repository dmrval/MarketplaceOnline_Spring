package com.epam.dmrval.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/** Author - Damir_Valeev */
@Converter
public class RoleAttributeConverter implements AttributeConverter<Role, Integer> {
  @Override
  public Integer convertToDatabaseColumn(Role attribute) {
    if (attribute == null) {
      return null;
    }
    switch (attribute) {
      case USER:
        return 1;
      case GUEST:
        return 2;
      default:
        throw new IllegalArgumentException(attribute + " not supported.");
    }
  }

  @Override
  public Role convertToEntityAttribute(Integer dbData) {
    if (dbData == null) {
      return null;
    }
    switch (dbData) {
      case 1:
        return Role.USER;
      case 2:
        return Role.GUEST;
      default:
        throw new IllegalArgumentException(dbData + " not supported.");
    }
  }
}
