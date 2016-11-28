package homework25;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomGarageTransactionFormat implements TextFormatStrategy {
    private final String CR = "\n";
    
    @Override
    public final String encodeToString(List<Map<String,String>> dataFromApp){
        Map<String,String> sourceData = dataFromApp.get(0);
        String totalHours = sourceData.get("totalHours");
        String totalFees = sourceData.get("totalFees");
        
        return totalHours + CR + totalFees + CR;
    }
    
    @Override
    public final List<Map<String,String>> decodeFromFile(List <String> dataFromFile){
        String totalHours = dataFromFile.get(0);
        String totalFees = dataFromFile.get(1);
        
        List<Map<String,String>> appData = new ArrayList<>();
        Map<String,String> record = new HashMap<>();
        record.put("totalHours", totalHours);
        record.put("totalFees", totalFees);
        appData.add(record);
        
        return appData;
    }
}
