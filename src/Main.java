import java.util.*;
public class Main {
    public static void main(String[] args){
        Video video1 = new Video("https://www.tiktok.com/@jules.gomezz/video/7671665094589254925?is_from_webapp=1&sender_device=pc", "College Outfit Inspo", new ArrayList<String>(List.of("Fashion", "College")), 15);
        Video video2 = new Video("https://www.tiktok.com/@namuuntur/video/7586365236131663135?is_from_webapp=1&sender_device=pc", "Life Before Exams POV", new ArrayList<String>(List.of("College", "Lifestyle", "Vlog")), 15);
        Video video3 = new Video("https://www.tiktok.com/@fitwithmy_/video/7675490307529608462?is_from_webapp=1&sender_device=pc", "Gym Grocery Haul", new ArrayList<String>(List.of("Gym", "College", "Food")), 46);

        ArrayList<Video> mediaList = new ArrayList<Video>();
        ArrayList<Recommendation> recommendations = new ArrayList<Recommendation>();
        mediaList.add(video1);
        mediaList.add(video2);
        mediaList.add(video3);
        
        ArrayList<String> chosenTopics = new ArrayList<String>(List.of("Lifestyle", "College"));

        for (Video x : mediaList){
            int score = 0;
            String reason = "This video contains the topics: ";
            for (String y : chosenTopics){
                if(x.getTopics().contains(y)){
                    reason += y + " ";
                    score++;
                }
            }
            if (score == 0){
                reason = "There were zero matches found.";
            }
            recommendations.add(new Recommendation(score, x, reason));
        }

    recommendations.sort((a,b) -> Integer.compare(b.getScore(), a.getScore()));
    for ( Recommendation x : recommendations){
        System.out.println(x.getRecommendation().getTitle() + ", " + x.getReason() + ", " + x.getScore());
    }
        

    }
}