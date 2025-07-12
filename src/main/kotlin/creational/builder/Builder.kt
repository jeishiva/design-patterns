package creational.builder

// RTCEngineWithBuilder.kt
class RTCEngine private constructor(
    private val isVideoEnabled: Boolean,
    private val isAudioEnabled: Boolean,
    private val streamQuality: String,
    private val networkFallbackSetting: String
) : IRTCEngine {

    init {
        // Initialize with given config
        println("RTCEngine built with video=$isVideoEnabled, audio=$isAudioEnabled, quality=$streamQuality, fallback=$networkFallbackSetting")
    }

    override fun start() {
        // Start RTC communication
    }

    class Builder {
        private var isVideoEnabled: Boolean = true
        private var isAudioEnabled: Boolean = true
        private var streamQuality: String = "HD"
        private var networkFallbackSetting: String = "STANDARD"

        fun setVideoEnabled(enabled: Boolean) = apply { this.isVideoEnabled = enabled }
        fun setAudioEnabled(enabled: Boolean) = apply { this.isAudioEnabled = enabled }
        fun setStreamQuality(quality: String) = apply { this.streamQuality = quality }
        fun setNetworkFallbackSetting(setting: String) = apply { this.networkFallbackSetting = setting }

        fun build(): RTCEngine {
            return RTCEngine(
                isVideoEnabled,
                isAudioEnabled,
                streamQuality,
                networkFallbackSetting
            )
        }
    }
}

interface IRTCEngine {
    fun start()
}

fun main() {
    val rtcEngine = RTCEngine.Builder()
        .setVideoEnabled(true)
        .setAudioEnabled(false)
        .setStreamQuality("HD")
        .setNetworkFallbackSetting("LOW_LATENCY")
        .build()
}