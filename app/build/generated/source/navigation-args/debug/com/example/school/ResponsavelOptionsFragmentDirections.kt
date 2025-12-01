package com.example.school

import android.os.Bundle
import androidx.`annotation`.CheckResult
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import kotlin.Int

public class ResponsavelOptionsFragmentDirections private constructor() {
  private data class ActionResponsavelOptionsFragmentToCadastrarResponsavelFragment(
    public val responsavelId: Int = -1,
  ) : NavDirections {
    public override val actionId: Int =
        R.id.action_responsavelOptionsFragment_to_cadastrarResponsavelFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putInt("responsavelId", this.responsavelId)
        return result
      }
  }

  public companion object {
    @CheckResult
    public fun actionResponsavelOptionsFragmentToCadastrarResponsavelFragment(responsavelId: Int = -1): NavDirections = ActionResponsavelOptionsFragmentToCadastrarResponsavelFragment(responsavelId)

    @CheckResult
    public fun actionResponsavelOptionsFragmentToEditarResponsaveisFragment(): NavDirections = ActionOnlyNavDirections(R.id.action_responsavelOptionsFragment_to_editarResponsaveisFragment)
  }
}
