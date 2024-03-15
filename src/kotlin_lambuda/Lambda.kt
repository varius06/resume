package kotlin_lambuda

import java.util.UUID

fun main() {
    val isEven = IntPredicate { it % 2 == 0 }
    val evenNumbers = filter(listOf(1, 2, 3, 4), isEven)
    val student1: Student = Student("test1", 1)
    val student2: Student = Student("test2", 2)
    val student3: Student = Student("test3", 30)
    var arraylist = ArrayList<Student>()
    arraylist.add(student1)
    arraylist.add(student2)
    arraylist.add(student3)

    val lambda = {stud: Student -> stud.getAge() < 20}
    val lambda1 = {std: String -> println(std) }
    val result = lambda.invoke(student1)
    println(result)
    val lam: (Student) -> Boolean = {it.getAge() < 20}
    filterLambda(arraylist, lam)

    val interfaceTOne: InterfaceT<Student> = InterfaceT { s -> s.getAge() < 20 }
    println(interfaceTOne.check(student1))
    filterStudentInterface(arraylist, interfaceTOne)

    val interfaceTTwo = object : InterfaceT<Student> {
        override fun check(t: Student): Boolean {
            return t.getAge() < 20
        }
    }
    filterStudentInterface(arraylist, interfaceTTwo)


    val coins: (Int) -> String = { quantity ->
        "$quantity quarters"
    }
    val b: String = coins.invoke(1)
    println(b)

    val test1: (text: String) -> Unit = {text ->  println(text) }
    test1.invoke("privet")

    val abc = block { test: String ->  println(test) }

    convert(20.0, { c: Double -> c * 1.8 + 32 })

    val iTest: ITest<Student> = ITest {  }
    val test = TestInterface(student1).setInterface{s: Student -> println(s.getAge().toString() + " iTest")}
    iTest.check(student1)

}

fun interface ITest<T> {
    fun check(t: T)
}

class TestInterface(private val student: Student){
    var iTest: ITest<Student>? = null
    fun setInterface(iTest: ITest<Student>) {
        this.iTest = iTest
        iTest.check(student)
    }
}

fun convert(x: Double, converter: (Double) -> Double) {
    val result = converter(x)
    println("$x is converted to $result") // выводим результат
}
fun block(block: (text: String) -> Unit) {
    block("test16")
    //println(test)
}

fun filter(numbers: List<Int>, predicate: IntPredicate){
    for (num in numbers) {
        println(predicate.accept(num))
    }
}

fun filterLambda(students: List<Student>, studentChecks: (Student) -> Boolean) {
    for (student in students) {
        if (studentChecks(student)) {
            println(student.getName())
        }
    }
}

fun filterStudentInterface(students: List<Student>, kConsumer: InterfaceT<Student>) {
    for (student in students) {
        if (kConsumer.check(student)) {
            println(student.getName())
        }
    }
}

fun interface InterfaceT<T> {
    fun check(t: T): Boolean
}



fun interface IntPredicate {
    fun accept(i: Int): Boolean
}

interface StudentChecks{
    fun check(student: Student): Boolean
}

class Student(private val name: String, private val age: Int) {
    fun getName() : String {
        return this.name;
    }
    fun getAge() : Int {
        return this.age
    }
}


