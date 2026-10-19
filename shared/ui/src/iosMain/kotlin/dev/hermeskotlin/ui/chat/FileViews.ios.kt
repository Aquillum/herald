package dev.hermeskotlin.ui.chat

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier

/** No PDF pages drawn in Herald on iOS yet: the viewer says so and offers Save and Share. */
@Composable
internal actual fun rememberPdfOpener(): suspend (ByteArray) -> PdfOpen =
    { PdfOpen.Failed("PDFs don't open in Herald on iOS yet. Save or share it instead.") }

/** No web view for inline widgets on iOS yet: the card shows why instead. */
@Composable
internal actual fun WidgetWebView(html: String, theme: WidgetTheme, name: String, modifier: Modifier, onFailure: (String) -> Unit) {
    val failure = rememberUpdatedState(onFailure)
    LaunchedEffect(Unit) { failure.value("Widgets don't show on iOS yet.") }
}
