package com.yuheng.composedemo

import android.view.MotionEvent
import android.widget.TextView
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.boundsInWindow
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintLayoutScope
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.yuheng.composedemo.ui.theme.ComposeDemoTheme
import kotlinx.coroutines.launch
import kotlin.math.PI
import kotlin.math.atan2
import kotlin.random.Random

@Composable
fun MyApp(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.background
    ) {
        Greeting("Android")
    }
}

@Composable
fun TextView() {
    Column(
        modifier = Modifier
            .background(Color.Green)
            .fillMaxHeight(0.5f)
            .fillMaxWidth()
            .border(5.dp, Color.Magenta)
            .padding(5.dp)
            .border(5.dp, Color.Cyan)
            .padding(5.dp)
    ) {
        Text("Hello")
        Spacer(modifier = Modifier.height(50.dp))
        Text("World")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Surface(color = MaterialTheme.colorScheme.primary) {
        Column(modifier = modifier.padding(24.dp)) {
            Text(text = "Hello")
            Text(text = name)
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    ComposeDemoTheme {
//        MyApp()
//    }
//}

@Composable
fun ImageCard() {
    val painter = painterResource(id = R.drawable.dice)
    val title = "This is a image shown in an image card"
    Box(modifier = Modifier
        .fillMaxSize(0.75f)
        .padding(15.dp)
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        ) {
            Box(modifier = Modifier.height(200.dp)) {
                Image(
                    painter = painter,
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    Color.Black
                                ),
                                startY = 300f
                            )
                        )
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(12.dp),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Text(title, style = TextStyle(color = Color.White, fontSize = 16.sp))
                }
            }
        }
    }
}

@Composable
fun TextView(modifier: Modifier = Modifier) {
    val fontFamily = FontFamily(
        Font(R.font.roboto_thin, FontWeight.Thin),
        Font(R.font.roboto_light, FontWeight.Thin),
        Font(R.font.roboto_regular, FontWeight.Thin),
        Font(R.font.roboto_medium, FontWeight.Thin),
        Font(R.font.roboto_bold, FontWeight.Thin),
        Font(R.font.roboto_black, FontWeight.Thin),
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF101010))
    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.Green, fontSize = 50.sp)) {
                    append("J")
                }
                append("etpack ")
                withStyle(style = SpanStyle(color = Color.Green, fontSize = 50.sp)) {
                    append("C")
                }
                append("ompose")
            },
            color = Color.White,
            fontSize = 30.sp,
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            textDecoration = TextDecoration.Underline
        )
    }
}

@Composable
fun StateColorBox(modifier: Modifier = Modifier) {
    @Composable
    fun ColorBox(modifier: Modifier = Modifier, updateColor: (Color) -> Unit) {
        Box(modifier = modifier
            .background(Color.Red)
            .clickable {
                updateColor(
                    Color(
                        Random.nextFloat(),
                        Random.nextFloat(),
                        Random.nextFloat(),
                        1f
                    )
                )
            }
        )
    }

    Column(Modifier.fillMaxSize()) {
        val color = remember {
            mutableStateOf(Color.Yellow)
        }
        ColorBox(
            Modifier
                .weight(1f)
                .fillMaxSize()) {
            color.value = it
        }
        Box(
            modifier = Modifier
                .background(color.value)
                .weight(1f)
                .fillMaxSize()
        )
    }
}

@Composable
fun TextFieldWithSnackbar(modifier: Modifier = Modifier) {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    var textFieldState by remember { mutableStateOf("") }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        modifier = Modifier.fillMaxSize(),
    ) { padding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            TextField(
                value = textFieldState,
                label = { Text(text = "Enter your name") },
                onValueChange = { textFieldState = it },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                scope.launch { snackbarHostState.showSnackbar(textFieldState) }
            }) {
                Text(text = "Please greet me")
            }
        }
    }
}

@Composable
fun LazyColumn(modifier: Modifier = Modifier) {
    LazyColumn {
//        items(5000) {}
        itemsIndexed(
            listOf("This", "is", "Jetpack", "Compose")
        ) { _, item ->
            Text(
                text = item,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp)
            )
        }
    }
}

