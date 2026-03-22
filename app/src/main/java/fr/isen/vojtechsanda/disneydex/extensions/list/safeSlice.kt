package fr.isen.vojtechsanda.disneydex.extensions.list

fun <T> List<T>.sliceSafe(start: Int, end: Int): List<T> {
    val safeStart = start.coerceIn(0, size)
    val safeEnd = end.coerceIn(safeStart, size)
    return this.subList(safeStart, safeEnd)
}
