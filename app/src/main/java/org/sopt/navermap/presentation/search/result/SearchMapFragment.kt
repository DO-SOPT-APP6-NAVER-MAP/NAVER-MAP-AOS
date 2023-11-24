package org.sopt.navermap.presentation.search.result

import android.os.Bundle
import android.view.View
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.CameraPosition
import com.naver.maps.map.MapFragment
import com.naver.maps.map.NaverMap
import com.naver.maps.map.OnMapReadyCallback
import com.naver.maps.map.overlay.Marker
import com.naver.maps.map.overlay.OverlayImage
import org.sopt.dosopttemplate.util.binding.DataBindingFragment
import org.sopt.navermap.BuildConfig
import org.sopt.navermap.R
import org.sopt.navermap.databinding.FragmentSearchMapBinding

class SearchMapFragment :
    DataBindingFragment<FragmentSearchMapBinding>(R.layout.fragment_search_map),
    OnMapReadyCallback {

    private val locationMarker = Marker()
    private lateinit var naverMap: NaverMap

    private val searchPosition = LatLng(BuildConfig.LOCATION_LATITUDE, BuildConfig.LOCATION_LONGITUDE)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initMapFragment()
    }

    private fun initMapFragment() {
        val mapFragment = MapFragment.newInstance()
        childFragmentManager.beginTransaction()
            .add(binding.fcvSearchMap.id, mapFragment)
            .commit()

        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(naverMap: NaverMap) {
        this.naverMap = naverMap
        initUISetting()
        initMarkerSetting()
    }

    private fun initUISetting() {
        val uiSetting = naverMap.uiSettings
        uiSetting.logoGravity = LOGO_GRAVITY
        uiSetting.isZoomControlEnabled = false
        uiSetting.isScaleBarEnabled = false
    }

    private fun initMarkerSetting() {
        naverMap.cameraPosition = CameraPosition(searchPosition, CAMERA_ZOOM)

        with(locationMarker) {
            position = searchPosition
            map = naverMap
            icon = OverlayImage.fromResource(R.drawable.ic__select_location)
            captionText = LOCATION_CAPTION
        }
    }

    companion object {
        const val LOGO_GRAVITY = 0
        const val LOCATION_CAPTION = "알고"
        const val CAMERA_ZOOM = 16.0
    }
}