package template.app.launches.screens.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.koinScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import template.app.launches.components.LaunchCard
import template.app.launches.screens.details.DetailsScreen

class LaunchScreen : Screen {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val viewModel = koinScreenModel<LaunchScreenModel>()
        val state by viewModel.state.collectAsState()
        val failure by viewModel.failure.collectAsState()
        viewModel.fetchItems()

        if (failure) {
            BasicAlertDialog(
                onDismissRequest = {

                },
                content = {
                    Text("Failed")
                }
            )
        }
        Scaffold(
            floatingActionButtonPosition = FabPosition.Center,
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        navigator.pop()
                    },
                    content = {
                        Text(
                            "Click Me",
                            modifier = Modifier.padding(horizontal = 6.dp)
                        )
                    }
                )
            },
            topBar = {
                TopAppBar(
                    title = {
                        Text("Main Screen")
                    }
                )
            }
        ) { padding ->
            if (state.isEmpty() && !failure) {
                CircularProgressIndicator(
                    modifier = Modifier.padding(padding)
                )
            } else {
                LazyColumn(
                    contentPadding = PaddingValues(all = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.padding(padding)
                ) {
                    items(state) { item ->
                        LaunchCard(
                            item = item,
                            onItemClicked = { clickedItem ->
                                navigator.push(DetailsScreen(clickedItem))
                            })
                    }
                }
            }

        }
    }
}

