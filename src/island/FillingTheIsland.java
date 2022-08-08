package island;

import animals.Animal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class FillingTheIsland {
    public List<Animal> fillingIsland(Set<Class> islandFauna) {
        List<Animal> islandFaunaGenerate = new CopyOnWriteArrayList<>();
        for (Class animalClass : islandFauna) {
            try {

                Field maxQuantityTypeAnimalCell = animalClass.getDeclaredField("maxQuantityTypeAnimal");
                maxQuantityTypeAnimalCell.setAccessible(true);
                int countAnimal = 1 + (int) (Math.random() * ((int) maxQuantityTypeAnimalCell.get(null) - 1));
                Constructor<Animal> constructor = animalClass.getConstructor();
                for (int i = 0; i < countAnimal; i++) {
                    Animal animalAdd = constructor.newInstance();
                    islandFaunaGenerate.add(animalAdd);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return islandFaunaGenerate;
    }
    public void reproductionAnimal(Set<Class> islandFauna, List<Animal> wildLife) {
        int male = 0;
        int female = 0;
        int children = 0;
        for (Class a : islandFauna) {
            int chanceReproduction = (int) (Math.random() * 2 + 1);
            if (chanceReproduction == 1) {
                for (Animal animal : wildLife) {
                    if (a.getSimpleName().equals(animal.getClass().getSimpleName())) {
                        if (animal.reproduction()) {
                            if (animal.getGenderAnimal() == 1) {
                                male++;
                            } else {
                                female++;
                            }
                        }
                    }
                }
                if (male >= female && female > 0) {
                    children = female;
                } else if (female >= male && male > 0) {
                    children = male;
                } else if (children != 0) {
                    try {

                        Field maxQuantityTypeAnimalCell = a.getDeclaredField("maxQuantityTypeAnimal");
                        maxQuantityTypeAnimalCell.setAccessible(true);
                        int countAnimal = (int) maxQuantityTypeAnimalCell.get(null);
                        if ((male + female + children) < countAnimal) {
                            Constructor<Animal> constructor = a.getConstructor();
                            for (int i = 0; i < children; i++) {
                                Animal animalAdd = constructor.newInstance();
                                wildLife.add(animalAdd);
                            }
                        } else {
                            countAnimal = countAnimal - (male + female);
                            if (countAnimal > 0) {
                                Constructor<Animal> constructor = a.getConstructor();
                                for (int i = 0; i < countAnimal; i++) {
                                    Animal animalAdd = constructor.newInstance();
                                    wildLife.add(animalAdd);
                                }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
