package app.kotlin.com.ui

import android.app.Application
import app.kotlin.com.util.DelegatesExt


/**
 *
 *
 * @author ZXW_LZR
 * @date 2018/3/5 0005
 */
class App : Application() {

    companion object {
        var instance : App by DelegatesExt.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}