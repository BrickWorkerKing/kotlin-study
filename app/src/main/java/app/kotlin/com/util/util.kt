package app.kotlin.com.util

import android.content.Context
import android.util.Log
import android.widget.Toast


/**
 *
 *
 * @author ZXW_LZR
 * @date 2018/3/2 0002
 */
fun Context.toast(msg: CharSequence) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

fun log(msg: String) {
    Log.i("kotlin_log", msg)
}

inline fun consume(f: () -> Unit): Boolean {
    f()
    return true
}
