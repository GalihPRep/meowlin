package meowlin

/**
 * An immutable singly linked list implementation.
 */
class SingleList<E>() : Collection<E> {
    private var data: Node<E> = Node()

    /**
     * Returns the first element.
     */
    val head: E?
        get() = data.curr

    /**
     * Returns all elements but the first.
     */
    val tail: SingleList<E>
        get() = toList().let {
            if (it.isNotEmpty()) SingleList(it.drop(1))
            else SingleList()
        }

    override var size: Int = 0
        private set(value) = value.let { field = it }

    override fun containsAll(elements: Collection<E>): Boolean {
        TODO("Not yet implemented")
    }

    override fun contains(element: E): Boolean {
        tailrec fun lessen(
            data: Node<E>? = this.data,
            i: Int = 0
        ): Boolean =
            if (data?.curr == element) true
            else if (data?.curr != null) lessen(data.next, i + 1)
            else false
        return lessen()
    }

    /**
     * Returns the element at the specified index in the list.
     */
    operator fun get(index: Int): E? {
        tailrec fun lessen(
            data: Node<E>? = this.data,
            i: Int = 0
        ): E? =
            if (i == index) data?.curr
            else lessen(data?.next, i + 1)
        return lessen()
    }

    override fun isEmpty(): Boolean = size == 0

    override fun iterator(): Iterator<E> {
        TODO("Not yet implemented")
    }

    /**
     * Returns a [List] containing all elements.
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

private class Node<T>() {
    var curr: T? = null
    var next: Node<T>? = null

    constructor(prev: T, next: Node<T>?) : this() {
        this.curr = prev
        this.next = next
    }
}