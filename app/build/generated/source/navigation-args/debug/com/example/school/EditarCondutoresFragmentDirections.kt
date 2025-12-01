package com.example.school

import android.os.Bundle
import androidx.`annotation`.CheckResult
import androidx.navigation.NavDirections
import kotlin.Int

public class EditarCondutoresFragmentDirections private constructor() {
  private data class ActionEditarCondutoresFragmentToCadastrarCondutoresFragment(
    public val condutorId: Int = -1,
  ) : NavDirections {
    public override val actionId: Int =
        R.id.action_editarCondutoresFragment_to_cadastrarCondutoresFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putInt("condutorId", this.condutorId)
        return result
      }
  }

  public companion object {
    @CheckResult
    public fun actionEditarCondutoresFragmentToCadastrarCondutoresFragment(condutorId: Int = -1): NavDirections = ActionEditarCondutoresFragmentToCadastrarCondutoresFragment(condutorId)
  }
}
