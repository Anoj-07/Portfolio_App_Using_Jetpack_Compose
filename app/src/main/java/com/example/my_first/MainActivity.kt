package com.example.my_first

import android.os.Bundle
import android.text.style.BackgroundColorSpan
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Divider
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.LocalAbsoluteTonalElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.my_first.ui.theme.MY_FIRSTTheme
import org.w3c.dom.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MY_FIRSTTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CreateMY_FIRST()

                }
            }
        }
    }
}
//Composable File
@Composable
fun CreateMY_FIRST(){
    //variable for button
    val buttonClickedState = remember {
        mutableStateOf(false)
    }
Surface(modifier = Modifier
    .fillMaxWidth()
    .fillMaxHeight()) {

    //This is Card (INSIDE)

    Card(modifier=
    Modifier
        .width(200.dp)
        .height(390.dp)
        .padding(12.dp),
        shape = RoundedCornerShape(corner = CornerSize(15.dp)),
       colors = CardDefaults.cardColors(
           containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp) ) {

        //Coloum

        Column(modifier = Modifier.height(900.dp),
         verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally , ) {
            profile()
            Divider()
            Createinfo()


                Button(
                    onClick = {
                        buttonClickedState.value= !buttonClickedState.value
                    }) {
                    Text(text = "portfolio" ,
                        style = MaterialTheme.typography.headlineMedium)
                    
                }
            if (buttonClickedState.value){
                Content()
            }else{
                Box {

                }
            }

        }

    }
}
}
@Preview
@Composable
fun Content(){
    Box(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        .padding(5.dp)){
        Surface(modifier = Modifier
            .padding(2.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
            shape = RoundedCornerShape(corner = CornerSize(8.dp)),
            border = BorderStroke(width = 3.dp,
                color = Color.White
            )){
            Portfolio(data = listOf("Project 1" ,
                "Project 2",
                "Project 3",
                "Project 4",
                "Project 5",
                "Project 6",
               ))
        }


    }
}

@Composable
fun Portfolio(data: List<String>) {
    LazyColumn{
        items(data){
            item ->

            //card for each project

            Card(modifier = Modifier
                .padding(13.dp)
                .fillMaxWidth(),
                shape = RectangleShape,
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp)
                ){
                Row (modifier = Modifier
                    .padding(5.dp)) {
                    profile(modifier = Modifier.size(100.dp))
                    Column(
                        modifier = Modifier
                            .padding(7.dp)
                            .align(alignment = Alignment.CenterVertically)
                    ) {
                        Text(text = item, fontWeight = FontWeight.Bold)
                        Text(
                            text = "A great Project",
                            style = MaterialTheme.typography.bodyLarge
                        )

                    }
                }

                }

            }
        }
    }



@Composable
private fun Createinfo() {
    Column(modifier = Modifier.padding(5.dp)) {
        Text(
            text = "Anoj Rawal",
            style = MaterialTheme.typography.displayMedium,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "BTech student",
            modifier = Modifier.padding(3.dp),
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = "anojrawal12345@gmail.com",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(3.dp)
        )
    }
}


@Composable
private fun profile(modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        shadowElevation = 5.dp,
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
    ) {

        //This is for Image

        Image(
            painter = painterResource(id = R.drawable.hello),
            contentDescription = "profile image",
            modifier = modifier.size(135.dp),
            contentScale = ContentScale.Crop
        )

    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MY_FIRSTTheme {
        CreateMY_FIRST()

    }
}