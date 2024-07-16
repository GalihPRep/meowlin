package meowlin

data class Complex<T : Number>(val real: T, val imaginary: T)

@JvmInline
value class Imaginary<T : Number>(val value: T)

operator fun Double.plus(other: Imaginary<Double>): Complex<Double> =
    Complex(this, other.value)

/**
 * Returns this number as an imaginary number.
 */
val Double.i: Imaginary<Double>
    get() = Imaginary(this)