package com.epam.dmrval.entity;

import javax.persistence.Entity;

/** Author - Damir_Valeev Created on 9/16/2019 */
public enum Sex {
  MR("Mr."),
  MRS("Mrs.");

  String respectCall;

  Sex(String respectCall) {
    this.respectCall = respectCall;
  }

  Sex() {
  }

  public String getRespectCall() {
    return respectCall;
  }
}
