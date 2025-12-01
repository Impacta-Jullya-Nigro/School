package com.example.school

import android.os.Bundle
import androidx.`annotation`.CheckResult
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import kotlin.Int

public class AlunoOptionsFragmentDirections private constructor() {
  private data class ActionAlunoOptionsFragmentToCadastrarAlunoFragment(
    public val alunoId: Int = -1,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_alunoOptionsFragment_to_cadastrarAlunoFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putInt("alunoId", this.alunoId)
        return result
      }
  }

  public companion object {
    @CheckResult
    public fun actionAlunoOptionsFragmentToCadastrarAlunoFragment(alunoId: Int = -1): NavDirections = ActionAlunoOptionsFragmentToCadastrarAlunoFragment(alunoId)

    @CheckResult
    public fun actionAlunoOptionsFragmentToEditarAlunosFragment(): NavDirections = ActionOnlyNavDirections(R.id.action_alunoOptionsFragment_to_editarAlunosFragment)
  }
}
