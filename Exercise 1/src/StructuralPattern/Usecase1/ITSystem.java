package StructuralPattern.Usecase1;

public class ITSystem {
    public void setupEmail(String name) {
        System.out.println("IT: Creating email account for " + name);
    }

    public void setupLaptop(String name) {
        System.out.println("IT: Setting up laptop and software for " + name);
    }
}
