package com.example.gymbro.ui.theme.model

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Entity(tableName = "statss")
data class StatsElement(
    @PrimaryKey(autoGenerate = true) val id_s: Int,
    val nazwa: String,
    val opis: String,
    val statystyka: Int,
    val m_id: Int
) {
    init {
        require(statystyka < 100 && statystyka >= 0 && nazwa.isNotEmpty())
    }
}
@Dao
interface StatsDao {
    @Query("SELECT * FROM statss ORDER BY nazwa ASC")
    fun getStats(): Flow<List<StatsElement>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(user: StatsElement)

    @Query("DELETE FROM statss")
    suspend fun deleteAll()

    @Update
    suspend fun update(stats: StatsElement)

    @Delete
    suspend fun delete(stats: StatsElement)
}

@Database(entities = [StatsElement::class, MuscleElement::class], version = 1, exportSchema = false)
abstract class StatsDatabase : RoomDatabase() {
    abstract fun statsDao(): StatsDao

    companion object {
        @Volatile
        private var Instance: StatsDatabase? = null

        fun getDatabase(context: Context): StatsDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, StatsDatabase::class.java, "statss")
                    .build()
                    .also { Instance = it }
            }
        }
    }
}