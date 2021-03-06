package saidul.com.androiddatabasernd.ui


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_persion.view.*
import saidul.com.androiddatabasernd.R
import saidul.com.androiddatabasernd.model.Person
import saidul.com.androiddatabasernd.ui.dummy.DummyContent.DummyItem
import saidul.com.androiddatabasernd.ui.show.PersonShowFragment.OnListFragmentInteractionListener


class MyPersionRecyclerViewAdapter(
        private val mValues: MutableList<Person>,
        private val mListener: OnListFragmentInteractionListener?)
    : RecyclerView.Adapter<MyPersionRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as DummyItem
            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.
            mListener?.onListFragmentInteraction(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_persion, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]

        holder.mIdView.text = item.id.toString();
        holder.mContentView.text = item.name;

        with(holder.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mIdView: TextView = mView.item_number
        val mContentView: TextView = mView.content

        override fun toString(): String {
            return super.toString() + " '" + mContentView.text + "'"
        }
    }
}
