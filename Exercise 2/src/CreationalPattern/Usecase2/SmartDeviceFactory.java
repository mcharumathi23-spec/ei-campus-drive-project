package CreationalPattern.Usecase2;

public class SmartDeviceFactory {

    public SmartDevice createDevice(String deviceType) {
        switch (deviceType.toLowerCase()) {
            case "light":
                return new Light();
            case "fan":
                return new Fan();
            case "airconditioner":
                return new AirConditioner();
            default:
                throw new IllegalArgumentException("Unknown device type: " + deviceType);
        }
    }
}
