package com.ehsankolivand.jetpackcomposelearning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDirection.Companion.Content
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ehsankolivand.jetpackcomposelearning.ui.theme.JetPackComposeLearningTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GradientBackgorund()
            Box {
                CoroutineScope(Dispatchers.Main).launch {
                    delay(3000)
                    val intent = Intent(this@SplashActivity,MainActivity::class.java)
                   startActivity(intent)
                    finish()
                }
            }
        }
    }

    @Preview
    @Composable
    fun GeneratePreview()
    {
        GradientBackgorund()
       Box {
           CoroutineScope(Dispatchers.Main).launch {
               delay(4000)
               val intent = Intent(this@SplashActivity,MainActivity::class.java)

           }
       }
    }

}

@Composable
fun GradientBackgorund()
{
    JetPackComposeLearningTheme {
        Box(
            modifier = Modifier
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            MaterialTheme.colors.primaryVariant,
                            MaterialTheme.colors.secondary
                        )

                    )
                )
                .fillMaxSize()
        ) {
            Image(painter = painterResource(id = R.drawable.splashlogo)
                , contentDescription = "",modifier = Modifier
                    .align(Alignment.Center)
                    .height(100.dp)
                    .width(100.dp).rotate(260f))


        }
    }

}
