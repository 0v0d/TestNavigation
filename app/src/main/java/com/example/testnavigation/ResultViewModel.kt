package com.example.testnavigation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ResultViewModel : ViewModel() {
  private val _textData = MutableLiveData<Word>()
  val textData: LiveData<Word> get() = _textData

  fun setContestData(data: Word) {
    _textData.value = data
  }
}