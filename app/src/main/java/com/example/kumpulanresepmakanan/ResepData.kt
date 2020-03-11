package com.example.kumpulanresepmakanan

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResepData(
    val jenis: String,
    val poster: Int,
    val foodName: String,
    val penjelasan: String
) : Parcelable