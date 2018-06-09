package io.github.thiminhnhut.listviewandfragment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView

class CustomListView (private var context: Context, private var layout: Int, private var array: ArrayList<String>, var listener: FragmentListView.OnEvent): BaseAdapter() {

    class ViewHolder (row: View) {
        var txtValue = row.findViewById<TextView>(R.id.txtValue)
        var btnAdd = row.findViewById<Button>(R.id.btnAdd)
        var btnDelete = row.findViewById<Button>(R.id.btnDelete)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View?
        val viewHolder: ViewHolder

        if (convertView == null) {
            val layoutinflater: LayoutInflater = LayoutInflater.from(context)
            view = layoutinflater.inflate(layout, null)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = convertView.tag as ViewHolder
        }

        viewHolder.txtValue.text = array[position]

        viewHolder.btnAdd.setOnClickListener {
            listener.onClickAdd(context, count + 1, this)
        }

        viewHolder.btnDelete.setOnClickListener {
            listener.onClickDelete(context, position, this)
        }

        return view as View
    }

    override fun getItem(position: Int): Any? {
        return array[position]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return array.size
    }
}