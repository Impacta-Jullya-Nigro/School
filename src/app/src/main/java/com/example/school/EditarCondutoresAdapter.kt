package com.example.school

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.school.data.Condutor
import com.example.school.databinding.CondutorListItemBinding

class EditarCondutoresAdapter(
    private val onEdit: (Condutor) -> Unit,
    private val onDelete: (Condutor) -> Unit
) : ListAdapter<Condutor, EditarCondutoresAdapter.CondutorViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CondutorViewHolder {
        val binding = CondutorListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CondutorViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CondutorViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current)
    }

    inner class CondutorViewHolder(private val binding: CondutorListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(condutor: Condutor) {
            binding.textViewCondutorNome.text = condutor.nome
            binding.textViewCondutorPlaca.text = "Placa: ${condutor.placaVeiculo}"
            binding.imageViewEdit.setOnClickListener { onEdit(condutor) }
            binding.imageViewDelete.setOnClickListener { onDelete(condutor) }
        }
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Condutor>() {
            override fun areItemsTheSame(oldItem: Condutor, newItem: Condutor): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Condutor, newItem: Condutor): Boolean {
                return oldItem == newItem
            }
        }
    }
}