package com.chandrasekar.quotes

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import com.chandrasekar.quotes.data.DataHandler
import com.chandrasekar.quotes.data.Pages
import com.chandrasekar.quotes.data.model.Quote
import com.chandrasekar.quotes.ui.screens.QuoteDetails
import com.chandrasekar.quotes.ui.screens.QuoteListing
import com.chandrasekar.quotes.ui.theme.QuotesTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        DataHandler.loadData()
        setContent {
            QuotesTheme {
                App()
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
                    DataHandler.currentQuote?.let {
                        QuoteDetails(quote = it) { quote ->
                            copyToClipboard(quote)
                        }
                    }
                }
            }
        }
    }

    private fun copyToClipboard(quote: Quote) {
        val text = "${quote.quote}\n - ${quote.author}"
        val clipboardManager = this.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clipData = ClipData.newPlainText("Quote", text)
        clipboardManager.setPrimaryClip(clipData)
    }

}