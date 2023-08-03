package sample;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class Controller {
    @FXML
    Label result;
    long number1 = 0;
    String operator = "";
    boolean start = true;
    calculator cal1 = new calculator();

    public void editNumber(javafx.event.ActionEvent event) {
        if(start){
            result.setText("");
            start = false;
        }
        String value = ((Button)event.getSource()).getText();
        result.setText(result.getText()+value);
    }
    public void editOperator(javafx.event.ActionEvent event) {
        String value = ((Button)event.getSource()).getText();
        if(!value.equals("=")){
            if(!operator.isEmpty())
                return;
            operator = value;
            number1 = Long.parseLong(result.getText());
            result.setText("");
        }
        else {
            if(operator.isEmpty())
                return;
            long number2 = Long.parseLong(result.getText());
            double output = cal1.cal(number1 , number2 , operator);
            result.setText(String.valueOf(output));
            operator = "";
            start = true;
        }
    }
}
