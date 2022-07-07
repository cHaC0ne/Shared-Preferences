package com.example.sharedpreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sharedpreferences.SharedPreferences.Companion.prefs
import com.example.sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var b: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)
        initUI()
        checkUserValues()
    }


    fun initUI(){
        b.bMainAct.setOnClickListener {
            accessSharedPreferences()
        }
    }
    fun checkUserValues(){
        if(prefs.getName().isNotEmpty()){
            goAccess()
        }
    }
    fun accessSharedPreferences(){
        if (b.etName.text.toString().isNotEmpty()){
            prefs.saveName(b.etName.text.toString())
            prefs.saveColor(b.chBRem.isChecked)
            goAccess()
        }else{
            Toast.makeText(this, "Debe rellenar el nombre", Toast.LENGTH_SHORT).show()
        }
    }
    private fun goAccess(){
        startActivity(Intent(this, SecondActivity::class.java))
    }
}