/**
 * Copyright (c) 2011-2013, kidzhou 周磊 (zhouleib1412@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jfinal.ext.render.chart.funshion;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.jfinal.kit.StrKit;

public class GraphChart {
    /**
     */
    private String caption;
    /**
     */
    private String subcaption;
    /**
     */
    private String bgColor;
    /**
     */
    private String divLineColor;

    /**
     */
    private String numberPrefix = "";

    /**
     */
    private String numberSuffix = "";
    /**
     */

    private String pYAxisName = "";

    /**
     */
    private String sNumberSuffix = "";
    /**
     */
    private String sYAxisName = "";
    /**
     */
    private List<String> labels;
    /**
     */
    private List<String> leftSeriesNames;
    /**
     */
    private List<String> rightSeriesNames;
    /**
     */
    private List<String> colors;
    /**
     */
    private List<List<String>> leftValues;

    /**
     */
    private List<List<String>> rightValues;

    /**
     */
    private String charUrl;
    /**
     */
    private String charWidth;

    /**
     */
    private String charHigh;

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getSubcaption() {
        return subcaption;
    }

    public void setSubcaption(String subcaption) {
        this.subcaption = subcaption;
    }

    public String getBgColor() {
        if (StrKit.isBlank(bgColor)) {
            bgColor = genColor();
        }
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    public String getDivLineColor() {
        if (StrKit.isBlank(bgColor)) {
            divLineColor = genColor();
        }
        return divLineColor;
    }

    public void setDivLineColor(String divLineColor) {
        this.divLineColor = divLineColor;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public List<String> getColors() {
        if (colors == null) {
            colors = new ArrayList<String>();
            for (int i = 0; i < leftValues.size(); i++) {
                colors.add(genColor());
            }
        }

        return colors;
    }

    public void setColors(List<String> colors) {
        this.colors = colors;
    }

    public String getCharUrl() {
        return charUrl;
    }

    public void setCharUrl(String charUrl) {
        this.charUrl = charUrl;
    }

    public String getCharWidth() {
        return charWidth;
    }

    public void setCharWidth(String charWidth) {
        this.charWidth = charWidth;
    }

    public String getCharHigh() {
        return charHigh;
    }

    public void setCharHigh(String charHigh) {
        this.charHigh = charHigh;
    }

    public String getNumberPrefix() {
        return numberPrefix;
    }

    public void setNumberPrefix(String numberPrefix) {
        this.numberPrefix = numberPrefix;
    }

    public String getpYAxisName() {
        return pYAxisName;
    }

    public void setpYAxisName(String pYAxisName) {
        this.pYAxisName = pYAxisName;
    }

    public String getsNumberSuffix() {
        return sNumberSuffix;
    }

    public void setsNumberSuffix(String sNumberSuffix) {
        this.sNumberSuffix = sNumberSuffix;
    }

    public String getsYAxisName() {
        return sYAxisName;
    }

    public void setsYAxisName(String sYAxisName) {
        this.sYAxisName = sYAxisName;
    }

    private String genColor() {
        Random random = new Random();
        String rgb = "";
        for (int i = 0; i < 6; i++) {
            int r = random.nextInt(16);
            rgb += Integer.toHexString(r);
        }
        return rgb;
    }

    public String getNumberSuffix() {
        return numberSuffix;
    }

    public void setNumberSuffix(String numberSuffix) {
        this.numberSuffix = numberSuffix;
    }

    public List<String> getLeftSeriesNames() {
        return leftSeriesNames;
    }

    public void setLeftSeriesNames(List<String> leftSeriesNames) {
        this.leftSeriesNames = leftSeriesNames;
    }

    public List<String> getRightSeriesNames() {
        return rightSeriesNames;
    }

    public void setRightSeriesNames(List<String> rightSeriesNames) {
        this.rightSeriesNames = rightSeriesNames;
    }

    public List<List<String>> getLeftValues() {
        return leftValues;
    }

    public void setLeftValues(List<List<String>> leftValues) {
        this.leftValues = leftValues;
    }

    public List<List<String>> getRightValues() {
        return rightValues;
    }

    public void setRightValues(List<List<String>> rightValues) {
        this.rightValues = rightValues;
    }

}
