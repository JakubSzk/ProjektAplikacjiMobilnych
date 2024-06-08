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

@Entity(tableName = "exercises", foreignKeys = [
    ForeignKey(entity = MuscleElement::class, parentColumns = ["id_m"], childColumns = ["m_id"])
])
data class ExerciseElement(
    @PrimaryKey(autoGenerate = true) val id_e: Int,
    val opis: String,
    val m_id: Int,
    val dlugosc_ruchu: Float
)
@Dao
interface ExerciseDao {
    @Query("SELECT * FROM exercises ORDER BY opis ASC")
    fun getExercise(): Flow<List<ExerciseElement>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(user: ExerciseElement)

    @Query("DELETE FROM exercises")
    suspend fun deleteAll()

    @Update
    suspend fun update(exercise: ExerciseElement)

    @Delete
    suspend fun delete(exercise: ExerciseElement)
}

@Database(entities = [ExerciseElement::class], version = 1, exportSchema = false)
abstract class ExerciseDatabase : RoomDatabase() {
    abstract fun exerciseDao(): ExerciseDao

    companion object {
        @Volatile
        private var Instance: ExerciseDatabase? = null

        fun getDatabase(context: Context): ExerciseDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, ExerciseDatabase::class.java, "exercise")
                    .build()
                    .also { Instance = it }
            }
        }
    }
}