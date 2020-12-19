import com.google.gson.Gson;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class IPLAnalysis {

    public static final String TOP_BATTING_AVG_FILE = "C:\\Users\\mural\\IdeaProjects\\IPL_Analysis_Problem\\src\\test\\resources\\TopBattingAverage.json";
    private static final String TOP_STRIKE_RATE_FILE = "C:\\Users\\mural\\IdeaProjects\\IPL_Analysis_Problem\\src\\test\\resources\\TopBattingStrikeRate.json";
    private static final String TOP_Fours_Sixes_FILE = "C:\\Users\\mural\\IdeaProjects\\IPL_Analysis_Problem\\src\\test\\resources\\TopSixesAndFours.json";
    public static List<IPLBatsman> IplBatsmanData;
    public static List<IPLBowler> IplBowlerData;


    public int loadIplBatsmanData(String csvFilePath) throws IPLAnalysisException {
        try(Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
            CSVReader csvReader = new CSVReader(reader);){

            IplBatsmanData = getCSVFileList(reader,IPLBatsman.class);
            return IplBatsmanData.size();
        } catch (IOException | RuntimeException e ) {
            throw new IPLAnalysisException(e.getMessage(),IPLAnalysisException.ExceptionType.IPL_FILE_PROBLEM);
        }
    }

    public int loadIplBowlerData(String csvFilePath) throws IPLAnalysisException {
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

    public void getTopSixesAndFours() throws IOException {
        Comparator com = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                IPLBatsman b1 = (IPLBatsman)o1;
                IPLBatsman b2 = (IPLBatsman)o2;
                if((b1.getSixes()+b1.getFours())>(b2.getFours()+b2.getSixes()))
                    return -3;
                else
                    return 3;
            }
        };
        Collections.sort(IplBatsmanData,com);
        Gson gson = new Gson();
        String json =gson.toJson(IplBatsmanData);
        FileWriter fileWriter = new FileWriter(TOP_Fours_Sixes_FILE);
        fileWriter.write(json);
        fileWriter.close();
    }

    public void getTopStrikeRateDataWithSixesAndFours() throws IOException{
        Comparator com = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                IPLBatsman b1 = (IPLBatsman)o1;
                IPLBatsman b2 = (IPLBatsman)o2;

                if(((b1.getSixes()+b1.getFours())>(b2.getFours()+b2.getSixes())) && (b1.getStrikeRate()>b2.getStrikeRate()))
                    return -3;
                else
                    return 3;
            }
        };
        Collections.sort(IplBatsmanData,com);
    }

    public void getTopAverageDataWithBestStrikeRates() {
        Comparator<IPLBatsman> iplBatsmanDataComparator = Comparator.comparingDouble(IPLBatsman::getAverage).thenComparing(IPLBatsman::getStrikeRate);
        Collections.sort(IplBatsmanData,iplBatsmanDataComparator);
    }

    public void getMaximumRunsDataWithBestAverage() {
        Comparator<IPLBatsman> iplBatsmanDataComparator = Comparator.comparingDouble(IPLBatsman::getRuns).thenComparing(IPLBatsman::getAverage);
        Collections.sort(IplBatsmanData,iplBatsmanDataComparator);
    }

    public void getTopBowlingAverageData() {
        Comparator<IPLBowler> iplBowlerComparator = Comparator.comparingDouble(IPLBowler::getAverage);
        Collections.sort(IplBowlerData, iplBowlerComparator);
        IplBowlerData = IplBowlerData.stream().filter(s -> (s.getAverage() != 0)).collect(Collectors.toList());
    }

    public void getTopBowlingStrikeRateData() {
        Comparator<IPLBowler> iplBowlerComparator = Comparator.comparingDouble(IPLBowler::getStrikeRate);
        Collections.sort(IplBowlerData, iplBowlerComparator);
        IplBowlerData = IplBowlerData.stream().filter(s -> (s.getStrikeRate() != 0)).collect(Collectors.toList());
    }

    public void getTopBowlingEconomyData() {
        Comparator<IPLBowler> iplBowlerComparator = Comparator.comparingDouble(IPLBowler::getEconomy);
        Collections.sort(IplBowlerData, iplBowlerComparator);
        IplBowlerData = IplBowlerData.stream().filter(s -> (s.getEconomy() != 0)).collect(Collectors.toList());
    }

    public void getTopBowlingStrikeRateDataWith4Wand5WHaul() {
        Comparator<IPLBowler> iplBowlerComparator = Comparator.comparingDouble(IPLBowler::getStrikeRate).thenComparing(IPLBowler::getFiveWicketHaul).thenComparing(IPLBowler::getFourWicketHaul);
        Collections.sort(IplBowlerData,iplBowlerComparator);
        IplBowlerData = IplBowlerData.stream().filter(s->(s.getFiveWicketHaul()!=0 || s.getFourWicketHaul()!=0)).collect(Collectors.toList());
    }

    public void getTopBowlingAverageDataWithBestStrikeRates() {
        Comparator<IPLBowler> iplBowlerComparator = Comparator.comparingDouble(IPLBowler::getAverage).thenComparing(IPLBowler::getStrikeRate);
        Collections.sort(IplBowlerData,iplBowlerComparator);
    }

    public void getMostWicketsDataWithBestAverages() {
        Comparator<IPLBowler> iplBowlerComparator = Comparator.comparingInt(IPLBowler::getWickets).thenComparing(IPLBowler::getAverage);
        Collections.sort(IplBowlerData,iplBowlerComparator);
    }

    public List<String> getTopBattingAverageDataWithBowlingAverageData() {
        Comparator<IPLBowler> iplBowlerComparator = Comparator.comparingDouble(IPLBowler::getAverage);
        Comparator<IPLBatsman> iplBatsmanComparator = Comparator.comparingDouble(IPLBatsman::getAverage);
        Collections.sort(IplBowlerData,iplBowlerComparator);
        Collections.sort(IplBatsmanData,iplBatsmanComparator);
        List<String> newList = new ArrayList();
        for(IPLBatsman batsman: IplBatsmanData){
            for(IPLBowler bowler: IplBowlerData){
                if(batsman.getPlayer().equals(bowler.getPlayer())){
                    newList.add(bowler.getPlayer());
                }
            }
        }
        return newList;
    }
}
