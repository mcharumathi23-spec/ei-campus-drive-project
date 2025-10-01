package CreationalPattern.Usecase1;

public class GamingComputerBuilder extends ComputerBuilder {

    @Override
    public void buildCPU() {
        computer.setCPU("Intel Core i9");
    }

    @Override
    public void buildRAM() {
        computer.setRAM("32GB");
    }

    @Override
    public void buildStorage() {
        computer.setStorage("1TB SSD");
    }

    @Override
    public void buildGPU() {
        computer.setGPU("NVIDIA RTX 4090");
    }

    @Override
    public void buildOS() {
        computer.setOS("Windows 11 Pro");
    }
}
