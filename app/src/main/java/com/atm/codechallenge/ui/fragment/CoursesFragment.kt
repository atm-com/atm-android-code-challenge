package com.atm.codechallenge.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.antmoney.kmm_services.GreetingKMM
import com.antmoney.kmm_services.network.CourseService
import com.atm.codechallenge.R
import com.atm.codechallenge.databinding.FragmentCoursesBinding
import com.atm.codechallenge.shared.viewBinding
import com.atm.codechallenge.ui.compose.atom.Greeting
import com.atm.codechallenge.ui.compose.theme.CodeChallengeTheme

class CoursesFragment : Fragment(R.layout.fragment_courses) {

    private val binding by viewBinding(FragmentCoursesBinding::bind)

    private val state = mutableStateOf<String>("")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.composeView.setContent {
            // TODO: Do stuff
            CodeChallengeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting(state)
                }
            }
        }

        // Basic GraphQL Query using a Coroutine. Note: This is happening on the main thread.
        // Probably it shouldn't.
        lifecycleScope.launchWhenResumed {
            val courses = CourseService.courses()
            val courseById = CourseService.courseById("08c75d52-84dd-4605-ab34-6da007d4787e")
//
            state.value = "Networking Success!\n\n $courses"

            Log.d("LaunchList", "Success $courses")
            Log.d("LaunchList", "Success By Id ${courseById}")

        }
    }
}