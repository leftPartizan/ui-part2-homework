package com.example.ui_part2_homework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.ui_part2_homework.R


class SecondFragment: Fragment(R.layout.second_fragment) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        childFragmentManager.beginTransaction().apply {
            setReorderingAllowed(true)
            val childFragment = SecondFragmentChild()
            add(R.id.fragmentContainerCounterSecond, childFragment)
            addToBackStack(null)

            commit()
        }

    }
}