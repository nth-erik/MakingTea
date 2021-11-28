package makeTea2.entity;

public interface TemperatureInterface {
  public double getTemperature();
  public double getDissipation();
  public void dissipateOverTime(double time);
}
