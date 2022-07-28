package parameters;

import java.util.HashMap;
import java.util.Map;

public  class MapChance {
    static Map<String, Integer> wolfEat=new HashMap<>();

    static {
        wolfEat.put("Horse",10);
        wolfEat.put("Deer",15);
        wolfEat.put("Rabbit",60);
        wolfEat.put("Mouse",80);
        wolfEat.put("Goat",60);
        wolfEat.put("Sheep",70);
        wolfEat.put("Boar",15);
        wolfEat.put("Buffalo",10);
        wolfEat.put("Duck",40);

    }

}
