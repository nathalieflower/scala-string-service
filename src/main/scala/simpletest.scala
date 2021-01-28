package simpletest

object Hello extends App {
    val p = new Person("Nat Flower")
    println(s"Hello ${p.name}")
}

class Person(var name: String)
