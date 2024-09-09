package ir.abzardanesh.daneshjooyarapp.view.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.abzardanesh.daneshjooyarapp.R
import ir.abzardanesh.daneshjooyarapp.activity.VideoActivity
import ir.abzardanesh.daneshjooyarapp.databinding.ItemVideoBinding
import ir.abzardanesh.daneshjooyarapp.model.ModelGroupCourseVideoProperty

class RecyclerViewVideo(
    private val context: Context,
    private val listVideo: Array<ModelGroupCourseVideoProperty>,


    ) : RecyclerView.Adapter<RecyclerViewVideo.ViewHolder>() {

    private val pref = context.getSharedPreferences("Pref", Context.MODE_PRIVATE)
    private var progress = pref.getLong("Progress", 0)
    private var idProgress = pref.getInt("id", -1)


    var selected = -1


    inner class ViewHolder(val binding: ItemVideoBinding) :
        RecyclerView.ViewHolder(binding.root) {


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemVideoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun getItemCount(): Int = listVideo.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.imageItemVideo.setImageResource(listVideo[position].imageUrl)
        holder.binding.tvTitle.text = listVideo[position].title


        holder.binding.root.setOnClickListener {
            val intent = Intent(context, VideoActivity::class.java)
            intent.putExtra("pos", position); // Pass Id
            context.startActivity(intent)
            updatePosition(position)
        }



        if (position == selected) {
            holder.binding.linearLayout.setBackgroundResource(R.color.green)
        }


    }

    fun updatePosition(position: Int) {
        selected = position;
        notifyItemChanged(position)

    }

}










