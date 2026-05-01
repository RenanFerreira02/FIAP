package br.com.fiap.omni_tribo.repository

import android.content.Context
import br.com.fiap.omni_tribo.dao.OmniDatabase
import br.com.fiap.omni_tribo.model.UserProfile

class UserRepository(context: Context) {

    private val dao = OmniDatabase.getDatabase(context).userDao()

    fun getProfile(): UserProfile {
        return dao.getProfile() ?: UserProfile().also { dao.saveProfile(it) }
    }

    fun completeMission(xp: Int, brlStr: String) {
        val current = getProfile()
        val brlEarned = if (brlStr == "—") 0.0 else brlStr.toDoubleOrNull() ?: 0.0
        val newXp = current.xp + xp
        val updated = if (newXp >= current.xpThreshold) {
            current.copy(
                xp = newXp - current.xpThreshold,
                level = current.level + 1,
                xpThreshold = current.xpThreshold + 1000,
                missionsCompleted = current.missionsCompleted + 1,
                brl = current.brl + brlEarned,
            )
        } else {
            current.copy(
                xp = newXp,
                missionsCompleted = current.missionsCompleted + 1,
                brl = current.brl + brlEarned,
            )
        }
        dao.updateProfile(updated)
    }
}
