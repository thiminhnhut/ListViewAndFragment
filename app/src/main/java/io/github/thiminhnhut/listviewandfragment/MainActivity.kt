package io.github.thiminhnhut.listviewandfragment

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    private var i = 1
    val dataA = arrayListOf(i.toString())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            loadFragment(dataA)
        }
    }

    private fun loadFragment(data: ArrayList<String>) {
        val fragmentListView = FragmentListView.newInstance(data)
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.layout_root, fragmentListView)
        fragmentTransaction.commit()
    }
}
