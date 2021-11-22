package makeTea.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EntityPhysics {
  private static ArrayList<MaterialEntity[]> contactList = new ArrayList<MaterialEntity[]>();

  public static void touch(MaterialEntity entity1, MaterialEntity entity2) {
    if (entity1 == entity2) {
      return;
    }

    MaterialEntity[] newContact = { entity1, entity2 };

    for (MaterialEntity[] contact : contactList) {
      List<MaterialEntity> contactPair = Arrays.asList(contact);

      if (contactPair.contains(newContact[0]) && contactPair.contains(newContact[1])) {
        return;
      }
    }

    EntityPhysics.contactList.add(newContact);
  }

  public static void dissipateHeat(double timeDelta) {
    for (MaterialEntity[] contact : contactList) {
      //System.out.println("\nDissipating...");
      double t0 = contact[0].getTemperature();
      double t1 = contact[1].getTemperature();

      double minArea = Math.min(contact[0].getArea(), contact[1].getArea());
      double minDissipation = Math.min(contact[0].getUnitDissipation(), contact[1].getUnitDissipation());
      double contactDissipation;
      if (
        (contact[0] instanceof WaterEntity || contact[0] instanceof AirEntity) &&
        (contact[1] instanceof WaterEntity || contact[1] instanceof AirEntity)
      ) {
        contactDissipation = minDissipation / 6; //temporary simulation of contained water top surface
      } else {
        contactDissipation = (minArea * minDissipation);
      }

      //System.out.println(contact[0].getName() + "/" + contact[1].getName() + ": " + contactDissipation + " C/m2/s");

      // emitted temperature removed, transferred temperature added
      contact[0].setTemperature(t0 + (t1 - t0) * contactDissipation * timeDelta);
      contact[1].setTemperature(t1 + (t0 - t1) * contactDissipation * timeDelta);

      /*System.out.println(contact[0].getName() + " : " + contact[1].getName());
      System.out.println(t0 + " : " + t1 + " -> " + contact[0].getTemperature() + " : " + contact[1].getTemperature());
      System.out.println("");*/
    }
  }
}
