### What is Beyond the Feed
Beyond the Feed is a Java video recommendation project built around a question: how can we discover unfamiliar content instead of watching the same kinds of videos repeatedly?

The goal is to let users explore beyond their usual interests while understanding why each video was recommended. 

The project began as a terminal-based Java application and is currently being developed into a full-stack web application using React, Java Spring Boot, and PostgreSQL (planned).

### What currently works
###### Video Data Management
- Videos are dynamically loaded from `data/videos.json` and deserialized using Gson rather than being hardcoded.
- Video objects are validated using custom validation logic, and invalid entries are filtered out.
- Available topics are dynamically extracted from the video dataset.

##### Recommendation Algorithm
- Users can select their initial interests through a terminal-based onboarding menu.
- User interests are stored in a `HashMap<String, Integer>` to represent topic weights.
- Each video's relevance score is calculated using the weights of matching topics.
- Recommendations include explanations identifying the topics contributing to their relevance scores.
- Recommendations are ranked from highest to lowest relevance score.
- Users can select a discovery preference between 0% and 100% through the terminal interface.


##### Java Spring Boot Backend
- Integrated Spring Boot into the existing Maven project.
- Created a REST API endpoint, GET /api/videos, that returns video data as JSON.
- Preserved Gson deserialization and video validation within the backend
- Implemented exception handling for malformed JSON and file-reading errors.
- Organized backend code into packages to separate data models from API controllers.
- Successfully tested API locally

### React Frontend
- Initialized a React application using Vite.
- Built a responsive video dashboard using CSS Grid.
- Connected React to the Spring Boot backend using asynchronous API requests.
- Configured a Vite development proxy to forward /api requests to Spring Boot.
- Implemented loading and error states for video fetching.
- Created clickable video cards displaying video titles and topics.
- Used React state to track the currently selected video.
- Embedded TikTok videos directly into the application using TikTok's official player.
- Added a Close Video button and configured the embedded player to limit related recommendations to the same creator.

### Project Structure

beyond-the-feed/
├── data/
│   └── videos.json
├── frontend/
│   ├── public/
│   ├── src/
│   │   ├── App.jsx
│   │   ├── App.css
│   │   ├── index.css
│   │   └── main.jsx
│   ├── package.json
│   ├── vite.config.js
│   └── index.html
├── src/
│   └── main/
│       └── java/
│           ├── Main.java
│           ├── Recommendation.java
│           └── com/
│               └── beyondthefeed/
│                   ├── BeyondTheFeedApplication.java
│                   ├── controller/
│                   │   └── VideoController.java
│                   └── model/
│                       └── Video.java
├── pom.xml
└── README.md


### Project Structure
- `Main.java` — Original terminal application responsible for user onboarding, topic selection, and recommendation ranking.
- `Recommendation.java` — Represents a recommended video, its relevance score, and its explanation.
- `Video.java` — Represents video attributes and provides validation methods.
- `BeyondTheFeedApplication.java` — Entry point for the Spring Boot backend.
- `VideoController.java` — Handles API requests and returns validated video data.
- `videos.json` — Stores the entire video dataset.
- `App.jsx` — React component responsible for fetching, displaying, and selecting videos.
- `App.css` — Styles the video dashboard, cards, and embedded player.
- `vite.config.js` — Configures Vite and the development API proxy.
- `pom.xml` — Manages Maven dependencies, Java configuration, and Spring Boot build settings.
- `frontend/package.json` — Manages frontend dependencies and development scripts.


### Technologies
##### Frontend
- React
- JavaScript (JSX)
- HTML and CSS
- Vite

###### Backend
- Java 17
- Spring Boot
- Maven
- Gson
- REST APIs
- JSON


### Running the Project

##### Start the Spring Boot backend:

mvn spring-boot:run

The backend runs locally at:

http://localhost:8080

##### View the video API:

http://localhost:8080/api/videos

This endpoint returns validated video objects from the dataset in JSON format.

### Start the React Frontend

Open a second terminal and navigate to the frontend directory:

cd frontend
npm install
npm run dev

Open:

http://localhost:5173

Both servers must be running for the React application to retrieve video data from Spring Boot.

##### Run the original terminal recommendation application:

mvn exec:java -Dexec.mainClass="Main"

The terminal application provides interest selection and recommendation ranking while the web interface is under development.

### Project Status

In active development.

The application currently supports browsing and watching TikTok videos through a React frontend connected to a Java Spring Boot API. Personalized recommendation ranking is implemented in the original terminal application, with web integration and persistent user profiles planned for future development.