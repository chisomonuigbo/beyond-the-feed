import com.beyondthefeed.model.Video;

public class Recommendation {
    private final Video recommendation;
    private final String reason;
    private final int score;

    public Recommendation(int score, Video recommendation, String reason){
        this.score = score;
        this.recommendation = recommendation;
        this.reason = reason;
    } 

    public int getScore(){
        return score;
    }

    public Video getRecommendation(){
        return recommendation;
    }

    public String getReason(){
        return reason;
    }

    
    
}
