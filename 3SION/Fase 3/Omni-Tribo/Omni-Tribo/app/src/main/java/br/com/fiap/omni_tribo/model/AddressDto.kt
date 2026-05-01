package br.com.fiap.omni_tribo.model

import com.google.gson.annotations.SerializedName

data class AddressDto(
    @SerializedName("cep") val cep: String = "",
    @SerializedName("logradouro") val logradouro: String = "",
    @SerializedName("complemento") val complemento: String = "",
    @SerializedName("bairro") val bairro: String = "",
    @SerializedName("localidade") val localidade: String = "",
    @SerializedName("uf") val uf: String = "",
    @SerializedName("erro") val erro: Boolean? = null,
) {
    fun fullAddress(): String = buildString {
        if (logradouro.isNotBlank()) append(logradouro)
        if (bairro.isNotBlank()) {
            if (isNotEmpty()) append(", ")
            append(bairro)
        }
        if (localidade.isNotBlank()) {
            if (isNotEmpty()) append(" · ")
            append("$localidade/$uf")
        }
    }
}
