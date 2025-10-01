package BehaviouralPattern.Usecase2;

import java.util.ArrayList;
import java.util.List;

// Subject class
public class NewsAgency {
    private List<Subscriber> subscribers = new ArrayList<>();
    private String latestNews;

    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void setNews(String news) {
        this.latestNews = news;
        notifySubscribers();
    }

    private void notifySubscribers() {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(latestNews);
        }
    }
}
