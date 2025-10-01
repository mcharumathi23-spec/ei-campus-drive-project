package CreationalPattern.Usecase2;

public class SmartHomeDemo {
    public static void main(String[] args) {
        SmartDeviceFactory factory = new SmartDeviceFactory();

        SmartDevice light = factory.createDevice("light");
        SmartDevice fan = factory.createDevice("fan");
        SmartDevice ac = factory.createDevice("airconditioner");

        System.out.println("=== Turning devices ON ===");
        light.turnOn();
        fan.turnOn();
        ac.turnOn();

        System.out.println("\n=== Turning devices OFF ===");
        light.turnOff();
        fan.turnOff();
        ac.turnOff();
    }
}
