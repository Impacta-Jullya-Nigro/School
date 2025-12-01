package com.example.school

import android.os.Bundle
import androidx.`annotation`.CheckResult
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import kotlin.Int

public class TurmaOptionsFragmentDirections private constructor() {
  private data class ActionTurmaOptionsFragmentToCadastrarTurmaFragment(
    public val turmaId: Int = -1,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_turmaOptionsFragment_to_cadastrarTurmaFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putInt("turmaId", this.turmaId)
        return result
      }
  }

  public companion object {
    @CheckResult
    public fun actionTurmaOptionsFragmentToCadastrarTurmaFragment(turmaId: Int = -1): NavDirections = ActionTurmaOptionsFragmentToCadastrarTurmaFragment(turmaId)

    @CheckResult
    public fun actionTurmaOptionsFragmentToEditarTurmasFragment(): NavDirections = ActionOnlyNavDirections(R.id.action_turmaOptionsFragment_to_editarTurmasFragment)
  }
}
