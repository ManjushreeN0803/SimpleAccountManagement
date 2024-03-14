public class Account {
    private String id;
    private String name;
    private Integer balance = 0;

    Account(String id,String name){
        this.id=id;
        this.name=name;
    }

    public Account(String id,String name,Integer balance){
        this.id=id;
        this.name=name;
        this.balance=balance;
    }

    public String getID(){
        return this.id;
    }

    public String getName(){
        return this.name;
    
    }

    public int getBalance(){
        return this.balance;
    }

    public void setId(String id){
        this.id=id;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setbalace(int balance){
        this.balance=balance;
    }

    public Integer credit(Integer amount){
        this.balance += amount;
        return this.balance ; 
    }

    public Integer debit(Integer amount){
        if(amount <= this.balance){
            this.balance -= amount;
            return this.balance;
        }else{
            System.out.println("Amount exceeded the balance");
            return this.balance;
        }
    }

    public Integer transferTo(Account acc,Integer amount){
        if(amount <= this.balance){
            acc.setbalace(acc.getBalance()+amount);
            this.balance = amount;
            return this.balance;
        }else{
            System.out.println("Amount Exceeded the balance");
            return this.balance;
        }

    }

    @Override
    public String toString() {
        return "Account[id = " + this.id + ", name = " + this.name + ", balance = " + this.balance + "]";
    }
}
