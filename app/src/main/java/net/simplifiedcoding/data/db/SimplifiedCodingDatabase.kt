package net.simplifiedcoding.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import net.simplifiedcoding.data.Course

@Database(entities = [Course::class], version = 1)
abstract class SimplifiedCodingDatabase : RoomDatabase() {

    abstract fun getCourseDao(): CourseDao

    companion object {
        @Volatile
        private var instance: SimplifiedCodingDatabase? = null
        private val LOCK = Any()

        //elvis operator
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                SimplifiedCodingDatabase::class.java,
                "MyDatabase.db"
            ).build()
    }
}