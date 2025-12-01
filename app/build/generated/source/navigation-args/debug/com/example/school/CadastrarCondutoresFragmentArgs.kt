package com.example.school

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.Int
import kotlin.jvm.JvmStatic

public data class CadastrarCondutoresFragmentArgs(
  public val condutorId: Int = -1,
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putInt("condutorId", this.condutorId)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("condutorId", this.condutorId)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): CadastrarCondutoresFragmentArgs {
      bundle.setClassLoader(CadastrarCondutoresFragmentArgs::class.java.classLoader)
      val __condutorId : Int
      if (bundle.containsKey("condutorId")) {
        __condutorId = bundle.getInt("condutorId")
      } else {
        __condutorId = -1
      }
      return CadastrarCondutoresFragmentArgs(__condutorId)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): CadastrarCondutoresFragmentArgs {
      val __condutorId : Int?
      if (savedStateHandle.contains("condutorId")) {
        __condutorId = savedStateHandle["condutorId"]
        if (__condutorId == null) {
          throw IllegalArgumentException("Argument \"condutorId\" of type integer does not support null values")
        }
      } else {
        __condutorId = -1
      }
      return CadastrarCondutoresFragmentArgs(__condutorId)
    }
  }
}
