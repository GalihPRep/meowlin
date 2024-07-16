package meowlin

/**
 * A singly linked list implementation.
 */
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
        get() = toList().let{
            if (it.isNotEmpty()) SingleList(it.drop(1))
            else SingleList()
        }
    var size: Int = 0

    operator fun plus(data: SingleList<T>): SingleList<T> =
        SingleList(toList() + data.toList())

    /**
     * Returns the read-only array list of this list.
     * Currently, it is implemented using tail recursion.
     */
    fun toList(): List<T> {
        tailrec fun lessen(
            data: Node<T>? = body,
            result: List<T> = listOf()
        ): List<T> =
            if (data?.curr == null) result
            else lessen(data.next, result + data.curr!!)
        return lessen()
    }

    /**
     * Returns the string representation of this list.
     * Currently, it is implemented using tail recursion.
     */
    override fun toString(): String {
        tailrec fun lessen(
            data: Node<T>? = body,
            result: String = "["
        ): String =
            if (data?.curr == null) "$result]"
            else if (result == "[") lessen(data.next, "$result${data.curr}")
            else lessen(data.next, "$result, ${data.curr}")
        return lessen()
    }

    constructor(vararg elements: T) : this() {
        tailrec fun lessen(
            data: List<T> = elements.toList(),
            result: Node<T>? = null
        ): Node<T> =
            if (data.size == 1) Node(data.last(), result)
            else lessen(data.dropLast(1), Node(data.last(), result))
        body = lessen()
        size = elements.size
    }

    constructor(elements: List<T>) : this() {
        tailrec fun lessen(
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
