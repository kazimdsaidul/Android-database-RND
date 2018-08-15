package saidul.com.androiddatabasernd.ui.insert

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_plus_one.view.*
import saidul.com.androiddatabasernd.R
import saidul.com.androiddatabasernd.ui.insert.viewModel.PersonViewModel


/**
 * A fragment with a Google +1 button.
 * Activities that contain this fragment must implement the
 * [PlusOneFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 */
class PlusOneFragment : Fragment() {

    lateinit var mPersonViewModel: PersonViewModel
    var counter: Int = 0;

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_plus_one, container, false)
        view.btAdd.setOnClickListener {
            Toast.makeText(context, "Test", Toast.LENGTH_LONG).show()

            mPersonViewModel.insert()

        }


//        mPersonViewModel.mAllPerson.observe(this, Observer {
//
//            Toast.makeText(context, "data change", Toast.LENGTH_LONG).show()
//        })


        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mPersonViewModel = ViewModelProviders.of(this).get(PersonViewModel::class.java)


    }


}


