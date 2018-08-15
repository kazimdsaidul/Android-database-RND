package saidul.com.androiddatabasernd

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import saidul.com.androiddatabasernd.ui.dummy.DummyContent
import saidul.com.androiddatabasernd.ui.insert.PlusOneFragment
import saidul.com.androiddatabasernd.ui.show.PersonShowFragment

class MainActivity : AppCompatActivity(), PersonShowFragment.OnListFragmentInteractionListener {


    override fun onListFragmentInteraction(item: DummyContent.DummyItem?) {


    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {

                supportFragmentManager.inTransaction {
                    replace(R.id.container, PlusOneFragment())
                }

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                supportFragmentManager.inTransaction {
                    replace(R.id.container, PersonShowFragment())
                }
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        supportFragmentManager.inTransaction {
            replace(R.id.container, PlusOneFragment())
        }
    }

    inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> Unit) {
        val fragmentTransaction = beginTransaction()
        fragmentTransaction.func()
        fragmentTransaction.commit()
    }

}
