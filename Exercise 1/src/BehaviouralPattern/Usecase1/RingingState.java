package BehaviouralPattern.Usecase1;

public class RingingState implements State {
    @Override
    public void alert() {
        System.out.println("Phone is Ringing! Ring Ring Ring!");
    }
}
