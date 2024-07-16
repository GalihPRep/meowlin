package meowlin

fun main() {
    `map test`()
}

fun `map test`() {
    val qa = None<Int>().map { it * it }
    val qb = Some(60).map { it * it }
    assert(qa == None<Int>())
    assert(qb.get() == 3600)
    println("`map` works!")
}