package app.kotlin.com.util

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty


/**
 *
 *
 * @author ZXW_LZR
 * @date 2018/3/5 0005
 */

object DelegatesExt {
    fun <T> notNullSingleValue() = NotNullSingleValueVar<T>()
}

class NotNullSingleValueVar<T> : ReadWriteProperty<Any?, T> {

    private var value: T? = null

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return value ?: throw IllegalStateException("${property.name} not init")
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        this.value = if (this.value == null) value
        else throw IllegalStateException("${property.name} is already init")
    }

}