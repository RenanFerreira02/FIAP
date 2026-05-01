package br.com.fiap.omni_tribo.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.fiap.omni_tribo.model.UserProfile

@Database(entities = [UserProfile::class], version = 1)
abstract class OmniDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        private lateinit var instance: OmniDatabase

        fun getDatabase(context: Context): OmniDatabase {
            if (!::instance.isInitialized) {
                instance = Room.databaseBuilder(
                    context,
                    OmniDatabase::class.java,
                    "omni_database"
                )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration(true)
                    .build()
            }
            return instance
        }
    }
}
