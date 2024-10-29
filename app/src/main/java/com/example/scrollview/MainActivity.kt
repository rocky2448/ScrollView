package com.example.scrollview

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var toolbarMain: Toolbar
    private lateinit var loadBTN: Button
    private lateinit var outputTextTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        toolbarMain = findViewById(R.id.toolbarMain)
        setSupportActionBar(toolbarMain)
        title = "Электронная книга"
        toolbarMain.subtitle = "by Rocky"

        loadBTN = findViewById(R.id.loadBTN)
        outputTextTV = findViewById(R.id.outputTextTV)

        val story = loadBook(Database().text)
        loadBTN.setOnClickListener{view ->
            for (i in story) {
                outputTextTV.append(i + "\n")
            }
        }


    }
    fun loadBook(text: String): List<String> {
        val list: List<String> = text.trim().split("\\s+".toRegex())
        return list
    }
}