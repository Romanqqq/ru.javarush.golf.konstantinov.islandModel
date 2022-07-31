package island;

import animals.Animals;
import animals.herbivores.*;
import animals.predators.*;
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

        //добавляем в список растения от 1 до 200 силой великого рандома
    public int plantsGrow() {
        int numberPlantsCell = ThreadLocalRandom.current().nextInt(1, new Plants().getMaxQuantity());
        for (int i = 1; i <= numberPlantsCell; i++) {
            cellPlants.add(new Plants());
        }
        return cellPlants.size();
    }

    public int predatorInitialize() {
        int numberWolfCell = ThreadLocalRandom.current().nextInt(1, new Wolf().getMaxQuantityTypeAnimal());
            for (int i = 1; i <= numberWolfCell; i++) {
               cellPredators.add(new Wolf());
        }
        int numberBearCell = ThreadLocalRandom.current().nextInt(1, new Bear().getMaxQuantityTypeAnimal());
            for (int i = 1; i <= numberBearCell; i++) {
            cellPredators.add(new Bear());
        }
        int numberBoaCell = ThreadLocalRandom.current().nextInt(1, new Boa().getMaxQuantityTypeAnimal());
        for (int i = 1; i <= numberBoaCell; i++) {
            cellPredators.add(new Boa());
        }
        int numberFoxCell = ThreadLocalRandom.current().nextInt(1, new Fox().getMaxQuantityTypeAnimal());
        for (int i = 1; i <= numberFoxCell; i++) {
            cellPredators.add(new Fox());
        }
        int numberEagleCell = ThreadLocalRandom.current().nextInt(1, new Eagle().getMaxQuantityTypeAnimal());
        for (int i = 1; i <= numberEagleCell; i++) {
            cellPredators.add(new Eagle());
        }
        return cellPredators.size();
    }

    public int herbivoresInitialize() {
       int numberRabbitCell = ThreadLocalRandom.current().nextInt(1, new Rabbit().getMaxQuantityTypeAnimal());
            for (int i = 1; i <= numberRabbitCell; i++) {
                cellHerbivore.add(new Rabbit());
            }
       int numberGoatCell = ThreadLocalRandom.current().nextInt(1, new Goat().getMaxQuantityTypeAnimal());
            for (int i = 1; i <= numberGoatCell; i++) {
                cellHerbivore.add(new Goat());
            }
       int numberBoarCell = ThreadLocalRandom.current().nextInt(1, new Boar().getMaxQuantityTypeAnimal());
            for (int i = 1; i <= numberBoarCell; i++) {
                cellHerbivore.add(new Boar());
            }
       int numberBuffaloCell = ThreadLocalRandom.current().nextInt(1, new Buffalo().getMaxQuantityTypeAnimal());
            for (int i = 1; i <= numberBuffaloCell; i++) {
                cellHerbivore.add(new Buffalo());
            }
       int numberCaterpillarCell = ThreadLocalRandom.current().nextInt(1, new Caterpillar().getMaxQuantityTypeAnimal());
            for (int i = 1; i <= numberCaterpillarCell; i++) {
                cellHerbivore.add(new Caterpillar());
            }
       int numberDeerCell = ThreadLocalRandom.current().nextInt(1, new Deer().getMaxQuantityTypeAnimal());
            for (int i = 1; i <= numberDeerCell; i++) {
                cellHerbivore.add(new Deer());
            }
       int numberDuckCell = ThreadLocalRandom.current().nextInt(1, new Duck().getMaxQuantityTypeAnimal());
            for (int i = 1; i <= numberDuckCell; i++) {
                cellHerbivore.add(new Duck());
            }
       int numberHorseCell = ThreadLocalRandom.current().nextInt(1, new Horse().getMaxQuantityTypeAnimal());
            for (int i = 1; i <= numberHorseCell; i++) {
                cellHerbivore.add(new Horse());
            }
       int numberMouseCell = ThreadLocalRandom.current().nextInt(1, new Mouse().getMaxQuantityTypeAnimal());
            for (int i = 1; i <= numberMouseCell; i++) {
                cellHerbivore.add(new Mouse());
            }
       int numberSheepCell = ThreadLocalRandom.current().nextInt(1, new Sheep().getMaxQuantityTypeAnimal());
            for (int i = 1; i <= numberSheepCell; i++) {
                cellHerbivore.add(new Sheep());
            }
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

    public void setCellPlants(List<Plants> cellPlants) {
        this.cellPlants = cellPlants;
    }

    public void setCellPredators(List<Animals> cellPredators) {
        this.cellPredators = cellPredators;
    }

    public void setCellHerbivore(List<Animals> cellHerbivore) {
        this.cellHerbivore = cellHerbivore;
    }
}
