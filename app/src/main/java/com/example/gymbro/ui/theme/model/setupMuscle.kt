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
import org.jetbrains.annotations.NotNull

@Entity(tableName = "muscle")
data class MuscleElement(
    @PrimaryKey(autoGenerate = true) val id_m: Int,
    val nazwa_miesnia: String
)
{
    init {
        require(nazwa_miesnia.isNotEmpty()) {"nazwa_miesnia cant be empty"}
    }
}
@Dao
interface MuscleDao {
    @Query("SELECT * FROM muscle ORDER BY nazwa_miesnia ASC")
    fun getMuscle(): Flow<List<MuscleElement>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertMuscle(user: MuscleElement)

    @Query("DELETE FROM muscle")
    suspend fun deleteAllMuscles()

    @Update
    suspend fun updateMuscle(muscle: MuscleElement)

    @Delete
    suspend fun deleteMuscle(muscle: MuscleElement)
}

@Database(entities = [MuscleElement::class], version = 1, exportSchema = false)
abstract class MuscleDatabase : RoomDatabase() {
    abstract fun muscleDao(): MuscleDao

    companion object {
        @Volatile
        private var Instance: MuscleDatabase? = null

        fun getDatabase(context: Context): MuscleDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, MuscleDatabase::class.java, "muscle")
                    .build()
                    .also { Instance = it }
            }
        }
    }
}