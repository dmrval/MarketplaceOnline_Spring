package com.epam.dmrval.learnSpring;

/** Author - Damir_Valeev Created on 9/24/2019 */
public class ConsoleEventLogger implements EventLogger {
    public void logEvent(String str) {
    System.out.println(str);
  }
}
