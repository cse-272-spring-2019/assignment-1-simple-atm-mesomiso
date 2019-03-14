import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.util.ArrayList;
public class Transactions {
    private String v = "12345";
    private static int i = -1;
    private static int j = -1;
    private static int k;
    private static double balance;
    static ArrayList<Double> numbers = new ArrayList<Double>(5);
    static ArrayList<String> actions = new ArrayList<String>(5);
    private int countactions1=-1,countactions2=-1;
    private int countnumbers1=-1,countnumbers2=-1;
    private int X=-1,Y=-1,W=-1,C=-1;
    public void setBalance(double balance) {
        this.balance = balance;
    }
    private void checksizeI(){
        if(i>4)
        {
            numbers.remove(0);
            i--;
        }

    }
    private void checksizeJ(){
        if(j>4){
            actions.remove(0);
            j--;}
    }

    public void setActions(String string)
    {
        actions.add(string);
        j++;
        checksizeJ();

    }
    public void setNumbers(double number)
    {
        numbers.add(number);
        i++;
        checksizeI();
    }

    public double getBalance() {
        return balance;
    }

    public boolean Validation(String cardnumber) {

        if (cardnumber.equals(v))
            return true;
        else
            return false;
    }

    public double getNumbers1(){

        if(Y==0){
            Y=-1;
            return numbers.get(i);
        }
        else{
        while(countnumbers1<i) {
            countnumbers1++;
            countnumbers2++;
            X=-1;
            return numbers.get(i-countnumbers1);
        }
        X=0;
        return 0;
    }}

    public double getNumbers2(){
        if(countnumbers2==-1){
            return 0;
        }
        else{
        if(X==0) {
            X = -1;
            return numbers.get(0);
        }else{
        while(countnumbers2!=0)
        {

            countnumbers2--;
            countnumbers1--;
            return numbers.get(i-countnumbers2);
        }
        Y=0;
        return 0;
    }}}

    public String getActions1(){

        if(C==0){
            C=-1;
            return actions.get(j);
        }

            else{
            while(countactions1<i) {
                countactions1++;
                countactions2++;
                W=-1;
                return actions.get(j-countactions1);
            }
            W=0;
            return "End";
        }}
    public String getActions2(){
        if(countactions2==-1){
        return null;
        }
        else{
        if(W==0) {
            W = -1;

            return actions.get(0);
        }else{
            while(countactions2!=0)
            {

                countactions2--;
                countactions1--;
                return actions.get(i-countactions2);
            }
            C=0;
            return "End";
        }}}
    public double Deposit(double amount) {


        if (amount > 0) {

            balance += amount;
            numbers.add(amount);
            actions.add("Deposit");
            i++;
            j++;
            checksizeI();
            checksizeJ();
            return balance;
        } else
            return -1;
    }


    public double Withdraw(double amount) {

        if (amount > 0 && amount <= balance) {

            balance -= amount;
            numbers.add(amount);
            actions.add("Withdraw");
            i++;
            j++;
            checksizeI();
            checksizeJ();

            return balance;

        } else
            return -1;
    }



}





