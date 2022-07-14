package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

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
        } else { // TODO extend the programm here
            return "";
        }
    }
}
