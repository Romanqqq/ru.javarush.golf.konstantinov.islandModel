package ru.javarush;

import ru.javarush.island.Island;
import ru.javarush.parameter.Info;
import ru.javarush.parameter.LifeOnTheIsland;
import ru.javarush.parameter.StatisticIsland;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class IslandController {



    public static void main(String[] args) {

        Info info = new Info();
        Island island = new Island();
        LifeOnTheIsland lifeOnTheIsland = new LifeOnTheIsland(island.getIslandLocation());
        StatisticIsland statisticIsland = new StatisticIsland(island.getIslandLocation());
        ScheduledExecutorService statistics = Executors.newScheduledThreadPool(1);
        ScheduledExecutorService simulators = Executors.newScheduledThreadPool(10);
        ScheduledFuture<?> scheduledFuture = statistics.scheduleAtFixedRate(statisticIsland, 0, 2, TimeUnit.SECONDS);
        ScheduledFuture<?> scheduledFutureSimulate = simulators.scheduleAtFixedRate(lifeOnTheIsland, 1, 1, TimeUnit.SECONDS);
        boolean life = true;
        int lifeIteration = 0;
        while (life) {
            try {
                Thread.sleep(2000);
                lifeIteration++;
                if (lifeIteration > IslandSettings.days) {
                    life = false;
                    scheduledFuture.cancel(true);
                    System.out.println("By the will of the user of the world, the island ceased to exist!");
                    scheduledFutureSimulate.cancel(true);
                    statistics.shutdown();
                    simulators.shutdown();
                    break;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}