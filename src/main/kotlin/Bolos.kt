var puntaje = 0

fun main() {
    val juego1 = listOf(1, 4, 4, 5, 6, 4, 5, 5, 10, 0, 1, 7, 3, 6, 4, 10, 2, 8, 6)
    val juego2 = listOf(10, 10, 10, 0, 0, 4, 6, 5, 5, 10, 1, 3, 7, 3, 1, 1)
    val juego3 = listOf(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10)

    println("Juego 1 -> Total: ${ series(juego1) }")

    println("Juego 2 -> Total: ${ series(juego2) }")

    println("Juego 3 -> Total: ${ series(juego3) }")
}

fun series(juego: List<Int>): Int {
    puntaje = 0
    var index = 0
    var apuntador = 0

    while (apuntador < 10) {
        when{
            //Strike
            juego[index] == 10 -> {
                puntaje += 10 + juego[index + 1] + juego[index + 2]
                index++
            }
            //Open
            juego[index] + juego[index + 1] < 10 -> {
                puntaje += juego[index] + juego[index + 1]

                if (index + 2 >= juego.size) {
                    index++
                } else {
                    index += 2
                }
            }
            //Spare
            juego[index] + juego[index + 1] == 10 -> {
                puntaje += 10 + juego[index + 2]

                if (index + 2 >= juego.size) {
                    index++
                } else {
                    index += 2
                }
            }
        }
        apuntador++
    }

    return puntaje
}