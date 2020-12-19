import com.jarfile.CSVBuilderException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class IPLAnalysisTest {

    public static final String BATSMAN_PATH = "C:\\Users\\mural\\IdeaProjects\\IPL_Analysis_Problem\\src\\test\\resources\\IPL2019FactsheetMostRuns.csv";
    public static final String BOWLER_PATH = "C:\\Users\\mural\\IdeaProjects\\IPL_Analysis_Problem\\src\\test\\resources\\IPL2019FactsheetMostWkts.csv";

    @Test
    public void loadingGivenCSVAndCheckingNoOfEntries() throws IPLAnalysisException, IOException, CSVBuilderException {
        IPLAnalysis iplAnalysis = new IPLAnalysis();
        int noOfEntriesBatsman = iplAnalysis.loadIplBatsmanData(BATSMAN_PATH);
        Assert.assertEquals(101,noOfEntriesBatsman);
        int noOfEntriesBowler = iplAnalysis.loadIplBowlerData(BOWLER_PATH);
        Assert.assertEquals(99,noOfEntriesBowler);

    }

    @Test
    public void givenIPLRunsData_ShouldReturn_TopBattingAverages_ofCricketers() throws IPLAnalysisException, IOException {
        IPLAnalysis iplAnalysis = new IPLAnalysis();
        iplAnalysis.loadIplBatsmanData(BATSMAN_PATH);
        iplAnalysis.getTopBattingAverageData();
        Assert.assertEquals("MS Dhoni",IPLAnalysis.IplBatsmanData.get(0).getPlayer());
        System.out.println("Answer found");
    }

    @Test
    public void givenIPLRunsData_ShouldReturn_TopStrikeRates_ofCricketers() throws IPLAnalysisException, IOException {
        IPLAnalysis iplAnalysis = new IPLAnalysis();
        iplAnalysis.loadIplBatsmanData(BATSMAN_PATH);
        iplAnalysis.getTopStrikeRateData();
        Assert.assertEquals("Ishant Sharma",IPLAnalysis.IplBatsmanData.get(0).getPlayer());
        System.out.println("Answer found");
    }

    @Test
    public void givenIPLRunsData_ShouldReturn_TopSixesAndFours_ofCricketers() throws IPLAnalysisException, IOException {
        IPLAnalysis iplAnalysis = new IPLAnalysis();
        iplAnalysis.loadIplBatsmanData(BATSMAN_PATH);
        iplAnalysis.getTopSixesAndFours();
        Assert.assertEquals("Andre Russell",IPLAnalysis.IplBatsmanData.get(0).getPlayer());
        System.out.println("Answer found");
    }

    @Test
    public void givenIPLRunsData_ShouldReturn_BestStrikeRateWith_SixesAndFours_ofCricketers() throws IPLAnalysisException, IOException {
        IPLAnalysis iplAnalysis = new IPLAnalysis();
        iplAnalysis.loadIplBatsmanData(BATSMAN_PATH);
        iplAnalysis.getTopStrikeRateDataWithSixesAndFours();
        Assert.assertEquals("Andre Russell",IPLAnalysis.IplBatsmanData.get(0).getPlayer());
        System.out.println("Answer found");
    }

    @Test
    public void givenIPLRunsData_ShouldReturn_BestAverageWith_BestStrikeRates_ofCricketers() throws IPLAnalysisException {
        IPLAnalysis iplAnalysis = new IPLAnalysis();
        iplAnalysis.loadIplBatsmanData(BATSMAN_PATH);
        iplAnalysis.getTopAverageDataWithBestStrikeRates();
        Assert.assertEquals("MS Dhoni",IPLAnalysis.IplBatsmanData.get(IPLAnalysis.IplBatsmanData.size()-1).getPlayer());
        System.out.println("Answer found");
    }

    @Test
    public void givenIPLRunsData_ShouldReturn_MaximumRunsWith_BestAverage_ofCricketers() throws IPLAnalysisException {
        IPLAnalysis iplAnalysis = new IPLAnalysis();
        iplAnalysis.loadIplBatsmanData(BATSMAN_PATH);
        iplAnalysis.getMaximumRunsDataWithBestAverage();
        Assert.assertEquals("David Warner",IPLAnalysis.IplBatsmanData.get(IPLAnalysis.IplBatsmanData.size()-1).getPlayer());
        System.out.println("Answer found");
    }

    @Test
    public void givenIPLRunsData_ShouldReturn_TopBowlingAverages_ofCricketers() throws IPLAnalysisException {
        IPLAnalysis iplAnalysis = new IPLAnalysis();
        iplAnalysis.loadIplBowlerData(BOWLER_PATH);
        iplAnalysis.getTopBowlingAverageData();
        Assert.assertEquals("Anukul Roy",IPLAnalysis.IplBowlerData.get(0).getPlayer());
        System.out.println("Answer found");
    }

    @Test
    public void givenIPLRunsData_ShouldReturn_TopBowlingStrikeRates_ofCricketers() throws IPLAnalysisException{
        IPLAnalysis iplAnalysis = new IPLAnalysis();
        iplAnalysis.loadIplBowlerData(BOWLER_PATH);
        iplAnalysis.getTopBowlingStrikeRateData();
        Assert.assertEquals("Alzarri Joseph",IPLAnalysis.IplBowlerData.get(0).getPlayer());
        System.out.println("Answer found");
    }

    @Test
    public void givenIPLRunsData_ShouldReturn_TopBowlingEconomy_ofCricketers() throws IPLAnalysisException {
        IPLAnalysis iplAnalysis = new IPLAnalysis();
        iplAnalysis.loadIplBowlerData(BOWLER_PATH);
        iplAnalysis.getTopBowlingEconomyData();
        Assert.assertEquals("Shivam Dube",IPLAnalysis.IplBowlerData.get(0).getPlayer());
        System.out.println("Answer found");
    }

    @Test
    public void givenIPLRunsData_ShouldReturn_TopBowlingStrikeRates_With4WAnd5WHaul_ofCricketers() throws IPLAnalysisException{
        IPLAnalysis iplAnalysis = new IPLAnalysis();
        iplAnalysis.loadIplBowlerData(BOWLER_PATH);
        iplAnalysis.getTopBowlingStrikeRateDataWith4Wand5WHaul();
        Assert.assertEquals("Alzarri Joseph",IPLAnalysis.IplBowlerData.get(0).getPlayer());
        System.out.println("Answer found");
    }

    @Test
    public void givenIPLRunsData_ShouldReturn_TopBowlingAverage_WithBestStrikeRates_ofCricketers() throws IPLAnalysisException {
        IPLAnalysis iplAnalysis = new IPLAnalysis();
        iplAnalysis.loadIplBowlerData(BOWLER_PATH);
        iplAnalysis.getTopBowlingAverageDataWithBestStrikeRates();
        Assert.assertEquals("Krishnappa Gowtham",IPLAnalysis.IplBowlerData.get(IPLAnalysis.IplBowlerData.size()-1).getPlayer());
        System.out.println("Answer found");
    }

    @Test
    public void givenIPLRunsData_ShouldReturn_MostWickets_WithBestAverages_ofCricketers() throws IPLAnalysisException {
        IPLAnalysis iplAnalysis = new IPLAnalysis();
        iplAnalysis.loadIplBowlerData(BOWLER_PATH);
        iplAnalysis.getMostWicketsDataWithBestAverages();
        Assert.assertEquals("Imran Tahir",IPLAnalysis.IplBowlerData.get(IPLAnalysis.IplBowlerData.size()-1).getPlayer());
        System.out.println("Answer found");
    }

    @Test
    public void givenIPLRunsData_ShouldReturn_BestBattingAverage_AndBowlingAverage_ofCricketers() throws IPLAnalysisException {
        IPLAnalysis iplAnalysis = new IPLAnalysis();
        iplAnalysis.loadIplBatsmanData(BATSMAN_PATH);
        iplAnalysis.loadIplBowlerData(BOWLER_PATH);
        List<String> namesList = iplAnalysis.getTopBattingAverageDataWithBowlingAverageData();
        Assert.assertEquals("Andre Russell",namesList.get(namesList.size()-1));
        System.out.println("Answer found");
    }

    @Test
    public void givenIPLRunsData_ShouldReturn_MostRuns_AndMostWickets_ofCricketers() throws IPLAnalysisException {
        IPLAnalysis iplAnalysis = new IPLAnalysis();
        iplAnalysis.loadIplBatsmanData(BATSMAN_PATH);
        iplAnalysis.loadIplBowlerData(BOWLER_PATH);
        List<String> namesList = iplAnalysis.getMostRunsDataWithMostWicketsData();
        Assert.assertEquals("Andre Russell",namesList.get(namesList.size()-1));
        System.out.println("Answer found");
    }

    @Test
    public void givenIPLRunsData_ShouldReturn_MostHundreds_WithBestBattingAverages_ofCricketers() throws IPLAnalysisException {
        IPLAnalysis iplAnalysis = new IPLAnalysis();
        iplAnalysis.loadIplBatsmanData(BATSMAN_PATH);
        iplAnalysis.getMostHundredsDataWithBestAverages();
        Assert.assertEquals("David Warner",IPLAnalysis.IplBatsmanData.get(IPLAnalysis.IplBatsmanData.size()-1).getPlayer());
        System.out.println("Answer found");
    }

    @Test
    public void givenIPLRunsData_ShouldReturn_0HundredsAnd0Fifties_WithBestBattingAverages_ofCricketers() throws IPLAnalysisException {
        IPLAnalysis iplAnalysis = new IPLAnalysis();
        iplAnalysis.loadIplBatsmanData(BATSMAN_PATH);
        iplAnalysis.getNoHundredsAndNoFiftyDataWithBestAverages();
        Assert.assertEquals("Marcus Stoinis",IPLAnalysis.IplBatsmanData.get(IPLAnalysis.IplBatsmanData.size()-1).getPlayer());
        System.out.println("Answer found");
    }
}
