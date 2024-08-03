package com.example.rtoadmin

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.rtoadmin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainUpload.setOnClickListener {
            startActivity(Intent(this,UploadActivity::class.java))
        }

        binding.mainUpdate.setOnClickListener {
            startActivity(Intent(this,UpdateActivity::class.java))
        }
    }
}