package it.`is`.all.good.android.shareapp.shareapp.adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import it.`is`.all.good.android.shareapp.shareapp.R
import it.`is`.all.good.android.shareapp.shareapp.models.Hobby
import it.`is`.all.good.android.shareapp.shareapp.showToast
import kotlinx.android.synthetic.main.item_hobby.view.*

class HobbiesAdapter(val context: Context, private val hobbies: List<Hobby>) : RecyclerView.Adapter<HobbiesAdapter.HobbiesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HobbiesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_hobby, parent, false)
        return HobbiesViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: HobbiesViewHolder, index: Int) {
        val hobby = hobbies[index]
        viewHolder.bindHobby(hobby, index)
    }

    override fun getItemCount(): Int {
        return hobbies.size
    }

    inner class HobbiesViewHolder(private val hobbiesView: View) : RecyclerView.ViewHolder(hobbiesView) {

        private lateinit var hobby: Hobby
        private var index: Int = 0

        init {
            hobbiesView.setOnClickListener {
                context.showToast("${hobby.title} is clicked")
            }

            itemView.hobbyImgShare.setOnClickListener {
                val message = "My hobby is : ${hobby.title}"

                val intent = Intent()
                with(intent) {
                    action = Intent.ACTION_SEND
                    type = "text/plain"
                    putExtra(Intent.EXTRA_TEXT, message)
                }

                context.startActivity(Intent.createChooser(intent, "Share to: "))
            }
        }

        fun bindHobby(hobby: Hobby, index: Int) {
            hobbiesView.hobbyTitle.text = hobby.title

            this.index = index
            this.hobby = hobby
        }
    }
}