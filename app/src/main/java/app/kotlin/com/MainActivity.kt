package app.kotlin.com

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import app.kotlin.com.adapter.HomePageRecyclerAdapter
import app.kotlin.com.domain.command.RequestHomePageCommand
import app.kotlin.com.domain.model.HomePage
import app.kotlin.com.domain.model.HomePageItem
import app.kotlin.com.request.HomePageRequest
import app.kotlin.com.response.HomePageResponse
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerList: RecyclerView = find(R.id.recycler_view)

        recyclerList.layoutManager = LinearLayoutManager(this)

        doAsync {
            val homePageModel: HomePage = RequestHomePageCommand(0).excute()
            val items : List<HomePageItem>? = homePageModel.items
            uiThread {
                recyclerList.adapter = HomePageRecyclerAdapter(items){
                    toast("link == " + it)
                }
            }
        }

    }
}
