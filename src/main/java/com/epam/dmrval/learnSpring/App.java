package com.epam.dmrval.learnSpring;

/** Author - Damir_Valeev Created on 9/24/2019 */
public class App {
  private EventLogger eventLogger;
  private Client client;

  public App(Client client, EventLogger eventLogger) {
    this.client = client;
    this.eventLogger = eventLogger;
  }

  public static void main(String[] args) {
    App app = new App(new Client("1", "Ivan"), new ConsoleEventLogger());
    app.logEvent("Some event for user 1");
  }

  private void logEvent(String smsg) {
    String message = smsg.replaceAll(client.getId(), client.getFullname());
    eventLogger.logEvent(message);
  }
}
