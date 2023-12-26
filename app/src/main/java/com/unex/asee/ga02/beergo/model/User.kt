package com.unex.asee.ga02.beergo.model

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import java.io.Serializable

/**
 * La entidad `User` representa a un usuario en la aplicación BeerGo.
 *
 * @property userId Identificador único autoincremental del usuario.
 * @property name El nombre del usuario.
 * @property password La contraseña del usuario.
 */
@Entity(indices = [Index(value = ["name"], unique = true)]) // Para que no se puedan repetir nombres de usuario.
data class User(
    @PrimaryKey(autoGenerate = true)
    var userId: Long = 0,
    var name: String = "",
    var password: String = ""


) : Serializable