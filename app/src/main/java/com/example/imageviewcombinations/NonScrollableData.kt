package com.example.imageviewcombinations


enum class NonScrollableKeys {
    WidthFillHeightFill,
    WidthFillHeightNone,
    WidthHeightNone
}

val nonScrollableData = mapOf(
    NonScrollableKeys.WidthFillHeightFill.name to ImageWidgetData(
        drawableRes = R.drawable.airpoint_deals,
        scale = ImageWidgetData.Scale.CROP,
        width = ImageWidgetData.Dimension.FILL,
        height = ImageWidgetData.Dimension.FILL,
        label = "Width - fill, height - fill"
    ),

    NonScrollableKeys.WidthHeightNone.name to ImageWidgetData(
        drawableRes = R.drawable.airpoint_deals,
        scale = ImageWidgetData.Scale.CROP,
        width = ImageWidgetData.Dimension.FILL,
        height = ImageWidgetData.Dimension.NONE,
        label = "Width - fill, height - not mentioned"
    ),

    NonScrollableKeys.WidthFillHeightNone.name to ImageWidgetData(
        drawableRes = R.drawable.airpoint_deals,
        scale = ImageWidgetData.Scale.CROP,
        width = ImageWidgetData.Dimension.NONE,
        height = ImageWidgetData.Dimension.NONE,
        label = "Width, height - not mentioned"
    )
)
