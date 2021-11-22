package makeTea.entity;

public final class KettleEntity extends SolidEntity {
  private static final String NAME = "Kettle";

  // Constructors
  public KettleEntity(double temperature, double unitDissipation) {
    super(KettleEntity.NAME, temperature, unitDissipation, 0.3);
  }
  public KettleEntity(double temperature, double unitDissipation, double size) {
    super(KettleEntity.NAME, temperature, unitDissipation, size);
  }
  public KettleEntity(double temperature, double unitDissipation, double diameter, double height) {
    super(KettleEntity.NAME, temperature, unitDissipation, diameter, height);
  }
}
