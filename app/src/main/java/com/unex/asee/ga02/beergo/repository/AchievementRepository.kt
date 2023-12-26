package com.unex.asee.ga02.beergo.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import com.unex.asee.ga02.beergo.database.AchievementDao
import com.unex.asee.ga02.beergo.database.UserDao
import com.unex.asee.ga02.beergo.model.Achievement
import com.unex.asee.ga02.beergo.model.UserWithAchievements
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Repositorio para manejar operaciones relacionadas con logros (Achievements).
 *
 * @property userDao DAO para la entidad de usuario.
 * @property achievementDao DAO para la entidad de logro (Achievement).
 */
class AchievementRepository (private val userDao: UserDao, private val achievementDao: AchievementDao) {

    private val userFilter = MutableLiveData<Long>()
    val listAchievementUser: LiveData<UserWithAchievements> = userFilter.switchMap{ userId -> userDao.getUserAchievements(userId) }

    fun setUserid(userid: Long) {
        userFilter.value = userid
    }

    /**
     * Obtiene todos los logros.
     *
     * @return Lista de todos los logros.
     */
    fun getAllAchievements() = achievementDao.getAll()

    /**
     * Obtiene los logros de un usuario específico.
     *
     * @param userId ID del usuario.
     * @return Logros del usuario.
     */



    suspend fun insertAndRelate(achievement: Achievement, userId: Long) {
        withContext(Dispatchers.IO){
            achievementDao.insertAndRelate(achievement, userId)
        }
    }

    /**
     * Verifica si un usuario ha alcanzado un logro específico.
     *
     * @param userId ID del usuario.
     * @param achievementId ID del logro a verificar.
     * @return `true` si el usuario ha alcanzado el logro, `false` en caso contrario.
     */

}
