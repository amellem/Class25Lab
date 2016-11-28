package inclass25lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomGarageFormat implements TextFormatStrategy {
    private final String CRLF = "\n";
    //Our own custom format
    //Line 1: (hours) 20.5
    //Line 2: (fees) 33.75
    
    @Override
    public final String encode(List<Map<String,String>> dataFromApp){
        Map<String,String> sourceData = dataFromApp.get(0);
        String sTotalHours = sourceData.get("totalHours");
        String sTotalFees = sourceData.get("totalFees");
        
        return sTotalHours + CRLF + sTotalFees + CRLF;
    }
    
    @Override
    public final List<Map<String,String>> decode(List <String> dataFromFile){
        String sTotalHours = dataFromFile.get(0);
        String sTotalFees = dataFromFile.get(1);
        
        List<Map<String,String>> appData = new ArrayList<>();
        Map<String,String> record = new HashMap<>();
        record.put("totalHours", sTotalHours);
        record.put("totalFees", sTotalFees);
        appData.add(record);
        
        return appData;
    }
    
    public static void main(String[] args) {
         CustomGarageFormat format = new CustomGarageFormat();
        //Test Decode
        List<String> dataFromFile = Arrays.asList("20.50", "33.75");
        List<Map<String,String>> appData = format.decode(dataFromFile);
        
        System.out.println(appData.get(0).get("totalHours"));
        
        //Test Encode
//       
//        List<Map<String,String>> dataFromApp = new ArrayList<>();
//        Map<String,String> record = new HashMap<>();
//        record.put("totalHours", "20.50");
//        record.put("totalFees", "33.75");
//        dataFromApp.add(record);
//        
//        String formatted = format.encode(dataFromApp);
//        System.out.println(formatted);
    }
}
