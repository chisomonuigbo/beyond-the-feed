import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException; // do not need both but lets use filenotfound
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

public class Main {
    public static void main(String[] args){
        String mediaSource = "data/videos.json";
        Gson gson = new Gson();
        ArrayList<Video> mediaList = new ArrayList<Video>();
        Type videoListType = new TypeToken<ArrayList<Video>>() {}.getType();

        try{
            FileReader file = new FileReader(mediaSource);
            BufferedReader reader = new BufferedReader(file);

            mediaList = gson.fromJson(reader, videoListType);

            Iterator<Video> iterator = mediaList.iterator();
            while (iterator.hasNext()){
                Video x = iterator.next();
                if (!x.isValid()){
                    System.out.println("The video, \"" + x.getTitle() + "\", is not a valid video.");
                    iterator.remove();
                }
            }

        } catch (FileNotFoundException e){
            System.out.println("File not found.");
        } catch (IOException e){
            System.out.println("Error occurred while reading the file: " + e);
        } catch (JsonSyntaxException e){
            System.out.println("Invalid data found in " + mediaSource);
        }

        ArrayList<Recommendation> recommendations = new ArrayList<Recommendation>();
        
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