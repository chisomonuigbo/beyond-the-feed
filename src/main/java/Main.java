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

        HashSet<String> availableTopics = new HashSet<>();
        for (Video x : mediaList){
            for (String y : x.getTopics()) {
                availableTopics.add(y);
            }
        }

        ArrayList<String> allTopics = new ArrayList<>(availableTopics);

        System.out.println("Select some topics you like to watch:");
        for(int i = 0; i < allTopics.size(); i++){
            System.out.println((i + 1) + ". " + allTopics.get(i));
        }
        System.out.println("Enter your chosen topics seperated by spaces! Example: \"1 2 3 4\"");
        
        Scanner scanner = new Scanner(System.in);
        String userTopicInput = scanner.nextLine();
        String[] chosenTopics = userTopicInput.split(" ");

        ArrayList<Recommendation> recommendations = new ArrayList<Recommendation>();


        HashMap<String, Integer> topicWeights = new HashMap<>();
        for (int x = 0; x < chosenTopics.length; ++x){
            String key = allTopics.get(Integer.parseInt(chosenTopics[x]) - 1);
            topicWeights.put(key, 1);
        }

        System.out.println(topicWeights);

        // I am changing to use weighted scoring instead of +1 by matching topic
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