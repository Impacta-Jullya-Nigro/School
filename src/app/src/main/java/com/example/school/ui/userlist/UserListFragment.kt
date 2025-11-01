package com.example.school.ui.userlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.school.data.AppDatabase
import com.example.school.databinding.FragmentUserListBinding
import kotlinx.coroutines.launch

class UserListFragment : Fragment() {

    private var _binding: FragmentUserListBinding? = null
    private val binding get() = _binding!!

    private val db by lazy { AppDatabase.getDatabase(requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerViewUsers.layoutManager = LinearLayoutManager(context)

        lifecycleScope.launch {
            val users = db.userDao().getAllUsers()
            binding.recyclerViewUsers.adapter = UserListAdapter(users)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
