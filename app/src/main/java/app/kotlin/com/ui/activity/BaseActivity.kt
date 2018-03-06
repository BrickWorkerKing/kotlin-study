package app.kotlin.com.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Window


/**
 *
 *
 * @author ZXW_LZR
 * @date 2018/3/6 0006
 */
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        super.onCreate(savedInstanceState)
        setContentView(getContentView())
        initView()
        initData()
        initEvent()
    }

    abstract fun getContentView(): Int

    abstract fun initView()

    abstract fun initData()

    abstract fun initEvent()
}