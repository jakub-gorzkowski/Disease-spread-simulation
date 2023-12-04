package Handlers;

public class TimeDisplayHandler {
    public static void timerDisplay(int currentTime) {
        if (currentTime % 1000 == 0) {
            System.out.println(currentTime / 1000 + " second/s");
        }
    }
}
