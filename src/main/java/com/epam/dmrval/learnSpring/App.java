package com.epam.dmrval.learnSpring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/** Author - Damir_Valeev Created on 9/24/2019 */
public class App {
  private EventLogger eventLogger;
  private EventLogger eventLogger2;

  private Client client;

  public App(Client client, EventLogger eventLogger, EventLogger eventLogger2) {
    super();
    this.client = client;
    this.eventLogger = eventLogger;
    this.eventLogger2 = eventLogger2;

  }

  void logEvent(Event event, String msg) {
    String message = msg.replaceAll(client.getId(), client.getFullname());
    event.setMsg(message);
    eventLogger.logEvent(event);
    eventLogger2.logEvent(event);
  }

  public static void main(String[] args) {
    ApplicationContext applicationContext =
        new FileSystemXmlApplicationContext("src/main/resources/applicationContext.xml");
    App app = (App) applicationContext.getBean("app");
    Event event = (Event) applicationContext.getBean("event");
    app.logEvent(event, "Some for 1");
  }
}
