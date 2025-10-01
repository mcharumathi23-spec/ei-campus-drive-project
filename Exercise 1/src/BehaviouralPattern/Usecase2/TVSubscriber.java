package BehaviouralPattern.Usecase2;

public class TVSubscriber implements Subscriber {

    private String name;

    public TVSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String news) {
        System.out.println(name + " (TV) received news: " + news);
    }

    // Test independently
    public static void main(String[] args) {
        TVSubscriber tv = new TVSubscriber("Channel 1");
        tv.update("Test News for TV!");
    }
}
