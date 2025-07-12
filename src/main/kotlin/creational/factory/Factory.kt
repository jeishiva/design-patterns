package creational.factory



class LiveVideo : Video {
    override fun play() { /* live playback */ }
    override fun pause() { /* live pause or no-op */ }
}

class RegularVideo : Video {
    override fun play() { /* regular playback */ }
    override fun pause() { /* regular pause */ }
}

interface Video {
    fun play()
    fun pause()
}

/**
 *  we intentionally avoided when/if-else logic for creating instances of the Video class
 *  as it violates the Open Closed Principle
 */
sealed class VideoType {
    abstract fun create(): Video

    data object Live : VideoType() {
        override fun create(): Video = LiveVideo()
    }

    data object Regular : VideoType() {
        override fun create(): Video = RegularVideo()
    }
}

fun main() {
    val video = VideoType.Live.create()
    video.play()
}