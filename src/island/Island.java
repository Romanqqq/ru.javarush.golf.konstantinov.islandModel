package island;

import animals.Animals;
import animals.herbivores.Goat;
import animals.herbivores.Rabbit;
import animals.predators.Wolf;
import plants.Plants;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

//Создали объект остров
public class Island {

    //Списки, куда будут записываться объекты
     List<Plants> cellPlants = new ArrayList<>();
     List<Animals>cellPredators= new ArrayList<>();
     List<Animals>cellHerbivore= new ArrayList<>();
    //public void fieldGrow(){
    //  plantsGrow();
    // }
    //добавляем в список растения от 1 до 200 силой великого рандома
    public void plantsGrow() {
        int numberPlantsCell = ThreadLocalRandom.current().nextInt(1, new Plants().getMaxQuantity());
        for (int i = 0; i <= numberPlantsCell; i++) {
            cellPlants.add(new Plants());
        }
    }
    public int plantsCount(){
        return cellPlants.size();
    }
    public void predatorInitialize() {
        int numberWolfCell = ThreadLocalRandom.current().nextInt(1, new Wolf().getMaxQuantityTypeAnimal());
        for (int i = 0; i < numberWolfCell; i++) {
            cellPredators.add(new Wolf());
        }
    }
    public int predatorCount(){
        return cellPredators.size();
    }
        public void herbivoresInitialize() {
            int numberRabbitCell = ThreadLocalRandom.current().nextInt(1, new Rabbit().getMaxQuantityTypeAnimal());
            for (int i = 0; i < numberRabbitCell; i++) {
                cellHerbivore.add(new Rabbit());
            }
            int numberGoatCell = ThreadLocalRandom.current().nextInt(1, new Rabbit().getMaxQuantityTypeAnimal());
            for (int i = 0; i < numberGoatCell; i++) {
                cellHerbivore.add(new Goat());
            }

        }
    public int herbivoreCount(){
        return cellHerbivore.size();
    }





    public List<Plants> getCellPlants() {
        return cellPlants;
    }

    public List<Animals> getCellPredators() {
        return cellPredators;
    }

    public List<Animals> getCellHerbivore() {
        return cellHerbivore;
    }
}
