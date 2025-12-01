package com.example.school

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.school.data.Condutor
import com.example.school.databinding.ItemCondutorBinding

class CondutorAdapter(
    private val onEdit: (Int) -> Unit,
    private val onDelete: (Condutor) -> Unit
) : ListAdapter<Condutor, CondutorAdapter.CondutorViewHolder>(CondutorDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CondutorViewHolder {
        val binding = ItemCondutorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CondutorViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CondutorViewHolder, position: Int) {
        val condutor = getItem(position)
        holder.bind(condutor)
    }

    inner class CondutorViewHolder(private val binding: ItemCondutorBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(condutor: Condutor) {
            binding.nomeCondutor.text = condutor.nome
            binding.telefoneCondutor.text = condutor.telefone
            binding.placaVeiculoCondutor.text = condutor.placaVeiculo

            binding.editButton.setOnClickListener {
                onEdit(condutor.id)
            }

            binding.deleteButton.setOnClickListener {
                onDelete(condutor)
            }
        }
    }
}

class CondutorDiffCallback : DiffUtil.ItemCallback<Condutor>() {
    override fun areItemsTheSame(oldItem: Condutor, newItem: Condutor):
        Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Condutor, newItem: Condutor):
        Boolean = oldItem == newItem
}
