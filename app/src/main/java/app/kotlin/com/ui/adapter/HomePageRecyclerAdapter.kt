package app.kotlin.com.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.kotlin.com.R
import app.kotlin.com.domain.model.HomePageItem
import app.kotlin.com.util.ctx
import kotlinx.android.synthetic.main.home_page_recycler_item.view.*

/**
 *
 *
 * @author ZXW_LZR
 * @date 2018/3/1 0001
 */
class HomePageRecyclerAdapter(private val items: List<HomePageItem>?, private val itemClickListener: (String) -> Unit)
    : RecyclerView.Adapter<HomePageRecyclerAdapter.ViewHolder>() {
    override fun getItemCount(): Int {
        return items?.size ?: 0
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent?.ctx)
                .inflate(R.layout.home_page_recycler_item, parent, false)
        return ViewHolder(itemView, itemClickListener)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val itemData: HomePageItem? = items?.get(position)
        if (itemData != null) {
            holder?.bind(itemData)
        }
    }

    class ViewHolder(itemView: View, private val itemClickListener: (String) -> Unit)
        : RecyclerView.ViewHolder(itemView) {

        fun bind(itemData: HomePageItem) {

            with(itemData) {
                itemView.tvTitle.text = title
                itemView.tvKey.text = java.lang.String.format("关键字: %s", key)
                itemView.tvDateTime.text = dateTime

                itemView.setOnClickListener {
                    itemClickListener(link)
                }
            }
        }
    }

}