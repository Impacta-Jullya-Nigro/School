package com.example.school

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.school.data.Responsavel
import com.example.school.databinding.ResponsavelListItemBinding

class EditarResponsaveisAdapter(
    private val onEdit: (Responsavel) -> Unit,
    private val onDelete: (Responsavel) -> Unit
) : ListAdapter<Responsavel, EditarResponsaveisAdapter.ResponsavelViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResponsavelViewHolder {
        val binding = ResponsavelListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ResponsavelViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ResponsavelViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current)
    }

    inner class ResponsavelViewHolder(private val binding: ResponsavelListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(responsavel: Responsavel) {
            binding.textViewResponsavelNome.text = responsavel.nome
            binding.imageViewEdit.setOnClickListener { onEdit(responsavel) }
            binding.imageViewDelete.setOnClickListener { onDelete(responsavel) }
        }
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Responsavel>() {
            override fun areItemsTheSame(oldItem: Responsavel, newItem: Responsavel): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Responsavel, newItem: Responsavel): Boolean {
                return oldItem == newItem
            }
        }
    }
}