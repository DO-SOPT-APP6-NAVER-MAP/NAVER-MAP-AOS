package org.sopt.navermap.presentation.search.result

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import org.sopt.dosopttemplate.util.binding.DataBindingFragment
import org.sopt.navermap.R
import org.sopt.navermap.databinding.FragmentSearchResultBinding

class SearchResultFragment: DataBindingFragment<FragmentSearchResultBinding>(R.layout.fragment_search_result) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val webView: WebView = binding.wvSearchMap
        webView.loadUrl("https://naver.me/5bds6BlO")
    }
}