package com.unex.asee.ga02.beergo.model


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Beer(
    @PrimaryKey val beerId: Int,
    val title: String,
    val description: String,
    val year: String,
    val kcal: String,
    val type: String,
    val nationality: String,
    val image: Int,
    val coverImage: Int,
    ): Serializable
