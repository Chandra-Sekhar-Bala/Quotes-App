package com.chandrasekar.quotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.chandrasekar.quotes.data.DataHandler
import com.chandrasekar.quotes.data.Pages
import com.chandrasekar.quotes.ui.screens.QuoteItemDetails
import com.chandrasekar.quotes.ui.screens.QuoteListing
import com.chandrasekar.quotes.ui.theme.QuotesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataHandler.loadData()
        setContent {
            QuotesTheme {
                App()
            }
        }
        
    }
}

@Composable
fun App() {
    if (DataHandler.isDataLoaded.value) {
        when (DataHandler.currentPage.value) {

            Pages.LISTING -> {
                QuoteListing(quotes = DataHandler.data) {
                    DataHandler.switchPages(it)
                }
            }

            Pages.DETAIL -> {
                DataHandler.currentQuote?.let { QuoteItemDetails(quote = it) }
            }
        }
    } else {


    }
}