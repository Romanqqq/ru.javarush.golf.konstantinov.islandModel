package ru.javarush.animal;

import java.util.List;

public class Herbivore extends Animal implements Herbivorous {
    public Herbivore(int movementSpeed, double weight, double saturationMax, int hungryAnimalTime) {
        super(movementSpeed, weight, saturationMax, hungryAnimalTime);
    }
    @Override
    public void eat(List<?> foodList, List<?> listFood) {
        if (this.getSaturation() < this.getSaturationMax()) {
            double difference = this.getSaturationMax() - this.getSaturation();
            if (foodList.size() > difference) {
                this.setSaturation(this.getSaturationMax());
                this.setHungryAnimalTime(this.getHungryAnimalTimeMax());
                foodList.subList(0, (int) difference).clear();
            }
        }
    }
}