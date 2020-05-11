package com.example.android

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.util.*



class Exo1 : AppCompatActivity() {

    var result = ArrayList<Word>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.exo2)

        //la liste des interventions
        var listView: ListView?
        listView = findViewById(R.id.listView)

        //lire les donnees du fichier
        result.add(Word("One", "Un",R.drawable.number_one, R.raw.color_gray, -1))
        result.add(Word("One", "Un",R.drawable.number_one, R.raw.color_gray, -1))
        result.add(Word("One", "Un",R.drawable.number_one, R.raw.color_gray, -1))
        result.add(Word("One", "Un",R.drawable.number_one, R.raw.color_gray, -1))
        result.add(Word("One", "Un",R.drawable.number_one, R.raw.color_gray, -1))

        var adapter = listAdapter(this, result)
        listView?.adapter = adapter
        adapter?.notifyDataSetChanged()

    }

    private fun setEvent(btn : Button, cls: Class<*>) {
        btn.setOnClickListener({
            val intent = Intent(this, cls)
            startActivity(intent)
        })
    }

}