package com.example.tester12

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.tab_btn.view.*

class MainActivity : AppCompatActivity() {
    private lateinit var mContext : Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mContext = applicationContext
        initViewPager() // 뷰페이저와 어댑터 장착
    }

    private fun initViewPager(){
        val listFragment = ListFragment()
        listFragment.name = "목록화"
        val galleryFragment = GalleryFragment()
        galleryFragment.name = "겔러리"
        val apiFragment = FragmentTab()
        apiFragment.name = "API"

        val adapter = PageAdapter(supportFragmentManager) // PageAdapter 생성
        adapter.addItems(listFragment)
        adapter.addItems(galleryFragment)
        adapter.addItems(apiFragment)


        main_viewPager.adapter = adapter // 뷰페이저에 adapter 장착
        main_tablayout.setupWithViewPager(main_viewPager) // 탭레이아웃과 뷰페이저를 연동

        main_tablayout.getTabAt(0)?.setCustomView(createView("데이터 목록화"))
        main_tablayout.getTabAt(1)?.setCustomView(createView("겔러리 불러오기"))
        main_tablayout.getTabAt(2)?.setCustomView(createView("API 활용"))

    }

    private fun createView(tabName: String): View {
        var tabView = LayoutInflater.from(mContext).inflate(R.layout.tab_btn, null)

        tabView.tab_text.text = tabName
        when (tabName) {
            "데이터 목록화" -> {
                tabView.tab_logo.setImageResource(android.R.drawable.ic_menu_view)
                return tabView
            }
            "겔러리 불러오기" -> {
                tabView.tab_logo.setImageResource(android.R.drawable.ic_menu_gallery)
                return tabView
            }
            "API 활용" -> {
                tabView.tab_logo.setImageResource(android.R.drawable.ic_dialog_map)
                return tabView
            }
            else -> {
                return tabView
            }
        }

    }
}