package meowlin

fun main() {
    `SingleList test`()
    `toList test`()
    `toString test`()
}

fun `SingleList test`() {
    val qa = SingleList<Int>()
    val qb = SingleList(0, 1, 2)
    assert(qa.head == null)
    assert(qb.head == 0)
    println("`head` works!")
    assert(qa.size == 0)
    assert(qb.size == 3)
    println("`size` works!")
    assert(qa.tail == SingleList<Int>())
    assert(qb.tail == SingleList(1, 2))
    println("`tail` works!")
}

fun `toList test`() {
    val qa = SingleList<Int>()
    val qb = SingleList(0)
    val qc = SingleList(0, 1)
    val qd = SingleList(0, 1, 2)
    assert(qa.toList() == listOf<Int>())
    assert(qb.toList() == listOf(0))
    assert(qc.toList() == listOf(0, 1))
    assert(qd.toList() == listOf(0, 1, 2))
    println("`toList` works!")
}

fun `toString test`() {
    val qa = SingleList<Int>()
    val qb = SingleList(0)
    val qc = SingleList(0, 1)
    val qd = SingleList(0, 1, 2)
    assert(qa.toString() == "[]")
    assert(qb.toString() == "[0]")
    assert(qc.toString() == "[0, 1]")
    assert(qd.toString() == "[0, 1, 2]")
    println("`toString` works!")
}