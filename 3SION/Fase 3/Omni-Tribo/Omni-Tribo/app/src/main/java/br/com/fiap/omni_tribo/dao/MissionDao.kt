package br.com.fiap.omni_tribo.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.fiap.omni_tribo.model.Mission
import kotlinx.coroutines.flow.Flow

@Dao
interface MissionDao {

    @Query("SELECT * FROM tb_mission ORDER BY id ASC")
    fun getAllMissionsFlow(): Flow<List<Mission>>

    @Query("SELECT * FROM tb_mission WHERE id = :id")
    fun getMissionById(id: Int): Mission?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(missions: List<Mission>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMission(mission: Mission)

    @Query("UPDATE tb_mission SET completed = 1 WHERE id = :id")
    fun markCompleted(id: Int)

    @Query("SELECT COUNT(*) FROM tb_mission")
    fun getCount(): Int
}
