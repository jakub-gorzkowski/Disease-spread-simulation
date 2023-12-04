package Random;

import java.util.Random;

public class RecoveryTimeGenerator {
    private final static int MIN_RECOVERY_TIME = 20000;
    private final static int MAX_RECOVERY_TIME = 30000;

    public static int generateTime() {
        Random random = new Random();
        return random.nextInt(MAX_RECOVERY_TIME - MIN_RECOVERY_TIME + 1) + MIN_RECOVERY_TIME;
    }
}
