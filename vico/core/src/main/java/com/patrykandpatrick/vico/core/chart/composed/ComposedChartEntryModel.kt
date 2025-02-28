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

package com.patrykandpatrick.vico.core.chart.composed

import com.patrykandpatrick.vico.core.entry.ChartEntryModel

/**
 * An extended [ChartEntryModel] that can compose multiple [ChartEntryModel]s. It is used by [ComposedChart].
 */
public interface ComposedChartEntryModel<Model : ChartEntryModel> : ChartEntryModel {

    /**
     * A list of the [ChartEntryModel]s that make up this model.
     */
    public val composedEntryCollections: List<Model>
}
