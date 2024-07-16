package meowlin

fun main() {
    `+ test`()
    `Complex Double test`()
    `i test`()
}

fun `+ test`() {
    val qa = 60E0 + 60E0.i
    assert(qa == Complex(60E0, 60E0))
    println("`+` works!")
}

fun `Complex Double test`() {
    val qa = Complex(60E0, 60E0)
    assert(qa.real == 60E0)
    assert(qa.imaginary == 60E0)
    println("`Complex` works!")
}

fun `i test`() {
    val qa = 60E0.i
    assert(qa == Imaginary(60E0))
    println("`i` works!")
}