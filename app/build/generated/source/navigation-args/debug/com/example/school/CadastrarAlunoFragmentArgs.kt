package com.example.school

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.Int
import kotlin.jvm.JvmStatic

public data class CadastrarAlunoFragmentArgs(
  public val alunoId: Int = -1,
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putInt("alunoId", this.alunoId)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("alunoId", this.alunoId)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): CadastrarAlunoFragmentArgs {
      bundle.setClassLoader(CadastrarAlunoFragmentArgs::class.java.classLoader)
      val __alunoId : Int
      if (bundle.containsKey("alunoId")) {
        __alunoId = bundle.getInt("alunoId")
      } else {
        __alunoId = -1
      }
      return CadastrarAlunoFragmentArgs(__alunoId)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): CadastrarAlunoFragmentArgs {
      val __alunoId : Int?
      if (savedStateHandle.contains("alunoId")) {
        __alunoId = savedStateHandle["alunoId"]
        if (__alunoId == null) {
          throw IllegalArgumentException("Argument \"alunoId\" of type integer does not support null values")
        }
      } else {
        __alunoId = -1
      }
      return CadastrarAlunoFragmentArgs(__alunoId)
    }
  }
}
