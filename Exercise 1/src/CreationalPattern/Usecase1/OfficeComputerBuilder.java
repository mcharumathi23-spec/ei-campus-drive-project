package CreationalPattern.Usecase1;

public class OfficeComputerBuilder extends ComputerBuilder {

    @Override
    public void buildCPU() {
        computer.setCPU("Intel Core i5");
    }

    @Override
    public void buildRAM() {
        computer.setRAM("16GB");
    }

    @Override
    public void buildStorage() {
        computer.setStorage("512GB SSD");
    }

    @Override
    public void buildGPU() {
        computer.setGPU("Integrated Graphics");
    }

    @Override
    public void buildOS() {
        computer.setOS("Windows 11 Home");
    }
}

