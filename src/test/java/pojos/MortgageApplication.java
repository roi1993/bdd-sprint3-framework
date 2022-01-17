package pojos;

public class MortgageApplication {

    int id;
    String b_FirstName;
    String b_LastName;
    String b_MiddleName;
    Integer totalLoanAmount;

    public MortgageApplication() {}

    public MortgageApplication(int id, String b_FirstName, String b_LastName, String b_MiddleName, Integer totalLoanAmount) {
        this.id = id;
        this.b_FirstName = b_FirstName;
        this.b_LastName = b_LastName;
        this.b_MiddleName = b_MiddleName;
        this.totalLoanAmount = totalLoanAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getB_FirstName() {
        return b_FirstName;
    }

    public void setB_FirstName(String b_FirstName) {
        this.b_FirstName = b_FirstName;
    }

    public String getB_LastName() {
        return b_LastName;
    }

    public void setB_LastName(String b_LastName) {
        this.b_LastName = b_LastName;
    }

    public String getB_MiddleName() {
        return b_MiddleName;
    }

    public void setB_MiddleName(String b_MiddleName) {
        this.b_MiddleName = b_MiddleName;
    }

    public Integer getTotalLoanAmount() {
        return totalLoanAmount;
    }

    public void setTotalLoanAmount(Integer totalLoanAmount) {
        this.totalLoanAmount = totalLoanAmount;
    }

    @Override
    public String toString() {
        return "MortgageApplication{" +
                "id=" + id +
                ", b_FirstName='" + b_FirstName + '\'' +
                ", b_LastName='" + b_LastName + '\'' +
                ", b_MiddleName='" + b_MiddleName + '\'' +
                ", totalLoanAmount=" + totalLoanAmount +
                '}';
    }
}

