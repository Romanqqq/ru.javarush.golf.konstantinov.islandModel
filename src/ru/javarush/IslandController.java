package ru.javarush;

import ru.javarush.island.Island;
import ru.javarush.island.LifeOnTheIsland;
import ru.javarush.parameter.MapChance;
import ru.javarush.parameter.StatisticIsland;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class IslandController {


    public static void main(String[] args) {
        MapChance mapChance = new MapChance();
        Island island = new Island();
        LifeOnTheIsland lifeOnTheIsland = new LifeOnTheIsland(island.getIslandLocation());
        StatisticIsland statisticIsland = new StatisticIsland(island.getIslandLocation());
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);
        ScheduledFuture<?> scheduledFuture = scheduledExecutorService.scheduleAtFixedRate(statisticIsland, 0, 2, TimeUnit.SECONDS);
        ScheduledFuture<?> scheduledFutureSimulate = executorService.scheduleAtFixedRate(lifeOnTheIsland, 1, 1, TimeUnit.SECONDS);
        boolean life = true;
        int lifeIteration = 0;
        while (life) {
            try {
                Thread.sleep(2000);
                lifeIteration++;
                if (lifeIteration > 100) {
                    life = false;
                    scheduledFuture.cancel(true);
                    System.out.println("Остров затонул");
                    scheduledFutureSimulate.cancel(true);
                    scheduledExecutorService.shutdown();
                    executorService.shutdown();
                    break;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}