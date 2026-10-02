### What is Beyond the Feed
Beyond the Feed is a Java video recommendation project built around a question: how can we discover unfamiliar content instead of watching the same kinds of videos repeatedly?

The goal is to let users explore beyond their usual interests while understanding why each video was recommended. 

### What currently works
- A small, hardcoded catalog of videos with titles, URLs, topics, and durations.
- Topic matching against interests currently defined in the code.
- A relevance score awarding one point per matching interest.
- Explanations identifying the matching topics.
- Recommendations sorted by score from highest to lowest.

The current version runs in the terminal. Discovery controls and a user interface are planned.

### Project Structure
- `src/Main.java` — creates the sample lists of user content, calculates scores, and prints ranked results.
- `src/Video.java` — stores video information and protects each videos data from being manipulated or accidently changed
- `src/Recommendation.java` — pairs a video object with its relevancy score and explanation of its relevancy.
