package br.com.example.padroesdeprojetoandroid.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.com.example.padroesdeprojetoandroid.R
import br.com.example.padroesdeprojetoandroid.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        initDataBinding()
        registerObserver()

        /*
        btPesquisar.setOnClickListener {
            mainViewModel.pesquisar(etCEP.text.toString())
        } */
    }

    private fun initDataBinding(){
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.mainViewModel = mainViewModel
        binding.lifecycleOwner = this
    }

    private fun registerObserver(){
        /*
        mainViewModel.enderecoResponse.observe(this, Observer {
            tvLogradouro.text = it.logradouro
            tvBairro.text = it.bairro
            tvLocalidade.text = it.localidade
            tvUF.text = it.uf
        }) */

        mainViewModel.mensagemErro.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })
    }
}