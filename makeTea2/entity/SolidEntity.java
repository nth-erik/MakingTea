package makeTea2.entity;

public class SolidEntity extends Entity {
  protected double surfaceTop;
  protected double surfaceFront;
  protected double surfaceRight;
  protected double surfaceBottom;
  protected double surfaceBack;
  protected double surfaceLeft;

  public SolidEntity(
    double top,
    double front,
    double right,
    double bottom,
    double back,
    double left
  ) {
    super();
    surfaceTop = top;
    surfaceFront = front;
    surfaceRight = right;
    surfaceBottom = bottom;
    surfaceBack = back;
    surfaceLeft = left;
  }

  // Temperature
  public void dissipateHeat() {
    
  }

  // Touch
  public void touchEntity(Entity entity) {
    touchList.add(entity);
  };
  public void releaseEntity(Entity entity) {
    touchList.remove(entity);
  };
}
