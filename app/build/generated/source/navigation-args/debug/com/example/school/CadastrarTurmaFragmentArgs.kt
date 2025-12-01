package com.example.school

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.Int
import kotlin.jvm.JvmStatic

public data class CadastrarTurmaFragmentArgs(
  public val turmaId: Int = -1,
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putInt("turmaId", this.turmaId)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("turmaId", this.turmaId)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): CadastrarTurmaFragmentArgs {
      bundle.setClassLoader(CadastrarTurmaFragmentArgs::class.java.classLoader)
      val __turmaId : Int
      if (bundle.containsKey("turmaId")) {
        __turmaId = bundle.getInt("turmaId")
      } else {
        __turmaId = -1
      }
      return CadastrarTurmaFragmentArgs(__turmaId)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): CadastrarTurmaFragmentArgs {
      val __turmaId : Int?
      if (savedStateHandle.contains("turmaId")) {
        __turmaId = savedStateHandle["turmaId"]
        if (__turmaId == null) {
          throw IllegalArgumentException("Argument \"turmaId\" of type integer does not support null values")
        }
      } else {
        __turmaId = -1
      }
      return CadastrarTurmaFragmentArgs(__turmaId)
    }
  }
}
