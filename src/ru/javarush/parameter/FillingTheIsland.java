package ru.javarush.parameter;

import ru.javarush.animal.Animal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class FillingTheIsland {
    public FillingTheIsland() {
    }

    public List<Animal> fillingIsland(Set<Class> islandFauna) {
        List<Animal> islandFaunaGenerate = new CopyOnWriteArrayList<>();
        for (Class animalClass : islandFauna) {
            try {
                Field maxQuantityLocationCell = animalClass.getDeclaredField("maxQuantityLocation");
                maxQuantityLocationCell.setAccessible(true);
                int countAnimal = 1 + (int) (Math.random() * (((int) maxQuantityLocationCell.get(null) - 1)));
                Constructor<Animal> constructor = animalClass.getConstructor();
                for (int i = 0; i <= countAnimal; i++) {
                    Animal animalAdd = constructor.newInstance();
                    islandFaunaGenerate.add(animalAdd);
                }
            } catch (NoSuchFieldException | IllegalAccessException | NoSuchMethodException | InvocationTargetException |
                     InstantiationException e) {
                throw new RuntimeException(e);
            }
        }
        return islandFaunaGenerate;
    }

    public void reproductionAnimal(Set<Class> islandFauna, List<Animal> wildLife) {
        for (Class a : islandFauna) {
            int chanceReproduction = (int) (Math.random() * 2 + 1);
            if (chanceReproduction == 1) {
                int male = 0;
                int female = 0;
                int children = 0;
                for (Animal predator : wildLife) {
                    if (a.getSimpleName().equals(predator.getClass().getSimpleName())) {
                        if (predator.reproduction()) {
                            if (predator.getGenderAnimal() == 1) {
                                male++;
                            } else {
                                female++;
                            }
                        }
                    }
                }
                if (male >= female && female > 0) {
                    children = female;
                }
                if (female >= male && male > 0) {
                    children = male;
                }
                if (children != 0) {

                    try {
                        Field maxQuantityLocationCell = a.getDeclaredField("maxQuantityLocation");
                        maxQuantityLocationCell.setAccessible(true);
                        int countAnimal = (int) maxQuantityLocationCell.get(null);
                        if ((male + female + children) < countAnimal) {
                            Constructor<Animal> constructor = a.getConstructor();
                            for (int i = 0; i <= children; i++) {
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
                    } catch (NoSuchFieldException | IllegalAccessException | NoSuchMethodException |
                             InvocationTargetException | InstantiationException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
