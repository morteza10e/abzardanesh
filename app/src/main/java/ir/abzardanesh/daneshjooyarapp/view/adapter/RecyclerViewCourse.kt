package ir.abzardanesh.daneshjooyarapp.view.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.abzardanesh.daneshjooyarapp.activity.EteelaatActivity
import ir.abzardanesh.daneshjooyarapp.databinding.ItemCourseBinding
import ir.abzardanesh.daneshjooyarapp.model.ModelGroupCourseVideoProperty

class RecyclerViewCourse  (
    private val context: Context,
    private val listCourse: Array<ModelGroupCourseVideoProperty>
) : RecyclerView.Adapter<RecyclerViewCourse.ViewHolder>() {



    inner class ViewHolder(val binding: ItemCourseBinding) :
        RecyclerView.ViewHolder(binding.root) {


    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCourseBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun getItemCount(): Int = listCourse.size

    @SuppressLint("ClickableViewAccessibility")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.imageViewCourse.setImageResource(listCourse[position].imageUrl)
        holder.binding.tvTitle.text = listCourse[position].title

        holder.binding.root.setOnClickListener {
            context.startActivity(Intent(context,EteelaatActivity::class.java))
        }





    }



}



