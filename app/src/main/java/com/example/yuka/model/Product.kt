package com.example.yuka.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Product(
    val name: String,
    val mark: String,
    val barCode: String,
    val nutriscore: String,
    val imgUrl: String,
    val quantity: String,
    val countryFrom: List<String>,
    val ingredient: List<String>,
    val allergen: List<String>,
    val addictif: List<String>,
    val calorie: Int
) : Parcelable {

}