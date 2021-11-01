package com.example.imageviewcombinations

import android.os.Parcelable
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import kotlinx.parcelize.Parcelize

@Composable
fun ImageWidget(
    modifier: Modifier = Modifier,
    model: ImageWidgetData
) {
    Column {
        val contentScale = remember {
            mutableStateOf(model.scale.toContentScale())
        }
        ScaleTypeRadioButton(model.scale, updateScale = {
            contentScale.value = it.toContentScale()
        })
        Text(text = model.label, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.size(12.dp))
        Image(
            modifier = modifier
                .width(model.width)
                .height(model.height),
            painter = painterResource(model.drawableRes),
            contentScale = contentScale.value,
            contentDescription = null
        )
    }
}

private fun Modifier.width(model: ImageWidgetData.Dimension): Modifier = when (model) {
    ImageWidgetData.Dimension.FILL -> fillMaxWidth()
    ImageWidgetData.Dimension.NONE -> this
}

private fun Modifier.height(model: ImageWidgetData.Dimension): Modifier = when (model) {
    ImageWidgetData.Dimension.FILL -> fillMaxHeight()
    ImageWidgetData.Dimension.NONE -> this
}

private fun ImageWidgetData.Scale.toContentScale(): ContentScale = when (this) {
    ImageWidgetData.Scale.CROP -> ContentScale.Crop
    ImageWidgetData.Scale.FIT -> ContentScale.Fit
    ImageWidgetData.Scale.FILL_BOUNDS -> ContentScale.FillBounds
    ImageWidgetData.Scale.INSIDE -> ContentScale.Inside
}

@Composable
fun ScaleTypeRadioButton(
    imageScale: ImageWidgetData.Scale,
    updateScale: (ImageWidgetData.Scale) -> Unit
) {
    val state = remember { mutableStateOf(imageScale) }
    Column {
        contentTypeRadioGroupData.forEach { entry ->
            Row {
                RadioButton(selected = state.value == entry.key, onClick = {
                    state.value = entry.key
                    updateScale(entry.key)
                })
                Text(text = entry.value, modifier = Modifier.padding(start = 18.dp))
            }
        }
    }
}

val contentTypeRadioGroupData = mapOf(
    ImageWidgetData.Scale.CROP to "Crop",
    ImageWidgetData.Scale.FIT to "Fit",
    ImageWidgetData.Scale.FILL_BOUNDS to "Fill bounds",
    ImageWidgetData.Scale.INSIDE to "Inside",
)

@Parcelize
data class ImageWidgetData(
    @DrawableRes val drawableRes: Int,
    val scale: Scale,
    val width: Dimension,
    val height: Dimension,
    val label: String
) : Parcelable {
    @Parcelize
    enum class Scale : Parcelable {
        CROP,
        FIT,
        FILL_BOUNDS,
        INSIDE
    }

    @Parcelize
    enum class Dimension : Parcelable {
        FILL,
        NONE
    }
}