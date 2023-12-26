package com.unex.asee.ga02.beergo.data
import com.unex.asee.ga02.beergo.model.Achievement

const val BARRIL_DE_PLATA = "Barril de plata"
val beerAchievements = listOf(
    Achievement(1, "Primer Sorbo", "Añade la primera cerveza a tu colección", 4, "Barril de madera"),
    Achievement(2, "Gusto Eclectico", "Añade 1 cerveza a favoritos",  6, "Barril de madera"),
    Achievement(3, "Palabras Arómaticas", "Añade 1 comentario a una cerveza", 26,  BARRIL_DE_PLATA),
    Achievement(4, "Explorador de Sabores Globales", "Añade 3 cervezas a favoritos",  25, BARRIL_DE_PLATA),
    Achievement(5, "Variedad Destilada", "Añade una cerveza con grado de alohol mas de 10",  4, "Barril de diamante"),
    Achievement(6, "Ritmo Cervecero", "Añadir 3 cervezas",  28, BARRIL_DE_PLATA),
    Achievement(7, "Maestro de la colección", "Añade 5 comentarios",  96, "Barril de oro"),
    Achievement(8, "Rey de la Celebración Cervecera", "Añade 7 cervezas",  102, "Barril de oro")
)