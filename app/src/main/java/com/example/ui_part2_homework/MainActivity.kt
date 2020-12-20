package com.example.ui_part2_homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.ui_part2_homework.fragments.FirstFragment
import com.example.ui_part2_homework.fragments.SecondFragment
import com.example.ui_part2_homework.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private val binding : ActivityMainBinding by lazy {
        val tempBnd = ActivityMainBinding.inflate(layoutInflater)
        setContentView(tempBnd.root)
        tempBnd
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Fragment2","oncreate")


        val secondFragment = SecondFragment()
        val firstFragment = FirstFragment()

        if (savedInstanceState == null) {

            supportFragmentManager.beginTransaction().apply {
                setReorderingAllowed(true)
                add(R.id.fragmentContainerViewMain, secondFragment)
                add(R.id.fragmentContainerViewMain, firstFragment)
                commit()
            }
        }
        binding.firstButton.setOnClickListener{
                supportFragmentManager.beginTransaction().apply {
                    setReorderingAllowed(true)
                    detach(secondFragment)
                    attach(firstFragment)
                    setPrimaryNavigationFragment(firstFragment)
                    commit()
                }
        }

        binding.secondButton.setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                setReorderingAllowed(true)
                detach(firstFragment)
                attach(secondFragment)
                setPrimaryNavigationFragment(secondFragment)

                commit()
            }
        }
    }
}