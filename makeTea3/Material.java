package makeTea3;

import java.util.ArrayList;

import makeTea3.AttributeDO.AttributeDO;
import makeTea3.AttributeDO.AttributeType;

public class Material {
  private ArrayList<AttributeDO> attributes = new ArrayList<AttributeDO>();
  
  public Material() {}

  public void dissipateAttributes(AttributeDO[] otherAttributes) {
    for (AttributeDO attr : attributes) {
      AttributeType type = attr.getType();
      for (AttributeDO otherAttr : otherAttributes) {
        if (type == otherAttr.getType()) {
          dissipate(attr, otherAttr);
          break;
        }
      }
    }
  }

  private void dissipate(AttributeDO attr1, AttributeDO attr2) {
    double minDissipation = Double.min(attr1.getUnitDissipation(), attr1.getUnitDissipation());
    attr1.setNextValue(attr2.getValue() * minDissipation);
    attr2.setNextValue(attr1.getValue() * minDissipation);
    
  }
}

/*
public class Foo implements Runnable {
     private volatile int value;

     @Override
     public void run() {
        value = 2;
     }

     public int getValue() {
         return value;
     }
 }

Foo foo = new Foo();
Thread thread = new Thread(foo);
thread.start();
thread.join();
int value = foo.getValue();
*/