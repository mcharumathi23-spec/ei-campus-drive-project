package BehaviouralPattern.Usecase1;

public class VibrateState implements State {
    @Override
    public void alert() {
        System.out.println("Phone is in Vibrate mode. It vibrates!");
    }
}
