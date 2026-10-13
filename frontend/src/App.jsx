
import { useEffect, useState } from 'react'
import './App.css'

function getTikTokEmbedUrl(url) {
  const match = url.match(/\/video\/(\d+)/)

  if (!match) {
    return null
  }

  const videoId = match[1]
  return `https://www.tiktok.com/player/v1/${videoId}?rel=0`
}

function App() {
  const [videos, setVideos] = useState([])
  const [loading, setLoading] = useState(true)
  const [error, setError] = useState(null)
  const [selectedVideo, setSelectedVideo] = useState(null)
  const [videoReactions, setVideoReactions] = useState({})

  useEffect(() => {
    async function fetchVideos() {
      try {
        const response = await fetch('/api/videos')

        if (!response.ok) {
          throw new Error('Failed to load videos')
        }

        const data = await response.json()
        setVideos(data)
      } catch (err) {
        setError(err.message)
      } finally {
        setLoading(false)
      }
    }

    fetchVideos()
  }, [])

  if (loading) return <p>Loading videos...</p>
  if (error) return <p>Error: {error}</p>

  function handleVideoClick(video) {
    setSelectedVideo(video);
    console.log(getTikTokEmbedUrl(video.url))
  }

  function handleReaction(reactionType) {
    const currentReaction = videoReactions[selectedVideo.url]

    const newReaction = currentReaction === reactionType ? null : reactionType

    setVideoReactions(prev => ({ ...prev, [selectedVideo.url]: newReaction}))
  }

  return (
    <div className="app">
      <h1>Beyond the Feed</h1>
      <p>Discover videos beyond your usual interests.</p>

      <div className="video-grid">
        {videos.map((video, index) => (
          <div className="video-card"
            key={video.url ?? index}
            onClick={() => handleVideoClick(video)}>
            <h2>{video.title}</h2>
            <p>Topics: {video.topics?.join(', ')}</p>
          </div>
        ))}
      </div>
      {selectedVideo && (
        <div className="selected-video">
          <h2>Now Playing: {selectedVideo.title}</h2>
          <iframe
            src={getTikTokEmbedUrl(selectedVideo.url)}
            title={selectedVideo.title}
            width="325"
            height="575"
            allow="fullscreen"
            allowFullScreen
          />
          <button onClick={() => handleReaction("liked")}
            >{videoReactions[selectedVideo.url] === "liked" ? "Liked" : "Like"}</button>
          <button onClick={() => handleReaction("disliked")}
            >{videoReactions[selectedVideo.url] === "disliked" ? "Disliked" : "Dislike"}</button>

          <button className="close" onClick={() => setSelectedVideo(null)}>Close Video</button>

        </div>
      )}
    </div>
  )
}

export default App
