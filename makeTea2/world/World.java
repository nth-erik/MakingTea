package makeTea2.world;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import makeTea2.entity.Entity;
import makeTea2.input.Input;

public class World {
  private ArrayList<Entity> entityList = new ArrayList<Entity>();
  private Input input;
  private double temperature;

  public World(Input input) {
    this.input = input;
    temperature = input.prompt("Default temperature:");
  }

  public void skipSeconds(double seconds) {

  }

  public Entity spawn(Class<Entity> entityClass) {
    Entity entity;
    try {
      entity = entityClass.getDeclaredConstructor().newInstance(temperature, input);
      this.entityList.add(entity);
      return entity;
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    } catch (SecurityException e) {
      e.printStackTrace();
    }
    return null;
  }
}
