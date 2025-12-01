package com.example.school

import android.os.Bundle
import androidx.`annotation`.CheckResult
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import kotlin.Int

public class CondutorOptionsFragmentDirections private constructor() {
  private data class ActionCondutorOptionsFragmentToCadastrarCondutoresFragment(
    public val condutorId: Int = -1,
  ) : NavDirections {
    public override val actionId: Int =
        R.id.action_condutorOptionsFragment_to_cadastrarCondutoresFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putInt("condutorId", this.condutorId)
        return result
      }
  }

  public companion object {
    @CheckResult
    public fun actionCondutorOptionsFragmentToCadastrarCondutoresFragment(condutorId: Int = -1): NavDirections = ActionCondutorOptionsFragmentToCadastrarCondutoresFragment(condutorId)

    @CheckResult
    public fun actionCondutorOptionsFragmentToEditarCondutoresFragment(): NavDirections = ActionOnlyNavDirections(R.id.action_condutorOptionsFragment_to_editarCondutoresFragment)
  }
}
