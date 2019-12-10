package com.example.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.viewmodel.com.example.viewmodel.CountViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //declare module-levwel variable
    private lateinit var countViewModel: CountViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("MainActivity", "onCreate")

        //initialise the ViewModel
        countViewModel = ViewModelProviders.of(this).get(CountViewModel::class.java)

        //add an observer to the CountView Model
        countViewModel.count.observe(this, Observer {
            if(it.equals(4))
                goodLuck()
        })


        textViewCount.text = countViewModel.count.value.toString()

        buttonPlus.setOnClickListener{
            countViewModel.increment()
            textViewCount.text = countViewModel.count.value.toString()
        }

        buttonMinus.setOnClickListener {
            countViewModel.decrement()
            textViewCount.text = countViewModel.count.value.toString()
        }
    }

    private fun goodLuck(){
        Toast.makeText(applicationContext,"Good Luck!!!", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy(){
        Log.d("MainActivity","onDestroy")
        super.onDestroy()
    }
}
