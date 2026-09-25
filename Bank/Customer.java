public class Customer {
   private String firstname;
   private String lastname;
   private Account[]accounts=new Account[2];
   private int numberofaccount=0;

   public Customer(String firstname,String lastname){
    this.firstname=firstname;
    this.lastname=lastname;
   }
   
   public String getfirstname(){
    return firstname;
   }
   public String getlastname(){
    return lastname;
   }

   public void setaccount(Account acct){
    if (numberofaccount<2){
        accounts[numberofaccount++] = acct;
    }

    }

    public Account getAccount(int account_index){
        return accounts[account_index];
    }

    public int getnumofaccounts(){
        return numberofaccount;
    }
   
}
