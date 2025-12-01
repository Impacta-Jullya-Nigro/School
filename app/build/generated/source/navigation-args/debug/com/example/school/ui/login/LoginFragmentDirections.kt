package com.example.school.ui.login

import androidx.`annotation`.CheckResult
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.school.R

public class LoginFragmentDirections private constructor() {
  public companion object {
    @CheckResult
    public fun actionLoginFragmentToNavHome(): NavDirections = ActionOnlyNavDirections(R.id.action_loginFragment_to_nav_home)

    @CheckResult
    public fun actionLoginFragmentToRegisterFragment(): NavDirections = ActionOnlyNavDirections(R.id.action_loginFragment_to_registerFragment)

    @CheckResult
    public fun actionLoginFragmentToUserListFragment(): NavDirections = ActionOnlyNavDirections(R.id.action_loginFragment_to_userListFragment)
  }
}
