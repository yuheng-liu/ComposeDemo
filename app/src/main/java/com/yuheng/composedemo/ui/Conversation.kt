package com.yuheng.composedemo.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.yuheng.composedemo.Message
import com.yuheng.composedemo.MessageCard
import com.yuheng.composedemo.ui.theme.ComposeDemoTheme

@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) { message ->
            MessageCard(message)
        }
    }
}

@Preview
@Composable
fun PreviewConversation() {
    ComposeDemoTheme {
        Conversation(SampleData.conversationSample)
    }
}