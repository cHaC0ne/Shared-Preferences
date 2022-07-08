package com.example.sharedpreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.sharedpreferences.SharedPreferences.Companion.prefs
import com.example.sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var b: ActivityMainBinding
    private var opColor ="amarillo"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)
        initUI()
        checkUserValues()

        val adaptador : ArrayAdapter<*> = ArrayAdapter.createFromResource(
            this,R.array.colores,android.R.layout.simple_spinner_item )
        b.spinner.adapter = adaptador
        b.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ){
                opColor = parent?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent:AdapterView<*>?) {
                opColor="Amarillo"
            }
        }
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
            prefs.saveCheckColor(b.chBRem.isChecked)
            prefs.saveColor(opColor)
            goAccess()
        }else{
            Toast.makeText(this, "Debe rellenar el nombre", Toast.LENGTH_SHORT).show()
        }
    }
    private fun goAccess(){
        startActivity(Intent(this, SecondActivity::class.java))
    }
}