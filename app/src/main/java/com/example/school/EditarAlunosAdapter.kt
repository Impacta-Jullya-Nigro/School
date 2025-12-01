package com.example.school

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.school.data.Aluno
import com.example.school.databinding.AlunoListItemBinding

class EditarAlunosAdapter(
    private val onEdit: (Aluno) -> Unit,
    private val onDelete: (Aluno) -> Unit
) : ListAdapter<Aluno, EditarAlunosAdapter.AlunoViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlunoViewHolder {
        val binding = AlunoListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AlunoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AlunoViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current)
    }

    inner class AlunoViewHolder(private val binding: AlunoListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(aluno: Aluno) {
            binding.textViewAlunoNome.text = aluno.nome
            binding.imageViewEdit.setOnClickListener { onEdit(aluno) }
            binding.imageViewDelete.setOnClickListener { onDelete(aluno) }
        }
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Aluno>() {
            override fun areItemsTheSame(oldItem: Aluno, newItem: Aluno): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Aluno, newItem: Aluno): Boolean {
                return oldItem == newItem
            }
        }
    }
}