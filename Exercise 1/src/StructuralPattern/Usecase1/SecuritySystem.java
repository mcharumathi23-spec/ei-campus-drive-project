package StructuralPattern.Usecase1;

public class SecuritySystem {
    public void createIDCard(String name) {
        System.out.println("Security: Creating ID card for " + name);
    }

    public void assignAccessBadge(String name) {
        System.out.println("Security: Assigning building access badge to " + name);
    }
}
