package BehaviouralPattern.Usecase2;

public class ObserverPatternDemo {
    public static void main(String[] args) {
        NewsAgency agency = new NewsAgency();

        TVSubscriber tv = new TVSubscriber("Channel 1");
        AppSubscriber app = new AppSubscriber("NewsApp");
        EmailSubscriber email = new EmailSubscriber("user@example.com");

        agency.addSubscriber(tv);
        agency.addSubscriber(app);
        agency.addSubscriber(email);

        System.out.println("=== First News ===");
        agency.setNews("Breaking News: Java 25 released!");

        System.out.println("\n=== Second News ===");
        agency.setNews("Weather Update: Heavy rain expected tomorrow!");
    }
}
