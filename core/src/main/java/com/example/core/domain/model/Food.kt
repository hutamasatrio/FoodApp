package com.example.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Food(
    val idMeal: String?,
    val strMeal: String,
    val strMealThumb: String
):Parcelable