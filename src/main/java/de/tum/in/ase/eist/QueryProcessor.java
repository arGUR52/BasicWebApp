package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class QueryProcessor {

    public String process(String query) {
        try {
            query = query.toLowerCase();
            query = query.substring(11);
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
                query = query.replace(" ", "");
                int start = 0;
                while (query.charAt(start) != '0' && query.charAt(start) != '1' && query.charAt(start) != '2'&& query.charAt(start) != '3' && query.charAt(start) != '4' && query.charAt(start) != '5' && query.charAt(start) != '6' && query.charAt(start) != '7' && query.charAt(start) != '8' && query.charAt(start) != '9') {
                    start++;
                }
                return query.contains("+") ? Integer.parseInt(query.split("\\+")[0].substring(start)) + Integer.parseInt(query.split("\\+")[1]) + ""
                        : Integer.parseInt(query.split("plus")[0].substring(start)) + Integer.parseInt(query.split("plus")[1]) + "";
            } else if (query.contains("-") || query.contains("minus")) {
                query = query.replace(" ", "");
                int start = 0;
                while (query.charAt(start) != '0' && query.charAt(start) != '1' && query.charAt(start) != '2'&& query.charAt(start) != '3' && query.charAt(start) != '4' && query.charAt(start) != '5' && query.charAt(start) != '6' && query.charAt(start) != '7' && query.charAt(start) != '8' && query.charAt(start) != '9') {
                    start++;
                }
                return query.contains("-") ? Integer.parseInt(query.split("\\-")[0].substring(start)) - Integer.parseInt(query.split("\\-")[1]) + ""
                        : Integer.parseInt(query.split("minus")[0].substring(start)) - Integer.parseInt(query.split("minus")[1]) + "";
            } else if (query.contains("*") || query.contains("times")) {
                query = query.replace(" ", "");
                int start = 0;
                while (query.charAt(start) != '0' && query.charAt(start) != '1' && query.charAt(start) != '2'&& query.charAt(start) != '3' && query.charAt(start) != '4' && query.charAt(start) != '5' && query.charAt(start) != '6' && query.charAt(start) != '7' && query.charAt(start) != '8' && query.charAt(start) != '9') {
                    start++;
                }
                return query.contains("*") ? Integer.parseInt(query.split("\\*")[0].substring(start)) * Integer.parseInt(query.split("\\*")[1]) + ""
                        : Integer.parseInt(query.split("times")[0].substring(start)) * Integer.parseInt(query.split("times")[1]) + "";
            } else if (query.contains("/") || query.contains("divided by")) {
                query = query.replace(" ", "");
                int start = 0;
                while (query.charAt(start) != '0' && query.charAt(start) != '1' && query.charAt(start) != '2'&& query.charAt(start) != '3' && query.charAt(start) != '4' && query.charAt(start) != '5' && query.charAt(start) != '6' && query.charAt(start) != '7' && query.charAt(start) != '8' && query.charAt(start) != '9') {
                    start++;
                }
                return query.contains("/") ? Integer.parseInt(query.split("\\/")[0].substring(start)) / Integer.parseInt(query.split("\\/")[1]) + ""
                        : Integer.parseInt(query.split("divided by")[0].substring(start)) / Integer.parseInt(query.split("divided by")[1]) + "";
            } else if (query.contains("%") || query.contains("modulo") || query.contains("mod")) {
                query = query.replace(" ", "");
                int start = 0;
                while (query.charAt(start) != '0' && query.charAt(start) != '1' && query.charAt(start) != '2'&& query.charAt(start) != '3' && query.charAt(start) != '4' && query.charAt(start) != '5' && query.charAt(start) != '6' && query.charAt(start) != '7' && query.charAt(start) != '8' && query.charAt(start) != '9') {
                    start++;
                }
                return query.contains("%") ? Integer.parseInt(query.split("\\%")[0].substring(start)) % Integer.parseInt(query.split("\\%")[1]) + ""
                        : query.contains("modulo") ? Integer.parseInt(query.split("modulo")[0]) % Integer.parseInt(query.split("modulo")[1]) + ""
                        : Integer.parseInt(query.split("mod")[0].substring(start)) % Integer.parseInt(query.split("mod")[1]) + "";
            } else if (query.contains("^")) {
                query = query.replace(" ", "");
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
            } else {
                return "";
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void main(String[] args) {
        QueryProcessor queryProcessor = new QueryProcessor();
        System.out.println(queryProcessor.process("add 34 plus 5"));
    }
}
