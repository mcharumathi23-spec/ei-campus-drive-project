package CreationalPattern.Usecase1;

public class BuilderPatternDemo {
    public static void main(String[] args) {
        // Build a gaming computer
        ComputerBuilder gamingBuilder = new GamingComputerBuilder();
        gamingBuilder.createComputer();
        gamingBuilder.buildCPU();
        gamingBuilder.buildRAM();
        gamingBuilder.buildStorage();
        gamingBuilder.buildGPU();
        gamingBuilder.buildOS();
        Computer gamingPC = gamingBuilder.getComputer();

        System.out.println("=== Gaming PC ===");
        System.out.println(gamingPC);

        System.out.println("\n========================\n");

        // Build an office computer
        ComputerBuilder officeBuilder = new OfficeComputerBuilder();
        officeBuilder.createComputer();
        officeBuilder.buildCPU();
        officeBuilder.buildRAM();
        officeBuilder.buildStorage();
        officeBuilder.buildGPU();
        officeBuilder.buildOS();
        Computer officePC = officeBuilder.getComputer();

        System.out.println("=== Office PC ===");
        System.out.println(officePC);
    }
}
