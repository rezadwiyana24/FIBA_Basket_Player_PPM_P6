package id.Federation.Internationale.de.Basketball.persistences

import androidx.lifecycle.LiveData
import androidx.room.*
import id.Federation.Internationale.de.Basketball.model.dataplayer

@Dao
interface dataplayerDao {
    @Query("SELECT * FROM dataplayer")
    fun loadAll(): LiveData<List<dataplayer>>

    @Query("SELECT * FROM dataplayer WHERE nopunggung = :nopunggung")
    fun find(nopunggung: String): dataplayer?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg items: dataplayer)

    @Delete
    fun delete(item: dataplayer)
}

@Database(entities = [dataplayer::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dataplayerDao(): dataplayerDao
}