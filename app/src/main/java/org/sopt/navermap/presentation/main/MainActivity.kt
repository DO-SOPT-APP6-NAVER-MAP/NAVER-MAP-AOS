package org.sopt.navermap.presentation.main

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import org.sopt.dosopttemplate.util.binding.DataBindingFragment
import org.sopt.navermap.R
import org.sopt.navermap.databinding.ActivityMainBinding
import org.sopt.navermap.presentation.detail.MainActivityViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainActivityViewModel by viewModels { MainActivityViewModelFactory() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        setTextWatcher()
        commitFragment(MainsearchglassFragment())
    }

    private fun setTextWatcher() {
        val editText = binding.etMainSearchBox

        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s?.isBlank() == true) {
                    Log.v("text is blank", s.toString())
                    replaceFragment(MainsearchglassFragment())
                } else {
                    Log.v("text is not blank", s.toString())
                    replaceFragment(MainsearchFragment())
                }
            }

            override fun afterTextChanged(s: Editable?) {}

        })
    }

    private fun <T : ViewDataBinding> commitFragment(fragment: DataBindingFragment<T>) {
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fcv_search_main)
        if (currentFragment == null) {
            supportFragmentManager.beginTransaction().add(R.id.fcv_search_main, fragment).commit()
        }
    }

    private fun <T : ViewDataBinding> replaceFragment(fragment: DataBindingFragment<T>) {
        supportFragmentManager.beginTransaction().replace(R.id.fcv_search_main, fragment).commit()
    }
}