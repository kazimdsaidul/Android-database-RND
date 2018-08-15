package saidul.com.androiddatabasernd.ui.insert.viewModel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.os.AsyncTask
import android.widget.Toast
import saidul.com.androiddatabasernd.db.PersonRepolsitory
import saidul.com.androiddatabasernd.model.Person

/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 8/14/18.
 */
public class PersonViewModel(application: Application) : AndroidViewModel(application) {

    var personRepolsitory: PersonRepolsitory
    lateinit var mAllPerson: LiveData<List<Person>>


    init {
        this.personRepolsitory = PersonRepolsitory(application)
        this.mAllPerson = personRepolsitory.allPerson
    }

    fun insert() {
        InsertMoreAsyncTask().execute()

    }

    inner class InsertMoreAsyncTask() : AsyncTask<Void, Person, Void>() {

        var counter: Int = 0

        override fun doInBackground(vararg p0: Void?): Void? {
            var person: Person

            for (i in 0..100000) {
                counter++;
                person = Person("saidul" + counter,
                        "sakdsjlfkjslfjlksjdfklj@gmail.com" + counter,
                        "+9989we8r98we" + counter,

                        "lslkdfjlksjdfl  s dflkjsfdl  sdlfkjslkfj  sadf lksjfd jskdlfjlksdfj  sdlkfjslkdfj kjasdfkl j" + counter,
                        "lslkdfjlksjdfl  s dflkjsfdl  sdlfkjslkfj  sadf lksjfd jskdlfjlksdfj  sdlkfjslkdfj kjasdfkl j" + counter,
                        "father name " + counter,
                        "Mother name name " + counter,
                        "sdfsdfsdf" + counter,
                        "sdfsdfsdf" + counter,
                        "sdfsdfsfsdf" + counter,
                        "sdfsdfsdf" + counter)

                publishProgress(person)


            }




            return null;
        }

        override fun onProgressUpdate(vararg values: Person?) {
            super.onProgressUpdate(*values)
            personRepolsitory.insert(values[0]!!)
            System.gc();


        }

        override fun onPostExecute(result: Void?) {
            super.onPostExecute(result)
            Toast.makeText(getApplication(), "findished", Toast.LENGTH_LONG).show();
        }


    }
}