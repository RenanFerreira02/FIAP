package br.com.fiap.omni_tribo.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import br.com.fiap.omni_tribo.model.UserProfile

@Dao
interface UserDao {

    @Query("SELECT * FROM tb_user_profile WHERE id = 1")
    fun getProfile(): UserProfile?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveProfile(profile: UserProfile)

    @Update
    fun updateProfile(profile: UserProfile)
}
