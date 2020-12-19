public class IPLAnalysisException extends Exception{
    enum ExceptionType{
        IPL_FILE_PROBLEM, NO_DATA;
    }

    ExceptionType type;

    public IPLAnalysisException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}
