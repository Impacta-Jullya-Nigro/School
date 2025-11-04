package com.example.school

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.school.data.Turma
import com.example.school.databinding.TurmaListItemBinding

class EditarTurmasAdapter(
    private val onEdit: (Turma) -> Unit,
    private val onDelete: (Turma) -> Unit
) : ListAdapter<Turma, EditarTurmasAdapter.TurmaViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TurmaViewHolder {
        val binding = TurmaListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TurmaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TurmaViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current)
    }

    inner class TurmaViewHolder(private val binding: TurmaListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(turma: Turma) {
            binding.textViewTurmaInfo.text = "${turma.serie} ${turma.nome} - ${turma.turno}"
            binding.imageViewEdit.setOnClickListener { onEdit(turma) }
            binding.imageViewDelete.setOnClickListener { onDelete(turma) }
        }
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Turma>() {
            override fun areItemsTheSame(oldItem: Turma, newItem: Turma): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Turma, newItem: Turma): Boolean {
                return oldItem == newItem
            }
        }
    }
}