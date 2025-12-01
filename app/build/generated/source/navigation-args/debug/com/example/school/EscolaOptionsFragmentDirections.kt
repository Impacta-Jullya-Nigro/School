package com.example.school

import android.os.Bundle
import androidx.`annotation`.CheckResult
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import kotlin.Int

public class EscolaOptionsFragmentDirections private constructor() {
  private data class ActionEscolaOptionsFragmentToCadastrarEscolaFragment(
    public val escolaId: Int = -1,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_escolaOptionsFragment_to_cadastrarEscolaFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putInt("escolaId", this.escolaId)
        return result
      }
  }

  public companion object {
    @CheckResult
    public fun actionEscolaOptionsFragmentToCadastrarEscolaFragment(escolaId: Int = -1): NavDirections = ActionEscolaOptionsFragmentToCadastrarEscolaFragment(escolaId)

    @CheckResult
    public fun actionEscolaOptionsFragmentToEditarEscolasFragment(): NavDirections = ActionOnlyNavDirections(R.id.action_escolaOptionsFragment_to_editarEscolasFragment)
  }
}
