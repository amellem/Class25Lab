/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inclass25lab;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Mike
 */
public class TextFileReader implements TextReaderStrategy {
    private TextFormatStrategy formatter;
    private String filePath;

    public TextFileReader(String filePath) {
        this.filePath = filePath;
    }

    public TextFileReader(String filePath, TextFormatStrategy formatter) {
        this.filePath = filePath;
        this.formatter = formatter;
    }

    @Override
    public List<Map<String,String>> readFile() throws IOException{
        File file = new File(filePath);
        
        BufferedReader in = null;
        List<String> lines = new ArrayList<>();
	   in = new BufferedReader(new FileReader(file));
	   String line = in.readLine();
	   while(line != null){
		  System.out.println(line);
		  line = in.readLine();  // strips out any carriage return chars
	   }
           in.close();
           
           return formatter.decode((lines));
    }
    
    @Override
    public TextFormatStrategy getFormatter() {
        return formatter;
    }

    @Override
    public void setFormatter(TextFormatStrategy formatter) {
        this.formatter = formatter;
    }

    @Override
    public String getFilePath() {
        return filePath;
    }

    @Override
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
