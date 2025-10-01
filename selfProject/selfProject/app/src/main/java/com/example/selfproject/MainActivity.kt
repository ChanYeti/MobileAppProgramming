package com.example.selfproject

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat.enableEdgeToEdge
import androidx.core.view.WindowInsetsCompat
import com.example.selfproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.switch1.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                binding.textView2.visibility = View.VISIBLE
                binding.radioGroup.visibility = View.VISIBLE
                binding.btn1.visibility = View.VISIBLE
                binding.btn2.visibility = View.VISIBLE
            } else {
                resetToInitialState()
            }
        }

        binding.radioGroup.setOnCheckedChangeListener { _, checkedId ->
            binding.imgOreo.visibility = View.GONE
            binding.imgPie.visibility = View.GONE
            binding.imgQ.visibility = View.GONE

            when (checkedId) {
                R.id.radioButtonOreo -> binding.imgOreo.visibility = View.VISIBLE
                R.id.radioButtonPie -> binding.imgPie.visibility = View.VISIBLE
                R.id.radioButtonQ -> binding.imgQ.visibility = View.VISIBLE
            }
        }

        binding.btn1.setOnClickListener {
            finish()
        }

        binding.btn2.setOnClickListener {
            binding.switch1.isChecked = false
        }
    }

    private fun resetToInitialState() {
        binding.textView2.visibility = View.GONE
        binding.radioGroup.visibility = View.GONE
        binding.imgOreo.visibility = View.GONE
        binding.imgPie.visibility = View.GONE
        binding.imgQ.visibility = View.GONE
        binding.btn1.visibility = View.GONE
        binding.btn2.visibility = View.GONE

        binding.radioGroup.clearCheck()
    }
}