package com.example.tester12

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_gallery.*
import kotlinx.android.synthetic.main.fragment_gallery.view.*
import java.lang.Exception

class GalleryFragment : FragmentTab() {
    val Gallery = 0
    val view = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_gallery, container, false)
        view.galleryBtn.setOnClickListener { loadImage() }

        return view
    }

    private fun loadImage(){
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT

        startActivityForResult(Intent.createChooser(intent, "Load Pic"), Gallery)
    }

    @Override
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == Gallery){
            if(resultCode == RESULT_OK){
                var dataUri = data?.data
                try {
                    var bitmap = MediaStore.Images.Media.getBitmap(activity?.contentResolver, dataUri)
                    imageView.setImageBitmap(bitmap)
                }catch (e:Exception){
                    Log.d("TTT", "error : " + e);
                }
            }
        }
    }
}