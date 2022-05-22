/*
 * Copyright 2022 Patryk Goworowski and Patryk Michalik
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

package com.patrykandpatryk.vico.sample.util

import com.patrykandpatryk.vico.R
import com.patrykandpatryk.vico.core.entry.ChartEntryModel
import com.patrykandpatryk.vico.core.entry.ChartEntryModelProducer
import com.patrykandpatryk.vico.core.entry.composed.ComposedChartEntryModelProducer
import com.patrykandpatryk.vico.sample.chart.ComposeColumnChart
import com.patrykandpatryk.vico.sample.chart.ComposeComposedChart
import com.patrykandpatryk.vico.sample.chart.ComposeLineChartWithLabelsInside
import com.patrykandpatryk.vico.sample.chart.ComposeStackedColumnChart
import com.patrykandpatryk.vico.sample.chart.ViewColumnChart
import com.patrykandpatryk.vico.sample.chart.compose.ComposeGroupedColumnChart
import com.patrykandpatryk.vico.sample.chart.compose.ComposeLineChart
import com.patrykandpatryk.vico.sample.chart.compose.ViewLineChart

internal fun getSampleCharts(
    chartEntryModelProducer: ChartEntryModelProducer,
    multiChartEntryModelProducer: ChartEntryModelProducer,
    composedChartEntryModelProducer: ComposedChartEntryModelProducer<ChartEntryModel>,
) = listOf(
    SampleChart(
        labelResourceId = R.string.line_chart_label,
        descriptionResourceId = R.string.line_chart_description,
        composeBased = { ComposeLineChart(chartEntryModelProducer = chartEntryModelProducer) },
        viewBased = { ViewLineChart(chartEntryModelProducer = chartEntryModelProducer) },
    ),
    SampleChart(
        labelResourceId = R.string.column_chart_label,
        descriptionResourceId = R.string.column_chart_description,
        composeBased = { ComposeColumnChart(chartEntryModelProducer = chartEntryModelProducer) },
        viewBased = { ViewColumnChart(chartEntryModelProducer = chartEntryModelProducer) },
    ),
    SampleChart(
        labelResourceId = R.string.composed_chart_label,
        descriptionResourceId = R.string.composed_chart_description,
        composeBased = { ComposeComposedChart(composedChartEntryModelProducer = composedChartEntryModelProducer) },
        viewBased = {},
    ),
    SampleChart(
        labelResourceId = R.string.stacked_column_chart_label,
        descriptionResourceId = R.string.stacked_column_chart_description,
        composeBased = { ComposeStackedColumnChart(chartEntryModelProducer = multiChartEntryModelProducer) },
        viewBased = {},
    ),
    SampleChart(
        labelResourceId = R.string.grouped_column_chart_label,
        descriptionResourceId = R.string.grouped_column_chart_description,
        composeBased = { ComposeGroupedColumnChart(chartEntryModelProducer = multiChartEntryModelProducer) },
        viewBased = {},
    ),
    SampleChart(
        labelResourceId = R.string.line_chart_with_labels_inside_label,
        descriptionResourceId = R.string.line_chart_with_labels_inside_description,
        composeBased = { ComposeLineChartWithLabelsInside(chartEntryModelProducer = multiChartEntryModelProducer) },
        viewBased = {},
    ),
)
