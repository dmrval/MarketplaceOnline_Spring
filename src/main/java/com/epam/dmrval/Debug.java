package com.epam.dmrval;

import com.epam.dmrval.entity.UsersHelper;

/** Author - Damir_Valeev Created on 9/28/2019 */
public class Debug {
  public static void main(String[] args) {
    UsersHelper usersHelper = new UsersHelper();
    System.out.println(usersHelper.getUserByLogin("ivan").getUserRole().name());
  }
}
