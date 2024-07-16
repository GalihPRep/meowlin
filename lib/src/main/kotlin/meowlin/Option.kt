package meowlin

sealed interface Option<T> {
    /**
     * Unwrap the value of this option.
     * Will return an exception if there is none.
     */
    fun get(): T

    /**
     * Unwrap the value of this option.
     * Will return the default value if there is none.
     */
    fun get(default: T): T
}

@JvmInline
value class Some<T>(val value: T) : Option<T> {
    override fun get(): T = value
    override fun get(default: T): T = get()
    override fun toString(): String = "[${value}]"
}

class None<T> : Option<T> {
    override fun get(): T = throw Exception()
    override fun get(default: T): T = default
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