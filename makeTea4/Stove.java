package makeTea4;

public class Stove extends Thread {
  final double STOVE_HEAT = 150.0;
  final double HEAT_FRAME = 0.015;
  final long TIME_FRAME = 100;
  Teapot kettle = null;
  boolean isOn = false;

  @Override
  public void run() {
    super.run();
    while (isOn) {
      if (kettle != null && kettle.getHeat() < STOVE_HEAT) {
        kettle.addHeat(HEAT_FRAME);
      }

      try {
        sleep(TIME_FRAME);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public void setPot(Teapot newPot) {
    kettle = newPot;
  }

  public void turnOn() {
    System.out.println(this.getClass().getName() + " turned ON");
    isOn = true;
    setDaemon(true);
    start();
  }

  public void turnOff() {
    System.out.println(this.getClass().getName() + " turned OFF");
    isOn = false;
  }
}
