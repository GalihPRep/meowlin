package meowlin

fun main() {
    `SingleList test`()
    `contains test`()
    `get test`()
    `isEmpty test`()
    `toList test`()
    `toString test`()
}

fun `SingleList test`() {
    val qa = SingleList<Int>()
    val qd = SingleList(0, 1, 2)
    assert(qa.head == null)
    assert(qd.head == 0)
    println("`head` works!")
    assert(qa.size == 0)
    assert(qd.size == 3)
    println("`size` works!")
    assert(qa.tail == SingleList<Int>())
    assert(qd.tail == SingleList(1, 2))
    println("`tail` works!")
}

fun `contains test`() {
    val qa = SingleList<Int>()
    val qd = SingleList(0, 1, 2)
    assert(!qa.contains(0))
    assert(qd.contains(0))
    assert(qd.contains(1))
    assert(qd.contains(2))
    println("`contains` works!")
}

fun `get test`() {
    val qa = SingleList<Int>()
    val qd = SingleList(0, 1, 2)
    assert(qa[0] == null)
    assert(qd[0] == 0)
    assert(qd[1] == 1)
    assert(qd[2] == 2)
    println("`get` works!")
}

fun `isEmpty test`() {
    val qa = SingleList<Int>()
    val qd = SingleList(0, 1, 2)
    assert(qa.isEmpty())
    assert(!qd.isEmpty())
    println("`isEmpty` works!")
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