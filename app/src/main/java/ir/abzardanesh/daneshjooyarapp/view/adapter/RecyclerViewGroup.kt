package ir.abzardanesh.daneshjooyarapp.view.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import ir.abzardanesh.daneshjooyarapp.R
import ir.abzardanesh.daneshjooyarapp.databinding.ItemGroupBinding
import ir.abzardanesh.daneshjooyarapp.model.ModelGroupCourseVideoProperty
import ir.abzardanesh.daneshjooyarapp.model.ModelMainActivity

class RecyclerViewGroup
    (
    private val listGroup: Array<ModelGroupCourseVideoProperty>
) : RecyclerView.Adapter<RecyclerViewGroup.ViewHolder>() {

    var selectedPosition =0
    var lastSelectedPosition = 0

    inner class ViewHolder(val binding: ItemGroupBinding) :
        RecyclerView.ViewHolder(binding.root) {


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemGroupBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun getItemCount(): Int = listGroup.size

    @SuppressLint("ClickableViewAccessibility")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.imageViewGroup.setImageResource(listGroup[position].imageUrl)
        holder.binding.tvGroup.text = listGroup[position].title



        holder.binding.cardView.setBackgroundResource(R.drawable.bg_splash)

        holder.binding.relative.setOnClickListener {
            lastSelectedPosition = selectedPosition;
            selectedPosition = position;
            notifyItemChanged(lastSelectedPosition);
            notifyItemChanged(selectedPosition);

        };
        if (selectedPosition == position) {
            holder.binding.cardView.setBackgroundResource(R.drawable.bg_splash);
            holder.binding.tvGroup.setTextColor(Color.WHITE)
        } else {
            holder.binding.cardView.setBackgroundResource(R.drawable.bg_group_white)
            holder.binding.tvGroup.setTextColor(Color.BLACK);
        }



    }












}



