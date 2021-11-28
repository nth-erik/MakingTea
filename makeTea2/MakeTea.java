package makeTea2;

import java.io.InputStream;
import java.util.Scanner;

import makeTea2.input.Input;
import makeTea2.stove.Stove;
import makeTea2.world.World;

public class MakeTea {
  public static void main(String[] args) {
    Input input = new Input();
    World world = new World(input);

    Air air = world.spawn(Air); // --> addSolid
    Table table = world.spawn(Table); // --> addTop
    Stove stove = world.spawn(Stove); // --> addTop
    Faucet faucet = world.spawn(Faucet); // --> pourLiquid
    Milkbox milkbox = world.spawn(Milkbox); // --> pourLiquid
    Kettle kettle = world.spawn(Kettle); // --> addLiquid, pourLiquid
    Mug mug = world.spawn(Mug); // --> addLiquid, pourLiquid

    air.addContent(table);
    air.addContent(stove);
    air.addContent(faucet);
    air.addContent(milkbox);
    air.addContent(kettle);
    air.addContent(mug);

    world.skipSeconds(10);

    table.addTop(kettle);
    table.addTop(mug);
    faucet.pourLiquid();

    input.close();
  }
}
