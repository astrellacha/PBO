import java.util.Scanner; //library buat masukin input

public class Bankdemo {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Bank b1 = new Bank();

        b1.addCustomer("Felix", "Lee");
        b1.addCustomer("Wonyoung", "Jang");
        b1.addCustomer("Xinlong", "He");

        Customer c1 = b1.getCustomer(0);
        Account a1 = new Account(100000);
        Account a4 = new Account(200000);
    
        c1.setaccount(a1);
        c1.setaccount(a4);
    
        

        Customer c2 = b1.getCustomer(1);
        Account a2 = new Account(250000);
        c2.setaccount(a2);
     

        Customer c3 = b1.getCustomer(2);
        Account a3 = new Account(300000);
        c3.setaccount(a3);
        

        System.out.println("========== BANK CHA ==========");

        System.out.print("Enter your first name: ");
        String firstname = input.next();

        System.out.print("Enter your last name: ");
        String lastname = input.next();

        Customer selectedCustomer = null;

     
            for (int i = 0; i < b1.getnumofcustomers(); i++) {
                
                Customer customer = b1.getCustomer(i);
                
                if (customer.getfirstname().equalsIgnoreCase(firstname)
                    && customer.getlastname().equalsIgnoreCase(lastname)) {
                
                selectedCustomer = customer;
                break;
            }
        }
        
        if(selectedCustomer==null){
            
            System.out.println("\nCustomer not found.");
            System.out.println("Please check your name.");
            
            
        }else{
            
            System.out.println("\nWelcome, "+ selectedCustomer.getfirstname() + " " + selectedCustomer.getlastname()+ "!"); 
            System.out.println("\nYour Accounts:");
            
            for (int i = 0;
                i < selectedCustomer.getnumofaccounts();
                i++) {
                    
                    Account account =
                    selectedCustomer.getAccount(i);
                    
                    System.out.println((i + 1) + ". Balance: "+ account.getBalance());
                }
                
                System.out.print("\nChoose account: ");
                int accountChoice = input.nextInt();
                
                Account selectedAccount =
                selectedCustomer.getAccount(accountChoice - 1);
                
                int choice;
                do{
                    System.out.println("\n========== ATM MENU ==========");
                    System.out.println("1. Check Balance");
                    System.out.println("2. Deposit");
                    System.out.println("3. Withdraw");
                    System.out.println("4. Account Information");
                    System.out.println("5. Exit");
                    
                    System.out.print("Choose: ");
                    choice = input.nextInt();
                    
                    if (choice == 1) {
                        
                        System.out.println("\nCurrent Balance: "+ selectedAccount.getBalance());
                        
                    } else if (choice == 2) {
                        
                        System.out.print("\nEnter deposit amount: ");
                        double amount = input.nextDouble();
                        if (selectedAccount.deposit(amount)) {
                            
                            System.out.println( "Deposit successful!");
                            System.out.println("Current Balance: "+ selectedAccount.getBalance());
                            
                        } else {
                            System.out.println( "Invalid deposit amount.");
                        }
       
                        
                    } else if (choice == 3) {
                        System.out.print("\nEnter withdraw amount: ");
                        double amount = input.nextDouble();
                        if (selectedAccount.withdraw(amount)) {
                            
                            System.out.println("Withdraw successful!");
                            System.out.println("Current Balance: "+ selectedAccount.getBalance());
                            
                        } else {
                            System.out.println("Insufficient balance.");
                        }
                        
                    } else if (choice == 4) {
                        
                        System.out.println(
                            "\n===== ACCOUNT INFORMATION ====="
                        );
                        
                        System.out.println(
                            "Total Deposit: "
                            + selectedAccount.getDeposit()
                        );
                        
                        System.out.println(
                            "Total Withdraw: "
                            + selectedAccount.getWithdraw()
                        );
                        
                        System.out.println(
                            "Current Balance: "
                            + selectedAccount.getBalance()
                        );
                        
                    } else if (choice == 5) {
                        
                        System.out.println("\nThank you for using Bank CHA ATM!");
                        
                    } else {
                        
                        System.out.println("\nInvalid choice.");
                    }
                    
                }while (choice != 5);
            }
            input.close();
    }
}