package BehaviouralPattern.Usecase1;

public class SilentState implements State {
    @Override
    public void alert() {
        System.out.println("Phone is in Silent mode. No sound!");
    }
}
