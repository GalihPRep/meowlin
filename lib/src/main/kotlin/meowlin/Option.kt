package meowlin

sealed interface Option<T> {
    fun unwrap(): T
    fun unwrap(default: T): T
}
@JvmInline
value class Some<T>(val value: T) : Option<T> {
    override fun unwrap(): T = value
    override fun unwrap(default: T): T = unwrap()
    override fun toString(): String = "[${value}]"
}
class None<T> : Option<T> {
    override fun unwrap(): T = throw Exception()
    override fun unwrap(default: T): T = default
    override fun toString(): String = "None"
}
fun <T> optionOf(value: T?): Option<T> = when (value) {
    null -> None()
    else -> Some(value)
}
inline fun <T, R> Option<T>.map(transform: (T) -> R): Option<R> = when (this) {
    is None -> None()
    is Some -> Some(transform(value))
}