/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inclass25lab;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Mike
 */
public class FileService {
    private TextReaderStrategy reader; 

    public FileService() {
    }

    public FileService(TextReaderStrategy reader) {
        this.reader = reader;
    }

    public TextReaderStrategy getReader() {
        return reader;
    }

    public void setReader(TextReaderStrategy reader) {
        this.reader = reader;
    }
    
    public List<Map<String,String>> readFile() throws IOException{
        return reader.readFile();
    }
    
//    public static void main(String[] args) throws IOException{
//        TextFormatStrategy formatter = new CustomGarageFormat();
//        String filePath = "src" + File.separatorChar + "custom_garage_format.txt";
//        TextReaderStrategy reader = new TextFileReader(filePath, formatter);
//        FileService fileService = new FileService(reader);
//        
//        List<Map<String,String>> result = fileService.readFile();
//        System.out.println(result);
//    }
}
