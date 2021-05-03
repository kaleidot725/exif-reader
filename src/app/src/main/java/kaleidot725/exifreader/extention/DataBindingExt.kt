package kaleidot725.exifreader.extention

import android.view.ViewGroup
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

fun <T : ViewDataBinding> FragmentActivity.dataBinding(): ReadOnlyProperty<FragmentActivity, T> {
    return object : ReadOnlyProperty<FragmentActivity, T> {
        override fun getValue(thisRef: FragmentActivity, property: KProperty<*>): T {
            val view = thisRef.findViewById<ViewGroup>(android.R.id.content)[0]
            return checkNotNull(DataBindingUtil.bind<T>(view)).apply { lifecycleOwner = thisRef }
        }
    }
}

fun <T : ViewDataBinding> Fragment.dataBinding(): ReadOnlyProperty<Fragment, T?> {
    return object : ReadOnlyProperty<Fragment, T?> {
        override fun getValue(thisRef: Fragment, property: KProperty<*>): T? {
            val view = thisRef.view ?: return null
            return checkNotNull(DataBindingUtil.bind<T>(view)).apply { lifecycleOwner = thisRef }
        }
    }
}