import com.jarfile.CSVBuilderException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

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

}
