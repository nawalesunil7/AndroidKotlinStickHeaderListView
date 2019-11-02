package com.sunil.androidstickyrecyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sunil.androidstickyrecyclerview.R
import com.sunil.androidstickyrecyclerview.interfaces.OnItemClickListener
import com.sunil.androidstickyrecyclerview.models.ListData
import com.sunil.androidstickyrecyclerview.utils.StickHeaderItemDecoration
import kotlinx.android.synthetic.main.layout_child_item.view.*
import kotlinx.android.synthetic.main.layout_list_header.view.*
import java.util.*


class StickyListAdapter(
    val context: Context,
    val list: ArrayList<ListData>, val listener: OnItemClickListener
) : androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder>(),
    StickHeaderItemDecoration.StickyHeaderInterface {
    class HeaderViewHolder(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {
        fun bindData(header: ListData) {
            itemView.txt_loc_catagory.text = header.header.trim()
        }
    }

    class ItemViewHolder(itemView: View, val listener: OnItemClickListener) :
        androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {
        fun bindData(item: ListData) {
            itemView.txt_child_name.text = item.text.trim()
            itemView.txt_child_name.setOnClickListener {
                listener.onItemClicked(item)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): androidx.recyclerview.widget.RecyclerView.ViewHolder {
        if (viewType == 0) {
            val headerView = LayoutInflater.from(context).inflate(R.layout.layout_list_header, parent, false)
            return HeaderViewHolder(headerView)
        }
        val itemView = LayoutInflater.from(context).inflate(R.layout.layout_child_item, parent, false)
        return ItemViewHolder(itemView, listener)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        return list.get(position).viewType
    }

    override fun onBindViewHolder(holder: androidx.recyclerview.widget.RecyclerView.ViewHolder, position: Int) {
        if (holder is HeaderViewHolder) {
            holder.bindData(list.get(position))
        } else if (holder is ItemViewHolder) {
            holder.bindData(list.get(position))
        }
    }

    override fun getHeaderPositionForItem(itmPosition: Int): Int {
        var headerPosition = 0
        var itemPosition = itmPosition
        do {
            if (this.isHeader(itemPosition)) {
                headerPosition = itemPosition
                break
            }
            itemPosition -= 1
        } while (itemPosition >= 0)
        return headerPosition
    }

    override fun getHeaderLayout(headerPosition: Int): Int {
        return R.layout.layout_list_header
    }

    override fun bindHeaderData(header: View, headerPosition: Int) {
        header.txt_loc_catagory.text = list.get(headerPosition).header.trim()
    }

    override fun isHeader(itemPosition: Int): Boolean {
        if ((list.get(itemPosition) as ListData).viewType == 0) {
            return true
        }
        return false
    }
}