import com.opencsv.bean.CsvBindByName;

public class IPLBowler {
    @CsvBindByName (column = "POS")
    private String position;

    @CsvBindByName (column = "PLAYER")
    private String player;

    @CsvBindByName (column = "Mat")
    private int matchesPlayed;

    @CsvBindByName(column = "Inns")
    private int innings;

    @CsvBindByName (column = "Ov")
    private double overs;

    @CsvBindByName (column = "Runs")
    private int runs;

    @CsvBindByName (column = "Wkts")
    private int wickets;

    @CsvBindByName (column = "BBI")
    private int bestBowlingInnings;

    @CsvBindByName (column = "Avg")
    private double average;

    @CsvBindByName (column = "Econ")
    private double economy;

    @CsvBindByName (column = "Sr")
    private double strikeRate;

    @CsvBindByName (column = "4w")
    private int fourWicketHaul;

    @CsvBindByName(column = "5w")
    private int fiveWicketHaul;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public int getInnings() {
        return innings;
    }

    public void setInnings(int innings) {
        this.innings = innings;
    }

    public double getOvers() {
        return overs;
    }

    public void setOvers(double overs) {
        this.overs = overs;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public int getWickets() {
        return wickets;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }

    public int getBestBowlingInnings() {
        return bestBowlingInnings;
    }

    public void setBestBowlingInnings(int bestBowlingInnings) {
        this.bestBowlingInnings = bestBowlingInnings;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public double getEconomy() {
        return economy;
    }

    public void setEconomy(double economy) {
        this.economy = economy;
    }

    public double getStrikeRate() {
        return strikeRate;
    }

    public void setStrikeRate(double strikeRate) {
        this.strikeRate = strikeRate;
    }

    public int getFourWicketHaul() {
        return fourWicketHaul;
    }

    public void setFourWicketHaul(int fourWicketHaul) {
        this.fourWicketHaul = fourWicketHaul;
    }

    public int getFiveWicketHaul() {
        return fiveWicketHaul;
    }

    public void setFiveWicketHaul(int fiveWicketHaul) {
        this.fiveWicketHaul = fiveWicketHaul;
    }

    @Override
    public String toString() {
        return "IPLBowler{" +
                "position='" + position + '\'' +
                ", player='" + player + '\'' +
                ", matchesPlayed=" + matchesPlayed +
                ", innings=" + innings +
                ", overs=" + overs +
                ", runs=" + runs +
                ", wickets=" + wickets +
                ", bestBowlingInnings=" + bestBowlingInnings +
                ", average=" + average +
                ", economy=" + economy +
                ", strikeRate=" + strikeRate +
                ", fourWicketHaul=" + fourWicketHaul +
                ", fiveWicketHaul=" + fiveWicketHaul +
                '}';
    }
}
