package animals.predators;

import animals.Animals;
import animals.herbivores.Herbivore;

import java.util.List;

public abstract class Predator extends Animals{
    public Predator(int movementSpeed, double weight, double saturationMax) {
        super(movementSpeed, weight, saturationMax);
    }

    public void eat(List<Herbivore> herbivores) {

    }


}
