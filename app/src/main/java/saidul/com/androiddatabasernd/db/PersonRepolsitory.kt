package saidul.com.androiddatabasernd.db

import android.app.Application
import android.arch.lifecycle.LiveData
import android.os.AsyncTask
import saidul.com.androiddatabasernd.model.Person

/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 8/14/18.
 */
class PersonRepolsitory() {
    lateinit var mPersonDAO: PersonDAO
    lateinit var allPerson: LiveData<List<Person>>

    init {

    }

    constructor(application: Application) : this() {
        val db = PersonDatabase.getInstance(application)
        db.isOpen();
        db.close();
        this.mPersonDAO = db.peronDao()
        this.allPerson = mPersonDAO.getAllPerson();

    }

    fun insert(person: Person): Unit {
        InsertAsyncTask(mPersonDAO).execute(person)

        // mPersonDAO.insert(person)
    }

    inner class InsertAsyncTask(val personDAO: PersonDAO) : AsyncTask<Person, Void, Void>() {
        override fun doInBackground(vararg p0: Person?): Void? {
            personDAO.insert(p0[0]!!)
            return null;
        }


    }
}

