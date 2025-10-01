package BehaviouralPattern.Usecase1;

public class MobilePhone {
    private State currentState;

    public void setState(State state) {
        this.currentState = state;
    }

    public void alert() {
        if (currentState != null) {
            currentState.alert();
        } else {
            System.out.println("Phone state not set!");
        }
    }
}
