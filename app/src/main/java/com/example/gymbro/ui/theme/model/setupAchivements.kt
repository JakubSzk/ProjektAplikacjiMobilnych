package com.example.gymbro.ui.theme.model

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.Update
import kotlinx.coroutines.flow.Flow


@Entity(tableName = "achivements")
data class AchiveElement(
    @PrimaryKey(autoGenerate = true) val id_a: Int,
    val opis: String,
    val nazwa: String,
    var progress: Int,
    var nazwa_ikonki: String
)
@Dao
interface AchiveDao {
    @Query("SELECT * FROM achivements ORDER BY nazwa ASC")
    fun getAchive(): Flow<List<AchiveElement>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(user: AchiveElement)

    @Query("DELETE FROM achivements")
    suspend fun deleteAll()

    @Update
    suspend fun update(achive: AchiveElement)

    @Delete
    suspend fun delete(achive: AchiveElement)
}

@Database(entities = [AchiveElement::class], version = 1, exportSchema = false)
abstract class AchiveDatabase : RoomDatabase() {
    abstract fun achiveDao(): AchiveDao

    companion object {
        @Volatile
        private var Instance: AchiveDatabase? = null

        fun getDatabase(context: Context): AchiveDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, AchiveDatabase::class.java, "achivements")
                    .build()
                    .also { Instance = it }
            }
        }
    }
}





