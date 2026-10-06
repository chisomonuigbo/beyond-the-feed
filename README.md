### What is Beyond the Feed
Beyond the Feed is a Java video recommendation project built around a question: how can we discover unfamiliar content instead of watching the same kinds of videos repeatedly?

The goal is to let users explore beyond their usual interests while understanding why each video was recommended. 

### What currently works
- Videos are loaded and read from the `data/videos.json` file and deserialized via Gson rather than hardcoded.
- Video objects read from the json file are validated and filtered before being used as a "recommendation"
- Topic matching compares each video's topics against user interests currently defined in the code.
- A relevance score awarding one point per matching interest.
- Each recommendation includes an explanation identifying the topics that contributed to its score.
- Recommendations sorted by score from highest to lowest.

The current version runs in the terminal. Discovery controls and a user interface are planned.

### Project Structure
- `src/main/java/Main.java` — loads video data, validates videos, calculates recommendation scores, and prints ranked results.
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

### Future Improvements
- Allow users to provide and update their interests instead of defining them directly in the code.
- Add user feedback such as Interested and Not Interested to influence future recommendations.
- Develop a more advanced scoring algorithm that considers multiple signals beyond simple topic matching.
- Introduce a discovery component that intentionally recommends content outside of a user's established interests.
- Use data structures such as a priority queue to manage and retrieve highly ranked recommendations.
- Add recommendation diversity so that the highest-scoring results are not dominated by the same topics.
- Build a user interface for browsing recommendations and viewing explanations.
- Expand the video dataset and support persistent user preference data.