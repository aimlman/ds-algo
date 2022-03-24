package string;

import java.util.*;

public class ShortenPath {

    public static void main(String[] args) {
        String longPath = "/foo/../test/../test/../foo//bar/./baz";
        String shortPath = shortenPath(longPath);
        System.out.println(shortPath);
    }

    // Time: O(n), Space: O(n)
    public static String shortenPath(String path) {
        // parse the string and create an array list for the path
        String ROOT = "";
        List<String> shortPath = new ArrayList<>();
        String[] tokens = path.split("/");
			 	boolean relativePath = path.charAt(0) == '/' ? false: true;
        for (String token: tokens) {
            process(token, shortPath, relativePath);
        }
       
        return reconstructPath(shortPath, relativePath);
    }

    private static void process(String token, List<String> shortPath, boolean relativePath) {
        
        String PARENT_DIR = "..";
        String CURRENT_DIR = ".";

        if (CURRENT_DIR.equals(token) || token.equals("")) {
            // Do nothing
        } else if (PARENT_DIR.equals(token)) {
            if (shortPath.size() > 0 && !shortPath.get(shortPath.size()-1).equals(PARENT_DIR)) { 
                shortPath.remove(shortPath.size()-1);
            } else if (relativePath) {
                shortPath.add(token);
            }
        } else {
            shortPath.add(token);
        }
    }
    
    private static String reconstructPath(List<String> shortPath, boolean relativePath) {
        String DIRECTORY_SEPARATOR = "/";
        StringBuffer sb = new StringBuffer();
        for (String pathElement: shortPath) {
            sb.append(DIRECTORY_SEPARATOR);
            sb.append(pathElement);
        }
        if (relativePath) sb.deleteCharAt(0);
        if (!relativePath && sb.length() == 0) sb.append(DIRECTORY_SEPARATOR);
        return sb.toString();
    }
}
