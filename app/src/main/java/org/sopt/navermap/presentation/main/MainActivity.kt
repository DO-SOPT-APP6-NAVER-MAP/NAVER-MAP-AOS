//package org.sopt.navermap.presentation.main
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import org.sopt.navermap.R
//
//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//    }
//}
//

package org.sopt.navermap.presentation.main

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import org.sopt.dosopttemplate.util.binding.DataBindingFragment
import org.sopt.navermap.R
import org.sopt.navermap.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val viewModel by viewModels<MainActivityViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        setTextWatcher()
        commitFragment(MainsearchFragment())
    }

    private fun setTextWatcher() {
        val editText = binding.etMainSearchBox

        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s.isNullOrEmpty()) {
                    commitFragment(MainsearchglassFragment())
                } else {
                    commitFragment(MainsearchFragment())
                }
            }

            override fun afterTextChanged(s: Editable?) {}

        })
    }

    private fun <T : ViewDataBinding> commitFragment(fragment: DataBindingFragment<T>) {
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fcv_search_main)
        if (currentFragment == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fcv_search_main, fragment)
                .commit()
        }
    }
}