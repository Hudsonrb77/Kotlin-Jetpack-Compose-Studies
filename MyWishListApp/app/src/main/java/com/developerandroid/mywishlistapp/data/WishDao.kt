package com.developerandroid.mywishlistapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

// Uma classe abstrata é uma classe que tem metodos que nao precisam de uma implementação
@Dao
abstract class WishDao {

    //As funcoes estão com "suspend", pois serao executadas em segundo plano ou em paralelo

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun addAWish(wishEntity: Wish)

    // Carrega todos os pedidos da tabela pedidos
    @Query("Select * from `wish-table`")
    abstract fun getAllWishes(): Flow<List<Wish>>

    // Nos permite editar uma entrada do meu banco de dados
    @Update
    abstract suspend fun updateAWish(wishEntity: Wish)

    @Delete
    abstract suspend fun deleteAWish(wishEntity: Wish)

    // Como o nome da funcao ja diz, ele retorna apenas os pedidos com o mesmo id.
    @Query("Select * from `wish-table` where id=:id")
    abstract fun getAWishById(id:Long):Flow<Wish>
}