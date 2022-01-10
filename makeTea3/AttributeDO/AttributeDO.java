package makeTea3.AttributeDO;

public class AttributeDO {
  private AttributeType type;
  private double unitDissipation;
  private double value;
  private double nextValue;

  public AttributeDO(AttributeType initType, double initDissipation) {
    type = initType;
    unitDissipation = initDissipation;
    value = 0;
    nextValue = 0;
  }
  public AttributeDO(AttributeType initType, double initDissipation, double initValue) {
    type = initType;
    unitDissipation = initDissipation;
    value = initValue;
    nextValue = initValue;
  }

  public AttributeType getType() {
    return type;
  }
  public double getUnitDissipation() {
    return unitDissipation;
  }
  public double getValue() {
    return value;
  }

  public void setNextValue(double newValue) {
    nextValue = newValue;
  }
  public void update() {
    value = nextValue;
  }
}
