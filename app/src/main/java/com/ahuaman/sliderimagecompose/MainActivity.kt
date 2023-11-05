package com.ahuaman.sliderimagecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ahuaman.sliderimagecompose.ui.theme.SliderImageComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SliderImageComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SliderImageComposable() {

    val pageCount by remember {
        mutableStateOf(listOf<Color>(
            Color.Red,
            Color.Green,
            Color.Blue,
            Color.Yellow,
            Color.Cyan,
            Color.Magenta,
            Color.Gray,
            Color.LightGray,
            Color.DarkGray,
            Color.Black,
            Color.White
        ))
    }

    val pagerState = rememberPagerState(
        initialPageOffsetFraction = 0f,
        initialPage = 0
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPager(
            pageCount = pageCount.size,
            state = pagerState,
            contentPadding = PaddingValues(50.dp),
        ) { page ->
            // Our page content
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .height(200.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(pageCount[page].value)
                ),
                shape = RoundedCornerShape(8.dp),
            ){
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Text(
                        text = "Page: $page",
                        textAlign = TextAlign.Center
                    )
                }

            }
        }
    }


}


@Preview
@Composable
fun SliderPrev() {
    SliderImageComposable()
}
