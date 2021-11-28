package makeTea2.stove;

import makeTea2.entity.Entity;
import makeTea2.input.Input;

public class Stove extends Entity {
  private double outputGain = 0.05;
  private double output = 0.0;
  private double maxOutput = 250.0;

  public Stove(double temperature, Input input) {
    super(temperature, input);
    setTemperature(clamp(temperature, 0.0, maxOutput));
    this.outputGain = clamp(outputGain, 0.0, 1.0);
  }

  public void changeOutput(double output) {
    this.output = output;
  }

  @Override
  public void dissipateOverTime(double time) {
    setTemperature(getTemperature() + (output - getTemperature()) * outputGain * time);
  }

  private double clamp(double val, double min, double max) {
    return Math.max(min, Math.min(max, val));
  }
}
