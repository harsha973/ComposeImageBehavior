package com.example.imageviewcombinations

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun ImageWidgetsNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController,
        ImageWidgetScreens.HOME.name,
        modifier
    ) {
        composable(ImageWidgetScreens.HOME.name) {
            Home(
                onShowImageImageWidget = {
                    navigateToNonScrollableImageWidget(navController, it)
                },
                onShowScrollableImageWidget = {
                    navigateToScrollableWidget(navController)
                })
        }

        val nonScrollableArgument = "id"
        composable(
            ImageWidgetScreens.NON_SCROLLABLE_PARENT.name + "/{$nonScrollableArgument}",
            arguments = listOf(
                navArgument(nonScrollableArgument) { type = NavType.StringType }
            )) {
            val key = it.arguments?.getString(nonScrollableArgument) ?: return@composable
            val data = nonScrollableData[key] ?: return@composable
            ImageWidget(model = data)
        }

        composable(ImageWidgetScreens.SCROLLABLE_PARENT.name) {
            ScrollableParentWidget()
        }
    }
}

private fun navigateToNonScrollableImageWidget(
    navController: NavHostController,
    key: String
) {
    navController.navigate(ImageWidgetScreens.NON_SCROLLABLE_PARENT.name + "/${key}")
}

private fun navigateToScrollableWidget(navController: NavHostController) {
    navController.navigate(ImageWidgetScreens.SCROLLABLE_PARENT.name)
}

enum class ImageWidgetScreens {
    HOME,
    NON_SCROLLABLE_PARENT,
    SCROLLABLE_PARENT
}