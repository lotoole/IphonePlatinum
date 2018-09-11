package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn10;

    @FXML
    private Button btn12;

    @FXML
    private TextField showJson;

    @FXML
    private TextField showNum;

    @FXML
    private Button btn8;

    @FXML
    private Button btn9;

    @FXML
    private Button btn6;

    @FXML
    private Button btn7;

    @FXML
    private Button btn4;

    @FXML
    private Button btn5;

    @FXML
    private Button btn2;

    @FXML
    private Button btnCall;

    @FXML
    private Button btn3;

    @FXML
    private Button btn0;

    @FXML
    private Button btn1;

    @FXML
    void addOne(ActionEvent event) {
        if(showNum.getText().length() < 10) {
            showNum.setText(showNum.getText() + "1");
        }
    }

    @FXML
    void addTwo(ActionEvent event) {
        if(showNum.getText().length() < 10) {
            showNum.setText(showNum.getText() + "2");
        }
    }

    @FXML
    void addThree(ActionEvent event) {
        if(showNum.getText().length() < 10) {
            showNum.setText(showNum.getText() + "3");
        }
    }

    @FXML
    void addFour(ActionEvent event) {
        if(showNum.getText().length() < 10) {
            showNum.setText(showNum.getText() + "4");
        }
    }

    @FXML
    void addFive(ActionEvent event) {
        if(showNum.getText().length() < 10) {
            showNum.setText(showNum.getText() + "5");
        }
    }

    @FXML
    void addSix(ActionEvent event) {
        if(showNum.getText().length() < 10) {
            showNum.setText(showNum.getText() + "6");
        }
    }

    @FXML
    void addSeven(ActionEvent event) {
        if(showNum.getText().length() < 10) {
            showNum.setText(showNum.getText() + "7");
        }
    }

    @FXML
    void addEight(ActionEvent event) {
        if(showNum.getText().length() < 10) {
            showNum.setText(showNum.getText() + "8");
        }
    }

    @FXML
    void addNine(ActionEvent event) {
        if(showNum.getText().length() < 10) {
            showNum.setText(showNum.getText() + "9");
        }
    }

    @FXML
    void addStar(ActionEvent event) {
        if(showNum.getText().length() < 10) {
            showNum.setText(showNum.getText() + "*");
        }
    }

    @FXML
    void addZero(ActionEvent event) {
        if(showNum.getText().length() < 10) {
            showNum.setText(showNum.getText() + "0");
        }
    }

    @FXML
    void addPound(ActionEvent event) {
        if(showNum.getText().length() < 10) {
            showNum.setText(showNum.getText() + "#");
        }
    }

    @FXML
    void placeCall(ActionEvent event) {
        String PhoneNumber = showNum.getText();
        PhoneAPIResponse r = PhoneAPI.verifyConnection();

        System.out.println("verify connection");
        if ( r.isSuccess() ) {
            System.out.println("success");
        } else {
            System.out.println("failed");
        }
        System.out.println("message is " + r.getMessage());
        System.out.println("data is " + r.getData().toString());

        r = PhoneAPI.placeCall(PhoneNumber);
        System.out.println("place call");
        if ( r.isSuccess() ) {
            System.out.println("success");
        } else {
            System.out.println("failed");
        }
        System.out.println("message is " + r.getMessage());
        System.out.println("data is " + r.getData().toString());


    }

    @FXML
    void initialize() {
        assert btn10 != null : "fx:id=\"btn10\" was not injected: check your FXML file 'sample.fxml'.";
        assert btn12 != null : "fx:id=\"btn12\" was not injected: check your FXML file 'sample.fxml'.";
        assert showJson != null : "fx:id=\"showJson\" was not injected: check your FXML file 'sample.fxml'.";
        assert showNum != null : "fx:id=\"showNum\" was not injected: check your FXML file 'sample.fxml'.";
        assert btn8 != null : "fx:id=\"btn8\" was not injected: check your FXML file 'sample.fxml'.";
        assert btn9 != null : "fx:id=\"btn9\" was not injected: check your FXML file 'sample.fxml'.";
        assert btn6 != null : "fx:id=\"btn6\" was not injected: check your FXML file 'sample.fxml'.";
        assert btn7 != null : "fx:id=\"btn7\" was not injected: check your FXML file 'sample.fxml'.";
        assert btn4 != null : "fx:id=\"btn4\" was not injected: check your FXML file 'sample.fxml'.";
        assert btn5 != null : "fx:id=\"btn5\" was not injected: check your FXML file 'sample.fxml'.";
        assert btn2 != null : "fx:id=\"btn2\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnCall != null : "fx:id=\"btnCall\" was not injected: check your FXML file 'sample.fxml'.";
        assert btn3 != null : "fx:id=\"btn3\" was not injected: check your FXML file 'sample.fxml'.";
        assert btn0 != null : "fx:id=\"btn0\" was not injected: check your FXML file 'sample.fxml'.";
        assert btn1 != null : "fx:id=\"btn1\" was not injected: check your FXML file 'sample.fxml'.";

    }

}
