package meowlin

fun main() {
    val qa = SingleList(50, 40, 30, 20, 10, 0)
    fun qr(a: String) = println(a)
    fun qt(a: String) = println("\n$a")

    qr("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% ORIGINAL")
    println(qa)

    qt("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% POSITION-BASED SINGLE OPERATIONS")
    val qaInsFir = 0 + qa
    val qaInsLas = qa + SingleList(50)
    val qaEleFir = qa.head
    val qaDelFir = qa.tail
    for (n in listOf(
        qaInsFir, qaInsLas,
        qaEleFir,
        qaDelFir
    )) println(n)
}