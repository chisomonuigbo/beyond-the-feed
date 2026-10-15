# Beyond the Feed

Beyond the Feed is a full-stack video discovery application designed to help users explore content beyond their usual interests through personalized recommendations and transparent explanations.

Originally developed as a Java terminal application, the project is being expanded into a web application using React and Spring Boot.

## Features

##### Video Discovery
- Browse and watch embedded TikTok videos through a responsive React interface.
- Load and validate video data dynamically from JSON.

##### Personalized Recommendations (Terminal)
- Rank videos using weighted user interests and topic relevance.
- Explain why videos are recommended based on matching topics.
- Allow users to adjust their discovery preference from 0% to 100%.

##### User Feedback
- Like, Dislike, or undo reactions on individual videos.
- Send reactions to Spring Boot through `POST /api/feedback`.
- Update reactions immediately, with automatic rollback and per-video error handling if requests fail.

## Tech Stack

- Frontend: React, JavaScript, Vite, CSS
- Backend: Java 17, Spring Boot, Maven, Gson
- Data: JSON (PostgreSQL planned)
- Communication: REST APIs, Fetch API

## Architecture

- `Main.java` / `Recommendation.java` — Terminal-based onboarding and recommendation ranking.
- `Video.java` / `Feedback.java` — Data models and validation.
- `VideoController.java` — Serves validated videos through `GET /api/videos`.
- `FeedbackController.java` — Receives and validates reactions through `POST /api/feedback`.
- `App.jsx` — React interface for video browsing, playback, and feedback.
- `data/videos.json` — Video dataset.

## Getting Started

**1. Start the backend**

```bash
mvn spring-boot:run
```

Backend: `http://localhost:8080`

**2. Start the frontend**

```bash
cd frontend
npm install
npm run dev
```

Frontend: `http://localhost:5173`

Both servers must be running for the web application to work.

**3. Run the original recommendation application (optional)**

```bash
mvn exec:java -Dexec.mainClass="Main"
```

## Project Status

**In active development.**

The web application currently supports video browsing, TikTok playback, and Like/Dislike interactions connected to the Spring Boot feedback API.

The recommendation algorithm is functional in the terminal application but has not yet been integrated into the web interface.

**Current limitations:** Feedback is validated but not permanently stored. Reactions reset on refresh, and concurrent feedback requests need further testing.

**Next Steps**
- Add persistent feedback storage.
- Integrate personalized recommendations into the web application.
- Connect engagement signals to recommendation ranking.
- Implement user profiles and preferences.