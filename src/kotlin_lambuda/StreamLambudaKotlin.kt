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
    //������� ���� File() � �������� inputStream � copyInputStream
    inputStream.use {input -> File("test.txt").copyInputStream(input) }
}
//�������� ����� this.outputStream().use � ���������� �����, ������� ������ FileOutputStream � �������� 
// FileOutputStream � ����� input.copyTo(fileOut)
fun File.copyInputStream(input: InputStream) {
    this.outputStream().use { fileOut -> input.copyTo(fileOut) }
}
