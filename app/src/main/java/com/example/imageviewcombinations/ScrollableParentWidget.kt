package com.example.imageviewcombinations

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ScrollableParentWidget() {
    val keys = scrollableData.keys.toList()

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.fillMaxHeight()
    ) {
        items(items = keys, itemContent = { key ->
            val item = nonScrollableData[key] ?: return@items
            ImageWidget(model = item)
            Divider(modifier = Modifier.padding(vertical = 12.dp))
        })
    }
}


enum class ScrollableKeys {
    WidthFillHeightFill,
    WidthFillHeightNone,
    WidthHeightNone,
    WidthNoneHeightFill, // crashing
}

val scrollableData = mapOf(
    ScrollableKeys.WidthFillHeightFill.name to ImageWidgetData(
        drawableRes = R.drawable.airpoint_deals,
        scale = ImageWidgetData.Scale.CROP,
        width = ImageWidgetData.Dimension.FILL,
        height = ImageWidgetData.Dimension.FILL,
        label = "Width - FILL, height - FILL"
    ),

    ScrollableKeys.WidthHeightNone.name to ImageWidgetData(
        drawableRes = R.drawable.airpoint_deals,
        scale = ImageWidgetData.Scale.CROP,
        width = ImageWidgetData.Dimension.FILL,
        height = ImageWidgetData.Dimension.NONE,
        label = "Width - FILL, height - NONE"
    ),

    ScrollableKeys.WidthFillHeightNone.name to ImageWidgetData(
        drawableRes = R.drawable.airpoint_deals,
        scale = ImageWidgetData.Scale.CROP,
        width = ImageWidgetData.Dimension.NONE,
        height = ImageWidgetData.Dimension.NONE,
        label = "Width, height - NONE"
    ),

    // CRASHING
//    ScrollableKeys.WidthNoneHeightFill.name to ImageWidgetData(
//        drawableRes = R.drawable.airpoint_deals,
//        scale = ImageWidgetData.Scale.CROP,
//        width = ImageWidgetData.Dimension.NONE,
//        height = ImageWidgetData.Dimension.FILL,
//        label = "Width - NONE, height - FILL"
//    )
)