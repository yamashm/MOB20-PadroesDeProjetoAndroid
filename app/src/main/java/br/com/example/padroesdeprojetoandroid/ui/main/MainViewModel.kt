package br.com.example.padroesdeprojetoandroid.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.example.padroesdeprojetoandroid.data.network.APIService
import br.com.example.padroesdeprojetoandroid.model.Endereco
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel: ViewModel() {

    val enderecoResponse = MutableLiveData<Endereco>()
    val mensagemErro = MutableLiveData<String>()

    fun pesquisar(cep: String){
        APIService.instance
            ?.pesquisar(cep)
            ?.enqueue(object: Callback<Endereco>{
                override fun onResponse(call: Call<Endereco>, response: Response<Endereco>) {
                    if(response.isSuccessful){
                        enderecoResponse.value = response.body()
                    } else {
                        mensagemErro.value = "Endereço não encontrado"
                    }
                }

                override fun onFailure(call: Call<Endereco>, t: Throwable) {
                    mensagemErro.value = t.message.toString()
                }
            })
    }
}