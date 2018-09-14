package io.github.thiminhnhut.listviewandfragment

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView



class FragmentListView: Fragment() {
    companion object {
        private lateinit var data: ArrayList<String>
        fun newInstance(data: ArrayList<String>) : FragmentListView {
            this.data = data
            return FragmentListView()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater!!.inflate(R.layout.fragment_listview, container, false)
        val lstView = view.findViewById<ListView>(R.id.lstView)
        val myView = CustomListView(activity, R.layout.item_add_device, data, object : OnEvent {
            override fun onClickAdd(sender: Any, pos: Int, customListView: CustomListView) {

                data.add(pos.toString())


//                val state = lstView.onSaveInstanceState()
//                lstView.adapter = customListView
//                lstView.onRestoreInstanceState(state)

                val currentPosition = lstView.firstVisiblePosition
                lstView.adapter = customListView
                lstView.setSelection(currentPosition + 2)
            }

            override fun onClickDelete(sender: Any, pos: Int, customListView: CustomListView) {
                data.remove(data[pos])

                val currentPosition = lstView.firstVisiblePosition
                lstView.adapter = customListView
                lstView.setSelection(currentPosition)
            }
        })

        lstView.adapter = myView
        lstView.onItemClickListener = AdapterView.OnItemClickListener {adapterView, view, position, id ->

        }

        myView.notifyDataSetChanged()

        return view
    }

    interface OnEvent {
        fun onClickAdd(sender: Any, pos: Int, customListView: CustomListView)
        fun onClickDelete(sender: Any, pos: Int, customListView: CustomListView)
    }
}