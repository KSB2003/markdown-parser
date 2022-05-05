import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.*;
public class MarkdownParseTest {
    @Test
    public void addition() {
    assertEquals(2, 1 + 1);
    }  
    
    
    @Test
    public void MarkdownTester(){
        String[] x = {"https://something.com", "some-page.html"};
        MarkdownParse y = new MarkdownParse();
        assertEquals(x, y.getLinks("test-file.md"));
    }
}