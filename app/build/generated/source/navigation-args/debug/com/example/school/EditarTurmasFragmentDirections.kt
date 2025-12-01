package com.example.school

import android.os.Bundle
import androidx.`annotation`.CheckResult
import androidx.navigation.NavDirections
import kotlin.Int

public class EditarTurmasFragmentDirections private constructor() {
  private data class ActionEditarTurmasFragmentToCadastrarTurmaFragment(
    public val turmaId: Int = -1,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_editarTurmasFragment_to_cadastrarTurmaFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putInt("turmaId", this.turmaId)
        return result
      }
  }

  public companion object {
    @CheckResult
    public fun actionEditarTurmasFragmentToCadastrarTurmaFragment(turmaId: Int = -1): NavDirections = ActionEditarTurmasFragmentToCadastrarTurmaFragment(turmaId)
  }
}
