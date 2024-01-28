package com.example.testnavigation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ResultViewModelTest {

  @get:Rule
  val rule = InstantTaskExecutorRule()

  private lateinit var viewModel: ResultViewModel
  private lateinit var observer: Observer<Word>

  @Before
  fun setup() {
    viewModel = ResultViewModel()
    observer = mock()
    viewModel.textData.observeForever(observer)
  }

  @Test
  fun `setContestData should update textData`() {
    // Given
    val text = "example"
    val testData = Word(text, text.length)

    // When
    viewModel.setContestData(testData)

    // Then
    verify(observer).onChanged(testData)
  }


  @Test
  fun `setContestData with valid data should update LiveData`() {
    // Given
    val testData = Word("test", 4)

    // When
    viewModel.setContestData(testData)

    // Then
    assertEquals(testData, viewModel.textData.value)
  }

  @Test
  fun `setContestData with different valid data should update LiveData`() {
    // Given
    val testData = Word("another test", 12)

    // When
    viewModel.setContestData(testData)

    // Then
    assertEquals(testData, viewModel.textData.value)
  }


  @Test
  fun `textData should start with null`() {
    // Given no data set

    // Then
    assert(viewModel.textData.value == null)
  }

}
