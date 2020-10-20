package br.com.example.padroesdeprojetoandroid.data.network

import br.com.example.padroesdeprojetoandroid.model.Endereco
import retrofit2.Call
import retrofit2.http.GET

interface EnderecoService {

    @GET("/ws/{cep}/json")
    fun pesuisar(cep: String): Call<Endereco>
}