package com.hemebiotech.analytics;

import com.hemebiotech.analytics.count.CountSymptom;
import com.hemebiotech.analytics.count.ICountSymptom;
import com.hemebiotech.analytics.read.ISymptomReader;
import com.hemebiotech.analytics.read.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.sort.ISortSymptomByName;
import com.hemebiotech.analytics.sort.SortSymptomByName;
import com.hemebiotech.analytics.write.IWriteSymptomDataToFile;
import com.hemebiotech.analytics.write.WriteSymtomDataToFile;

public class Main {
    public static void main(String[] args) throws Exception {
        ISymptomReader reader = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
        ICountSymptom counter = new CountSymptom();
        ISortSymptomByName sorter = new SortSymptomByName();
        IWriteSymptomDataToFile writer = new WriteSymtomDataToFile("result.out");

        AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, counter, sorter, writer);
        analyticsCounter.execute();
    }
}
