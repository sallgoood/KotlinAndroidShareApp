package it.`is`.all.good.android.shareapp.shareapp.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import it.`is`.all.good.android.shareapp.shareapp.R
import it.`is`.all.good.android.shareapp.shareapp.adapters.HobbiesAdapter
import it.`is`.all.good.android.shareapp.shareapp.models.hobbies
import kotlinx.android.synthetic.main.activity_hobbies.*

class HobbiesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hobbies)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = HobbiesAdapter(this, hobbies)
    }
}
