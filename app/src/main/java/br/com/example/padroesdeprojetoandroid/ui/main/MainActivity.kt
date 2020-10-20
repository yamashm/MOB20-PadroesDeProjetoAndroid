package br.com.example.padroesdeprojetoandroid.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.example.padroesdeprojetoandroid.R
import br.com.example.padroesdeprojetoandroid.data.network.APIService
import br.com.example.padroesdeprojetoandroid.model.Endereco
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), MainContract.MainView {

    private lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainPresenter = MainPresenter(this)

        btPesquisar.setOnClickListener {
            mainPresenter.pesquisar(etCEP.text.toString())
        }
    }

    override fun mostrarEndereco(endereco: Endereco?) {
        tvLogradouro.text = endereco?.logradouro
        tvBairro.text = endereco?.bairro
        tvLocalidade.text = endereco?.localidade
        tvUF.text = endereco?.uf
    }

    override fun mostrarErro(mensagem: String) {
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show()
    }


}