package app.kotlin.com.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import app.kotlin.com.R
import app.kotlin.com.domain.model.HomePageItem
import org.jetbrains.anko.find

/**
 *
 *
 * @author ZXW_LZR
 * @date 2018/3/1 0001
 */
class HomePageRecyclerAdapter(val items: List<HomePageItem>?, val itemClickListener: (String) -> Unit) : RecyclerView.Adapter<HomePageRecyclerAdapter.ViewHolder>() {
    override fun getItemCount(): Int {
        return items?.size ?: 0
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent?.context)
                .inflate(R.layout.home_page_recycler_item, parent, false)
        return ViewHolder(itemView,itemClickListener)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val itemData : HomePageItem? = items?.get(position)
        if (itemData != null) {
            holder?.bind(itemData)
        }
    }

    class ViewHolder(itemView: View, val itemClickListener:(String) -> Unit)
        : RecyclerView.ViewHolder(itemView){

        private val tvTitle : TextView = itemView.find(R.id.tv_title)
        private val tvKey : TextView = itemView.find(R.id.tv_key)
        private val tvDateTime : TextView = itemView.find(R.id.tv_date_time)

        fun bind(itemData: HomePageItem){
            tvTitle.text = itemData.title
            tvKey.text = java.lang.String.format("key: %s", itemData.key)
            tvDateTime.text = itemData.dateTime

            itemView.setOnClickListener{
                itemClickListener(itemData.link)
            }
        }

    }
}