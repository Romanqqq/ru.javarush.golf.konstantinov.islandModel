package animals;

public abstract class Animals {
    int movementSpeed; // скорость передвижения
    int weight; // вес животного кг
    double saturationMax; //насыщение животного максимальное
    double saturation;

    public Animals(int movementSpeed, int weight,double saturationMax) {
        this.movementSpeed = movementSpeed;
        this.weight = weight;
        this.saturationMax = saturationMax;
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


}
