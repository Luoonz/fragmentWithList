package com.example.tester12

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.tester12.FragmentTab;

class PageAdapter(fm : FragmentManager) : FragmentStatePagerAdapter(fm){
    private var fragments : ArrayList<FragmentTab> = ArrayList()

    override fun getItem(position: Int): Fragment = fragments[position]

    override fun getCount(): Int = fragments.size

    fun addItems(fragment : FragmentTab){
        fragments.add(fragment)
    }
}