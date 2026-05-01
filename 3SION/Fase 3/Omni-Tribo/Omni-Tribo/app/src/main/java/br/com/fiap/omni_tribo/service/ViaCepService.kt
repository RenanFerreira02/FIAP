package br.com.fiap.omni_tribo.service

import br.com.fiap.omni_tribo.model.AddressDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ViaCepService {
    @GET("{cep}/json/")
    suspend fun getAddress(@Path("cep") cep: String): AddressDto
}
