package transfer;

public class Account {


    String agency;
    String numberAccount;
    double balance;
    Client owner;

    public Account(String agency, String numberAccount, double balance, Client owner) {
        this.agency = agency;
        this.numberAccount = numberAccount;
        this.balance = balance;
        this.owner = owner;
    }

    public String getAgency() {
        return agency;
    }

    public String getNumberAccount() {
        return numberAccount;
    }

    public double getBalance() {
        return balance;
    }

    public Client getOwner() {
        return owner;
    }

    public void deveRealizarDeposito(double value){
        balance += value;
    }

    public boolean deveRealizarSaque(double value){
        if(value > balance){
            return false;
        }
        balance -= value;
        return true;
    }

    public boolean deveRealizarTransferencia(double value, Account destiny){

        if(deveRealizarSaque(value)){
            destiny.deveRealizarDeposito(value);
            return true;
        }
        return false;
    }
}
