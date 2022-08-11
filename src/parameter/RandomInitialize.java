package parameter;

import java.util.concurrent.ThreadLocalRandom;

public class RandomInitialize {

    public  static int randomNumber(int maxQuantity) {
        return ThreadLocalRandom.current().nextInt(1,maxQuantity);
    }
}
