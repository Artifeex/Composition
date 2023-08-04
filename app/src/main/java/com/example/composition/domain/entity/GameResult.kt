package com.example.composition.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Parcelize
data class GameResult(
    val winner: Boolean,
    val countOfRightAnswers: Int,
    val countOfQuestions: Int,
    val gameSettings: GameSettings
): Parcelable {
    fun calculatePercentOfRightAnswers(): Int {
        if(countOfQuestions == 0) {
            return 0
        }
        return (countOfRightAnswers / countOfQuestions.toDouble() * 100).toInt()
    }

}