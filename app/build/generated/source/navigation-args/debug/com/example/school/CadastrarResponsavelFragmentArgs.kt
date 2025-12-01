package com.example.school

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.Int
import kotlin.jvm.JvmStatic

public data class CadastrarResponsavelFragmentArgs(
  public val responsavelId: Int = -1,
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putInt("responsavelId", this.responsavelId)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("responsavelId", this.responsavelId)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): CadastrarResponsavelFragmentArgs {
      bundle.setClassLoader(CadastrarResponsavelFragmentArgs::class.java.classLoader)
      val __responsavelId : Int
      if (bundle.containsKey("responsavelId")) {
        __responsavelId = bundle.getInt("responsavelId")
      } else {
        __responsavelId = -1
      }
      return CadastrarResponsavelFragmentArgs(__responsavelId)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): CadastrarResponsavelFragmentArgs {
      val __responsavelId : Int?
      if (savedStateHandle.contains("responsavelId")) {
        __responsavelId = savedStateHandle["responsavelId"]
        if (__responsavelId == null) {
          throw IllegalArgumentException("Argument \"responsavelId\" of type integer does not support null values")
        }
      } else {
        __responsavelId = -1
      }
      return CadastrarResponsavelFragmentArgs(__responsavelId)
    }
  }
}
