package org.sopt.navermap.presentation.detail

import android.os.Bundle
import androidx.activity.viewModels
import org.sopt.navermap.R
import org.sopt.navermap.databinding.ActivityDetailBinding
import org.sopt.navermap.util.binding.ViewBindingActivity

class DetailActivity :
    ViewBindingActivity<ActivityDetailBinding>({ ActivityDetailBinding.inflate(it) }) {
    var intColorCode = 255
    private val viewModel : DetailViewModel by viewModels { DetailViewModelFactory() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel.getDetail(1)

        viewModel.getDetailResult.observe(this){
            binding.tvDetailMain.text = it.data.name
            binding.tvDetailTitle.text = it.data.name
            binding.tvDetailSubtitle.text = it.data.category
            binding.tvDetailDescription.text = it.data.description
            binding.tvDetailStar.text = it.data.stars
            binding.tvDetailVisitorReview.text = "방문자리뷰 " + it.data.visitorReview.toString()
            binding.tvDetailBlogReview.text = "블로그리뷰 " + it.data.blogReview.toString()
            binding.tvDetailLocation1.text = it.data.detailAddress
            binding.tvDetailLocation2.text = it.data.direction
            binding.tvDetailTime2.text = it.data.closeTime + "에 라스트 오더"
            binding.tvDetailCall1.text = it.data.number
            binding.tvDetailHome.text = it.data.characters
            binding.tvDetailInternet.text = it.data.sns
            binding.tvDetailInfo.text = it.data.detail
        }

        initAppbarOffsetChangedListener()
    }

    private fun initAppbarOffsetChangedListener() {
        binding.detailAppbar.addOnOffsetChangedListener { _, verticalOffset ->
            intColorCode = -verticalOffset / 2
            if (intColorCode > 255) {
                intColorCode = 255
            }

            if (intColorCode > 50) {
                binding.ivDetailBack.setColorFilter(getColor(R.color.gray_4))
                binding.ivDetailClose.setColorFilter(getColor(R.color.gray_4))
            } else {
                binding.ivDetailBack.setColorFilter(getColor(R.color.white))
                binding.ivDetailClose.setColorFilter(getColor(R.color.white))
            }
            binding.tbDetailTitle.background.alpha = intColorCode
            binding.tvDetailMain.alpha = intColorCode.toFloat() / 255f
        }
    }
}