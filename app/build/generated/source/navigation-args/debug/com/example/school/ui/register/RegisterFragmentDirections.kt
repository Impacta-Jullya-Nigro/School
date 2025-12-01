package com.example.school.ui.register

import androidx.`annotation`.CheckResult
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.school.R

public class RegisterFragmentDirections private constructor() {
  public companion object {
    @CheckResult
    public fun actionRegisterFragmentToLoginFragment(): NavDirections = ActionOnlyNavDirections(R.id.action_registerFragment_to_loginFragment)
  }
}
