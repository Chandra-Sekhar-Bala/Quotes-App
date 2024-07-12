package com.chandrasekar.quotes.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material.icons.outlined.FormatQuote
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chandrasekar.quotes.R
import com.chandrasekar.quotes.ui.Colors.Colors

@Composable
fun QuoteListItem(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .padding(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                imageVector = Icons.Outlined.FormatQuote,
                contentDescription = "An image representing quote icon",
                colorFilter = ColorFilter.tint(Colors.Violet),
                modifier = Modifier
                    .size(50.dp)
                    .rotate(180f)
            )
            Spacer(modifier = Modifier.padding(10.dp))
            Column {
                Text(
                    text = "Hello brother, how do you do??",
                    style = MaterialTheme.typography.titleLarge,
                    color = Color.Black,
                    modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 8.dp),
                    fontFamily = FontFamily(Font(R.font.outfit_medium))
                )

                Box(
                    modifier = Modifier
                        .height(1.dp)
                        .fillMaxWidth(.5f)
                        .background(color = Color.Gray)
                )

                Text(
                    text = "Chandra Sekhar Bala",
                    style = MaterialTheme.typography.titleSmall,
                    color = Color.DarkGray,
                    modifier = Modifier.padding(0.dp, 3.dp, 0.dp, 0.dp),
                    fontFamily = FontFamily(Font(R.font.outfit_regular))
                )
            }
        }

    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewQuoteDetails(modifier: Modifier = Modifier) {
    QuoteItemDetails(modifier)
//    QuoteListItem(modifier)
}

@Composable
fun QuoteItemDetails(modifier: Modifier) {
    Box(
        contentAlignment = Alignment.Center, modifier = modifier
            .fillMaxSize(1f)
            .background(
                Brush.sweepGradient(
                    colors = listOf(
                        Colors.Violet, Color.White
                    )
                )
            )
    ) {
        Card(
            modifier = Modifier
                .padding(32.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp
            ),
        ) {

            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(16.dp, 24.dp),
            ) {
                Image(
                    imageVector = Icons.Filled.FormatQuote,
                    contentDescription = "Image representing quote",
                    modifier = Modifier
                        .size(70.dp),
                    colorFilter = ColorFilter.tint(Color.Black)
                )
                Text(
                    text = "Bohot hard bohot hard bro bro",
                    style = MaterialTheme.typography.headlineLarge,
                    fontFamily = FontFamily(Font(R.font.outfit_bold)),
                    modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 8.dp)
                )
                Box(
                    modifier = Modifier
                        .height(0.6.dp)
                        .fillMaxWidth(.7f)
                        .background(color = Color.Black)
                )
                Text(
                    text = "Author name",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(0.dp, 4.dp, 0.dp, 0.dp),
                    fontFamily = FontFamily(Font(R.font.outfit_regular)),
                )
            }
        }
    }

}