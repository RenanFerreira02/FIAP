package br.com.fiap.omni_tribo.repository

import android.content.Context
import br.com.fiap.omni_tribo.dao.OmniDatabase
import br.com.fiap.omni_tribo.model.Mission
import br.com.fiap.omni_tribo.model.sampleMissions
import kotlinx.coroutines.flow.Flow

class MissionsRepository(context: Context) {

    private val dao = OmniDatabase.getDatabase(context).missionDao()

    init {
        if (dao.getCount() == 0) {
            dao.insertAll(sampleMissions)
        }
    }

    val missionsFlow: Flow<List<Mission>> = dao.getAllMissionsFlow()

    fun getMissionById(id: Int): Mission? = dao.getMissionById(id)

    fun markCompleted(id: Int) = dao.markCompleted(id)

    fun addMission(tag: String, title: String, subtitle: String, xp: Int, brl: String, time: String) {
        dao.insertMission(Mission(tag = tag, title = title, subtitle = subtitle, dist = "—", xp = xp, brl = brl, time = time))
    }
}
