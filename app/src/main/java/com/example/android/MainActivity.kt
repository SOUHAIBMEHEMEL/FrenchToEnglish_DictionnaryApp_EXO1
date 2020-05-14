package com.example.android

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val params = getSharedPreferences("COLOR", 0)
        val app_color = params.getInt("macouleur", 0)
        if(app_color==0){setTheme(R.style.AppTheme)}
        else { setTheme(app_color)}
        setContentView(R.layout.activity_main)
        setEvent(btn1, Exo1::class.java)
        setEvent(btn2, Exo1_1::class.java)
    }


    private fun setEvent(btn : Button, cls: Class<*>) {

        btn.setOnClickListener({
            val intent = Intent(this, cls)
            startActivity(intent)
        })

    }
}
