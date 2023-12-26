package com.unex.asee.ga02.beergo.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.unex.asee.ga02.beergo.model.Achievement
import com.unex.asee.ga02.beergo.model.Beer
import com.unex.asee.ga02.beergo.model.Comment
import com.unex.asee.ga02.beergo.model.User
import com.unex.asee.ga02.beergo.model.UserAchievementCrossRef
import com.unex.asee.ga02.beergo.model.UserBeerCrossRef
import com.unex.asee.ga02.beergo.model.UserFavouriteBeerCrossRef

/**
 * Room Database para la aplicación BeerGo.
 * Contiene entidades: User, Beer, Comment, UserFavouriteBeerCrossRef, Achievement, UserAchievementCrossRef.
 */
@Database(
    entities = [User::class, Beer::class, Comment::class, UserFavouriteBeerCrossRef::class, Achievement::class, UserAchievementCrossRef::class, UserBeerCrossRef::class],
    version = 2
) //La base de datos se encuentra en versión 2 debido a que se ha hecho una actualización de los atributos de la clase Beer

abstract class BeerGoDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun achievementDao(): AchievementDao
    abstract fun beerDao(): BeerDao
    abstract fun commentDao(): CommentDao
    companion object {
        private var INSTANCE: BeerGoDatabase? = null
        fun getInstance(context: Context): BeerGoDatabase? {
            if (INSTANCE == null) {
                synchronized(BeerGoDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context, BeerGoDatabase::class.java, "beergo.db"
                    ).addCallback(BeerGoCallback(context)).build()
                }
            }
            return INSTANCE
        }
        fun destroyInstance() {
            INSTANCE = null
        }
    }

    // Clase interna para realizar la precarga de datos
    private class BeerGoCallback(private val context: Context) : RoomDatabase.Callback()  {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            val achievementDao = getInstance(context)!!.achievementDao()
            val userDao = getInstance(context)!!.userDao()
            val beerDao = getInstance(context)!!.beerDao()
            //Inserción de los logros en la base de datos
            /*
            GlobalScope.launch(Dispatchers.IO) {
                if (!ModoPrueba.modoPrueba) {
                    for (achievement in beerAchievements) {
                        achievementDao.insert(achievement)
                    }

                    for (beer in dummyBeers) {
                        beerDao.insert(beer)
                    }

                    for (user in dummyUsers) {
                        userDao.insert(user)
                    }

                    for (comment in dummyComments) {
                        commentDao.insert(comment)
                    }
                }
            }
            */

        }
    }
}



