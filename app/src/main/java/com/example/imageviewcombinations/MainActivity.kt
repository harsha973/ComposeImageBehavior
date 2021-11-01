package com.example.imageviewcombinations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.imageviewcombinations.ui.theme.ImageViewCombinationsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            ImageViewCombinationsTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    ImageWidgetsNavHost(navController = navController)
                }

//                Surface(color = MaterialTheme.colors.background) {
//                    Column {
//                        // Image widget
//                        //    - width, height - not mentioned
//                        //    - parent - non-scrollable
//
//                        Text(text = "Width, height - not mentioned, parent - non-scrollable")
//                        Box(modifier = Modifier.background(color = Color.Cyan)) {
//                            ImageWidget(model = imageData)
//                        }
//
//                        Spacer(modifier = Modifier.size(16.dp))
//
//                        // Plain Image widget
//                        //    - width - Fit, height - not mentioned
//                        //    - parent - non-scrollable
//                        Text(text = "Width - fill, height - not mentioned, parent - non-scrollable")
//                        Box(modifier = Modifier.background(color = Color.Cyan)) {
//                            ImageWidget(
//                                modifier = Modifier.fillMaxWidth(), // fill width
//                                model = imageData
//                            )
//                        }
//
//                        Spacer(modifier = Modifier.size(16.dp))
//
//                        // Plain Image widget
//                        //    - width - Fit, height - not mentioned
//                        //    - parent - non-scrollable
//                        Text(text = "Width - fill, height - fill, parent - non-scrollable")
//                        Box(modifier = Modifier.background(color = Color.Cyan)) {
//                            ImageWidget(
//                                modifier = Modifier
//                                    .fillMaxWidth()
//                                    .fillMaxHeight(), // fill width, height
//                                model = imageData
//                            )
//                        }
//                    }
//                }
            }
        }
    }
}

//val imageData = ImageWidgetData(
//    drawableRes = R.drawable.airpoint_deals,
//    scale = ImageWidgetData.Scale.CROP
//)
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    ImageViewCombinationsTheme {
//        ImageWidget(model = imageData)
//    }
//}

//Scenarios


// Plain Image widget
//    - width - Fit, height - not mentioned
//    - parent - non-scrollable
