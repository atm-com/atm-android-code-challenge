package com.atm.codechallenge.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.fragment.app.Fragment
import com.atm.codechallenge.R
import com.atm.codechallenge.databinding.FragmentCoursesBinding
import com.atm.codechallenge.shared.viewBinding
import com.atm.codechallenge.ui.compose.atom.Greeting
import com.atm.codechallenge.ui.compose.theme.CodeChallengeTheme

class CoursesFragment : Fragment(R.layout.fragment_courses) {

    private val binding by viewBinding(FragmentCoursesBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.composeView.setContent {
            // TODO: Do stuff
            CodeChallengeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Courses Screen")
                }
            }
        }
    }
}