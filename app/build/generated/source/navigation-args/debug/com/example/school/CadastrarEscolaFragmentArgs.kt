package com.example.school

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.Int
import kotlin.jvm.JvmStatic

public data class CadastrarEscolaFragmentArgs(
  public val escolaId: Int = -1,
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putInt("escolaId", this.escolaId)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("escolaId", this.escolaId)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): CadastrarEscolaFragmentArgs {
      bundle.setClassLoader(CadastrarEscolaFragmentArgs::class.java.classLoader)
      val __escolaId : Int
      if (bundle.containsKey("escolaId")) {
        __escolaId = bundle.getInt("escolaId")
      } else {
        __escolaId = -1
      }
      return CadastrarEscolaFragmentArgs(__escolaId)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): CadastrarEscolaFragmentArgs {
      val __escolaId : Int?
      if (savedStateHandle.contains("escolaId")) {
        __escolaId = savedStateHandle["escolaId"]
        if (__escolaId == null) {
          throw IllegalArgumentException("Argument \"escolaId\" of type integer does not support null values")
        }
      } else {
        __escolaId = -1
      }
      return CadastrarEscolaFragmentArgs(__escolaId)
    }
  }
}
