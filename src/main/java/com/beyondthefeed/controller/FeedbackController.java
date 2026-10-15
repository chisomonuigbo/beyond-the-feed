package com.beyondthefeed.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.beyondthefeed.model.Feedback;

@RestController 
@RequestMapping("/api/feedback")
public class FeedbackController {
    @PostMapping
    public ResponseEntity<String> saveFeedback(@RequestBody Feedback feedback){
        if (feedback == null || !feedback.isValid()){
            return ResponseEntity.badRequest().body("Invalid feedback");
        }
        return ResponseEntity.ok("Feedback recieved");

    }

}
