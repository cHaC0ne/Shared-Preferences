package com.example.sharedpreferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.sharedpreferences.SharedPreferences.Companion.prefs
import com.example.sharedpreferences.databinding.ActivityMainBinding
import com.example.sharedpreferences.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var b: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(b.root)
        initUi()

    }
    fun initUi(){
        b.bClose.setOnClickListener {
            prefs.wipeData()
            onBackPressed()
        }
        val userName = prefs.getName()
        b.tvHello.text = "Hola $userName !"
        if(prefs.getColorCheck()){
            val elColor = getMyColor(prefs.getColor())
            b.constLayout.setBackgroundColor(
                ContextCompat.getColor(this, elColor)
            )
        }
    }
    fun getMyColor(color:String):Int{
        val resourceColor = when(color){
            "Lila Claro"-> R.color.purple_200
            "Lila"-> R.color.purple_500
            "Lila Fuerte"-> R.color.purple_700
            "Azul Marino"-> R.color.teal_200
            "Azul Fuerte"-> R.color.teal_700
            "Negro"-> R.color.black
            "Naranja"-> R.color.orange
            else ->  R.color.white
        }
        return resourceColor
    }
}