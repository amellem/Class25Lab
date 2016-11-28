/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inclass25lab;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Mike
 */
public interface TextReaderStrategy {

    String getFilePath();

    TextFormatStrategy getFormatter();

    List<Map<String, String>> readFile() throws IOException;

    void setFilePath(String filePath);

    void setFormatter(TextFormatStrategy formatter);
    
}
