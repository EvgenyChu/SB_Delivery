package ru.churkin.sbdelivery.view_models

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.churkin.sbdelivery.Product

class BasketViewModel : ViewModel() {
    private val _state: MutableStateFlow<BasketState> = MutableStateFlow(BasketState())

    val state: StateFlow<BasketState>
        get() = _state

    private val currentState: BasketState
        get() = state.value

    private val products: List<Product> = listOf(
        Product(
            "5ed8da011f071c00465b2026",
            "Бургер \"Америка\"",
            "320 г • Котлета из 100% говядины (прожарка medium) на гриле, картофельная булочка на гриле, фирменный соус, лист салата, томат, маринованный лук, жареный бекон, сыр чеддер.",
            "https://www.delivery-club.ru/media/cms/relation_product/32350/312372888_m650.jpg",
            "259",
            170,
            3.55f,
            9,
            "5ed8da011f071c00465b1fde",
            36,
            true,
            1591269889000,
            1637762841000
        ),
        Product(
            "5ed8da011f071c00465b2027",
            "Бургер \"Мексика\"",
            "295 г • Котлета из 100% говядины (прожарка medium) на гриле, картофельная булочка на гриле, мексиканские чипсы начос, лист салата, перчики халапеньо, сыр чеддер, соус сальса из свежих томатов.",
            "https://www.delivery-club.ru/media/cms/relation_product/32350/312372889_m650.jpg",
            "",
            259,
            3.5f,
            3,
            "5ed8da011f071c00465b1fde",
            4,
            true,
            1591269889000,
            1637762928000
        ),
        Product(
            "5ed8da011f071c00465b2028",
            "Бургер \"Русский\"",
            "460 г • Две котлеты из 100% говядины (прожарка medium) на гриле, картофельная булочка на гриле, фирменный соус, лист салата, томат, маринованный лук, маринованные огурчики, двойной сыр чеддер, соус ранч.",
            "https://www.delivery-club.ru/media/cms/relation_product/32350/312372890_m650.jpg",
            "",
            379,
            4f,
            3,
            "5ed8da011f071c00465b1fde",
            8,
            true,
            1591269889000,
            1633634131000
        ),
        Product(
            "5ed8da011f071c00465b2029",
            "Бургер \"Люксембург\"",
            "Куриное филе приготовленное на гриле, картофельная булочка на гриле, сыр чеддер, соус ранч, лист салата, томат, свежий огурец.",
            "https://www.delivery-club.ru/media/cms/relation_product/32350/312372891_m650.jpg",
            "",
            189,
            2.6f,
            2,
            "5ed8da011f071c00465b1fde",
            1,
            true,
            1591269889000,
            1637765044000
        ),
        Product(
            "5ed8da011f071c00465b202a",
            "Бургер \"Классика\"",
            "290 г • Котлета из 100% говядины (прожарка medium) на гриле, картофельная булочка на гриле, фирменный соус, лист салата, томат, сыр чеддер.",
            "https://www.delivery-club.ru/media/cms/relation_product/32350/312372893_m650.jpg",
            "",
            199,
            4.5f,
            1,
            "5ed8da011f071c00465b1fde",
            1,
            true,
            1591269889000,
            1637763352000
        ),
        Product(
            "5ed8da011f071c00465b202b",
            "Бургер \"Швейцария\"",
            "320 г • Котлета из 100% говядины (прожарка medium) на гриле, картофельная булочка на гриле, натуральный сырный соус, лист салата, томат, маринованный огурчик, 2 ломтика сыра чеддер.",
            "https://www.delivery-club.ru/media/cms/relation_product/32350/312700349_m650.jpg",
            "",
            279,
            3.5714285714285716f,
            3,
            "5ed8da011f071c00465b1fde",
            3,
            true,
            1591269889000,
            1633636232000
        ),
        Product(
            "5ed8da011f071c00465b202c",
            "Бургер \"Франция\"",
            "305 г • Котлета из 100% говядины (прожарка medium) на гриле, картофельная булочка на гриле, творожный сыр, лист салата, сыр чеддер, карамелизированная груша.",
            "https://www.delivery-club.ru/media/cms/relation_product/32350/312700351_m650.jpg",
            "",
            289,
            3f,
            1,
            "5ed8da011f071c00465b1fde",
            6,
            true,
            1591269889000,
            1635945308000
        ),
        Product(
            "5ed8da011f071c00465b202d",
            "Бургер \"Чак Норрис\"",
            "345 г • Котлета из 100% говядины (прожарка medium) на гриле, картофельная булочка на гриле, соус барбекю, фирменный соус, лист салата, луковые кольца, жареный бекон, сыр чеддер.",
            "https://www.delivery-club.ru/media/cms/relation_product/32350/312700353_m650.jpg",
            "",
            299,
            0f,
            0,
            "5ed8da011f071c00465b1fde",
            0,
            true,
            1591269889000,
            1625494780000
        ),
        Product(
            "5ed8da011f071c00465b202e",
            "Пицца Дьябло с двойной начинкой",
            "Бекон, свинина, пепперони, перец болгарский, халапеньо, томатный пицца-соус, соус шрирача, моцарелла, зелень",
            "https://www.delivery-club.ru/media/cms/relation_product/13219/301422298_m650.jpg",
            "",
            779,
            0f,
            0,
            "5ed8da011f071c00465b1fe8",
            0,
            true,
            1591269889000,
            1623703869000
        ),
        Product(
            "5ed8da011f071c00465b202f",
            "Пицца Карбонара с двойной начинкой",
            "Бекон, пармезан, соус сливочный, моцарелла",
            "https://www.delivery-club.ru/media/cms/relation_product/13219/301422305_m650.jpg",
            "",
            739,
            0f,
            0,
            "5ed8da011f071c00465b1fe8",
            0,
            true,
            1591269889000,
            1591269889000
        )
    )

    init {
        _state.value = currentState.copy(products = products)
        var totalPrice = 0
            products.forEach { totalPrice += it.price }
        _state.value = currentState.copy(totalPrice = totalPrice)
    }

    fun updatePromoCode(promoCode: String) {
        _state.value = currentState.copy(promoCode = promoCode)
    }

}

data class BasketState(
    val products: List<Product> = listOf(),
    val promoCode: String = "",
    val totalPrice: Int = 0
)