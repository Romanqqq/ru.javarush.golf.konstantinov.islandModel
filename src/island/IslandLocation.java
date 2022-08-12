package island;

import animal.Animal;
import animal.Herbivore;
import animal.Predator;
import plant.Plant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;


//Создали объект остров
public class IslandLocation {
    FillingTheIsland fillingTheIsland = new FillingTheIsland();
    MovementOnTheIsland movementOnTheIsland = new MovementOnTheIsland();
    Set<Class> predatorAnimal = getPredatorAnimal();
    Set<Class> herbivoreAnimal = getHerbivoreAnimal();

    //Списки, куда будут записываться объекты
    private final List<Plant> cellPlants = new CopyOnWriteArrayList<>();
    private final List<Animal> cellPredators = new ArrayList<>();
            //fillingTheIsland.fillingIsland(predatorAnimal);
    private final List<Animal> cellHerbivore = new ArrayList<>();
                    //fillingTheIsland.fillingIsland(herbivoreAnimal);


    //добавляем в список растения от 1 до 200 силой великого рандома
    public IslandLocation() {
        plantsGrow();
    }

    private void plantsGrow() {
        int numberPlantsCell = ThreadLocalRandom.current().nextInt(1, Plant.getMaxQuantity());
        for (int i = 1; i <= numberPlantsCell; i++) {
            cellPlants.add(new Plant());
        }
    }

    public void addPlants() {
        if (this.cellPlants.size() < Plant.getMaxQuantity()) {
            int difference = Plant.getMaxQuantity() - this.cellPlants.size();
            int addPl = ThreadLocalRandom.current().nextInt(0, difference);
            for (int i = 0; i < addPl; i++) {
                this.cellPlants.add(new Plant());

            }
        }
    }


//    public void predatorInitialize(Animal animal){
//        if (animal instanceof Herbivore){
//            cellHerbivore.add(animal);
//
//        }else if(animal instanceof Predator){
//            cellPredators.add(animal);
//        }
//    }

//    public int predatorInitialize() {
//        int numberWolfCell = ThreadLocalRandom.current().nextInt(1, new Wolf().getMaxQuantityTypeAnimal());
//        for (int i = 1; i <= numberWolfCell; i++) {
//            cellPredators.add(new Wolf());
//        }
//        int numberBearCell = ThreadLocalRandom.current().nextInt(1, new Bear().getMaxQuantityTypeAnimal());
//        for (int i = 1; i <= numberBearCell; i++) {
//            cellPredators.add(new Bear());
//        }
//        int numberBoaCell = ThreadLocalRandom.current().nextInt(1, new Boa().getMaxQuantityTypeAnimal());
//        for (int i = 1; i <= numberBoaCell; i++) {
//            cellPredators.add(new Boa());
//        }
//        int numberFoxCell = ThreadLocalRandom.current().nextInt(1, new Fox().getMaxQuantityTypeAnimal());
//        for (int i = 1; i <= numberFoxCell; i++) {
//            cellPredators.add(new Fox());
//        }
//        int numberEagleCell = ThreadLocalRandom.current().nextInt(1, new Eagle().getMaxQuantityTypeAnimal());
//        for (int i = 1; i <= numberEagleCell; i++) {
//            cellPredators.add(new Eagle());
//        }
//        return cellPredators.size();
//    }

//    public int herbivoresInitialize() {
//        int numberRabbitCell = ThreadLocalRandom.current().nextInt(1, new Rabbit().getMaxQuantityTypeAnimal());
//        for (int i = 1; i <= numberRabbitCell; i++) {
//            cellHerbivore.add(new Rabbit());
//        }
//        int numberGoatCell = ThreadLocalRandom.current().nextInt(1, new Goat().getMaxQuantityTypeAnimal());
//        for (int i = 1; i <= numberGoatCell; i++) {
//            cellHerbivore.add(new Goat());
//        }
//        int numberBoarCell = ThreadLocalRandom.current().nextInt(1, new Boar().getMaxQuantityTypeAnimal());
//        for (int i = 1; i <= numberBoarCell; i++) {
//            cellHerbivore.add(new Boar());
//        }
//        int numberBuffaloCell = ThreadLocalRandom.current().nextInt(1, new Buffalo().getMaxQuantityTypeAnimal());
//        for (int i = 1; i <= numberBuffaloCell; i++) {
//            cellHerbivore.add(new Buffalo());
//        }
//        int numberCaterpillarCell = ThreadLocalRandom.current().nextInt(1, new Caterpillar().getMaxQuantityTypeAnimal());
//        for (int i = 1; i <= numberCaterpillarCell; i++) {
//            cellHerbivore.add(new Caterpillar());
//        }
//        int numberDeerCell = ThreadLocalRandom.current().nextInt(1, new Deer().getMaxQuantityTypeAnimal());
//        for (int i = 1; i <= numberDeerCell; i++) {
//            cellHerbivore.add(new Deer());
//        }
//        int numberDuckCell = ThreadLocalRandom.current().nextInt(1, new Duck().getMaxQuantityTypeAnimal());
//        for (int i = 1; i <= numberDuckCell; i++) {
//            cellHerbivore.add(new Duck());
//        }
//        int numberHorseCell = ThreadLocalRandom.current().nextInt(1, new Horse().getMaxQuantityTypeAnimal());
//        for (int i = 1; i <= numberHorseCell; i++) {
//            cellHerbivore.add(new Horse());
//        }
//        int numberMouseCell = ThreadLocalRandom.current().nextInt(1, new Mouse().getMaxQuantityTypeAnimal());
//        for (int i = 1; i <= numberMouseCell; i++) {
//            cellHerbivore.add(new Mouse());
//        }
//        int numberSheepCell = ThreadLocalRandom.current().nextInt(1, new Sheep().getMaxQuantityTypeAnimal());
//        for (int i = 1; i <= numberSheepCell; i++) {
//            cellHerbivore.add(new Sheep());
//        }
//        return cellHerbivore.size();
//    }

