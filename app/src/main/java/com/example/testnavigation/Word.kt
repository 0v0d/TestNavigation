package com.example.testnavigation

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Word(
  val text: String,
  val textCount: Int
) : Parcelable