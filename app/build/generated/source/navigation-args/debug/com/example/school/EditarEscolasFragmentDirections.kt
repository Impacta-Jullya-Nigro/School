package com.example.school

import android.os.Bundle
import androidx.`annotation`.CheckResult
import androidx.navigation.NavDirections
import kotlin.Int

public class EditarEscolasFragmentDirections private constructor() {
  private data class ActionEditarEscolasFragmentToCadastrarEscolaFragment(
    public val escolaId: Int = -1,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_editarEscolasFragment_to_cadastrarEscolaFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putInt("escolaId", this.escolaId)
        return result
      }
  }

  public companion object {
    @CheckResult
    public fun actionEditarEscolasFragmentToCadastrarEscolaFragment(escolaId: Int = -1): NavDirections = ActionEditarEscolasFragmentToCadastrarEscolaFragment(escolaId)
  }
}
