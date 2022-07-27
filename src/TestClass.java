import plants.Plants;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class TestClass {
    public static void main(String[] args) {
        List<Plants> cellPlants= new ArrayList<Plants>();
        int numberPlantsSell= ThreadLocalRandom.current().nextInt(1, new Plants().getMaxQuantity());
        for (int i = 0; i <= numberPlantsSell; i++) {

            cellPlants.add(new Plants());
        }
        System.out.println(numberPlantsSell);
    }
}
