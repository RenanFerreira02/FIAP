package br.com.fiap.omni_tribo.repository

import br.com.fiap.omni_tribo.model.AddressDto
import br.com.fiap.omni_tribo.service.RetrofitClient

class AddressRepository {

    suspend fun getAddress(cep: String): AddressDto? {
        return try {
            val result = RetrofitClient.viaCepService.getAddress(cep)
            if (result.erro == true) null else result
        } catch (e: Exception) {
            null
        }
    }
}
