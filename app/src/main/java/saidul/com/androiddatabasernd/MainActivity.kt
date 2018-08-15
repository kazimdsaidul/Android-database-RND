package saidul.com.androiddatabasernd

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import saidul.com.androiddatabasernd.ui.dummy.DummyContent
import saidul.com.androiddatabasernd.ui.insert.PersonShowFragment

class MainActivity : AppCompatActivity(), PersonShowFragment.OnListFragmentInteractionListener {
  

    override fun onListFragmentInteraction(item: DummyContent.DummyItem?) {


    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {

                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
