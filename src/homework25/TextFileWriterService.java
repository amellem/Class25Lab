package homework25;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class TextFileWriterService implements TextFileWriterStrategy {
    private TextFormatStrategy textFormatStrategy;
    private String filePath;
    private boolean append;

    public TextFileWriterService(TextFormatStrategy textFormatStrategy, String filePath, boolean append) {
        this.textFormatStrategy = textFormatStrategy;
        this.filePath = filePath;
        this.append = append;
    }
    
    @Override
    public final void writeFile(List<Map<String, String>> dataFromApp) throws IOException {
        PrintWriter fileOutput = new PrintWriter(new BufferedWriter(new FileWriter(filePath, append)));
        fileOutput.print(textFormatStrategy.encodeToString(dataFromApp));
        fileOutput.close();
    }

    @Override
    public TextFormatStrategy getTextFormatStrategy() {
        return textFormatStrategy;
    }

    @Override
    public void setTextFormatStrategy(TextFormatStrategy textFormatStrategy) {
        this.textFormatStrategy = textFormatStrategy;
    }

    @Override
    public String getFilePath() {
        return filePath;
    }

    @Override
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public boolean isAppend() {
        return append;
    }

    @Override
    public void setAppend(boolean append) {
        this.append = append;
    }
    
    //Unit Testing
//    public static void main(String[] args) {
//        List<Map<String, String>> dataFromApp = new ArrayList<>();
//        Map<String,String> record = new HashMap<>();
//        record.put("totalHours", "20.50");
//        record.put("totalFees", "33.75");
//        dataFromApp.add(record);
//        
//        String filePath = "src" + File.separatorChar + "custom_garage_format.txt";
//        TextFileWriterService tws = new TextFileWriterService(new CustomGarageTransactionFormat(), filePath, false);
//        try {
//            tws.writeFile(dataFromApp);
//        } catch (IOException ex) {
//            Logger.getLogger(TextFileWriterService.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
