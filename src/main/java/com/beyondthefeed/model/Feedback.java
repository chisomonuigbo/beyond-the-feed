package com.beyondthefeed.model;

public class Feedback {
    private String videoUrl;
    private String reaction;

    public Feedback() {
    }

    public Feedback(String videoUrl, String reaction){
        this.videoUrl = videoUrl;
        this.reaction = reaction;
    }

    public String getReaction(){
        return reaction;
    }

    public String getVideoUrl(){
        return videoUrl;
    }

    public boolean isValid(){
        if( reaction != null && !reaction.equals("liked") && !reaction.equals("disliked")){
            return false;
        }
        if (videoUrl == null || videoUrl.isBlank()) {
            return false;
        }

        return true;
    }
}