@Composable
fun ConstraintLayout(modifier: Modifier = Modifier) {
    val constraint = ConstraintSet {
        val greenBox = createRefFor("greenbox")
        val redBox = createRefFor("redbox")
        val guideLine = createGuidelineFromTop(0.5f)

        constrain(greenBox) {
            top.linkTo(guideLine)
            start.linkTo(parent.start)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }
        constrain(redBox) {
            top.linkTo(parent.top)
            start.linkTo(greenBox.end)
            end.linkTo(parent.end)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }
        createHorizontalChain(greenBox, redBox)
    }
    ConstraintLayout(
        constraintSet = constraint,
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .background(Color.Green)
                .layoutId("greenbox")
        )
        Box(
            modifier = Modifier
                .background(Color.Red)
                .layoutId("redbox")
        )
    }
}

@Composable
fun Animations(modifier: Modifier = Modifier) {
    var sizeState by remember { mutableStateOf(200.dp) }
    val size by animateDpAsState(
        targetValue = sizeState,
//                animationSpec = tween(
//                    durationMillis = 3000,
//                    delayMillis = 300,
//                    easing = LinearOutSlowInEasing,
//                )
        animationSpec = keyframes {
            durationMillis = 5000
            sizeState at 0 using LinearEasing
            sizeState * 1.5f at 1000 using FastOutLinearInEasing
            sizeState * 2f at 5000
        }
    )
    val infiniteTransition = rememberInfiniteTransition()
    val color by infiniteTransition.animateColor(
        initialValue = Color.Red,
        targetValue = Color.Green,
        animationSpec = infiniteRepeatable(tween(durationMillis = 2000), repeatMode = RepeatMode.Reverse)
    )

    Box(modifier = Modifier
        .size(size)
        .background(color),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = { sizeState += 50.dp }) {
            Text(text = "Increase Size")
        }
    }
}

@Composable
fun CircularProgressBar(
    percentage: Float,
    number: Int,
    fontSize: TextUnit = 28.sp,
    radius: Dp = 50.dp,
    color: Color = Color.Green,
    strokeWidth: Dp = 8.dp,
    animDuration: Int = 1000,
    animDelay: Int = 0,
) {
    var animationPlayed by remember {
        mutableStateOf(false)
    }
    var curPercentage = animateFloatAsState(
        targetValue = if (animationPlayed) percentage else 0f,
        animationSpec = tween(
            durationMillis = animDuration,
            delayMillis = animDelay
        )
    )
    LaunchedEffect(key1 = true) {
        animationPlayed = true
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.size(radius * 2f)
        ) {
            Canvas(modifier = Modifier.size(radius * 2f)) {
                drawArc(
                    color = color,
                    startAngle = -90f,
                    sweepAngle = 360 * curPercentage.value,
                    useCenter = false,
                    style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
                )
            }
            Text(
                text = (curPercentage.value * number).toInt().toString(),
                color = Color.Black,
                fontSize = fontSize,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { animationPlayed = !animationPlayed }
        ) {
            Text(text = "Button")
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun MusicKnob(
    modifier: Modifier = Modifier,
    limitingAngle: Float = 25f,
    onValueChange: (Float) -> Unit
) {
    var rotation by remember {
        mutableStateOf(limitingAngle)
    }
    var touchX by remember {
        mutableStateOf(0f)
    }
    var touchY by remember {
        mutableStateOf(0f)
    }
    var centerX by remember {
        mutableStateOf(0f)
    }
    var centerY by remember {
        mutableStateOf(0f)
    }

    Image(
        painter = painterResource(id = R.drawable.music_knob),
        contentDescription = "Music Knob",
        modifier = Modifier.fillMaxSize()
            .onGloballyPositioned {
                centerX = it.boundsInWindow().size.width / 2f
                centerY = it.boundsInWindow().size.height / 2f
            }
            .pointerInteropFilter { event ->
                touchX = event.x
                touchY = event.y
                val angle = -atan2(centerX - touchX, centerY - touchY) * (180f / PI).toFloat()

                when (event.action) {
                    MotionEvent.ACTION_DOWN,
                    MotionEvent.ACTION_MOVE -> {
                        if (angle !in -limitingAngle..limitingAngle) {
                            val fixedAngle = if (angle in -180f..-limitingAngle) {
                                360f + angle
                            } else {
                                angle
                            }
                            rotation = fixedAngle

                            val percent = (fixedAngle - limitingAngle) / (360f - 2 * limitingAngle)
                            onValueChange(percent)
                            true
                        } else false
                    }
                    else -> false
                }
            }
            .rotate(rotation)
    )
}