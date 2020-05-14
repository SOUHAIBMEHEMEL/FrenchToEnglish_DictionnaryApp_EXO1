package com.example.android

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.util.*



class Exo1 : AppCompatActivity() {

    var result = ArrayList<Word>()
    private var mp: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.exo2)

        //la liste des interventions
        var listView: ListView?
        listView = findViewById(R.id.listView)

        //Ajouter les mots
        result.add(Word("One", "Un",R.drawable.one, R.raw.one, -1))
        result.add(Word("Two", "Deux",R.drawable.two, R.raw.two, -1))
        result.add(Word("Three", "Trois",R.drawable.three, R.raw.three, -1))
        result.add(Word("Four", "Quatre",R.drawable.four, R.raw.four, -1))
        result.add(Word("Five", "Cinq",R.drawable.five, R.raw.five, -1))

        var adapter = listAdapter(this, this, result)
        listView?.adapter = adapter
        adapter?.notifyDataSetChanged()

        val img = findViewById<ImageView>(R.id.image)

        // play audio
        listView.setOnItemClickListener { parent, view, position, id ->
            lireAudio(result[position].audio)
            img.setImageResource(result[position].img)
            Toast.makeText(this, "lecture audio", Toast.LENGTH_SHORT).show()
        }

    }

    fun lireAudio(resId: Int) {
        mp=null

        if (mp == null) {        //set up MediaPlayer
            mp = MediaPlayer.create(this, resId)

            try {
                mp!!.prepare()

            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
        if (!mp!!.isPlaying())
            mp!!.start()
        else
            mp!!.pause()
    }

}