package com.beyondthefeed.controller;

import com.beyondthefeed.model.Video;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;


@RestController
public class VideoController {
    @GetMapping("/api/videos")
    public ArrayList<Video> getVideos() throws IOException{

        Gson gson = new Gson();
        Type videoListType = new TypeToken<ArrayList<Video>>() {}.getType();

        try (BufferedReader reader =
                new BufferedReader(new FileReader("data/videos.json"))) {

            ArrayList<Video> videos = gson.fromJson(reader, videoListType);
            
            if (videos == null) {
                return new ArrayList<>();
            }

            Iterator<Video> iterator = videos.iterator();

            while (iterator.hasNext()) {
                Video video = iterator.next();

                if (video == null || !video.isValid()) {
                    iterator.remove();
                }
            }

            return videos;
            
        } catch (JsonParseException e) {
            throw new ResponseStatusException(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "Video data contains invalid JSON",
                e
            );

        } catch (IOException e) {
            throw new ResponseStatusException(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "Unable to read video data",
                e
            );
        }
    }
}
