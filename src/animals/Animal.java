package animals;

import parameters.Direction;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal {
    int movementSpeed; // скорость передвижения
    double weight; // вес животного кг
    double saturationMax; //насыщение животного максимальное
    double saturation; // насыщение животного при появлении
    int genderAnimal;

    public Animal(int movementSpeed, double weight, double saturationMax) {
        this.movementSpeed = movementSpeed;
        this.weight = weight;
        this.saturationMax = saturationMax;
        this.saturation = saturationMax / 2;
    }

    //перемещение
    public void move() {

    }

    public Direction directionOfMovement() {
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

    //размножение, рандомно задаем пол животного
    public void setGenderAnimal() {
        this.genderAnimal = (int) (Math.random() * 2 + 1);
    }

    public int getGenderAnimal() {
        return this.genderAnimal;
    }
//проверяем сыто ли животное для размножения

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

    public void setSaturationMax(double saturationMax) {
        this.saturationMax = saturationMax;
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

    public void setMovementSpeed(int movementSpeed) {
        this.movementSpeed = movementSpeed;
    }
}
