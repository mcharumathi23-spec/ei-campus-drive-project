package CreationalPattern.Usecase2;

public class Fan implements SmartDevice {

    @Override
    public void turnOn() {
        System.out.println("Fan is ON");
    }

    @Override
    public void turnOff() {
        System.out.println("Fan is OFF");
    }
}
