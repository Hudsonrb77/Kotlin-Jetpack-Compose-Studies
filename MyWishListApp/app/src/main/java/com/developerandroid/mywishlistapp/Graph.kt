package com.developerandroid.mywishlistapp

import android.content.Context
import androidx.room.Room
import com.developerandroid.mywishlistapp.data.WishDatabase
import com.developerandroid.mywishlistapp.data.Wishrepository

// Objeto Graph, usado para gerenciar dependências no app.
object Graph {
    // Declaração do banco de dados. Será inicializado posteriormente.
    lateinit var database: WishDatabase

    // Criação do repositório de desejos usando o DAO do banco de dados.
    // O "by lazy" garante que o repositório só será inicializado quando for usado.
    val wishRepository by lazy {
        Wishrepository(wishDao = database.wishDao())
    }

    // Método para configurar o banco de dados usando Room.
    // Recebe o contexto do app e cria a instância do banco de dados "wishlist.db".
    fun provide(context: Context) {
        database = Room.databaseBuilder(
            context,    // Contexto necessário para acessar o sistema de arquivos.
            WishDatabase::class.java, // Classe do banco de dados que define sua estrutura.
            "wishlist.db"    // Nome do arquivo
        ).build()
    }
}