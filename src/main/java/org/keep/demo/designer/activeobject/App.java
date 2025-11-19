package org.keep.demo.designer.activeobject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App implements Runnable{

  private final Logger logger = LoggerFactory.getLogger(App.class.getName());

  public static void main(String[] args) {
    var app = new App();
    app.run();
  }

  @Override
  public void run() {
    ActiveCreature creature;
    try {
      for (int i = 0;i < 10;i++) {
        creature = new Orc(Orc.class.getSimpleName().toString() + i);
        creature.eat();
        creature.roam();
      }
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      logger.error(e.getMessage());
    }
    Runtime.getRuntime().exit(1);
  }
}
