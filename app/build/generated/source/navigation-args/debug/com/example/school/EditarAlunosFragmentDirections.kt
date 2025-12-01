package com.example.school

import android.os.Bundle
import androidx.`annotation`.CheckResult
import androidx.navigation.NavDirections
import kotlin.Int

public class EditarAlunosFragmentDirections private constructor() {
  private data class ActionEditarAlunosFragmentToCadastrarAlunoFragment(
    public val alunoId: Int = -1,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_editarAlunosFragment_to_cadastrarAlunoFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putInt("alunoId", this.alunoId)
        return result
      }
  }

  public companion object {
    @CheckResult
    public fun actionEditarAlunosFragmentToCadastrarAlunoFragment(alunoId: Int = -1): NavDirections = ActionEditarAlunosFragmentToCadastrarAlunoFragment(alunoId)
  }
}
