package vendingmachine.util

inline fun <T, R> List<List<T>>.flattenMap(transform: (List<T>) -> R): List<R> {
    val list = mutableListOf<R>()

    for (element in this) {
        list.add(transform(element))
    }

    return list
}