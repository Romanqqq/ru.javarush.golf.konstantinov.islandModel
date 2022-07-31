import island.Island;
import island.IslandLocation;

public class IslandController {




    public static void main(String[] args) {
        //создали объект остров
        IslandLocation islandLocation = new IslandLocation();
        //создали объект наполнения острова
        Island island = new Island();
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