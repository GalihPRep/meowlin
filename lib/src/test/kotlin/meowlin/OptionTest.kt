package meowlin

fun main() {
    fun qr(a: String) = println(a)
    fun qt(a: String) = println("\n$a")

    qr("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% OPTION")
    println(optionOf("Hinako"))
    println(optionOf(null))

    qt("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% SOME")
    val qa = Some("Hinako")
    val qaRep = qa.map(String::uppercase)
    val qaUnw = qa.unwrap()
    for (n in listOf(qa, qaRep, qaUnw)) println(n)

    qt("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% NONE")
    val qb = None<String>()
    val qbRep = qb.map(String::uppercase)
    val qbUnw = qb.unwrap("Hinako")
    for (n in listOf(qb, qbRep, qbUnw)) println(n)
}