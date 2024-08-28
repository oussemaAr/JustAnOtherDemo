package template.app.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Done
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.aakira.napier.Napier
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import template.app.theme.onErrorLight
import template.app.theme.secondaryLight

data class LaunchDTO(
    val imageUrl: String,
    val title: String,
    val description: String,
    val status: Boolean,
)

@Composable
fun LaunchCard(
    item: LaunchDTO,
    modifier: Modifier = Modifier,
    onItemClicked: (LaunchDTO) -> Unit = {}
) {
    Card(
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp),
        modifier = modifier
            .clickable {
                onItemClicked(item)
            }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            val painter = asyncPainterResource(item.imageUrl)
            KamelImage(
                resource = painter,
                contentDescription = "Launch Image",
                onFailure = {
                    Napier.e("Image Failed")
                },
                onLoading = {
                    CircularProgressIndicator()
                },
                modifier = Modifier
                    .size(48.dp)
                    .padding(end = 6.dp)
            )
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    item.title,
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                )
                Text(
                    item.description,
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Light
                    )
                )
            }
            Icon(
                imageVector = if (item.status) Icons.Rounded.Done else Icons.Rounded.Info,
                contentDescription = "Launch State",
                tint = if (item.status) secondaryLight else onErrorLight
            )
        }
    }
}