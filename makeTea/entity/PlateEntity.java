package makeTea.entity;

public final class PlateEntity extends SolidEntity {
  // Constructors
  public PlateEntity(String name, double temperature, double unitDissipation) {
    super(name, temperature, unitDissipation, 0.2, 0);
  }
  public PlateEntity(String name, double temperature, double unitDissipation, double diameter) {
    super(name, temperature, unitDissipation, diameter, 0);
  }
}
