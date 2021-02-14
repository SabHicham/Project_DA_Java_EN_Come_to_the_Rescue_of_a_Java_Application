package com.hemebiotech.analytics.sort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SortSymptomByName implements ISortSymptomByName {
    /**
     * On range les symptoms dans l'ordre alphabétique
     * @param symptoms
     * @return
     */

    @Override
    public List<String> sort(Collection<String> symptoms) {
        List<String> copy = new ArrayList<>(symptoms);
        Collections.sort(copy);
        return copy;
    }

}
