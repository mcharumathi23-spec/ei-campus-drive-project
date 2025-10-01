package CreationalPattern.Usecase2;

public class AirConditioner implements SmartDevice {

    @Override
    public void turnOn() {
        System.out.println("Air Conditioner is ON");
    }

    @Override
    public void turnOff() {
        System.out.println("Air Conditioner is OFF");
    }
}
