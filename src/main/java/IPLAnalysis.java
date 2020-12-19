import com.google.gson.Gson;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class IPLAnalysis {

    public static final String TOP_BATTING_AVG_FILE = "C:\\Users\\mural\\IdeaProjects\\IPL_Analysis_Problem\\src\\test\\resources\\TopBattingAverage.json";
    private static final String TOP_STRIKE_RATE_FILE = "C:\\Users\\mural\\IdeaProjects\\IPL_Analysis_Problem\\src\\test\\resources\\TopBattingStrikeRate.json";
    public static List<IPLBatsman> IplBatsmanData;
    public static List<IPLBowler> IplBowlerData;


    public int loadIplBatsmanStat(String csvFilePath) throws IPLAnalysisException {
        try(Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
            CSVReader csvReader = new CSVReader(reader);){

            IplBatsmanData = getCSVFileList(reader,IPLBatsman.class);
            return IplBatsmanData.size();
        } catch (IOException | RuntimeException e ) {
            throw new IPLAnalysisException(e.getMessage(),IPLAnalysisException.ExceptionType.IPL_FILE_PROBLEM);
        }
    }

    public int loadIplBowlerStat(String csvFilePath) throws IPLAnalysisException {
        try(Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
            CSVReader csvReader = new CSVReader(reader);){

            IplBowlerData = getCSVFileList(reader,IPLBowler.class);
            return IplBowlerData.size();
        } catch (IOException| RuntimeException e ) {
            throw new IPLAnalysisException(e.getMessage(),IPLAnalysisException.ExceptionType.IPL_FILE_PROBLEM);
        }
    }

    public <E> List getCSVFileList(Reader reader, Class csvClass)  {

        CsvToBeanBuilder<E> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
        csvToBeanBuilder.withType(csvClass);
        csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
        CsvToBean<E> csvToBean = csvToBeanBuilder.build();
        return csvToBean.parse();
    }


    public void getTopBattingAverageData() throws IOException {
        Comparator com = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                IPLBatsman b1 = (IPLBatsman)o1;
                IPLBatsman b2 = (IPLBatsman)o2;
                if(b1.getAverage()>b2.getAverage())
                    return -3;
                else
                    return 3;
            }
        };
        Collections.sort(IplBatsmanData,com);
        Gson gson = new Gson();
        String json =gson.toJson(IplBatsmanData);
        FileWriter fileWriter = new FileWriter(TOP_BATTING_AVG_FILE);
        fileWriter.write(json);
        fileWriter.close();
    }

    public void getTopStrikeRateData() throws IOException {
        Comparator com = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                IPLBatsman b1 = (IPLBatsman)o1;
                IPLBatsman b2 = (IPLBatsman)o2;
                if(b1.getStrikeRate()>b2.getStrikeRate())
                    return -3;
                else
                    return 3;
            }
        };
        Collections.sort(IplBatsmanData,com);
        Gson gson = new Gson();
        String json =gson.toJson(IplBatsmanData);
        FileWriter fileWriter = new FileWriter(TOP_STRIKE_RATE_FILE);
        fileWriter.write(json);
        fileWriter.close();

    }
}
