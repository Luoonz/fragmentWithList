package com.example.tester12

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.android.synthetic.main.fragment_tab.view.*
import java.io.Serializable

class ListFragment : FragmentTab() {

    lateinit var recyleAdapter: RecyleAdapter
    val datas = mutableListOf<RecyleData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =inflater.inflate(R.layout.fragment_list, container, false)




        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyleAdapter = RecyleAdapter(requireActivity().applicationContext)
        rv_profile.adapter = recyleAdapter

        datas.apply{
            add(RecyleData(img = R.drawable.pic1, name = "유재석", age=48))
            add(RecyleData(img = R.drawable.pic2, name = "이광수", age=35))
            add(RecyleData(img = R.drawable.pic3, name = "송지효", age=39))
            add(RecyleData(img = R.drawable.pic4, name = "김종국", age=45))
            add(RecyleData(img = R.drawable.pic5, name = "하하", age=41))
            add(RecyleData(img = R.drawable.pic6, name = "지석진", age=55))
            add(RecyleData(img = R.drawable.pic7, name = "전소민", age=35))
            add(RecyleData(img = R.drawable.pic8, name = "양세찬", age=34))

            recyleAdapter.datas = datas
            recyleAdapter.notifyDataSetChanged()
        }

        recyleAdapter.setOnItemClickListener(object : RecyleAdapter.OnItemClickListener{
            override fun onItemClick(v: View, data: RecyleData, pos: Int) {
                Intent(activity, ProfileDetailActivity::class.java).apply{
                    putExtra("name", data.name)
                    putExtra("img", data.img)
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }.run{startActivity(this)}
            }
        })

        rv_profile.addItemDecoration(VerticalItemDecorator(20))
        rv_profile.addItemDecoration(HorizontalItemDecorator(10))

    }

}