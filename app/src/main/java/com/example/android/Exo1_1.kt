package com.example.android

import android.net.Uri
import android.os.Bundle
import android.widget.ListView
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import java.util.ArrayList

class Exo1_1 : AppCompatActivity() {

    var result = ArrayList<Word>()
    private var mc: MediaController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.exo2_video)

        //la liste des interventions
        var listView: ListView?
        listView = findViewById(R.id.listView1)

        //Ajouter les mots
        result.add(Word("One", "Un",R.drawable.one, R.raw.one, R.raw.number1))
        result.add(Word("Two", "Deux",R.drawable.two, R.raw.two, R.raw.number2))


        var adapter = listAdapter(this, this, result)
        listView?.adapter = adapter
        adapter?.notifyDataSetChanged()

        // play audio
        listView.setOnItemClickListener { parent, view, position, id ->
            lireVideo(result[position].video)
            Toast.makeText(this, "lecture video", Toast.LENGTH_SHORT).show()
        }

    }


    private fun lireVideo(resId: Int) {
        val vv = findViewById<VideoView>(R.id.videoPlayer)
        mc=null
        if (mc == null) {

            mc = MediaController(this)
            vv.setMediaController(mc)
            val video = Uri.parse("android.resource://" + this?.packageName + "/"
                    + resId) //do not add any extension
            vv.setVideoURI(video)
            vv.start()
        } else {
            if (!vv.isPlaying) {
                vv.start()

            } else {
                vv.pause()
            }
        }
    }


}