    public void addAnAnimalToACell(Animal animal) {
        if (animal instanceof Herbivore) {
            cellHerbivore.add(animal);
        } else if (animal instanceof Predator) {
            cellPredators.add(animal);
        }
    }

    public Set<Class> getPredatorAnimal() {
        Set<Class> predatorAnimal = new HashSet<>();
        for (Animal cellPredator : cellPredators) {
            predatorAnimal.add(cellPredator.getClass());
        }
        return predatorAnimal;
    }

    public Set<Class> getHerbivoreAnimal() {
        Set<Class> herbivoreAnimal = new HashSet<>();
        for (Animal cellHerbivore : cellHerbivore) {
            predatorAnimal.add(cellHerbivore.getClass());
        }
        return herbivoreAnimal;
    }

    public void bornAnimal() {
        fillingTheIsland.reproductionAnimal(predatorAnimal, cellPredators);
        fillingTheIsland.reproductionAnimal(herbivoreAnimal, cellHerbivore);
    }

    public void animalEat() {
        try {


            for (Animal herbivore : cellHerbivore) {
                herbivore.eat(cellPlants, cellHerbivore);
            }
            for (Animal predator : cellPredators) {
                predator.eat(cellHerbivore, cellPredators);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void deathFromExhaustion() {
        for (Animal herbivore : cellHerbivore) {
            if (herbivore.getSaturation() <= 0) {
                cellHerbivore.remove(herbivore);
            } else {
                continue;
            }
            for (Animal predator : cellPredators) {
                if (predator.getSaturation() <= 0) {
                    cellPredators.remove(predator);
                } else {
                    continue;
                }
            }
        }
    }

    public void move(int cellY, int cellX) {
        IslandLocation[][] islandLocations = Island.getIslandLocationStatic();
        movementOnTheIsland.movementOfAnimalsOnTheIsland(cellPredators, islandLocations, cellX, cellY);
        movementOnTheIsland.movementOfAnimalsOnTheIsland(cellHerbivore, islandLocations, cellX, cellY);
    }

    public long getCellPlants() {
        return cellPlants.size();
    }

    public long getCellPredators() {
        return cellPredators.size();
    }

    public long getCellHerbivore() {
        return cellHerbivore.size();
    }

//    public void setCellPlants(List<Plant> cellPlants) {
//        this.cellPlants = cellPlants;
//    }
//
//    public void setCellPredators(List<Animal> cellPredators) {
//        this.cellPredators = cellPredators;
//    }
//
//    public void setCellHerbivore(List<Animal> cellHerbivore) {
//        this.cellHerbivore = cellHerbivore;
//    }
}
