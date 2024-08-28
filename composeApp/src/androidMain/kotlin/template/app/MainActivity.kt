package template.app

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            App()
        }
    }

}

@Preview(wallpaper = Wallpapers.GREEN_DOMINATED_EXAMPLE,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    showSystemUi = true, showBackground = true, fontScale = 2.0f, apiLevel = 31,
    device = "spec:parent=pixel_4a", name = "ghgh"
)
@Composable
fun UserName(){
    Text(text = "Hello", style = TextStyle(
        fontSize = 46.sp,
        color = Color.Red
    ))
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}