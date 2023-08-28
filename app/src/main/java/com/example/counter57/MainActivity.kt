package com.example.counter57

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.counter57.databinding.ActivityMainBinding
import com.example.counter57.view.CounterView

class MainActivity : AppCompatActivity(), CounterView {
    lateinit var binding: ActivityMainBinding
    var presenter = Presenter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initClicker()
    }

    private fun initClicker() {
        with(binding) {
            incrementBtn.setOnClickListener {
                presenter.increment()
            }
            decrementBtn.setOnClickListener {
                presenter.decrement()
            }
        }
    }

    override fun showCount(number: Int) {
        binding.countTv.text = number.toString()    }

    override fun showToast() {
        Toast.makeText(this, "Congratulation", Toast.LENGTH_SHORT).show()
    }

    override fun changeCountColor(color: Int) {
        binding.countTv.setTextColor(color)
    }
}