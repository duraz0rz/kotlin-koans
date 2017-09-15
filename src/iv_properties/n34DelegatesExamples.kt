package iv_properties

import util.TODO
import util.doc34
import kotlin.reflect.KProperty

class LazyPropertyUsingDelegates(val initializer: () -> Int) {
    val lazyValue: Int by Meow(initializer)
}

class Meow(private val initializer: () -> Int) {
    private var number: Int? = null
    operator fun getValue(thisRef: Any?, property: KProperty<*>) : Int {
        if (number == null) {
            number = initializer()
        }
        return number!!
    }
}

fun todoTask34(): Lazy<Int> = TODO(
    """
        Task 34.
        Read about delegated properties and make the property lazy by using delegates.
    """,
    documentation = doc34()
)
