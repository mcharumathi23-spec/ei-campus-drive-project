package CreationalPattern.Usecase1;

public abstract class ComputerBuilder {
    protected Computer computer;

    public void createComputer() {
        computer = new Computer();
    }

    public Computer getComputer() {
        return computer;
    }

    public abstract void buildCPU();
    public abstract void buildRAM();
    public abstract void buildStorage();
    public abstract void buildGPU();
    public abstract void buildOS();
}
