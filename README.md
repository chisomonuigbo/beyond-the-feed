### What is Beyond the Feed
Beyond the Feed is a Java video recommendation project built around a question: how can we discover unfamiliar content instead of watching the same kinds of videos repeatedly?

The goal is to let users explore beyond their usual interests while understanding why each video was recommended. 

### What currently works
- Videos are loaded and read from the `data/videos.json` file and deserialized via Gson rather than hardcoded.
- Video objects read from the json file are validated and filtered before being used as a "recommendation"
- Available topics are dynamically collected from the video dataset rather than being hardcoded.
- New users can select their initial interests through a terminal-based onboarding menu.
- Selected interests are stored in a HashMap as an initial user interest profile.
- Topic matching compares each video's topics against user interests selected during onboarding.
- A relevance score awarding one point per matching interest.
- Each recommendation includes an explanation identifying the topics that contributed to its score.
- Recommendations sorted by score from highest to lowest.

The current version runs in the terminal. Dynamic interest weighting, discovery controls, and a user interface are planned.

### Project Structure
- `src/main/java/Main.java` — loads video data, validates videos, handles user interest selection, calculates recommendation scores, and prints ranked results.
- `src/main/java/Video.java` — represents a video and its attributes and provides validation for video data.
- `src/main/java/Recommendation.java` — pairs a video object with its relevancy score and explanation of its relevancy.
- `pom.xml` - configures the Maven project, including dependency management and Java build settings.
- `data/videos.json` - stores all the video objects data and attributes that will be used to generate recommendations.
- `src/main/java` - contains the Java source code for the application.

### Technologies
- Maven
- Java 17
- Gson
- JSON