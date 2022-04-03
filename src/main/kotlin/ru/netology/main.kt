package ru.netology

val cardType: String = "Visa"
val previousTransfer: Int = 75000_00
val currentTransfer: Int = 10000_00


fun prevComission(cardType: String, previousTransfer: Int, currentTransfer: Int): Int {
    val previousComission = when (cardType) {
        "Mastercard", "Maestro" -> if (currentTransfer + previousTransfer > 75000_00) currentTransfer / 1000 * 6 + 20_00 else 0
        "МИР", "Visa" -> if (currentTransfer / 10000 * 75 > 35_00) currentTransfer / 10000 * 75 else 35_00
        else -> 0 // остается только vk
    }
    return previousComission
}

fun finalComission(cardType: String, previousTransfer: Int, currentTransfer: Int, prevComission: Int): Any {
    return when (cardType) {
        "Mastercard", "Maestro", "МИР", "Visa" -> if (currentTransfer > 150_000_00 || currentTransfer + previousTransfer > 600_000_00) "Превышен лимит переводов"
        else prevComission
        "VKPay" -> if (currentTransfer > 15000_00 || currentTransfer + previousTransfer > 40000_00) "Превышен лимит переводов"
        else prevComission
        else -> "Такого варианта быть не может) Введите правильный вариант"
    }
}

fun comission(cardType: String, previousTransfer: Int, currentTransfer: Int): Any {
    val prevComission = prevComission(cardType, previousTransfer, currentTransfer)
    val finalComission = finalComission(cardType, previousTransfer, currentTransfer, prevComission)
    return finalComission
}


fun main() {

    val comission = comission(cardType, previousTransfer, currentTransfer)

    println("Окончательная комиссия: $comission")

}
