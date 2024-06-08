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
import java.sql.Date

@Entity(tableName = "trainings", foreignKeys = [
    ForeignKey(entity = ExerciseElement::class, parentColumns = ["id_e"], childColumns = ["e_id"])
])
data class TrainingElement(
    @PrimaryKey(autoGenerate = true) val id_t: Int,
    val czas: Float,
    val ilosc_powtorzen: Int,
    val e_id: Int,
    val masa: Float,
    val data: Date
)
@Dao
interface TrainingDao {
    @Query("SELECT * FROM trainings ORDER BY masa ASC")
    fun getTraining(): Flow<List<TrainingElement>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(user: TrainingElement)

    @Query("DELETE FROM trainings")
    suspend fun deleteAll()

    @Update
    suspend fun update(training: TrainingElement)

    @Delete
    suspend fun delete(training: TrainingElement)
}

@Database(entities = [TrainingElement::class], version = 1, exportSchema = false)
abstract class TrainingDatabase : RoomDatabase() {
    abstract fun trainingDao(): TrainingDao

    companion object {
        @Volatile
        private var Instance: TrainingDatabase? = null

        fun getDatabase(context: Context): TrainingDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, TrainingDatabase::class.java, "trainings")
                    .build()
                    .also { Instance = it }
            }
        }
    }
}