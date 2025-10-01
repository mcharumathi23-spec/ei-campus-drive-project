package BehaviouralPattern.Usecase2;

public class EmailSubscriber implements Subscriber {

    private String email;

    public EmailSubscriber(String email) {
        this.email = email;
    }

    @Override
    public void update(String news) {
        System.out.println("Email to " + email + ": " + news);
    }

    // Test independently
    public static void main(String[] args) {
        EmailSubscriber email = new EmailSubscriber("user@example.com");
        email.update("Test Email News!");
    }
}
