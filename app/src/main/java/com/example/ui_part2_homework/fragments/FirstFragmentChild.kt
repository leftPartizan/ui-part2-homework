package com.example.ui_part2_homework.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.ui_part2_homework.R
import com.example.ui_part2_homework.databinding.FirstChildFragmentBinding
import com.example.ui_part2_homework.utils.CounterManager


class FirstFragmentChild: Fragment(R.layout.first_child_fragment) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bindingFragment = FirstChildFragmentBinding.bind(view)
        val counterManager = CounterManager()
        val countValue = counterManager.getCounter(arguments)
        bindingFragment.childFirstFragmentCounter.text = "$countValue"

        bindingFragment.root.setOnClickListener {

            parentFragmentManager.beginTransaction().apply {
                setReorderingAllowed(true)
                replace(R.id.fragmentContainerCounterFirst, FirstFragmentChild::class.java,
                        counterManager.createArgs(countValue+1))
                addToBackStack(null)

                commit()
            }
        }
    }

}