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
        this.saturation=saturationMax/2;
    }

    //перемещение
    public void move(){

    }

    public static Direction directionOfMovement() {
        return switch (ThreadLocalRandom.current().nextInt(0, 4)) {
            case 0 -> Direction.UP;
            case 1 -> Direction.RIGHT;
            case 2 -> Direction.DOWN;
            default -> Direction.LEFT;
        };
    }

    //размножение, рандомно задаем пол животного
    public void setGenderAnimal(){
        this.genderAnimal= (int) (Math.random()*2+1);
    }

    public int getGenderAnimal() {
         return this.genderAnimal;
    }
//проверяем сыто ли животное для размножения

    public boolean reproduction (){
        boolean reproduction=false;
        if(this.saturation==this.saturationMax){
           reproduction=true;
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
