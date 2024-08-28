package template.app.screens.details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import template.app.components.LaunchCard
import template.app.components.LaunchDTO

class DetailsScreen(
    private val launch: LaunchDTO
) : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        Scaffold(
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        navigator.pop()
                    },
                    content = {
                        Text("Back")
                    }
                )
            }
        ) { paddingValues ->
            Box(modifier = Modifier.padding(paddingValues)) {
                LaunchCard(
                    launch
                )
            }

        }
    }
}