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

import android.content.res.Resources

internal inline val Float.dp: Float
    get() = this * Resources.getSystem().displayMetrics.density

internal inline val Int.dp: Float
    get() = this * Resources.getSystem().displayMetrics.density

internal inline val Float.sp: Float
    get() = this * Resources.getSystem().displayMetrics.scaledDensity

internal inline val Int.sp: Int
    get() = (this * Resources.getSystem().displayMetrics.scaledDensity).toInt()

internal inline val Float.dpInt: Int
    get() = dp.toInt()
