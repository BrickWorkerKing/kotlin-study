package app.kotlin.com.ui.adapter

import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import app.kotlin.com.R
import app.kotlin.com.domain.model.FriendWebsiteItem
import com.zhy.view.flowlayout.FlowLayout
import com.zhy.view.flowlayout.TagAdapter
import org.jetbrains.anko.find
import org.jetbrains.anko.textColor


/**
 *
 *
 * @author ZXW_LZR
 * @date 2018/3/6 0006
 */
class FriendWebsiteTagFlowAdapter(items: List<FriendWebsiteItem>) : TagAdapter<FriendWebsiteItem>(items) {

    companion object {
        private val textColors: List<Int> = listOf(
                R.color.colorHotFlag0,
                R.color.colorHotFlag1,
                R.color.colorHotFlag2,
                R.color.colorHotFlag3,
                R.color.colorHotFlag4,
                R.color.colorHotFlag5,
                R.color.colorHotFlag6,
                R.color.colorHotFlag7,
                R.color.colorHotFlag8,
                R.color.colorHotFlag9
        )
    }

    override fun getView(parent: FlowLayout?, position: Int, t: FriendWebsiteItem?): View {
        val flagView = LayoutInflater.from(parent?.context)
                .inflate(R.layout.hot_flag_flow_item, parent, false)
        val tvFlag: TextView = flagView.find(R.id.tvFlag)
        tvFlag.text = t?.name
        tvFlag.textColor = ContextCompat.getColor(parent?.context, textColors[position % 10])
        return flagView
    }

}