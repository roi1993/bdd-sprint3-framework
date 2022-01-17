package pojos;

public class MortgageApplicationDetails {

    int id;
    int realtor_status;
    String realtor_info;
    int loan_officer_status;
    String purpose_loan;
    int est_purchase_price;
    int down_payment;
    int down_payment_percent;
    int total_loan_amount;
    String src_down_payment;
    int apply_co_borrower;
    String b_firstName;
    String b_lastName;
    String b_email;
    String b_dob;
    String b_ssn;
    String b_marital;
    String b_cell;
    String rent_own_status;
    int monthly_rental_payment;
    String employer_name;
    int gross_monthly_income;
    String eConsent_declarer_FirstName;
    String eConsent_declarer_LastName;
    String eConsent_declarer_Email;
    String created_on;
    int user_id;
    int active;

    public MortgageApplicationDetails(){}

    public MortgageApplicationDetails(int id, int realtor_status, String realtor_info, int loan_officer_status, String purpose_loan,
                                      int est_purchase_price, int down_payment, int down_payment_percent, int total_loan_amount,
                                      String src_down_payment, int apply_co_borrower, String b_firstName, String b_lastName,
                                      String b_email, String b_dob, String b_ssn, String b_marital, String b_cell, String rent_own_status,
                                      int monthly_rental_payment, String employer_name, int gross_monthly_income, String eConsent_declarer_FirstName,
                                      String eConsent_declarer_LastName, String eConsent_declarer_Email, String created_on, int user_id, int active) {
        this.id = id;
        this.realtor_status = realtor_status;
        this.realtor_info = realtor_info;
        this.loan_officer_status = loan_officer_status;
        this.purpose_loan = purpose_loan;
        this.est_purchase_price = est_purchase_price;
        this.down_payment = down_payment;
        this.down_payment_percent = down_payment_percent;
        this.total_loan_amount = total_loan_amount;
        this.src_down_payment = src_down_payment;
        this.apply_co_borrower = apply_co_borrower;
        this.b_firstName = b_firstName;
        this.b_lastName = b_lastName;
        this.b_email = b_email;
        this.b_dob = b_dob;
        this.b_ssn = b_ssn;
        this.b_marital = b_marital;
        this.b_cell = b_cell;
        this.rent_own_status = rent_own_status;
        this.monthly_rental_payment = monthly_rental_payment;
        this.employer_name = employer_name;
        this.gross_monthly_income = gross_monthly_income;
        this.eConsent_declarer_FirstName = eConsent_declarer_FirstName;
        this.eConsent_declarer_LastName = eConsent_declarer_LastName;
        this.eConsent_declarer_Email = eConsent_declarer_Email;
        this.created_on = created_on;
        this.user_id = user_id;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRealtor_status() {
        return realtor_status;
    }

    public void setRealtor_status(int realtor_status) {
        this.realtor_status = realtor_status;
    }

    public String getRealtor_info() {
        return realtor_info;
    }

    public void setRealtor_info(String realtor_info) {
        this.realtor_info = realtor_info;
    }

    public int getLoan_officer_status() {
        return loan_officer_status;
    }

    public void setLoan_officer_status(int loan_officer_status) {
        this.loan_officer_status = loan_officer_status;
    }

    public String getPurpose_loan() {
        return purpose_loan;
    }

    public void setPurpose_loan(String purpose_loan) {
        this.purpose_loan = purpose_loan;
    }

    public int getEst_purchase_price() {
        return est_purchase_price;
    }

    public void setEst_purchase_price(int est_purchase_price) {
        this.est_purchase_price = est_purchase_price;
    }

    public int getDown_payment() {
        return down_payment;
    }

    public void setDown_payment(int down_payment) {
        this.down_payment = down_payment;
    }

    public int getDown_payment_percent() {
        return down_payment_percent;
    }

    public void setDown_payment_percent(int down_payment_percent) {
        this.down_payment_percent = down_payment_percent;
    }

    public int getTotal_loan_amount() {
        return total_loan_amount;
    }

    public void setTotal_loan_amount(int total_loan_amount) {
        this.total_loan_amount = total_loan_amount;
    }

    public String getSrc_down_payment() {
        return src_down_payment;
    }

    public void setSrc_down_payment(String src_down_payment) {
        this.src_down_payment = src_down_payment;
    }

    public int getApply_co_borrower() {
        return apply_co_borrower;
    }

    public void setApply_co_borrower(int apply_co_borrower) {
        this.apply_co_borrower = apply_co_borrower;
    }

    public String getB_firstName() {
        return b_firstName;
    }

    public void setB_firstName(String b_firstName) {
        this.b_firstName = b_firstName;
    }

    public String getB_lastName() {
        return b_lastName;
    }

    public void setB_lastName(String b_lastName) {
        this.b_lastName = b_lastName;
    }

    public String getB_email() {
        return b_email;
    }

    public void setB_email(String b_email) {
        this.b_email = b_email;
    }

    public String getB_dob() {
        return b_dob;
    }

    public void setB_dob(String b_dob) {
        this.b_dob = b_dob;
    }

    public String getB_ssn() {
        return b_ssn;
    }

    public void setB_ssn(String b_ssn) {
        this.b_ssn = b_ssn;
    }

    public String getB_marital() {
        return b_marital;
    }

    public void setB_marital(String b_marital) {
        this.b_marital = b_marital;
    }

    public String getB_cell() {
        return b_cell;
    }

    public void setB_cell(String b_cell) {
        this.b_cell = b_cell;
    }

    public String getRent_own_status() {
        return rent_own_status;
    }

    public void setRent_own_status(String rent_own_status) {
        this.rent_own_status = rent_own_status;
    }

    public int getMonthly_rental_payment() {
        return monthly_rental_payment;
    }

    public void setMonthly_rental_payment(int monthly_rental_payment) {
        this.monthly_rental_payment = monthly_rental_payment;
    }

    public String getEmployer_name() {
        return employer_name;
    }

    public void setEmployer_name(String employer_name) {
        this.employer_name = employer_name;
    }

    public int getGross_monthly_income() {
        return gross_monthly_income;
    }

    public void setGross_monthly_income(int gross_monthly_income) {
        this.gross_monthly_income = gross_monthly_income;
    }

    public String geteConsent_declarer_FirstName() {
        return eConsent_declarer_FirstName;
    }

    public void seteConsent_declarer_FirstName(String eConsent_declarer_FirstName) {
        this.eConsent_declarer_FirstName = eConsent_declarer_FirstName;
    }

    public String geteConsent_declarer_LastName() {
        return eConsent_declarer_LastName;
    }

    public void seteConsent_declarer_LastName(String eConsent_declarer_LastName) {
        this.eConsent_declarer_LastName = eConsent_declarer_LastName;
    }

    public String geteConsent_declarer_Email() {
        return eConsent_declarer_Email;
    }

    public void seteConsent_declarer_Email(String eConsent_declarer_Email) {
        this.eConsent_declarer_Email = eConsent_declarer_Email;
    }

    public String getCreated_on() {
        return created_on;
    }

    public void setCreated_on(String created_on) {
        this.created_on = created_on;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return id + realtor_status+ realtor_info+
                +loan_officer_status+ purpose_loan +est_purchase_price +down_payment +down_payment_percent +total_loan_amount
                +src_down_payment + apply_co_borrower +b_firstName +b_lastName +b_email +b_dob + b_ssn + b_marital + b_cell +rent_own_status+ '\'' +
               + monthly_rental_payment +employer_name + gross_monthly_income +eConsent_declarer_FirstName
                 +eConsent_declarer_LastName +eConsent_declarer_Email +created_on +user_id +active;
//        return "single_Application{" +
//         "id= " + id +
//        ",rStatus= " +realtor_status+ '\'' +
//        ",rInfo= " +realtor_info+ '\'' +
//        ",loan amount= " +loan_officer_status+ '\'' +
//        "loan purpose= " +purpose_loan+ '\'' +
//        "estimated purchase price= " +est_purchase_price+ '\'' +
//        "down payment= " +down_payment+ '\'' +
//        "down payment % = " +down_payment_percent+ '\'' +
//        "total loan amount= " +total_loan_amount+ '\'' +
//        "down payment source=  "+src_down_payment+ '\'' +
//        "co-borrower yes/no= "+ apply_co_borrower+ '\'' +
//        "borrower's firstName= " +b_firstName+ '\'' +
//        "borrower's lastName= " +b_lastName+ '\'' +
//        "borrower's email= " +b_email+ '\'' +
//        "borrower's DOB= " + b_dob+ '\'' +
//        "borrower's SSN= " + b_ssn+ '\'' +
//        "borrower's marital status= " + b_marital+ '\'' +
//        "borrower's cellPhone= " + b_cell+ '\'' +
//        "rent/own status= " +rent_own_status+ '\'' +
//        "monthly rental payment= "+ monthly_rental_payment+ '\'' +
//        "employer's name= " +employer_name+ '\'' +
//        "gross montthly income= "+ gross_monthly_income+ '\'' +
//        "eConsent declarer's firstName= " +eConsent_declarer_FirstName+ '\'' +
//        "eConsent declarer's lastName= " +eConsent_declarer_LastName+ '\'' +
//        "eConsent declarer's Email= " +eConsent_declarer_Email+ '\'' +
//        "application created date= " +created_on+ '\'' +
//        "user id= "+user_id+ '\'' +
//        "status of application= "+active+ '\'' +
//                '}';
    }
}

