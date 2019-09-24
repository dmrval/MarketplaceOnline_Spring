package com.epam.dmrval.learnSpring;

/** Author - Damir_Valeev Created on 9/24/2019 */
public class ConsoleEventLogger implements EventLogger {

  @Override
  public void logEvent(Event event) {
    System.out.println(event.toString());
  }
}
