package makeTea;

import java.util.Date;
import java.util.Scanner;

import makeTea.entity.AirEntity;
import makeTea.entity.EntityPhysics;
import makeTea.entity.KettleEntity;
import makeTea.entity.StoveEntity;
import makeTea.entity.WaterEntity;

class MakeTea {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("\nAir temperature (C): ");
    double temperature = scanner.nextDouble();
    scanner.nextLine();
    System.out.println("\tAir temperature measured as " + temperature + " C\n");

    AirEntity air = new AirEntity(temperature, 0.05);
    StoveEntity stove = new StoveEntity(temperature, 0.5);
    KettleEntity kettle = new KettleEntity(temperature, 0.16);
    WaterEntity water = new WaterEntity(temperature, 0.06);

    System.out.println("\n Preparing kitchen...");
    EntityPhysics.touch(air, stove.getPlate());
    EntityPhysics.touch(air, kettle);
    EntityPhysics.touch(air, water);

    System.out.print("\nStove temperature (C): ");
    double temperatureOutput = scanner.nextDouble();
    scanner.nextLine();
    System.out.println("\tStove temperature will be set to " + temperatureOutput + " C\n");

    System.out.println("Pouring water in kettle...");
    EntityPhysics.touch(kettle, water);
    System.out.println("Putting kettle on stove plate...");
    EntityPhysics.touch(stove.getPlate(), kettle);
    System.out.println("Setting stove to " + temperatureOutput + " C...");
    stove.setTemperatureOutput(temperatureOutput);

    long startTime = new Date().getTime();
    long lastTime = new Date().getTime();
    long time = new Date().getTime();
    long endTime = startTime + 600000;
    double timeElapsed = 0.0;

    while (time < endTime && water.getTemperature() < 100) {
      double timeDelta = (time - lastTime) / 1000.0;
      stove.heatPlate(timeDelta);
      EntityPhysics.dissipateHeat(timeDelta);

      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      lastTime = time;
      time = new Date().getTime();
      timeElapsed = (time - startTime) / 1000.0;
      System.out.println("[" + timeElapsed + " s]:\t" + water.getTemperature() + " C");
    }

    System.out.println("Turning off stove.");
    stove.setTemperatureOutput(0);

    System.out.println("Water reached " + water.getTemperature() + " C heat in " + timeElapsed + " seconds.");

    System.out.println("Tea is done!");
    scanner.close();
  }
}
