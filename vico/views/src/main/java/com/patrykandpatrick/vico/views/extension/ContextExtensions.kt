/*
 * Copyright 2022 by Patryk Goworowski and Patrick Michalik.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.patrykandpatrick.vico.views.extension

import android.content.Context
import android.content.res.Configuration
import android.os.Build
import androidx.core.view.ViewCompat
import com.patrykandpatrick.vico.core.DefaultColors

internal val Context.density: Float
    get() = resources.displayMetrics.density

internal val Context.fontScale: Float
    get() = resources.displayMetrics.scaledDensity

internal val Context.isLtr: Boolean
    get() = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
        resources.configuration.layoutDirection == ViewCompat.LAYOUT_DIRECTION_LTR
    } else {
        true
    }

internal val Context.isDarkMode: Boolean
    get() = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES

internal val Context.defaultColors: DefaultColors
    get() = if (isDarkMode) DefaultColors.Dark else DefaultColors.Light
