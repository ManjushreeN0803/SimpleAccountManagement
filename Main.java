import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{

    public static void main(String [] args) throws IOException{
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int n,choice,accid;
        String id,name;
        int balance,amount,accidf,accidt;
        Account acc,accf,acct;  //object

        System.out.println("Enter the no of accounts you want to create");
        n = Integer.parseInt(br.readLine());
        Account [] accarr = new Account[n];
        
        for(int i=0;i<n;i++){
            System.out.println("Enter the ID/ACCNO:");
            id = br.readLine();
            System.out.println("Enter the name");
            name= br.readLine();
            System.out.println("Enter the balance");
            balance = Integer.parseInt(br.readLine());
            //getting input from user
            acc = new Account(id, name,balance); //object
            accarr[i] = acc; 
        }

        for (int i = 0; i < n; i++) {
                            System.out.println("Acc " + (i + 1) + ": " + accarr[i].toString());
                        }

        
        
        do{
            System.out.println("1.CREDIT");
            System.out.println("2.DEBIT");
            System.out.println("3.TRANSFER");
            System.out.println("Enter your choice:");
            choice = Integer.parseInt(br.readLine());
            switch (choice) {
                case 1:
                System.out.println("Select the Account");
                display(accarr, n);
                accid = Integer.parseInt(br.readLine());
                acc = accarr[accid-1];
                System.out.println("Enter the amount to be added");
                amount = Integer.parseInt(br.readLine());
                balance = acc.credit(amount);
                System.out.println("New balance: " + balance);
                System.out.println(acc.toString());
                break;
                case 2:
                System.out.println("Select the Account");
                display(accarr, n);
                accid = Integer.parseInt(br.readLine());
                acc = accarr[accid-1];
                System.out.println("Enter the amount to be withdrawen");
                amount = Integer.parseInt(br.readLine());
                balance = acc.debit(amount);
                System.out.println("New balance: " + balance);
                System.out.println(acc.toString());
                break;

                case 3:
                System.out.println("Select the Account");
                display(accarr, n);
                accidf = Integer.parseInt(br.readLine());
                accf = accarr[accidf-1];
                System.out.println("Select the Account to be transferred");
                display(accarr, n);
                accidt = Integer.parseInt(br.readLine());
                acct =accarr[accidt-1];
                System.out.println("Enter the amount to be transfer");
                amount = Integer.parseInt(br.readLine());
                balance =accf.transferTo(acct,amount);
                System.out.println("New balance: " + balance);
                System.out.println(accf.toString());
                System.out.println(acct.toString());
                break;
                
                default:
                break;
            }

        }while(choice >=1 && choice<=3);
            
        

        
    }

    public static void display(Account [] arr,int size){
        for (int i = 0; i < size; i++) {
                    System.out.println("Acc " + (i + 1) + ": " + arr[i].toString());
                }


    }
}