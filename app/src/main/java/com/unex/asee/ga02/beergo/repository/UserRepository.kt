package com.unex.asee.ga02.beergo.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.unex.asee.ga02.beergo.database.UserDao
import com.unex.asee.ga02.beergo.model.Beer
import com.unex.asee.ga02.beergo.model.User
import com.unex.asee.ga02.beergo.utils.CredentialCheck

/**
 * Repositorio para gestionar la autenticación de usuarios.
 *
 * Este repositorio proporciona funcionalidad para autenticar usuarios utilizando
 * un objeto [UserDao] para acceder a la base de datos y [CredentialCheck] para
 * verificar las credenciales del usuario.
 *
 * @property userDao Instancia de UserDao para acceder a la base de datos local de usuarios.
 */
class UserRepository (private val userDao: UserDao) {

    /**
     * Intenta autenticar a un usuario utilizando el nombre de usuario y la contraseña proporcionados.
     *
     * @param username Nombre de usuario del usuario que intenta autenticarse.
     * @param password Contraseña del usuario que intenta autenticarse.
     * @return Objeto User si la autenticación es exitosa.
     * @throws Exception Si la autenticación falla debido a un nombre de usuario inválido o una contraseña incorrecta.
     */

    suspend fun loginUser(username: String, password: String): User {
        val user = userDao.findByName(username)
        if (user != null) {
            val check = CredentialCheck.passwordOk(password, user.password)
            if (check.fail) {
                throw Exception(check.msg) // Lanza una excepción si la contraseña no es válida.
            } else {
                return user // Retorna el objeto User si la autenticación es exitosa.
            }
        } else {
            throw Exception("Invalid username") // Lanza una excepción si el nombre de usuario no es válido.
        }
    }

    /**
     * Registra a un nuevo usuario en la base de datos.
     *
     * @param username Nombre de usuario del nuevo usuario.
     * @param password Contraseña del nuevo usuario.
     * @return Objeto User si el registro es exitoso, o null si el usuario ya existe.
     * @throws Exception Si el nombre de usuario no es válido.
     */
    suspend fun registerUser(username: String, password: String): User? {
        val check = CredentialCheck.join(username, password, password)
        var user: User? = null
        if (check.fail) {
            throw Exception(check.msg) // Lanza una excepción si el nombre de usuario no es válido.
        } else {
            user = User(0, username, password)
            val userId = userDao.insert(user)
            if (userId == -1L) {
                user = null
            } else {
                user.userId = userId
            }
        }
        return user
    }
    suspend fun getUser(userId: Long): User? {
        return userDao.findByID(userId)
    }
    suspend fun deleteUser(user: User) {
        userDao.delete(user)
    }

    fun countBeersInsertedByUser(userId: Long): LiveData<Int> {
        return userDao.countBeersInsertedByUser(userId)

    }

    fun countFavouritesByUser(userId: Long): LiveData<Int> {

            return userDao.countUserFavouriteBeers(userId)


    }

    fun countCommentsByUser(userId: Long): LiveData<Int> {
        Log.d("Observation", "CountCommentRer: ${userDao.countCommentsByUser(userId).value}")
            return userDao.countCommentsByUser(userId)
    }

    fun countUserAchievements(userId: Long): Int {
        if(userDao.countUserAchievements(userId) == null) {
            return 0
        }else{
            return userDao.countUserAchievements(userId)
        }
    }

    fun getUserBeers(userId: Long): LiveData<List<Beer>> {
        return userDao.getBeersByUserId(userId)
    }
}
