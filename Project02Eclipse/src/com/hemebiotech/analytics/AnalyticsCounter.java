package com.hemebiotech.analytics;

import com.hemebiotech.analytics.count.ICountSymptom;
import com.hemebiotech.analytics.read.ISymptomReader;
import com.hemebiotech.analytics.sort.ISortSymptomByName;
import com.hemebiotech.analytics.write.IWriteSymptomDataToFile;
import java.util.*;

public class AnalyticsCounter {
    private final ISymptomReader reader;
    private final ICountSymptom counter;
    private final ISortSymptomByName sorter;
    private final IWriteSymptomDataToFile writer;

    public AnalyticsCounter(ISymptomReader reader, ICountSymptom counter, ISortSymptomByName sorter, IWriteSymptomDataToFile writer) {
        this.reader = reader;
        this.counter = counter;
        this.sorter = sorter;
        this.writer = writer;
    }

    /**
     * On initialise le comptage plus le trie des symptoms
     * @throws Exception
     */
    public void execute() throws Exception {
        // 1ere étape: on lit le ficher symptoms.txt READ
        List<String> allSymptoms = reader.getSymptoms();


        // 2eme etapes: on parcours le fichier en comptant les symptoms COUNT (Map)
        Map<String, Integer> symptomsCounter = counter.count(allSymptoms);


        // 3éme étapes: on range dans l'ordre alphabétique les symptomes SORT Collections.sort
        List<String> symptoms = sorter.sort(symptomsCounter.keySet());


        // 4éme étapes: on écrit le fichier result.out WRITE
        writer.write(symptoms, symptomsCounter);
    }
}
