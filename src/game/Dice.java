package game;

import java.util.Random;

public class Dice {
    private final Random random = new Random();

    public boolean rollSuccess(int attempts) {
        if (attempts < 1) attempts = 1;

        for (int i = 0; i < attempts; i++) {
            if ((random.nextInt(6) + 1) > 4) {
                return true;
            }
        }

        return false;
    }
}
