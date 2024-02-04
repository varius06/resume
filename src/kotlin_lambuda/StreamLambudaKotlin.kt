package kotlin_lambuda

import java.io.ByteArrayInputStream
import java.io.File
import java.io.InputStream

fun main() {
    val content = "Hello World"
    val inputStream = ByteArrayInputStream(content.toByteArray())
    /*val file: File = File("test.txt")
       inputStream.use { input ->
        file.outputStream().use { output ->
            input.copyTo(output)
        }
    }*/
    //создаем файл File() и передаем inputStream в copyInputStream
    inputStream.use {input -> File("test.txt").copyInputStream(input) }
}
//Вызываем метод this.outputStream().use у созданного файла, создаем объект FileOutputStream и передаем 
// FileOutputStream в метод input.copyTo(fileOut)
fun File.copyInputStream(input: InputStream) {
    this.outputStream().use { fileOut -> input.copyTo(fileOut) }
}
