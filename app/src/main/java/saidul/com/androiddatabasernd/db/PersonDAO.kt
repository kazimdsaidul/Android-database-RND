package saidul.com.androiddatabasernd.db

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import saidul.com.androiddatabasernd.model.Person

/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 8/14/18.
 */
@Dao
interface PersonDAO {

    @Insert
    fun insert(persons: Person)

    @Query("DELETE FROM Person")
    fun deleteAll()

    @Query("SELECT * FROM PERSON ORDER BY PERSON.name ASC")
    fun getAllPerson(): LiveData<List<Person>>


}