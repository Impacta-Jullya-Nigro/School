package com.example.school

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.school.data.Escola
import com.example.school.databinding.EscolaListItemBinding

class EditarEscolasAdapter(
    private val onEdit: (Escola) -> Unit,
    private val onDelete: (Escola) -> Unit
) : ListAdapter<Escola, EditarEscolasAdapter.EscolaViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EscolaViewHolder {
        val binding = EscolaListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EscolaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EscolaViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current)
    }

    inner class EscolaViewHolder(private val binding: EscolaListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(escola: Escola) {
            binding.textViewEscolaNome.text = escola.nome
            binding.textViewEscolaEndereco.text = "${escola.endereco}, ${escola.numero}"
            binding.imageViewEdit.setOnClickListener { onEdit(escola) }
            binding.imageViewDelete.setOnClickListener { onDelete(escola) }
        }
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Escola>() {
            override fun areItemsTheSame(oldItem: Escola, newItem: Escola): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Escola, newItem: Escola): Boolean {
                return oldItem == newItem
            }
        }
    }
}