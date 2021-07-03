package com.example.affirmations.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

//Добавляем аннотации, т к можно случайно передать аргументы в неправильном порядке
// ( imageResourceId сначала вместо stringResourceId)
data class Affirmation(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int
) {
}