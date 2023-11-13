package com.example.jetpack.model

import com.example.jetpack.R

object FakeDataSource {
    val dummyStories = listOf(
        Item(1, R.drawable.reward_1, "Token Sertifikasi Associate Android Developer", 6000),
        Item(2, R.drawable.reward_2, "Token Sertifikasi TensorFlow", 4500),
        Item(3, R.drawable.reward_3, "Paket Langganan Dicoding Academy 30 Hari", 1000),
        Item(4, R.drawable.reward_4, "Jaket Hoodie Dicoding", 1000),
        Item(5, R.drawable.reward_5, "Tas Ransel Dicoding", 1000),
        Item(6, R.drawable.reward_6, "Google Play Store Voucher Code", 1000),
        Item(7, R.drawable.reward_7, "Polo Shirt Dicoding", 750),
        Item(8, R.drawable.reward_8, "Tumbler Digital Dicoding", 750),
        Item(9, R.drawable.reward_9, "T-shirt Dicoding Developer Biru", 300),
        Item(10, R.drawable.reward_10, "T-shirt Dicoding Champ", 300),
        Item(11, R.drawable.reward_11, "T-shirt Dicoding Graduate", 300),
        Item(12, R.drawable.reward_12, "T-shirt Dicoding Developer Putih", 300),
    )

}

//model disatuin biar ga ribet

data class Item(
    val id: Long,
    val image: Int,
    val title: String,
    val requiredPoint: Int,
)