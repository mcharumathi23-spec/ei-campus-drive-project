package BehaviouralPattern.Usecase2;

public class AppSubscriber implements Subscriber {

    private String name;

    public AppSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String news) {
        System.out.println(name + " (App) received news: " + news);
    }

    // Test independently
    public static void main(String[] args) {
        AppSubscriber app = new AppSubscriber("NewsApp");
        app.update("Test News for App!");
    }
}
