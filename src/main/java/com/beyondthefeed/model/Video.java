package com.beyondthefeed.model;
import java.util.*;

public class Video {
    private final String url;
    private final String title;
    private final ArrayList<String> topics;
    private final int duration;

    public Video(String url, String title, ArrayList<String> topics, int duration ) {
        this.url = url; //stores a reference to whatever was passed in
        this.title = title;
        this.topics = new ArrayList<String>(topics);
        this.duration = duration;
    }

    public String getURL(){
        return url;
    }

    public String getTitle(){
        return title;
    }

    public ArrayList<String> getTopics(){
        ArrayList<String> copyTopics = new ArrayList<String>(topics);
        return copyTopics;
    }

    public int getDuration(){
        return duration;
    }

    public boolean isValid() {
    if (url == null || url.isBlank()) {
        return false;
    }

    if (title == null || title.isBlank()) {
        return false;
    }

    if (topics == null || topics.isEmpty()) {
        return false;
    }

    if (duration <= 0) {
        return false;
    }

    return true;
}
}