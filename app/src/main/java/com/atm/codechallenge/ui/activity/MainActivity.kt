package com.atm.codechallenge.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.lifecycleScope
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

        // Basic GraphQL Query using a Coroutine. Note: This is happening on the main thread.
        // Probably it shouldn't.
        lifecycleScope.launchWhenResumed {
//            GreetingKMM()
//            val courses = CourseService.courses()
//            val courseById = CourseService.courseById("08c75d52-84dd-4605-ab34-6da007d4787e")
//
//            Log.d("LaunchList", "Success ${courses}")
//            Log.d("LaunchList", "Success By Id ${courseById}")

        }
    }
}

