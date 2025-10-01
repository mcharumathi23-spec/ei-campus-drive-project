
package BehaviouralPattern.Usecase1;

public class StatePatternDemo {
    public static void main(String[] args) {
        MobilePhone phone = new MobilePhone();

        System.out.println("=== Silent Mode ===");
        phone.setState(new SilentState());
        phone.alert();

        System.out.println("\n=== Vibrate Mode ===");
        phone.setState(new VibrateState());
        phone.alert();

        System.out.println("\n=== Ringing Mode ===");
        phone.setState(new RingingState());
        phone.alert();
    }
}
