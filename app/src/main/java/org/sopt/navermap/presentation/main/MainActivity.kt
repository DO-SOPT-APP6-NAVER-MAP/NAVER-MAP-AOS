package org.sopt.navermap.presentation.main

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import org.sopt.dosopttemplate.util.binding.DataBindingFragment
import org.sopt.navermap.R
import org.sopt.navermap.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
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
            }

            override fun afterTextChanged(s: Editable?) {
                if (s?.isBlank() == true) {
                    replaceFragment(MainsearchglassFragment())
                } else {
                    viewModel.setEnteredName(s.toString())
                    replaceFragment(MainsearchFragment())
                }
            }
        })
    }

    private fun <T : ViewDataBinding> commitFragment(fragment: DataBindingFragment<T>) {
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fcv_search_main)
        if (currentFragment == null) {
            supportFragmentManager.beginTransaction().add(R.id.fcv_search_main, fragment).commit()
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fcv_search_main, fragment).commit()
    }
}