package island;

import plants.Plants;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

//Создали объект остров
public class Island {
    //задали стороны острова
    private static final int SIDE = 1;
    //создали массив, который задает размеры острова
    private IslandSize[][] IslandField= new IslandSize[SIDE][SIDE];
    public static List<Plants> cellPlants = new ArrayList<Plants>();
    public void fieldGrow(){
        plantsGrow();
    }
    //добавляем в список растения от 1 до 200 силой великого рандома
    public  void plantsGrow() {
        int numberPlantsSell = ThreadLocalRandom.current().nextInt(1, new Plants().getMaxQuantity());
        for (int i = 0; i <= numberPlantsSell; i++) {
            cellPlants.add(new Plants());

        }

    }
}
