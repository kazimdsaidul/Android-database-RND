package saidul.com.androiddatabasernd.db


import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import saidul.com.androiddatabasernd.model.Person


/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 8/14/18.
 */

@Database(entities = [Person::class], version = 1)
abstract class PersonDatabase() : RoomDatabase() {
    companion object {

        /**
         * The only instance
         */
        private var sInstance: PersonDatabase? = null

        val databaseName: String = "PersonDB"


        @Synchronized
        fun getInstance(context: Context): PersonDatabase {
            if (sInstance == null) {
                sInstance = Room
                        .databaseBuilder(context.applicationContext, PersonDatabase::class.java, databaseName)
                        .fallbackToDestructiveMigration()
                        .build()
            }
            return sInstance!!
        }

    }


    abstract fun peronDao(): PersonDAO


}



