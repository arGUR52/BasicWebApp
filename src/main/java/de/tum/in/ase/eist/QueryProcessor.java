package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class QueryProcessor {

    public String process(String query) {
		query = query.toLowerCase();
        if (query.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.contains("name")) {
            return "arGUR";
        } else if (query.contains("favorite color")) {
            return "#33400";
        } else if (query.contains("email")) {
            return "no, don't hack me!";
        } else if (query.contains("age")) {
            return "0";
        } else if (query.contains("+") || query.contains("plus")) {
            return query.contains("+") ? Integer.parseInt(query.split("\\+")[0]) + Integer.parseInt(query.split("\\+")[1]) + ""
                    : Integer.parseInt(query.split("plus")[0]) + Integer.parseInt(query.split("plus")[1]) + "";
        } else if (query.contains("-") || query.contains("minus")) {
            return query.contains("-") ? Integer.parseInt(query.split("\\-")[0]) - Integer.parseInt(query.split("\\-")[1]) + ""
                    : Integer.parseInt(query.split("minus")[0]) - Integer.parseInt(query.split("minus")[1]) + "";
        } else if (query.contains("*") || query.contains("times")) {
            return query.contains("*") ? Integer.parseInt(query.split("\\*")[0]) * Integer.parseInt(query.split("\\*")[1]) + ""
                    : Integer.parseInt(query.split("times")[0]) * Integer.parseInt(query.split("times")[1]) + "";
        } else if (query.contains("/") || query.contains("divided by")) {
            return query.contains("/") ? Integer.parseInt(query.split("\\/")[0]) / Integer.parseInt(query.split("\\/")[1]) + ""
                   : Integer.parseInt(query.split("divided by")[0]) / Integer.parseInt(query.split("divided by")[1]) + "";
        } else if (query.contains("%") || query.contains("modulo") || query.contains("mod")) {
            return query.contains("%") ? Integer.parseInt(query.split("\\%")[0]) % Integer.parseInt(query.split("\\%")[1]) + ""
                    : query.contains("modulo") ? Integer.parseInt(query.split("modulo")[0]) % Integer.parseInt(query.split("modulo")[1]) + ""
                    : Integer.parseInt(query.split("mod")[0]) % Integer.parseInt(query.split("mod")[1]) + "";
        } else if (query.contains("^")) {
            return Math.pow(Integer.parseInt(query.split("\\^")[0]), Integer.parseInt(query.split("\\^")[1])) + "";
        } else if (query.contains("largest")) {
            String numbers = query.split(":")[1].replace(" ", "");
            String[] numbersArray = numbers.split(",");
            int largest = Integer.parseInt(numbersArray[0]);
            for (int i = 1; i < numbersArray.length; i++) {
                if (Integer.parseInt(numbersArray[i]) > largest) {
                    largest = Integer.parseInt(numbersArray[i]);
                }
            }
            return largest + "";
        } else { // TODO extend the programm here
            return "";
        }
    }

    public static void main(String[] args) {
        QueryProcessor queryProcessor = new QueryProcessor();
        System.out.println(queryProcessor.process("what is the largest number of the following numbers: 1,2,3,4,5,6,7,8,9,10"));
    }
}
