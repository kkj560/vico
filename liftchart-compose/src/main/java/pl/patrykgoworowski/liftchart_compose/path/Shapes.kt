package pl.patrykgoworowski.liftchart_compose.data_set.bar.path

import android.graphics.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.asAndroidPath
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.Dp
import pl.patrykgoworowski.liftchart_common.path.CutCornerBarPath
import pl.patrykgoworowski.liftchart_common.path.RoundedCornersShape
import pl.patrykgoworowski.liftchart_common.path.Shape
import pl.patrykgoworowski.liftchart_compose.extension.density
import androidx.compose.ui.graphics.Shape as ComposeShape

@Composable
fun ComposeShape.chartShape(): Shape = object : Shape {

    val layoutDirection = LocalLayoutDirection.current
    val density = LocalDensity.current

    private val radii by lazy { FloatArray(8) }
    private val matrix: Matrix by lazy { Matrix() }

    override fun drawShape(canvas: Canvas, paint: Paint, path: Path, bounds: RectF) {
        val outline = createOutline(
            size = Size(
                width = bounds.width(),
                height = bounds.height()
            ),
            layoutDirection = layoutDirection,
            density = density,
        )
        when (outline) {
            is Outline.Rectangle -> path.addRect(bounds.left, bounds.top, bounds.right, bounds.bottom, Path.Direction.CCW)
            is Outline.Rounded -> path.addRoundRect(bounds, outline.roundRect, radii)
            is Outline.Generic -> {
                matrix.setTranslate(bounds.left, bounds.top)
                path.addPath(outline.path.asAndroidPath(), matrix)
            }
        }
        canvas.drawPath(path, paint)
    }
}

fun Path.addRoundRect(bounds: RectF, rect: RoundRect, radii: FloatArray) {
    radii[0] = rect.topLeftCornerRadius.x
    radii[1] = rect.topLeftCornerRadius.y
    radii[2] = rect.topRightCornerRadius.x
    radii[3] = rect.topRightCornerRadius.y
    radii[4] = rect.bottomRightCornerRadius.x
    radii[5] = rect.bottomRightCornerRadius.y
    radii[6] = rect.bottomLeftCornerRadius.x
    radii[7] = rect.bottomLeftCornerRadius.y
    addRoundRect(bounds.left, bounds.top, bounds.right, bounds.bottom, radii, Path.Direction.CCW)
}

@Composable
fun roundedCornerBarPath(
    all: Dp = Dp(0f),
): Shape = RoundedCornersShape(all.value * density)

@Composable
fun roundedCornerBarPath(
    topLeft: Dp = Dp(0f),
    topRight: Dp = Dp(0f),
    bottomRight: Dp = Dp(0f),
    bottomLeft: Dp = Dp(0f),
): Shape = RoundedCornersShape(
    topLeft.value * density,
    topRight.value * density,
    bottomRight.value * density,
    bottomLeft.value * density
)

@Composable
fun cutCornerBarPath(
    all: Dp = Dp(0f),
): Shape = CutCornerBarPath(all.value * density)

@Composable
fun cutCornerBarPath(
    topLeft: Dp = Dp(0f),
    topRight: Dp = Dp(0f),
    bottomRight: Dp = Dp(0f),
    bottomLeft: Dp = Dp(0f),
): Shape = CutCornerBarPath(
    topLeft.value * density,
    topRight.value * density,
    bottomRight.value * density,
    bottomLeft.value * density
)