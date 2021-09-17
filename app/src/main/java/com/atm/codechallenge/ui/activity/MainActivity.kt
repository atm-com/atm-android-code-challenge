package com.atm.codechallenge.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.lifecycleScope
import com.antmoney.kmm_services.network.CourseService
import com.atm.codechallenge.databinding.ActivityMainBinding
import com.atm.codechallenge.shared.viewBinding
import com.atm.codechallenge.ui.fragment.CoursesFragment

class MainActivity : FragmentActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().apply {
                add(binding.contentRoot.id, CoursesFragment(), "CoursesFragment")
            }.commit()
        }
    }
}

