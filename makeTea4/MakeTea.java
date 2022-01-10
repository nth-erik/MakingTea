package makeTea4;

import java.util.Date;

public class MakeTea {
  public static void main(String[] args) {
    final double BOIL_HEAT = 100.0;
    final long TIME_FRAME = 100;
    long lastTime = new Date().getTime();
    long time;
    TeaFilter filter = new TeaFilter();
    Teapot teapot = new Teapot();
    Cup cup = new Cup(filter);
    Stove stove = new Stove();
    Air air = new Air(teapot, cup);

    stove.setPot(teapot);
    stove.turnOn();

    while (teapot.getHeat() < BOIL_HEAT) {
      System.out.println(teapot.getClass().getName() + " heat: " + teapot.getHeat());

      try {
        Thread.sleep(TIME_FRAME);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    time = new Date().getTime();
    System.out.println("Water has boiled! " + Math.ceil((time - lastTime) / 1000));

    cup.addWater(teapot.getHeat());

    while (cup.getFlavor() < 1.0) {
      System.out.println(cup.getClass().getName() + " flavor: " + cup.getFlavor());
      System.out.println(cup.getClass().getName() + " heat: " + cup.getHeat());

      try {
        Thread.sleep(TIME_FRAME);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    stove.turnOff();

    System.out.println("Tea is done!");
    System.out.println("Boiled: " + Math.ceil((time - lastTime) / 1000));
    System.out.println("Soaked: " + Math.ceil((new Date().getTime() - time) / 1000));
    System.out.println("Total:  " + Math.ceil((new Date().getTime() - lastTime) / 1000));
  }
}
