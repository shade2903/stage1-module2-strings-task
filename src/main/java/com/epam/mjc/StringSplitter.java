package com.epam.mjc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source     source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
        List<String> newLine = new ArrayList<>();
        String[] strings;
        String regex = "[";
        StringBuilder sb = new StringBuilder(regex);
        for (String delimiter : delimiters) {
            sb.append(delimiter);
        }
        sb.append("]");
        strings = source.split(sb.toString());
        for (String str : strings) {
            if (!str.equals("")) newLine.add(str);
        }
        return newLine;
    }


}
