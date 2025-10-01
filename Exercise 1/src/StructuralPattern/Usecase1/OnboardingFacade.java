package StructuralPattern.Usecase1;

public class OnboardingFacade {
    private HRSystem hr;
    private ITSystem it;
    private SecuritySystem security;

    public OnboardingFacade() {
        hr = new HRSystem();
        it = new ITSystem();
        security = new SecuritySystem();
    }

    public void onboardEmployee(String name) {
        System.out.println("\nStarting onboarding process for " + name + "...");
        hr.addEmployee(name);
        hr.assignBenefits(name);
        it.setupEmail(name);
        it.setupLaptop(name);
        security.createIDCard(name);
        security.assignAccessBadge(name);
        System.out.println("Onboarding completed for " + name + "!\n");
    }
}
