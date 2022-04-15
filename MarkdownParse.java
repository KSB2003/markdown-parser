//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            int openBracket = markdown.indexOf("[", currentIndex);
            int closeBracket = markdown.indexOf("]", openBracket);
            int openParen = markdown.indexOf("(", closeBracket);
            int closeParen = markdown.indexOf(")", openParen);
            toReturn.add(markdown.substring(openParen + 1, closeParen));
            currentIndex = closeParen + 1;
            // System.out.println(currentIndex);
        }

        return toReturn;
    }


    public static ArrayList<String> getLinks2(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        int currentIndex = 0;

        while(currentIndex<markdown.length()){
            int openBracket = markdown.indexOf("[", currentIndex);
            // System.out.println(openBracket);
            int closeBracket = markdown.indexOf("]", openBracket);
            // System.out.println(closeBracket);
            
            int openParen = markdown.indexOf(" ");
            // System.out.println(openParen);

            int closeParen = markdown.indexOf(" ", openParen+1);
            // System.out.println(closeParen);
            
            toReturn.add(markdown.substring(openParen, closeParen));
            break;

        }

        return toReturn;
    }

    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
        ArrayList<String> links2 = getLinks2(content);
        if (links.isEmpty()){

        }
        else{
            for (String x: links2){
                links.add(x);
            }
        }
	    System.out.println(links);
    }
}
