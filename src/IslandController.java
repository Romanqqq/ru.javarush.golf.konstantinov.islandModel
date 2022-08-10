import island.IslandLocation;
import island.Island;

public class IslandController {




    public static void main(String[] args) {
        //создали объект остров
        Island islandLocation = new Island();
        //создали объект наполнения острова
        IslandLocation island = new IslandLocation();
        //инициализируем остров
        islandLocation.initialize();
        //заполняем ячейки острова растениями
        island.plantsGrow();
        //заполняем ячейки острова  хищниками
        island.predatorInitialize();
        //заполняем ячейки острова травоядными
        island.herbivoresInitialize();
        //Выгружаем статистику по острову общую
        islandLocation.printIslandStatistics();
//        System.out.println(island.getCellPlants());
//        System.out.println(island.getCellHerbivore());
//        System.out.println(island.getCellPredators());

            }





}