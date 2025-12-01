package com.example.school

import android.os.Bundle
import androidx.`annotation`.CheckResult
import androidx.navigation.NavDirections
import kotlin.Int

public class EditarResponsaveisFragmentDirections private constructor() {
  private data class ActionEditarResponsaveisFragmentToCadastrarResponsavelFragment(
    public val responsavelId: Int = -1,
  ) : NavDirections {
    public override val actionId: Int =
        R.id.action_editarResponsaveisFragment_to_cadastrarResponsavelFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putInt("responsavelId", this.responsavelId)
        return result
      }
  }

  public companion object {
    @CheckResult
    public fun actionEditarResponsaveisFragmentToCadastrarResponsavelFragment(responsavelId: Int = -1): NavDirections = ActionEditarResponsaveisFragmentToCadastrarResponsavelFragment(responsavelId)
  }
}
