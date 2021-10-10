package com.example.affirmations.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

//Добавляем аннотации, т к можно случайно передать аргументы в неправильном порядке
// (например сначала imageResourceId  вместо stringResourceId)
data class Affirmation(
    //текст аффирмации
    @StringRes val stringResourceId: Int,
    //картинка аффирмации
    @DrawableRes val imageResourceId: Int
) {
}