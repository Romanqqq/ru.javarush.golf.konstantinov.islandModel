package ru.javarush.animal;

import ru.javarush.parameter.Direction;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal {
    private int movementSpeed;
    private double weight;
    private double saturationMax;
    private double saturation;
    private int genderAnimal;




    public Animal(int movementSpeed, double weight, double saturationMax) {
        this.movementSpeed = movementSpeed;
        this.weight = weight;
        this.saturationMax = saturationMax;
        this.saturation = saturationMax;
        setGenderAnimal();
    }

    public Direction setDirectionOfMovement() {
        Direction direction;
        int directionMove = ThreadLocalRandom.current().nextInt(0, 4);

        if (directionMove == Direction.UP.ordinal()) {
            direction = Direction.UP;
        } else if (directionMove == Direction.RIGHT.ordinal()) {
            direction = Direction.RIGHT;
        } else if (directionMove == Direction.DOWN.ordinal()) {
            direction = Direction.DOWN;
        } else if (directionMove == Direction.LEFT.ordinal()) {
            direction = Direction.LEFT;
        } else {
            direction = null;
        }
        return direction;
    }

    public abstract void eat(List<?> foodList, List<?> listFood);

    public void setGenderAnimal() {
        this.genderAnimal = (int) (Math.random() * 2 + 1);
    }

    public int getGenderAnimal() {
        return this.genderAnimal;
    }

    public boolean reproduction() {
        boolean reproduction = false;
        if (this.saturation == this.saturationMax) {
            reproduction = true;
        }
        return reproduction;
    }

    public double getSaturationMax() {
        return saturationMax;
    }

    public double getSaturation() {
        return saturation;
    }

    public void setSaturation(double saturation) {
        this.saturation = saturation;
    }

    public int getMovementSpeed() {
        return movementSpeed;
    }

    public void hunger() {
        if (this.saturation <= 0) {

        } else {
            int random = 1 + (int) (Math.random() * ((this.saturationMax - 1)));
            this.saturation = this.saturation - random;
        }
    }
}
