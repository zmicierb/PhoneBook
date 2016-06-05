package by.borisevich.phone.book.dao.util;

/**
 * Created by dima on 6/5/16.
 */
public class StoredProcedureReturnException extends RuntimeException {

    public static final int UNKNOWN = -1;
    public static final int PROHIBITED = -2;
    public static final int INCORRECT = -3;
    public static final int FINISHED = -4;
    public static final int NOT_UNIQUE_INDEX = -11;

    private static final String DEFAULT_ERROR_MESSAGE = "Unknown error";

    private int errorCode;
    private String procedureName;
    private String procedureParams;

    public StoredProcedureReturnException() {
        super(DEFAULT_ERROR_MESSAGE);
        this.errorCode = UNKNOWN;
    }

    public StoredProcedureReturnException(Integer errorCode) {
        super();
        this.errorCode = errorCode;
    }

    public StoredProcedureReturnException(String message) {
        super(message == null ? DEFAULT_ERROR_MESSAGE : message);
        this.errorCode = UNKNOWN;
    }

    public StoredProcedureReturnException(Integer errorCode, String message) {
        super(message == null ? DEFAULT_ERROR_MESSAGE : message);
        this.errorCode = errorCode;
    }

    public StoredProcedureReturnException(Integer errorCode, String message, String procedureName, String procedureParams) {
        super(message == null ? DEFAULT_ERROR_MESSAGE : message);

        this.errorCode = errorCode;
        this.procedureName = procedureName;
        this.procedureParams = procedureParams;
    }

    @Override
    public String getMessage() {
        return super.getMessage();// + " \n" + this.getProcedureName() + " \n" + this.getProcedureParams();
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getProcedureName() {
        return procedureName;
    }

    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }

    public String getProcedureParams() {
        return procedureParams;
    }

    public void setProcedureParams(String procedureParams) {
        this.procedureParams = procedureParams;
    }
}

