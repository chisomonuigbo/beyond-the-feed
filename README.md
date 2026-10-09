### What is Beyond the Feed
Beyond the Feed is a Java video recommendation project built around a question: how can we discover unfamiliar content instead of watching the same kinds of videos repeatedly?

The goal is to let users explore beyond their usual interests while understanding why each video was recommended. 

The project began as a terminal-based Java application and is currently being developed into a full-stack web application using React, Java Spring Boot, and PostgreSQL.

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

### Project Structure

beyond-the-feed/
├── data/
│   └── videos.json
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
- `pom.xml` — Manages Maven dependencies, Java configuration, and Spring Boot build settings.


### Technologies
- Maven
- Spring Boot
- Java 17
- Gson
- JSON
- REST APIs

### Running the Project

##### Start the Spring Boot backend:

mvn spring-boot:run

The backend runs locally at:

http://localhost:8080

##### View the video API:

http://localhost:8080/api/videos

This endpoint returns validated video objects from the dataset in JSON format.

##### Run the original terminal recommendation application:

mvn exec:java -Dexec.mainClass="Main"

The terminal application provides interest selection and recommendation ranking while the web interface is under development.