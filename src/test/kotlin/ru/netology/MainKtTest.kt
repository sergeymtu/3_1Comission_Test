package ru.netology

import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun prevComission_Visa() {

        val card:String = "Visa"
        val previous= 75000_00
        val current= 10000_00

        val result =  prevComission(cardType = card, previousTransfer = previous, currentTransfer = current)

        assertEquals(75_00 , result)

    }

    @Test
    fun prevComission_Mir() {

        val card:String = "МИР"
        val previous= 75000_00
        val current= 10000_00

        val result =  prevComission(cardType = card, previousTransfer = previous, currentTransfer = current)

        assertEquals(75_00 , result)

    }

    @Test
    fun prevComission_Maestro() {

        val card:String = "Maestro"
        val previous= 75000_00
        val current= 10000_00

        val result =  prevComission(cardType = card, previousTransfer = previous, currentTransfer = current)

        assertEquals(80_00 , result)

    }

    @Test
    fun prevComission_Mastercard() {

        val card:String = "Mastercard"
        val previous= 75000_00
        val current= 10000_00

        val result =  prevComission(cardType = card, previousTransfer = previous, currentTransfer = current)

        assertEquals(80_00 , result)

    }

    @Test
    fun prevComission_VK() {

        val card:String = "VKPay"
        val previous= 75000_00
        val current= 10000_00

        val result =  prevComission(cardType = card, previousTransfer = previous, currentTransfer = current)

        assertEquals(0 , result)

    }


    @Test
    fun prevComission_MaestroZeroComission() {

        val card:String = "Maestro"
        val previous= 10000_00
        val current= 10000_00

        val result =  prevComission(cardType = card, previousTransfer = previous, currentTransfer = current)

        assertEquals(0 , result)

    }

    @Test
    fun prevComission_MastercardZeroomission() {

        val card:String = "Mastercard"
        val previous= 10000_00
        val current= 10000_00

        val result =  prevComission(cardType = card, previousTransfer = previous, currentTransfer = current)

        assertEquals(0 , result)

    }




    @Test
    fun finalComission_MastercardOutLimit() {
        val card:String = "Mastercard"
        val previous= 75000_00
        val current= 160000_00
        val prevCom = 2000_00

        val result =  finalComission(cardType = card, previousTransfer = previous, currentTransfer = current, prevComission = prevCom)
        assertEquals("Превышен лимит переводов" , result)
    }

    @Test
    fun finalComission_MaestroOutLimit() {
        val card:String = "Maestro"
        val previous= 75000_00
        val current= 160000_00
        val prevCom = 2000_00

        val result =  finalComission(cardType = card, previousTransfer = previous, currentTransfer = current, prevComission = prevCom)
        assertEquals("Превышен лимит переводов" , result)
    }

    @Test
    fun finalComission_MirOutLimit() {
        val card:String = "МИР"
        val previous= 75000_00
        val current= 160000_00
        val prevCom = 2000_00

        val result =  finalComission(cardType = card, previousTransfer = previous, currentTransfer = current, prevComission = prevCom)
        assertEquals("Превышен лимит переводов" , result)
    }

    @Test
    fun finalComission_VisaOutLimit() {
        val card:String = "VKPay"
        val previous= 75000_00
        val current= 160000_00
        val prevCom = 2000_00

        val result =  finalComission(cardType = card, previousTransfer = previous, currentTransfer = current, prevComission = prevCom)
        assertEquals("Превышен лимит переводов" , result)
    }








    @Test
    fun finalComission_MastercardNonOutLimit() {
        val card:String = "Mastercard"
        val previous= 10000_00
        val current= 10000_00
        val prevCom = 0

        val result =  finalComission(cardType = card, previousTransfer = previous, currentTransfer = current, prevComission = prevCom)
        assertEquals(0 , result)
    }

    @Test
    fun finalComission_MaestroNonOutLimit() {
        val card:String = "Maestro"
        val previous= 10000_00
        val current= 10000_00
        val prevCom = 0

        val result =  finalComission(cardType = card, previousTransfer = previous, currentTransfer = current, prevComission = prevCom)
        assertEquals(0 , result)
    }

    @Test
    fun finalComission_MirNonOutLimit() {
        val card:String = "МИР"
        val previous= 10000_00
        val current= 10000_00
        val prevCom = 75_00

        val result =  finalComission(cardType = card, previousTransfer = previous, currentTransfer = current, prevComission = prevCom)
        assertEquals(75_00 , result)
    }

    @Test
    fun finalComission_VisaNonOutLimit() {
        val card:String = "Visa"
        val previous= 10000_00
        val current= 10000_00
        val prevCom = 75_00

        val result =  finalComission(cardType = card, previousTransfer = previous, currentTransfer = current, prevComission = prevCom)
        assertEquals(75_00 , result)
    }

    @Test
    fun finalComission_VkNonOutLimit() {
        val card:String = "VKPay"
        val previous= 10000_00
        val current= 10000_00
        val prevCom = 0

        val result =  finalComission(cardType = card, previousTransfer = previous, currentTransfer = current, prevComission = prevCom)
        assertEquals(0 , result)
    }

    @Test
    fun finalComission_NonVariant() {
        val card:String = "YandexPay"
        val previous= 10000_00
        val current= 10000_00
        val prevCom = 0

        val result =  finalComission(cardType = card, previousTransfer = previous, currentTransfer = current, prevComission = prevCom)
        assertEquals("Такого варианта быть не может) Введите правильный вариант", result)
    }







    @Test
    fun comission_NonVariant() {
        val card:String = "YandexPay"
        val previous= 10000_00
        val current= 10000_00

        val result = comission(cardType = card, previousTransfer = previous, currentTransfer = current)

        assertEquals("Такого варианта быть не может) Введите правильный вариант", result)

    }


    @Test
    fun comission_VisaVariant() {
        val card: String = "Visa"
        val previous = 10000_00
        val current = 10000_00

        val result = comission(cardType = card, previousTransfer = previous, currentTransfer = current)

        assertEquals(75_00, result)
    }


    @Test
    fun comission_MirVariant() {
        val card: String = "МИР"
        val previous = 10000_00
        val current = 10000_00

        val result = comission(cardType = card, previousTransfer = previous, currentTransfer = current)

        assertEquals(75_00, result)
    }

    @Test
    fun comission_VKVariant() {
        val card: String = "VKPay"
        val previous = 10000_00
        val current = 10000_00

        val result = comission(cardType = card, previousTransfer = previous, currentTransfer = current)

        assertEquals(0, result)
    }

    @Test
    fun comission_MastercardMin() {
        val card: String = "Mastercard"
        val previous = 10000_00
        val current = 10000_00

        val result = comission(cardType = card, previousTransfer = previous, currentTransfer = current)

        assertEquals(0, result)
    }

    @Test
    fun comission_Maestromin() {
        val card: String = "Maestro"
        val previous = 10000_00
        val current = 10000_00

        val result = comission(cardType = card, previousTransfer = previous, currentTransfer = current)

        assertEquals(0, result)
    }

    @Test
    fun comission_MastercardMax() {
        val card: String = "Mastercard"
        val previous = 10000_00
        val current = 100000_00

        val result = comission(cardType = card, previousTransfer = previous, currentTransfer = current)

        assertEquals(620_00, result)
    }

    @Test
    fun comission_MaestroMax() {
        val card: String = "Maestro"
        val previous = 10000_00
        val current = 100000_00

        val result = comission(cardType = card, previousTransfer = previous, currentTransfer = current)

        assertEquals(620_00, result)
    }
}