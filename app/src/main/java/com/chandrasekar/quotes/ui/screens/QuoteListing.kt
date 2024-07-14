package com.chandrasekar.quotes.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.chandrasekar.quotes.R
import com.chandrasekar.quotes.data.model.Quote

@Composable
fun QuoteListing(quotes: List<Quote>, onClick: (Quote) -> Unit) {
    val listState = rememberLazyListState()
    Column {
        Text(
            text = "Quotes App",
            style = MaterialTheme.typography.titleLarge,
            color = Color.Black,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(8.dp, 24.dp),
            fontFamily = FontFamily(Font(R.font.outfit_medium))
        )
        LazyColumn(state = listState) {
            items(quotes) {
                QuoteListItem(quote = it, onClick)
            }
        }
    }
}