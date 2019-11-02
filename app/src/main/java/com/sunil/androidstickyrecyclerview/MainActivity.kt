package com.sunil.androidstickyrecyclerview

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.sunil.androidstickyrecyclerview.adapter.StickyListAdapter
import com.sunil.androidstickyrecyclerview.interfaces.OnItemClickListener
import com.sunil.androidstickyrecyclerview.models.ListData
import com.sunil.androidstickyrecyclerview.utils.StickHeaderItemDecoration
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupStickyListData()
    }

    private fun setupStickyListData() {
        val list = getData()
        val adapter = StickyListAdapter(this, list,clickListener)
        sticky_view.addItemDecoration(StickHeaderItemDecoration(adapter))
        val layoutManager = LinearLayoutManager(this)
        sticky_view.layoutManager = layoutManager
        sticky_view.adapter = adapter
    }

    private fun getData(): ArrayList<ListData> {
        val list = ArrayList<ListData>()
        list.add(ListData("Header 1", " Text 1", 0))
        list.add(ListData("Header 1", " Text 1", 1))
        list.add(ListData("Header 1", " Text 2", 1))
        list.add(ListData("Header 1", " Text 3", 1))
        list.add(ListData("Header 1", " Text 4", 1))
        list.add(ListData("Header 1", " Text 5", 1))
        list.add(ListData("Header 1", " Text 6", 1))
        list.add(ListData("Header 1", " Text 7", 1))
        list.add(ListData("Header 1", " Text 8", 1))
        list.add(ListData("Header 1", " Text 9", 1))
        list.add(ListData("Header 1", " Text 10", 1))
        list.add(ListData("Header 1", " Text 11", 1))
        list.add(ListData("Header 1", " Text 12", 1))
        list.add(ListData("Header 2", " Text 1", 0))
        list.add(ListData("Header 2", " Text 21", 1))
        list.add(ListData("Header 2", " Text 22", 1))
        list.add(ListData("Header 2", " Text 23", 1))
        list.add(ListData("Header 2", " Text 24", 1))
        list.add(ListData("Header 2", " Text 25", 1))
        list.add(ListData("Header 2", " Text 26", 1))
        list.add(ListData("Header 2", " Text 27", 1))
        list.add(ListData("Header 2", " Text 28", 1))
        list.add(ListData("Header 2", " Text 29", 1))
        list.add(ListData("Header 2", " Text 30", 1))
        list.add(ListData("Header 2", " Text 31", 1))
        list.add(ListData("Header 2", " Text 32", 1))
        list.add(ListData("Header 2", " Text 33", 1))
        list.add(ListData("Header 3", " Text 1", 0))
        list.add(ListData("Header 3", " Text 31", 1))
        list.add(ListData("Header 3", " Text 32", 1))
        list.add(ListData("Header 3", " Text 33", 1))
        list.add(ListData("Header 3", " Text 34", 1))
        list.add(ListData("Header 3", " Text 35", 1))
        list.add(ListData("Header 3", " Text 36", 1))
        list.add(ListData("Header 3", " Text 37", 1))
        list.add(ListData("Header 3", " Text 38", 1))
        list.add(ListData("Header 3", " Text 39", 1))
        list.add(ListData("Header 4", " Text 1", 0))
        list.add(ListData("Header 4", " Text 41", 1))
        list.add(ListData("Header 4", " Text 42", 1))
        list.add(ListData("Header 4", " Text 43", 1))
        list.add(ListData("Header 4", " Text 44", 1))
        list.add(ListData("Header 4", " Text 45", 1))
        list.add(ListData("Header 4", " Text 46", 1))
        list.add(ListData("Header 4", " Text 47", 1))
        list.add(ListData("Header 4", " Text 49", 1))
        list.add(ListData("Header 4", " Text 49", 1))
        list.add(ListData("Header 5", " Text 1", 0))
        list.add(ListData("Header 5", " Text 51", 1))
        list.add(ListData("Header 5", " Text 52", 1))
        list.add(ListData("Header 5", " Text 53", 1))
        list.add(ListData("Header 5", " Text 54", 1))
        list.add(ListData("Header 5", " Text 55", 1))
        list.add(ListData("Header 5", " Text 56", 1))
        list.add(ListData("Header 5", " Text 57", 1))
        list.add(ListData("Header 5", " Text 58", 1))
        list.add(ListData("Header 5", " Text 59", 1))
        list.add(ListData("Header 5", " Text 60", 1))
        return list;
    }

    val clickListener = object : OnItemClickListener {
        override fun onItemClicked(item: ListData) {
            Toast.makeText(this@MainActivity, "List Item Clicked " + item.text, Toast.LENGTH_LONG).show()
        }

    }
}
