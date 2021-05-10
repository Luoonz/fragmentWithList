package com.example.tester12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.list_detail_view.*

class ProfileDetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_detail_view)

        var names = intent.getStringExtra("name") as String
        var img = intent.getIntExtra("img", 0)

        Glide.with(this).load(img).into(img_profile)
        tv_name.text = names

    }
}