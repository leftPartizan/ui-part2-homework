package com.example.ui_part2_homework.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.ui_part2_homework.R
import com.example.ui_part2_homework.databinding.FirstChildFragmentBinding
import com.example.ui_part2_homework.databinding.SecondChildFragmentBinding
import com.example.ui_part2_homework.utils.CounterManager


class SecondFragmentChild: Fragment(R.layout.second_child_fragment) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bindingFragment = SecondChildFragmentBinding.bind(view)
        val counterManager = CounterManager()
        val countValue = counterManager.getCounter(arguments)
        bindingFragment.childSecondFragmentCounter.text = "$countValue"

        bindingFragment.root.setOnClickListener {

            parentFragmentManager.beginTransaction().apply {
                setReorderingAllowed(true)
                add(R.id.fragmentContainerCounterSecond, SecondFragmentChild::class.java,
                        counterManager.createArgs(countValue+1))
                addToBackStack(null)

                commit()
            }
        }
    }

}