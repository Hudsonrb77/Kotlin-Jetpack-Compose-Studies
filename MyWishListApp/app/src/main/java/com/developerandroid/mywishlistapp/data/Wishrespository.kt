package com.developerandroid.mywishlistapp.data

import kotlinx.coroutines.flow.Flow

class Wishrepository(private val wishDao: WishDao) {

    suspend fun addAWish(wish:Wish)  {
        wishDao.addAWish(wish)
    }

    // Retorna todos os desejos salvos no banco de dados.
    // O resultado é um Flow<List<Wish>>, que emite atualizações em tempo real sempre que os dados mudam.
    suspend fun getWishes(): Flow<List<Wish>> = wishDao.getAllWishes()

    // Busca um desejo específico pelo ID fornecido.
    // Retorna um Flow<Wish>, permitindo observar atualizações do item específico.
    fun getAWishById(id:Long) :Flow<Wish> {
        return wishDao.getAWishById(id)
    }

    // Atualiza as informações de um desejo no banco de dados.
    // 'wishDao.updateAWish(wish)' chama o método do DAO para atualizar o registro correspondente.
    suspend fun updateAWish(wish:Wish){
        wishDao.updateAWish(wish)
    }

    // Remove um desejo do banco de dados.
    // 'wishDao.deleteAWish(wish)' executa a operação de exclusão no banco.
    suspend fun deleteAWish(wish: Wish){
        wishDao.deleteAWish(wish)
    }
}