package saidul.com.androiddatabasernd.ui

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_persion_list.view.*
import saidul.com.androiddatabasernd.R
import saidul.com.androiddatabasernd.ui.dummy.DummyContent.DummyItem


/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [PersionFragment.OnListFragmentInteractionListener] interface.
 */
class PersionFragment : Fragment() {


    private var listener: OnListFragmentInteractionListener? = null
    var mValues: ArrayList<DummyItem> = arrayListOf();
    lateinit var adapter: MyPersionRecyclerViewAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_persion_list, container, false)

        // Set the adapter

        adapter = MyPersionRecyclerViewAdapter(mValues, listener)



        linearLayoutManager = LinearLayoutManager(activity)
        view.list.layoutManager = linearLayoutManager

        view.list.adapter = adapter



        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)



        load();
        adapter.notifyDataSetChanged();


    }


    private fun load() {

        for (i in 0..2) {
            mValues.add(DummyItem("3434", "sdfsd", "sdfsdf"))
        }


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
