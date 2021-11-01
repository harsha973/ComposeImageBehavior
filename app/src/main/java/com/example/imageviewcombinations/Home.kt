package com.example.imageviewcombinations

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Home(
    onShowImageImageWidget: (String) -> Unit,
    onShowScrollableImageWidget: () -> Unit,
) {
    val scrollableParentKey = "In scrollable parent"

    val list = nonScrollableData.keys.toMutableList().apply {
        add(scrollableParentKey)
    }

    LazyColumn(
        modifier = Modifier.fillMaxHeight(),
    ) {
        items(items = list, itemContent = { key ->
            if(key == scrollableParentKey) {
                Text(
                    text = scrollableParentKey,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            onShowScrollableImageWidget()
                        }
                        .padding(12.dp)
                )
            } else {
                val label = nonScrollableData[key]?.label ?: return@items
                Text(
                    text = label,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            onShowImageImageWidget(key)
                        }
                        .padding(12.dp)
                )
            }

            Divider()
        })
    }
}