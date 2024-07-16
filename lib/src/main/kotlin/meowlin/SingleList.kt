package meowlin

/**
 * An immutable singly linked list implementation.
 */
class SingleList<E>() {
    private var data: Node<E> = Node()

    private class Node<T>() {
        var curr: T? = null
        var next: Node<T>? = null

        constructor(prev: T, next: Node<T>?) : this() {
            this.curr = prev
            this.next = next
        }
    }


    /** Returns the first element. */
    val head: E?
        get() = data.curr

    /** Returns all elements but the first. */
    val tail: SingleList<E>
        get() = toList().let {
            if (it.isNotEmpty()) SingleList(it.drop(1))
            else SingleList()
        }

    /** Returns the size of the list. */
    var size: Int = 0
        private set(value) = value.let { field = it }


    /**
     * Returns the read-only array list of this list.
     * Currently, it is implemented using tail recursion.
     */
    fun toList(): List<E> {
        tailrec fun lessen(
            data: Node<E>? = this.data,
            result: List<E> = listOf()
        ): List<E> =
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
            data: Node<E>? = this.data,
            result: String = "["
        ): String =
            if (data?.curr == null) "$result]"
            else if (result == "[") lessen(data.next, "$result${data.curr}")
            else lessen(data.next, "$result, ${data.curr}")
        return lessen()
    }


    constructor(vararg elements: E) : this() {
        tailrec fun lessen(
            data: List<E> = elements.toList(),
            result: Node<E>? = null
        ): Node<E> =
            if (data.size == 1) Node(data.last(), result)
            else lessen(data.dropLast(1), Node(data.last(), result))
        data = lessen()
        size = elements.size
    }
    constructor(elements: List<E>) : this() {
        tailrec fun lessen(
            data: List<E> = elements,
            result: Node<E>? = null
        ): Node<E> =
            if (data.size == 1) Node(data.last(), result)
            else lessen(data.dropLast(1), Node(data.last(), result))
        data = lessen()
        size = elements.size
    }

}