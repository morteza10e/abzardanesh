package ir.abzardanesh.daneshjooyarapp.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.abzardanesh.daneshjooyarapp.databinding.ItemLearnBinding
import ir.abzardanesh.daneshjooyarapp.model.ModelLearn

class RecyclerViewLearn  (private val listLearn: Array<ModelLearn>
) : RecyclerView.Adapter<RecyclerViewLearn.ViewHolder>() {


    inner class ViewHolder(val binding: ItemLearnBinding) :
        RecyclerView.ViewHolder(binding.root) {


    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemLearnBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun getItemCount(): Int = listLearn.size

    @SuppressLint("ClickableViewAccessibility")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.tvText.text = listLearn[position].text
        holder.binding.tvTitle.text = listLearn[position].title
        holder.binding.imageItemLearn.setImageResource(listLearn[position].imageUrl)




    }



}


