package StructuralPattern.Usecase1;

public class HRSystem {
    public void addEmployee(String name) {
        System.out.println("HR: Adding employee " + name + " to HR records");
    }

    public void assignBenefits(String name) {
        System.out.println("HR: Assigning benefits to " + name);
    }
}
