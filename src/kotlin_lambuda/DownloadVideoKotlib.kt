package kotlin_lambuda

import java.io.BufferedInputStream
import java.io.File
import java.io.InputStream
import java.io.OutputStream
import java.net.URL

fun main() {
    val  url: String = "https://download.samplelib.com/mp4/sample-5s.mp4"
    BufferedInputStream(URL(url).openStream()).use {
        File("video.mp4").copyInputStreamToFile(it) }
}

fun File.copyInputStreamToFile(inputStream: InputStream) {
    this.outputStream().use { fileOut ->  inputStream.copyTo(fileOut)}
}

fun InputStream.copyTo(out: OutputStream, bufferSize: Int = 1024): Long {
    var bytesCopied: Long = 0
    val buffer = ByteArray(bufferSize)
    var bytes = read(buffer)
    while (bytes >= 0) {
        out.write(buffer, 0, bytes)
        bytesCopied += bytes
        bytes = read(buffer)
    }
    return bytesCopied
}