package net.simplifiedcoding.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import net.simplifiedcoding.data.Course

@Dao
interface CourseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCourse(courses: List<Course>?)

    @Query("SELECT * FROM courses ORDER BY id DESC")
    suspend fun getCourses() : List<Course>

}