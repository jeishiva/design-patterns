package behavioural.iterator

data class DownloadTask(val filename: String)

class DownloadManager : Iterable<DownloadTask> {
    private val tasks = mutableListOf<DownloadTask>()

    fun addDownload(task: DownloadTask) {
        tasks.add(task)
    }

    override fun iterator(): Iterator<DownloadTask> = DownloadIterator(tasks)
}

class DownloadIterator(private val tasks: List<DownloadTask>) : Iterator<DownloadTask> {
    private var index = 0
    override fun hasNext(): Boolean = index < tasks.size
    override fun next(): DownloadTask = tasks[index++]
}

// Usage
fun main() {
    val manager = DownloadManager()
    manager.addDownload(DownloadTask("video.mp4"))
    manager.addDownload(DownloadTask("image.png"))
    val iterator = manager.iterator()
    while (iterator.hasNext()) {
        val task = iterator.next()
        println("Download '${task.filename}' started...")
    }
}
