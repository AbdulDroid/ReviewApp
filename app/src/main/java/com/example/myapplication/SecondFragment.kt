package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_second.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment(), BioRecyclerAdapter.OnItemClick {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(task_recycler) {
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            adapter = BioRecyclerAdapter(populate(), this@SecondFragment)
        }
        button_second.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }


    private fun populate(): List<BioItem> {
        return listOf(
            BioItem("Full Name:", getString(R.string.full_name_abdulrahman_abdulkarim)),
            BioItem("Email Address:", getString(R.string.email_address_olanre12waju_gmail_com)),
                    BioItem("Slack Username:", getString(R.string.slack_userame_abdul)),
            BioItem("Tracks:", getString(R.string.tracks_mobile))
        )
    }

    override fun onClick() {
        Toast.makeText(requireContext(), "An Item was clicked", Toast.LENGTH_LONG).show()
    }
}
