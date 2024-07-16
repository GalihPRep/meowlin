package meowlin

class SingleList<T>() {
    private class Node<T>() {
        var curr: T? = null
        var next: Node<T>? = null

        constructor(prev: T, next: Node<T>?) : this() {
            this.curr = prev
            this.next = next
        }
    }

    private var body: Node<T> = Node()
    val head: T?
        get() = body.curr
    val tail: SingleList<T>
        get() = SingleList(toList().drop(1))
    var size: Int = 0

    operator fun plus(data: SingleList<T>): SingleList<T> =
        SingleList(toList() + data.toList())

    fun toList(): List<T> {
        fun lessen(
            data: Node<T>? = body,
            result: List<T> = listOf()
        ): List<T> =
            if (data?.curr == null) result
            else lessen(data.next, result + data.curr!!)
        return lessen()
    }

    override fun toString(): String {
        fun lessen(
            data: Node<T>? = body,
            result: String = "["
        ): String =
            if (data?.curr == null) "$result]"
            else if (result == "[") lessen(data.next, "$result${data.curr}")
            else lessen(data.next, "$result, ${data.curr}")
        return lessen()
    }

    constructor(vararg elements: T) : this() {
        fun lessen(
            data: List<T> = elements.toList(),
            result: Node<T>? = null
        ): Node<T> =
            if (data.size == 1) Node(data.last(), result)
            else lessen(data.dropLast(1), Node(data.last(), result))
        body = lessen()
        size = elements.size
    }

    constructor(elements: List<T>) : this() {
        fun lessen(
            data: List<T> = elements,
            result: Node<T>? = null
        ): Node<T> =
            if (data.size == 1) Node(data.last(), result)
            else lessen(data.dropLast(1), Node(data.last(), result))
        body = lessen()
        size = elements.size
    }

}

operator fun <T> T.plus(elements: SingleList<T>): SingleList<T> =
    SingleList(listOf(this) + elements.toList())
