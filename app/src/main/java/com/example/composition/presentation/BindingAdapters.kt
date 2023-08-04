package com.example.composition.presentation

import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.composition.R
import com.example.composition.domain.entity.GameResult

interface OnOptionClickListener {

    fun onOptionClick(option: Int)
}

@BindingAdapter("requiredAnswers")
fun bindRequiredAnswers(textView: TextView, count: Int) {
    textView.text = String.format(textView.context.getString(R.string.required_score), count)
}

@BindingAdapter("scoreAnswers")
fun bindScoreAnswers(textView: TextView, count: Int) {
    textView.text = String.format(textView.context.getString(R.string.score_answers), count)
}

@BindingAdapter("requiredPercent")
fun bindRequiredPercent(textView: TextView, requiredPercent: Int) {
    textView.text = String.format(textView.context.getString(R.string.required_percentage), requiredPercent)
}

@BindingAdapter("scorePercent")
fun bindScorePercent(textView: TextView, gameResult: GameResult) {
    textView.text = String.format(textView.context.getString(R.string.score_percentage), gameResult.calculatePercentOfRightAnswers())
}

@BindingAdapter("setImage")
fun bindImage(image: ImageView, winner: Boolean) {
    val imageResId = if(winner) R.drawable.ic_smile else R.drawable.ic_sad
    image.setImageResource(imageResId)
}

@BindingAdapter("sumQuestion")
fun bindSum(textView: TextView, sum: Int) {
    textView.text = sum.toString()
}

@BindingAdapter("visibleNumber")
fun bindVisibleNumber(textView: TextView, visibleNumber: Int) {
    textView.text = visibleNumber.toString()
}

@BindingAdapter("progressBarMain")
fun bindProgress(progressBar: ProgressBar, progress: Int) {
    progressBar.setProgress(progress, true)
}

@BindingAdapter("progressBarSecondary")
fun bindProgressSecondary(progressBar: ProgressBar, minPercent: Int) {
    progressBar.secondaryProgress = minPercent
}

@BindingAdapter("onOptionClickListener")
fun bindOnOptionClickListener(textView: TextView, clickListener: OnOptionClickListener) {
    textView.setOnClickListener {
        clickListener.onOptionClick(textView.text.toString().toInt())
    }
}



