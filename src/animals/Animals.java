package animals;

import plants.Plants;

import java.util.List;

public abstract class Animals {
    int movementSpeed; // скорость передвижения
    double weight; // вес животного кг
    double saturationMax; //насыщение животного максимальное
    double saturation; // насыщение животного при появлении

    public Animals(int movementSpeed, double weight,double saturationMax) {
        this.movementSpeed = movementSpeed;
        this.weight = weight;
        this.saturationMax = saturationMax;
        this.saturation=saturationMax/2;
    }

    //перемещение
    public void move(){

        

    }

    //поесть
//    public void eat(){
//
//
//    }

    //размножение
    public void reproduction(){

    }
 //   public abstract void listEat(List<Plants>plants);

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
