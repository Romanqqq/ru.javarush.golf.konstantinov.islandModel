package ru.javarush.animal;

import java.util.List;

public class Herbivore extends Animal implements Herbivorous {
    public Herbivore(int movementSpeed, double weight, double saturationMax) {
        super(movementSpeed, weight, saturationMax);
    }
    @Override
    public void eat(List<?> foodList, List<?> listFood) {
        if (this.getSaturation() < this.getSaturationMax()) {
            double difference = this.getSaturationMax() - this.getSaturation();
            if (foodList.size() > difference) {
                this.setSaturation(this.getSaturationMax());
                foodList.subList(0, (int) difference).clear();
            }
        }
    }
}