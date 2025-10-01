package StructuralPattern.Usecase1;

public class CorporateOnboardingDemo {
    public static void main(String[] args) {
        OnboardingFacade onboarding = new OnboardingFacade();

        System.out.println("=== Corporate Employee Onboarding System ===");

        onboarding.onboardEmployee("Alice Johnson");
        onboarding.onboardEmployee("Bob Smith");
        onboarding.onboardEmployee("Charlie Lee");
    }
}
