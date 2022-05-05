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
        int counter = 0;
        while(currentIndex < markdown.length() && counter<=2) {
            int openBracket = markdown.indexOf("[", currentIndex);
            int closeBracket = markdown.indexOf("]", openBracket);
            int openParen = markdown.indexOf("(", closeBracket);
            int closeParen = markdown.indexOf(")", openParen);
            counter+=1;
            toReturn.add(markdown.substring(openParen + 1, closeParen));
            currentIndex = closeParen + 1;
        }

        return toReturn;
    }

    public static ArrayList<String> getLinks2(String markdown)  {
        ArrayList<String> toReturn =  new ArrayList<>();
        int currentIndex =  0;
  
        while(currentIndex <markdown.length()){
            int openBracket =  markdown.indexOf("[", currentIndex);
             // System.out.println(openBracket);
            int closeBracket = markdown.indexOf("]", openBracket);
            //  System.out.println(closeBracket);
            //
            int openParen =  markdown.indexOf(" ");
            // Syst em.out.println(openParen);
            //
            int closeParen =  markdown.indexOf(" ", openParen+1);
            // System.out.printl n(closeParen);
            //
            toReturn.add(markdown.substring(openParen,closeParen));
            break; //break off
 //
        }
  
        return toReturn;
    }
 







    public static void main(String[]  args) throws IOException {
        Path fileName =  Path.of(args[0]);
        String content =  Files.readString(fileName);
        ArrayList<String>  links = getLinks(content); 
        ArrayList<String>  links2 = getLinks2(content); //کسو
       if (links.isEmpty() ){
       }
       else{
           for (String x:links2){
               links.add(x);  //THE MISTAKE IS HERE
           }
       }
       ArrayList<String> links3 = new ArrayList<>();
       links3.add(links.get(0));
       links3.add(links.get(1));

	    System.out.println(links3); 
    } 
} 
