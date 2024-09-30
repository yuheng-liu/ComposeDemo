package com.yuheng.composedemo

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Path
import kotlin.math.abs

fun Path.standardQuadFromTo(from: Offset, to: Offset) {
    quadraticTo(
        from.x, from.y,
        abs(from.x + to.x) / 2f,
        abs(from.y + from.y) / 2f,
    )
}