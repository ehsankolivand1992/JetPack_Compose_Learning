package com.ehsankolivand.jetpackcomposelearning

import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintLayout
import com.ehsankolivand.jetpackcomposelearning.ui.theme.JetPackComposeLearningTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeLearningTheme {
                LoginBody()
            }
        }
    }

    @Composable
    fun LoginBody()
    {

        Column(modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        MaterialTheme.colors.primaryVariant,
                        MaterialTheme.colors.secondary
                    )

                )
            )
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally)
        {
            ConstraintLayout{
                val (logo,loginForm) = createRefs()
                Box(modifier = Modifier
                    .height(300.dp)
                    .constrainAs(logo) {
                        top.linkTo(loginForm.top)
                        bottom.linkTo(loginForm.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }) {
                    Image(
                        painter = painterResource(id = R.drawable.splashlogo),
                        contentDescription = "",
                        modifier = Modifier
                            .height(200.dp)
                            .width(200.dp)
                    )
                }
                Card(
                    shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp),
                    backgroundColor = MaterialTheme.colors.background,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 50.dp)
                        .constrainAs(loginForm) {
                            bottom.linkTo(loginForm.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        },
                    elevation = 10.dp
                ) {
                    ConstraintLayout(modifier = Modifier.background(MaterialTheme.colors.background)) {
                        val (refuser,refpass,refbutton,img) = createRefs()

                       Image(painter = painterResource(id = R.drawable.img), contentDescription ="logo",Modifier.constrainAs(img){
                           top.linkTo(parent.top)
                           bottom.linkTo(refuser.top)
                           start.linkTo(parent.start)
                           end.linkTo(parent.end)
                       } )
                        TextField(value = "", onValueChange = {},
                        modifier = Modifier
                            .constrainAs(refuser)
                            {
                                top.linkTo(img.top)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                            }
                            .fillMaxWidth()
                            .padding(9.dp, 20.dp, 9.dp, 10.dp)
                        )
                        TextField(value = "", onValueChange = {},
                            modifier = Modifier
                                .constrainAs(refpass)
                                {
                                    top.linkTo(refuser.bottom)
                                    start.linkTo(parent.start)
                                    end.linkTo(parent.end)
                                }
                                .fillMaxWidth()
                                .padding(9.dp, 0.dp, 9.dp, 10.dp),

                        )
                        Button(
                            onClick = { Toast.makeText(this@MainActivity,"salam",Toast.LENGTH_LONG).show() },
                            modifier = Modifier.constrainAs(refbutton) {
                                top.linkTo(refpass.bottom)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                            }) {
                            Text(text = "Login")
                        }


                    }
                }
            }


        }

    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        JetPackComposeLearningTheme {
            LoginBody()
        }
    }


}



