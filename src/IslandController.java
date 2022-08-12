import island.IslandLocation;
import island.Island;
import island.LifeOnTheIsland;
import parameter.MapChance;
import parameter.StatisticIsland;

import java.util.concurrent.*;

public class IslandController {


    public static void main(String[] args) {
        MapChance mapChance = new MapChance();
        //создали объект остров
        Island island = new Island();
        LifeOnTheIsland lifeOnTheIsland = new LifeOnTheIsland(island.getIslandLocation());
        StatisticIsland statisticIsland = new StatisticIsland(island.getIslandLocation());
//        инициализируем остров
//   island.initialize();
//        заполняем ячейки острова растениями
 //islandLocation.plantsGrow();
//        заполняем ячейки острова  хищниками
        //  islandLocation.predatorInitialize();
//        заполняем ячейки острова травоядными
        //       islandLocation.herbivoresInitialize();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
        //Выгружаем статистику по острову общую

        ScheduledFuture<?> scheduledFuture = scheduledExecutorService.scheduleAtFixedRate(statisticIsland, 0, 5, TimeUnit.SECONDS);
        ScheduledFuture<?> scheduledFutureSimulate = executorService.scheduleAtFixedRate(lifeOnTheIsland, 1, 2, TimeUnit.SECONDS);
        boolean life = true;
        int lifeIter = 0;
        while (life) {
            try {
                Thread.sleep(5000);
                lifeIter++;
                if (lifeIter > 100) {
                    life = false;
                    scheduledFuture.cancel(true);
                    System.out.println("Остров погиб");
                    scheduledFutureSimulate.cancel(true);
                    scheduledExecutorService.shutdown();
                    executorService.shutdown();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}