package br.com.example.padroesdeprojetoandroid.ui.main

import br.com.example.padroesdeprojetoandroid.model.Endereco

interface MainContract {

    interface  MainView{
        fun mostrarEndereco(endereco: Endereco?)
        fun mostrarErro(mensagem: String)
    }

    interface  MainPresenter{
        fun pesquisar(cep: String)
    }
}