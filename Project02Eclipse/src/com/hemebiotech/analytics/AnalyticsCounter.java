package com.hemebiotech.analytics;

import com.hemebiotech.analytics.count.CountSymptom;
import com.hemebiotech.analytics.read.ReadSymptomDataFromFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class AnalyticsCounter {
	
	public static void main(String args[]) throws Exception {
		// 1ere étape: on lit le ficher symptoms.txt READ
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("symptoms.txt");
		List<String> allSymptoms = reader.GetSymptoms();
		//System.out.println(Arrays.toString(allSymptoms.toArray()));


		// 2eme etapes: on parcours le fichier en comptant les symptoms COUNT (Map)
		CountSymptom counter = new CountSymptom();
		Map<String, Integer> symptomsCounter = counter.count(allSymptoms);


		// Afficher la map
		//for (Map.Entry entry : symptomsCounter.entrySet()) {
			//System.out.println("key: "+entry.getKey()+"; value: "+entry.getValue());
		//}


		// 3éme étapes: on range dans l'ordre alphabétique les symptomes SORT Collections.sort
		List<String> symptoms = new ArrayList<>(symptomsCounter.keySet());
		Collections.sort(symptoms);

		//for (int i = 0; i < symptoms.size(); i++){
			//System.out.println(symptoms.get(i)+" = "+symptomsCounter.get(symptoms.get(i)));
		//}

		// 4éme étapes: on écrit le fichier result.out WRITE
		FileWriter writer = new FileWriter ("result.out");
		for (String symptom : symptoms) {
			writer.write(symptom+" = "+symptomsCounter.get(symptom)+"\n");
		}
		writer.close();




		// tester











	}
}
