package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AnimalTest {
    @Test
    public void animalTest(){
        OptionsParser parser = new OptionsParser();
        IWorldMap map = new RectangularMap(4, 4);
        Vector2d initialPosition = new Vector2d(2, 2);
        Animal cat = new Animal(map, initialPosition);
        MoveDirection[] directions = parser.parse("f f f asdfe dkje r");
        for(MoveDirection dir: directions){
            cat.move(dir);
        }
        Assertions.assertEquals(cat.getPosition(), new Vector2d(2, 3));
        Assertions.assertEquals(cat.getDirection(), MapDirection.EAST);
        directions = parser.parse("b b b b l l l");
        for(MoveDirection dir: directions){
            cat.move(dir);
        }
        Assertions.assertEquals(cat.getPosition(), new Vector2d(0, 3));
        Assertions.assertEquals(cat.getDirection(), MapDirection.SOUTH);
        directions = parser.parse("r a3f r b b b b b b b");
        for(MoveDirection dir: directions){
            cat.move(dir);
        }
        Assertions.assertEquals(cat.getPosition(), new Vector2d(0, 0));
        Assertions.assertEquals(cat.getDirection(), MapDirection.NORTH);
    }
}
