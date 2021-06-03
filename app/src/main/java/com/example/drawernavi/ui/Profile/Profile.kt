package com.example.drawernavi.ui.Profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.drawernavi.R


class Profile : Fragment() {

    private lateinit var profileView: ProfileView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        profileView =
            ViewModelProvider(this).get(ProfileView::class.java)
        val root = inflater.inflate(R.layout.fragment_profile, container, false)
        val textView: TextView = root.findViewById(R.id.text_profile)
        profileView.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}