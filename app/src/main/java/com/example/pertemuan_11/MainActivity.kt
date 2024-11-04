package com.example.pertemuan_11

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pertemuan_11.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        val adapterDisaster = DisasterAdapter(generatedataDummy()) {
            disaster ->
            Toast.makeText(this@MainActivity, "You click on ${disaster.nameDisaster}" ,
                Toast.LENGTH_SHORT).show()
        }
        with(binding) {
            rvDisaster.apply {
                adapter = adapterDisaster
//                layoutManager = LinearLayoutManager(this@MainActivity)
                layoutManager = GridLayoutManager(this@MainActivity,2)
            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun generatedataDummy(): List<Disaster>{
        return listOf(
            Disaster("Tsunami", "Natural"),
            Disaster("Volcanic eruption", "Natural"),
            Disaster("Nuclear accident", "Natural"),
            Disaster("War", "Natural"),
            Disaster("Flood", "Natural")
        )
    }
}