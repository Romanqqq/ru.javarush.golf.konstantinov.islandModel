import island.IslandLocation;
import island.Island;
import parameter.MapChance;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class IslandController {




    public static void main(String[] args) {
        MapChance mapChance = new MapChance();
        //создали объект остров
        Island island = new Island();
        IslandLocation islandLocation = new IslandLocation();
        //инициализируем остров
        island.initialize();
        //заполняем ячейки острова растениями
        islandLocation.plantsGrow();
        //заполняем ячейки острова  хищниками
        islandLocation.predatorInitialize();
        //заполняем ячейки острова травоядными
        islandLocation.herbivoresInitialize();
        ScheduledExecutorService scheduledExecutorService= Executors.newScheduledThreadPool(5);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        //Выгружаем статистику по острову общую
        island.printIslandStatistics();

            }





}