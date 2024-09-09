package ir.abzardanesh.daneshjooyarapp.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.abzardanesh.daneshjooyarapp.databinding.ItemLearnBinding
import ir.abzardanesh.daneshjooyarapp.databinding.ItemPropertyBinding
import ir.abzardanesh.daneshjooyarapp.model.ModelGroupCourseVideoProperty

class RecyclerViewProperty
    (
    private val listProperty: Array<ModelGroupCourseVideoProperty>
) : RecyclerView.Adapter<RecyclerViewProperty.ViewHolder>() {


    inner class ViewHolder(val binding: ItemPropertyBinding) :
        RecyclerView.ViewHolder(binding.root) {


    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerViewProperty.ViewHolder {
        return ViewHolder(ItemPropertyBinding.inflate(LayoutInflater.from(parent.context),
            parent,false))
    }

    override fun getItemCount(): Int = listProperty.size

    override fun onBindViewHolder(holder: RecyclerViewProperty.ViewHolder, position: Int) {
       holder.binding.imageViewProperty.setImageResource(listProperty[position].imageUrl)
        holder.binding.tvTitle.text = listProperty[position].title
    }
}








