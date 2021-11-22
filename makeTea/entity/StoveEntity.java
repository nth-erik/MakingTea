package makeTea.entity;

public final class StoveEntity {
  private static final String NAME = "Stove Plate";
  private double temperatureOutput = 0;
  protected PlateEntity plate;

  public void setTemperatureOutput(double temperatureOutput) {
    this.temperatureOutput = temperatureOutput;
  }

  public double getTemperatureOutput() {
    return this.temperatureOutput;
  }
  public PlateEntity getPlate() {
    return this.plate;
  }

  public void heatPlate(double timeDelta) {
    double t = this.plate.getTemperature();
    double d = this.plate.getUnitDissipation();
    double a = this.plate.getArea();

    this.plate.setTemperature(t + this.temperatureOutput * d * a * timeDelta);
  }

  public StoveEntity(double temperature, double unitDissipation) {
    this.plate = new PlateEntity(StoveEntity.NAME, temperature, unitDissipation);
  }
  public StoveEntity(double temperature, double unitDissipation, double plateDiameter) {
    this.plate = new PlateEntity(StoveEntity.NAME, temperature, unitDissipation, plateDiameter);
  }
}
