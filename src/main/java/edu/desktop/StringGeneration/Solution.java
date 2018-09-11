package edu.desktop.StringGeneration;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.lang.String;

// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution {

    public static void generateAllSubstrings(List<Character>conversion, HashSet<String> substrings_set) {
        if(conversion == null)
            return;
        if(conversion.size() == 1) { // already added
            return;
        }
        substrings_set.add(conversion.subList(1, conversion.size()).toString());
        generateAllSubstrings(conversion.subList(1, conversion.size()), substrings_set );
        substrings_set.add(conversion.subList(0, conversion.size()-1).toString());
        generateAllSubstrings(conversion.subList(0, conversion.size()-1), substrings_set );
        for(int i = 1; i < (conversion.size()-1); ++i) {
            List<Character> duplicate = new ArrayList<Character>(conversion);
            duplicate.remove(i);
            substrings_set.add(duplicate.toString());
            generateAllSubstrings(duplicate, substrings_set );
        }

    }

    public static void main(String args[]) {
        String contents = null;
        String exclusion = null;
        List<Character> conversion = new ArrayList<Character>();
        HashSet<String> list_of_substring_lists = new HashSet<String>();

        if (args.length == 0) {
            System.err.printf( "Program must have args.\n" );
            System.exit( -1 );
        }

        for (String tmp : args) {
            conversion.add( tmp.charAt( 0 ) );
        }


        list_of_substring_lists.add(conversion.toString());
        generateAllSubstrings(conversion, list_of_substring_lists);
        for(String substring:list_of_substring_lists) {
            System.out.println( substring );
        }

    }
}

// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED

