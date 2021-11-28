package makeTea2.entity;

import java.util.Set;

import makeTea2.input.Input;

public abstract class Entity implements TemperatureInterface {
  protected Set<Entity> touchList;
  private double temperature;
  private double dissipation;

  // Constructor
  public Entity(double t, double d) {
    temperature = t;
    dissipation = d;
  }
  public Entity(double t, Input input) {
    temperature = t;
    dissipation = input.prompt(getClass().getName() + " dissipation:");
  }
  public Entity(Input input) {
      temperature = input.prompt(getClass().getName() + " temperature:");
      dissipation = input.prompt(getClass().getName() + " dissipation:");
  }

  // Temperature
  public double getTemperature() {
    return temperature;
  }
  protected void setTemperature(double t) {
    temperature = t;
  }
  public double getDissipation() {
    return dissipation;
  }
  protected void setDissipation(double d) {
    dissipation = d;
  }
}
