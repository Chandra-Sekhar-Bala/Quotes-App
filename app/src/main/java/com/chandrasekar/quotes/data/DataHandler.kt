package com.chandrasekar.quotes.data

import androidx.compose.runtime.mutableStateOf
import com.chandrasekar.quotes.data.model.Quote
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object DataHandler {
    val isDataLoaded = mutableStateOf(false)
    val currentPage = mutableStateOf(Pages.LISTING)
    val data = mutableListOf<Quote>()
    var currentQuote: Quote? = null

    fun loadData() {
        CoroutineScope(Dispatchers.IO).launch {
            if (isDataLoaded.value) return@launch
            for (quoteItem in SAMPLE_QUOTE_DATA) {
                data.add(Quote(quoteItem.first, quoteItem.second))
            }
            isDataLoaded.value = true
        }
    }

    fun switchPages(quote: Quote?) {
        if (currentPage.value == Pages.LISTING) {
            currentPage.value = Pages.DETAIL
            currentQuote = quote
        } else {
            currentPage.value = Pages.LISTING
        }
    }
}

enum class Pages {
    LISTING, DETAIL
}