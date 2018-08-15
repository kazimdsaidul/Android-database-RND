package saidul.com.androiddatabasernd.ui.show

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_persion_list.*
import saidul.com.androiddatabasernd.R
import saidul.com.androiddatabasernd.model.Person
import saidul.com.androiddatabasernd.ui.MyPersionRecyclerViewAdapter
import saidul.com.androiddatabasernd.ui.dummy.DummyContent.DummyItem
import saidul.com.androiddatabasernd.ui.insert.viewModel.PersonViewModel


/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [PersonShowFragment.OnListFragmentInteractionListener] interface.
 */
class PersonShowFragment : Fragment() {


    private var listener: OnListFragmentInteractionListener? = null

    var mValues: MutableList<Person> = mutableListOf()
    lateinit var adapter: MyPersionRecyclerViewAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var mPersonViewModel: PersonViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_persion_list, container, false)

        // Set the adapter


        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)



        load();


    }


    private fun load() {


        mPersonViewModel = ViewModelProviders.of(this).get(PersonViewModel::class.java)
        mPersonViewModel.mAllPerson.observe(this, object : Observer<List<Person>> {
            override fun onChanged(t: List<Person>?) {
                mValues = t as ArrayList<Person>;

                adapter = MyPersionRecyclerViewAdapter(mValues, listener)



                linearLayoutManager = LinearLayoutManager(activity)
                list.layoutManager = linearLayoutManager

                list.adapter = adapter

                Toast.makeText(context, "notifyDataSetChanged", Toast.LENGTH_LONG).show()

            }


        })

    }

    override fun onResume() {
        super.onResume()

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnListFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson
     * [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onListFragmentInteraction(item: DummyItem?)
    }


}
