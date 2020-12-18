package com.example.ui_part2_homework.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.ui_part2_homework.R
import com.example.ui_part2_homework.databinding.FirstFragmentBinding
import com.example.ui_part2_homework.utils.CounterManager


class FirstFragment: Fragment(R.layout.first_fragment) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bindingFragment = FirstFragmentBinding.bind(view)
        val counterManager = CounterManager()

        bindingFragment.root.setOnClickListener {
            val countValue = counterManager.getCounter(arguments)
            bindingFragment.firstFragmentCounter.text = "$countValue"
            parentFragmentManager.beginTransaction().apply {
                setReorderingAllowed(true)
                add(R.id.firstFragmentContainerView, FirstFragment::class.java,
                    counterManager.createArgs(countValue+1))
                addToBackStack(null)

                commit()
            }
        }

    }

}