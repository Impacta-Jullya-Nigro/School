package com.example.school.ui.cadastro

import androidx.`annotation`.CheckResult
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.school.R

public class CadastroFragmentDirections private constructor() {
  public companion object {
    @CheckResult
    public fun actionNavCadastroToAlunoOptionsFragment(): NavDirections = ActionOnlyNavDirections(R.id.action_nav_cadastro_to_alunoOptionsFragment)

    @CheckResult
    public fun actionNavCadastroToResponsavelOptionsFragment(): NavDirections = ActionOnlyNavDirections(R.id.action_nav_cadastro_to_responsavelOptionsFragment)

    @CheckResult
    public fun actionNavCadastroToTurmaOptionsFragment(): NavDirections = ActionOnlyNavDirections(R.id.action_nav_cadastro_to_turmaOptionsFragment)

    @CheckResult
    public fun actionNavCadastroToEscolaOptionsFragment(): NavDirections = ActionOnlyNavDirections(R.id.action_nav_cadastro_to_escolaOptionsFragment)

    @CheckResult
    public fun actionNavCadastroToCondutorOptionsFragment(): NavDirections = ActionOnlyNavDirections(R.id.action_nav_cadastro_to_condutorOptionsFragment)
  }
}
