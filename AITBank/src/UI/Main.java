package UI;

import aitbank.Accounts.AITBank;
import aitbank.Accounts.ChequeAccount;
import aitbank.Accounts.FixedAccount;
import aitbank.Accounts.NetSavingAccount;
import aitbank.Accounts.SavingAccount;
import aitbank.Accounts.Login;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {
    
    private Stage loginStage;
    private Stage mainStage;
    private Stage savingsStage;
    private Stage fixedStage;
    private Stage chequeStage;
    private Stage netSavingsStage;
    private Stage withdrawStage;
    private Stage withdrawLimitStage;
    private Stage depositeStage;
    private Stage checkBalanceStage;
    private Stage fixedAccInterestRateStage;
    private Stage pastStage;   // used for return page button
    
    public AITBank currentAccount;
    private String bankName = "AIT Bank  ";
    private boolean skipLoginPageButton = true;
    
    
    @Override
    public void start(Stage primaryStage) {
        loginStage(primaryStage);
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
    
    
    
    // login stage   Starts here
    public void loginStage(Stage primaryStage){
        loginStage = primaryStage;
        BorderPane logInBp = new BorderPane();
        String currentPage;
        currentPage = setBorderPaneTopLogin(logInBp, "login");
        setBorderPaneLogin(logInBp);
        
        
        Scene scene = new Scene(logInBp, Constants.SCENEWIDTH, Constants.SCENEHEIGHT);
        scene.getStylesheets().add("/styles/aitBank.css");// add connection to stylesheet per scene
        loginStage.setTitle(bankName + ": " + currentPage);
        loginStage.setScene(scene);
        loginStage.show();
        createMainStage();  // creates next stage
    } 
    
  
    // public function to change stage
    public void changeStage(Stage currentStage,Stage goToStage){
        goToStage.show();
        currentStage.hide();
    }


    
    
    
    // create main stages     (excluding logIn stage)
    public void createMainStage(){
        mainStage = new Stage();
        BorderPane mainPageBp = new BorderPane();
        
        String headerTextMain = "Main menu";
        setBorderPaneTop(mainPageBp, headerTextMain, mainStage);
        setBorderPaneCenterMain(mainPageBp);
        setBorderPaneBottomMain(mainPageBp);
        
        Scene sceneMain = new Scene(mainPageBp,Constants.SCENEWIDTH, Constants.SCENEHEIGHT);
        sceneMain.getStylesheets().add("/styles/aitBank.css");// add connection to stylesheet per scene
        mainStage.setTitle(bankName);
        mainStage.setScene(sceneMain);
    }
    
    
    // create these stages on call from main stage
    public void createChequeStage(){
        chequeStage = new Stage();
        BorderPane chequePageBp = new BorderPane();
        
        String headerTextMain = "Cheque Account";
        setBorderPaneTop(chequePageBp, headerTextMain, chequeStage);
        setBorderPaneCenterCheque(chequePageBp);
        setBorderPaneBottomCheque(chequePageBp, chequeStage);
        
        Scene sceneCheque = new Scene(chequePageBp,Constants.SCENEWIDTH, Constants.SCENEHEIGHT);
        sceneCheque.getStylesheets().add("/styles/aitBank.css");// add connection to stylesheet per scene
        chequeStage.setTitle(bankName);
        chequeStage.setScene(sceneCheque);
    }
    
    public void createSavingsStage(){
        savingsStage = new Stage();
        BorderPane savingsPageBp = new BorderPane();
        
        String headerTextMain = "Savings Account";
        setBorderPaneTop(savingsPageBp, headerTextMain, savingsStage);
        setBorderPaneCenterSavings(savingsPageBp);
        setBorderPaneBottomSavings(savingsPageBp, savingsStage);
        
        Scene sceneSavings = new Scene(savingsPageBp,Constants.SCENEWIDTH, Constants.SCENEHEIGHT);
        sceneSavings.getStylesheets().add("/styles/aitBank.css");// add connection to stylesheet per scene
        savingsStage.setTitle(bankName);
        savingsStage.setScene(sceneSavings);
    }
    
    public void createNetSavingsStage(){
        netSavingsStage = new Stage();
        BorderPane netSavingsPageBp = new BorderPane();
        
        String headerTextMain = "Net Savings Account";
        setBorderPaneTop(netSavingsPageBp , headerTextMain, netSavingsStage);
        setBorderPaneCenterNetSavings(netSavingsPageBp );
        setBorderPaneBottomNetSavings(netSavingsPageBp, netSavingsStage);
        
        Scene sceneNetSavings = new Scene(netSavingsPageBp , Constants.SCENEWIDTH, Constants.SCENEHEIGHT);
        sceneNetSavings.getStylesheets().add("/styles/aitBank.css");// add connection to stylesheet per scene
        netSavingsStage.setTitle(bankName);
        netSavingsStage.setScene(sceneNetSavings);
    }
    
    public void createFixedStage(){
        fixedStage = new Stage();
        BorderPane fixedPageBp = new BorderPane();
        
        String headerTextMain = "Fixed Account";
        setBorderPaneTop(fixedPageBp, headerTextMain, fixedStage);
        setBorderPaneCenterFixed(fixedPageBp);
        setBorderPaneBottomFixed(fixedPageBp, fixedStage);
        
        Scene sceneFixed = new Scene(fixedPageBp, Constants.SCENEWIDTH, Constants.SCENEHEIGHT);
        sceneFixed.getStylesheets().add("/styles/aitBank.css");// add connection to stylesheet per scene
        fixedStage.setTitle(bankName);
        fixedStage.setScene(sceneFixed);
    }
    

    // these stages created when called
    public void createWithdrawStage(Stage previousStage){
        pastStage = previousStage;
        withdrawStage = new Stage();
        BorderPane withdrawPageBp = new BorderPane();
        
        String headerTextMain = "Withdraw";
        setBorderPaneTop(withdrawPageBp, headerTextMain, withdrawStage);
        setBorderPaneWithdraw(withdrawPageBp);
        
        Scene sceneWithdraw = new Scene(withdrawPageBp, Constants.SCENEWIDTH, Constants.SCENEHEIGHT);
        sceneWithdraw.getStylesheets().add("/styles/aitBank.css");// add connection to stylesheet per scene
        withdrawStage.setTitle(bankName);
        withdrawStage.setScene(sceneWithdraw);
        previousStage.hide();
        withdrawStage.show();
    }
    
    public void createDepositeStage(Stage previousStage){
        pastStage = previousStage;
        depositeStage = new Stage();
        BorderPane depositeBp = new BorderPane();
        
        String headerTextMain = "Deposite";
        setBorderPaneTop(depositeBp, headerTextMain, depositeStage );
        setBorderPaneDeposite(depositeBp);
        
        Scene sceneDeposite = new Scene(depositeBp, Constants.SCENEWIDTH, Constants.SCENEHEIGHT);
        sceneDeposite.getStylesheets().add("/styles/aitBank.css");// add connection to stylesheet per scene
        depositeStage.setTitle(bankName);
        depositeStage.setScene(sceneDeposite);
        previousStage.hide();
        depositeStage.show();
    }
    
    public void createCheckBalanceStage(Stage previousStage){
        pastStage = previousStage;
        checkBalanceStage = new Stage();
        BorderPane checkbalanceBp = new BorderPane();
        
        String headerTextMain = "Check Balance";
        setBorderPaneTop(checkbalanceBp, headerTextMain, checkBalanceStage );
        setBorderPaneCenterCheckBalance(checkbalanceBp);
        setBorderPaneBottomCheckBalance(checkbalanceBp);
        
        Scene sceneCheckBalance = new Scene(checkbalanceBp, Constants.SCENEWIDTH, Constants.SCENEHEIGHT);
        sceneCheckBalance.getStylesheets().add("/styles/aitBank.css");// add connection to stylesheet per scene
        checkBalanceStage.setTitle(bankName);
        checkBalanceStage.setScene(sceneCheckBalance);
        previousStage.hide();
        checkBalanceStage.show();
    }
    
    public void createFixedInterestStage(Stage previousStage){
        pastStage = previousStage;
        fixedAccInterestRateStage = new Stage();
        BorderPane fixedInterestBp = new BorderPane();
        
        String headerTextMain = "Fixed Interest Rate";
        setBorderPaneTop(fixedInterestBp, headerTextMain, fixedAccInterestRateStage );
        setBorderPaneCenterCheckFixedInterest(fixedInterestBp);
        setBorderPaneBottomFixedInterest(fixedInterestBp);
        
        Scene sceneFixedInterest = new Scene(fixedInterestBp, Constants.SCENEWIDTH, Constants.SCENEHEIGHT);
        sceneFixedInterest.getStylesheets().add("/styles/aitBank.css");// add connection to stylesheet per scene
        fixedAccInterestRateStage.setTitle(bankName);
        fixedAccInterestRateStage.setScene(sceneFixedInterest);
        previousStage.hide();
        fixedAccInterestRateStage.show();
    }
    
    public void createChangeWithdrawLimitStage(Stage previousStage){
        pastStage = previousStage;
        withdrawLimitStage = new Stage();
        BorderPane withdrawLimitPageBp = new BorderPane();
        
        String headerTextMain = "Change Withdraw Limit";
        setBorderPaneTop(withdrawLimitPageBp, headerTextMain, withdrawLimitStage);
        setBorderPaneWithdrawLimit(withdrawLimitPageBp);
        
        Scene sceneWithdrawLimit = new Scene(withdrawLimitPageBp, Constants.SCENEWIDTH, Constants.SCENEHEIGHT);
        sceneWithdrawLimit.getStylesheets().add("/styles/aitBank.css");// add connection to stylesheet per scene
        //mainPageStage.setTitle(bankName + ": " + headerTextMain);
        withdrawLimitStage.setTitle(bankName);
        withdrawLimitStage.setScene(sceneWithdrawLimit);
        previousStage.hide();
        withdrawLimitStage.show();
    }
    
    
    
    

    

    // borderPane setup top
    // all stages except LoginStage
    public String setBorderPaneTop(BorderPane bp,String pageName, Stage currentStage){
        HBox topHb = new HBox();
        bp.setTop(topHb);
        
        //Hbox settings
        topHb.getStyleClass().add("nodeBkg");
        topHb.setAlignment(Pos.CENTER);
        
        
        //borderpane settings
        bp.setAlignment(topHb, Pos.CENTER);
        
        
        // create nodes
        Label header = new Label(pageName);
        Button logOut = new Button("Log out");
        
        
        //add nodes
        topHb.getChildren().add(header);
        topHb.getChildren().add(logOut);
        
        
        // log out button event
        logOut.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                changeStage(currentStage,loginStage);
            }
        });
              
        return header.getText();
    }

    // login does not have the logOut button
    public String setBorderPaneTopLogin(BorderPane bp,String pageName){
        VBox myVbox = new VBox();
        myVbox.getStyleClass().add("nodeBkg");
        myVbox.setAlignment(Pos.CENTER);
        
        // create label
        Label header = new Label(pageName);
        header.setAlignment(Pos.CENTER);
        
        myVbox.getChildren().add(header);
        
        // borderPane settings
        bp.setTop(myVbox);
        bp.setAlignment(myVbox, Pos.CENTER);
        

        return header.getText();
    }
    
    
        

    
    // borderPane setup lowerHalf 
    // center and bottom due to connectivity between numpad and textFields
    public void setBorderPaneLogin(BorderPane bp){
        VBox userInfo = new VBox();
        HBox userPinBox = new HBox();
        bp.setCenter(userInfo);   // set Vbox to parent for center 
        userInfo.getStyleClass().add("nodeBkg");
        userInfo.setPadding(new Insets(40));
        
        // borderPane Settings
        bp.setAlignment(userInfo, Pos.CENTER);
        
        //box settings
        userInfo.setAlignment(Pos.CENTER);
        userPinBox.setAlignment(Pos.CENTER);
        
           
        // create labels
        Label introText = new Label("Enter your details");
        Label pinLabel = new Label("User Pin: ");
        
        //create textField
        PasswordField pinField = new PasswordField();
           
        
        //Hbox setup        
        userPinBox.getChildren().add(pinLabel);
        userPinBox.getChildren().add(pinField);
        
        
        // cheat login button
        Button login = new Button("Login");
        login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Login myLogin = new Login(); 
                
                
                if (myLogin.login(pinField.getText())){  // use login class method returns true / false
                    changeStage(loginStage, mainStage);
                }
                else{
                    Alert userError = new Alert(AlertType.ERROR);
                    userError.show();
                }
            }
        });
        

        // cheat login button
        Button skipLogin = new Button("skipLogin");
        skipLogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                changeStage(loginStage, mainStage);
            }
        });
        
           
        // add to VBOX
        userInfo.getChildren().add(introText);
        userInfo.getChildren().add(userPinBox);
        userInfo.getChildren().add(login);
        
        if (skipLoginPageButton){
            userInfo.getChildren().add(skipLogin);
        }
        
        //----------------------------------------------------
        // start of bottom numpad ----------------------------------------

        
        GridPane numPad = new GridPane();
        bp.setBottom(numPad); 

        
        //numPad setting for responsive 
        numPad.setAlignment(Pos.CENTER);
        numPad.prefWidthProperty().bind(bp.widthProperty());
        numPad.prefHeightProperty().bind(bp.heightProperty());
        numPad.setHgap(4.0);
        numPad.setVgap(4.0);
        numPad.setPadding(new Insets (15));
        

        // create columns and rows     // not sure why but it offsets it to the right?????
        for (int i = 0; i < 4; i++) {
            ColumnConstraints column = new ColumnConstraints();
            column.setPercentWidth(25);
            numPad.getColumnConstraints().add(column);
        }

        // essentialy i am altering it until it works 100% is below the screen (not an issue if numpad is set to centre of the borderPane)
        for (int i = 0; i <= 4; i++) {     // if set numpad to bottom of BorderPane added a row to fix it extending over bottom (if numpad was set to borderPane center this would not be included)
            RowConstraints row = new RowConstraints();
            if (i < 4){
                row.setPercentHeight(15);  //15 x 4 = 60
            }else{
                row.setPercentHeight(25);    // 25% for margin at the bottom row (invisable) leaves 15% somewhere
            }
            
            numPad.getRowConstraints().add(row);
        }
        
        
        
        
        // create buttons
        
        Button empty = new Button (Constants.EMPTY);
        Button empty1 = new Button (Constants.EMPTY);
        Button empty2 = new Button (Constants.EMPTY);
        Button empty3 = new Button (Constants.EMPTY);
        Button enter = new Button(Constants.ENTER);
        Button clear = new Button (Constants.CLEAR);

        Button zero = new Button(Constants.ZERO);
        Button one = new Button(Constants.ONE);
        Button two = new Button(Constants.TWO);
        Button three = new Button(Constants.THREE);
        Button four = new Button(Constants.FOUR);
        Button five = new Button(Constants.FIVE);
        Button six = new Button(Constants.SIX);
        Button seven = new Button(Constants.SEVEN);
        Button eight = new Button(Constants.EIGHT);
        Button nine = new Button(Constants.NINE);  
        

        // add buttons to numPad
        //collumn 1
        numPad.add(one,0,0);
        numPad.add(four,0,1);
        numPad.add(seven,0,2);
        numPad.add(empty,0,3);

        // column 2
        numPad.add(two,1,0);
        numPad.add(five,1,1);
        numPad.add(eight,1,2);
        numPad.add(zero,1,3);

        // column 3
        numPad.add(three,2,0);
        numPad.add(six,2,1);
        numPad.add(nine,2,2);
        numPad.add(empty1,2,3);

        //  coulumn 4
        numPad.add(empty2,3,0);
        numPad.add(clear,3,1);
        numPad.add(enter,3,2);
        numPad.add(empty3,3,3);
        

        
//        // set button size  v2 Responsive
        empty.prefWidthProperty().bind(numPad.widthProperty());
        empty.prefHeightProperty().bind(numPad.heightProperty());        
        empty1.prefWidthProperty().bind(numPad.widthProperty());
        empty1.prefHeightProperty().bind(numPad.heightProperty());        
        empty2.prefWidthProperty().bind(numPad.widthProperty());
        empty2.prefHeightProperty().bind(numPad.heightProperty());
        empty3.prefWidthProperty().bind(numPad.widthProperty());
        empty3.prefHeightProperty().bind(numPad.heightProperty());    
        zero.prefWidthProperty().bind(numPad.widthProperty());
        zero.prefHeightProperty().bind(numPad.heightProperty());
        one.prefWidthProperty().bind(numPad.widthProperty());
        one.prefHeightProperty().bind(numPad.heightProperty());
        two.prefWidthProperty().bind(numPad.widthProperty());
        two.prefHeightProperty().bind(numPad.heightProperty());
        three.prefWidthProperty().bind(numPad.widthProperty());
        three.prefHeightProperty().bind(numPad.heightProperty());
        four.prefWidthProperty().bind(numPad.widthProperty());
        four.prefHeightProperty().bind(numPad.heightProperty());
        five.prefWidthProperty().bind(numPad.widthProperty());
        five.prefHeightProperty().bind(numPad.heightProperty());
        six.prefWidthProperty().bind(numPad.widthProperty());
        six.prefHeightProperty().bind(numPad.heightProperty());
        seven.prefWidthProperty().bind(numPad.widthProperty());
        seven.prefHeightProperty().bind(numPad.heightProperty());
        eight.prefWidthProperty().bind(numPad.widthProperty());
        eight.prefHeightProperty().bind(numPad.heightProperty());
        nine.prefWidthProperty().bind(numPad.widthProperty());
        nine.prefHeightProperty().bind(numPad.heightProperty());
        enter.prefWidthProperty().bind(numPad.widthProperty());
        enter.prefHeightProperty().bind(numPad.heightProperty());
        clear.prefWidthProperty().bind(numPad.widthProperty());
        clear.prefHeightProperty().bind(numPad.heightProperty());

        //Adding styles
        numPad.getStyleClass().add("nodeBkg");
        enter.getStyleClass().add("enterButton");
        clear.getStyleClass().add("clearButton");
        
        zero.getStyleClass().add("genericButton");
        one.getStyleClass().add("genericButton");
        two.getStyleClass().add("genericButton");
        three.getStyleClass().add("genericButton");
        four.getStyleClass().add("genericButton");
        five.getStyleClass().add("genericButton");
        six.getStyleClass().add("genericButton");
        seven.getStyleClass().add("genericButton");
        eight.getStyleClass().add("genericButton");
        nine.getStyleClass().add("genericButton");
        empty.getStyleClass().add("genericButton");
        empty1.getStyleClass().add("genericButton");
        empty2.getStyleClass().add("genericButton");
        empty3.getStyleClass().add("genericButton");
        
        
        


        // repeated log in cheack in case user uses enter button instead of login button
        enter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Login myLogin = new Login(); 
                
                
                if (myLogin.login(pinField.getText())){  // use login class method returns true / false
                    changeStage(loginStage, mainStage);
                }
                else{
                    Alert userError = new Alert(AlertType.ERROR);
                    userError.show();
                }
            }
        });
        
        
        
        
        
        // add num button actions
        one.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                pinField.appendText(one.getText());
            }
        });
        two.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                pinField.appendText(two.getText());
            }
        });
        three.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                pinField.appendText(three.getText());
            }
        });
        four.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                pinField.appendText(four.getText());
            }
        });
        five.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                pinField.appendText(five.getText());
            }
        });
        six.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                pinField.appendText(six.getText());
            }
        });
        seven.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                pinField.appendText(seven.getText());
            }
        });
        eight.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                pinField.appendText(eight.getText());
            }
        });
        nine.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                pinField.appendText(nine.getText());
            }
        });
        
        zero.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                pinField.appendText(zero.getText());
            }
        });
        
        clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                pinField.clear();
            }
        });
        

          
    }
    
    public void setBorderPaneDeposite(BorderPane bp){
        VBox userInfo = new VBox();
        HBox depositBox = new HBox();
        HBox resultBox = new HBox();
        bp.setCenter(userInfo);
        userInfo.getStyleClass().add("nodeBkg");
        userInfo.setPadding(new Insets(40));
        
        // borderPane Settings
        bp.setAlignment(userInfo, Pos.CENTER);
        
           
        //box settings
        userInfo.setAlignment(Pos.CENTER);
        depositBox.setAlignment(Pos.CENTER);
        resultBox.setAlignment(Pos.CENTER);
        
        // create labels
        Label accountName = new Label(currentAccount.getAccountType());
        Label emptyArea = new Label ("");
        Label withdrawText = new Label ("withdraw ammount = ");
        Label resultText = new Label ("transaction result = ");
        TextField depositAmmount = new TextField();
        TextField resultOutput = new TextField();
        
        //add to witdrawbox / resultBox
        depositBox.getChildren().add(withdrawText);
        depositBox.getChildren().add(depositAmmount);
        resultBox.getChildren().add(resultText);
        resultBox.getChildren().add(resultOutput);
        
        
        // add labels to VBOX
        userInfo.getChildren().add(accountName);
        userInfo.getChildren().add(emptyArea);
        userInfo.getChildren().add(depositBox);
        userInfo.getChildren().add(resultBox);
        
        
        //-------------------------------------------------------------
        // set BorderPane Bottom---------------------------------------
        GridPane numPad = new GridPane();
        bp.setBottom(numPad); 

        
        //numPad setting for responsive 
        numPad.setAlignment(Pos.CENTER);
        numPad.prefWidthProperty().bind(bp.widthProperty());
        numPad.prefHeightProperty().bind(bp.heightProperty());
        numPad.setHgap(4.0);
        numPad.setVgap(4.0);
        numPad.setPadding(new Insets (15));
        

        // create columns and rows     // not sure why but it offsets it to the right?????
        for (int i = 0; i < 4; i++) {
            ColumnConstraints column = new ColumnConstraints();
            column.setPercentWidth(25);
            numPad.getColumnConstraints().add(column);
        }

        // essentialy i am altering it until it works 100% is below the screen (not an issue if numpad is set to centre of the borderPane)
        for (int i = 0; i <= 4; i++) {     // if set numpad to bottom of BorderPane added a row to fix it extending over bottom (if numpad was set to borderPane center this would not be included)
            RowConstraints row = new RowConstraints();
            if (i < 4){
                row.setPercentHeight(15);  //15 x 4 = 60
            }else{
                row.setPercentHeight(25);    // 25% for margin at the bottom row (invisable) leaves 15% somewhere
            }
            
            numPad.getRowConstraints().add(row);
        }
        
        
        
        
        // create buttons
        
        Button empty = new Button (Constants.EMPTY);
        Button empty1 = new Button (Constants.EMPTY);
        Button empty2 = new Button (Constants.EMPTY);
        Button empty3 = new Button (Constants.EMPTY);
        Button enter = new Button(Constants.ENTER);
        Button clear = new Button (Constants.CLEAR);
        Button pageReturn = new Button (Constants.RETURN);

        Button zero = new Button(Constants.ZERO);
        Button one = new Button(Constants.ONE);
        Button two = new Button(Constants.TWO);
        Button three = new Button(Constants.THREE);
        Button four = new Button(Constants.FOUR);
        Button five = new Button(Constants.FIVE);
        Button six = new Button(Constants.SIX);
        Button seven = new Button(Constants.SEVEN);
        Button eight = new Button(Constants.EIGHT);
        Button nine = new Button(Constants.NINE);  




        // add buttons to numPad
        //collumn 1
        numPad.add(one,0,0);
        numPad.add(four,0,1);
        numPad.add(seven,0,2);
        numPad.add(empty,0,3);

        // column 2
        numPad.add(two,1,0);
        numPad.add(five,1,1);
        numPad.add(eight,1,2);
        numPad.add(zero,1,3);

        // column 3
        numPad.add(three,2,0);
        numPad.add(six,2,1);
        numPad.add(nine,2,2);
        numPad.add(empty1,2,3);

        //  coulumn 4
        numPad.add(pageReturn,3,0);
        numPad.add(clear,3,1);
        numPad.add(enter,3,2);
        numPad.add(empty3,3,3);
        

        
//        // set button size  v2 Responsive
        empty.prefWidthProperty().bind(numPad.widthProperty());
        empty.prefHeightProperty().bind(numPad.heightProperty());        
        empty1.prefWidthProperty().bind(numPad.widthProperty());
        empty1.prefHeightProperty().bind(numPad.heightProperty());        
        empty2.prefWidthProperty().bind(numPad.widthProperty());
        empty2.prefHeightProperty().bind(numPad.heightProperty());
        empty3.prefWidthProperty().bind(numPad.widthProperty());
        empty3.prefHeightProperty().bind(numPad.heightProperty());    
        zero.prefWidthProperty().bind(numPad.widthProperty());
        zero.prefHeightProperty().bind(numPad.heightProperty());
        one.prefWidthProperty().bind(numPad.widthProperty());
        one.prefHeightProperty().bind(numPad.heightProperty());
        two.prefWidthProperty().bind(numPad.widthProperty());
        two.prefHeightProperty().bind(numPad.heightProperty());
        three.prefWidthProperty().bind(numPad.widthProperty());
        three.prefHeightProperty().bind(numPad.heightProperty());
        four.prefWidthProperty().bind(numPad.widthProperty());
        four.prefHeightProperty().bind(numPad.heightProperty());
        five.prefWidthProperty().bind(numPad.widthProperty());
        five.prefHeightProperty().bind(numPad.heightProperty());
        six.prefWidthProperty().bind(numPad.widthProperty());
        six.prefHeightProperty().bind(numPad.heightProperty());
        seven.prefWidthProperty().bind(numPad.widthProperty());
        seven.prefHeightProperty().bind(numPad.heightProperty());
        eight.prefWidthProperty().bind(numPad.widthProperty());
        eight.prefHeightProperty().bind(numPad.heightProperty());
        nine.prefWidthProperty().bind(numPad.widthProperty());
        nine.prefHeightProperty().bind(numPad.heightProperty());
        enter.prefWidthProperty().bind(numPad.widthProperty());
        enter.prefHeightProperty().bind(numPad.heightProperty());
        clear.prefWidthProperty().bind(numPad.widthProperty());
        clear.prefHeightProperty().bind(numPad.heightProperty());
        pageReturn.prefWidthProperty().bind(numPad.widthProperty());
        pageReturn.prefHeightProperty().bind(numPad.heightProperty());
        
        
        //Adding styles
        numPad.getStyleClass().add("nodeBkg");
        enter.getStyleClass().add("enterButton");
        clear.getStyleClass().add("clearButton");
        pageReturn.getStyleClass().add("pageReturn");
        zero.getStyleClass().add("genericButton");
        one.getStyleClass().add("genericButton");
        two.getStyleClass().add("genericButton");
        three.getStyleClass().add("genericButton");
        four.getStyleClass().add("genericButton");
        five.getStyleClass().add("genericButton");
        six.getStyleClass().add("genericButton");
        seven.getStyleClass().add("genericButton");
        eight.getStyleClass().add("genericButton");
        nine.getStyleClass().add("genericButton");
        empty.getStyleClass().add("genericButton");
        empty1.getStyleClass().add("genericButton");
        empty2.getStyleClass().add("genericButton");
        empty3.getStyleClass().add("genericButton");
        
        

        // set up button actions/events
        pageReturn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                changeStage(depositeStage,pastStage);
            }
        });
        
        enter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                 currentAccount.deposit(Double.parseDouble(depositAmmount.getText())); // get text converted to double from textFiled
                 String result = "transaction complete";
                 resultOutput.clear();
                 resultOutput.appendText(result);
            }
        });
        
        
        // add num button actions
        one.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                depositAmmount.appendText(one.getText());
            }
        });
        two.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                depositAmmount.appendText(two.getText());
            }
        });
        three.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                depositAmmount.appendText(three.getText());
            }
        });
        four.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                depositAmmount.appendText(four.getText());
            }
        });
        five.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                depositAmmount.appendText(five.getText());
            }
        });
        six.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                depositAmmount.appendText(six.getText());
            }
        });
        seven.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                depositAmmount.appendText(seven.getText());
            }
        });
        eight.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                depositAmmount.appendText(eight.getText());
            }
        });
        nine.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                depositAmmount.appendText(nine.getText());
            }
        });
        
        zero.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                depositAmmount.appendText(zero.getText());
            }
        });
        
        clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                depositAmmount.clear();
            }
        });
        
        
        
    }
     
    public void setBorderPaneWithdraw(BorderPane bp){
        VBox userInfo = new VBox();
        HBox withdrawBox = new HBox();
        HBox resultBox = new HBox();
        bp.setCenter(userInfo);
        userInfo.getStyleClass().add("nodeBkg");
        userInfo.setPadding(new Insets(40));
        
        // borderPane Settings
        bp.setAlignment(userInfo, Pos.CENTER);
        
           
        //box settings
        userInfo.setAlignment(Pos.CENTER);
        withdrawBox.setAlignment(Pos.CENTER);
        resultBox.setAlignment(Pos.CENTER);
           
        
        // create labels
        Label accountName = new Label(currentAccount.getAccountType());
        Label emptyArea = new Label ("");
        Label withdrawText = new Label ("withdraw ammount = ");
        Label resultText = new Label ("transaction result = ");
        TextField withdrawAmmount = new TextField();
        TextField resultOutput = new TextField();
        
        //add to witdrawbox
        withdrawBox.getChildren().add(withdrawText);
        withdrawBox.getChildren().add(withdrawAmmount);
        resultBox.getChildren().add(resultText);
        resultBox.getChildren().add(resultOutput);
           
        // add labels to VBOX
        userInfo.getChildren().add(accountName);
        userInfo.getChildren().add(emptyArea);
        userInfo.getChildren().add(withdrawBox);
        userInfo.getChildren().add(resultBox);
        
        
        
        
        
        // set BorderPane Bottom
        GridPane numPad = new GridPane();
        bp.setBottom(numPad); 

        
        //numPad setting for responsive 
        numPad.setAlignment(Pos.CENTER);
        numPad.prefWidthProperty().bind(bp.widthProperty());
        numPad.prefHeightProperty().bind(bp.heightProperty());
        numPad.setHgap(4.0);
        numPad.setVgap(4.0);
        numPad.setPadding(new Insets (15));
        

        // create columns and rows     // not sure why but it offsets it to the right?????
        for (int i = 0; i < 4; i++) {
            ColumnConstraints column = new ColumnConstraints();
            column.setPercentWidth(25);
            numPad.getColumnConstraints().add(column);
        }

        // essentialy i am altering it until it works 100% is below the screen (not an issue if numpad is set to centre of the borderPane)
        for (int i = 0; i <= 4; i++) {     // if set numpad to bottom of BorderPane added a row to fix it extending over bottom (if numpad was set to borderPane center this would not be included)
            RowConstraints row = new RowConstraints();
            if (i < 4){
                row.setPercentHeight(15);  //15 x 4 = 60
            }else{
                row.setPercentHeight(25);    // 25% for margin at the bottom row (invisable) leaves 15% somewhere
            }
            
            numPad.getRowConstraints().add(row);
        }
        
        
        
        
        // create buttons
        
        Button empty = new Button (Constants.EMPTY);
        Button empty1 = new Button (Constants.EMPTY);
        Button empty2 = new Button (Constants.EMPTY);
        Button empty3 = new Button (Constants.EMPTY);
        Button enter = new Button(Constants.ENTER);
        Button clear = new Button (Constants.CLEAR);
        Button pageReturn = new Button (Constants.RETURN);

        Button zero = new Button(Constants.ZERO);
        Button one = new Button(Constants.ONE);
        Button two = new Button(Constants.TWO);
        Button three = new Button(Constants.THREE);
        Button four = new Button(Constants.FOUR);
        Button five = new Button(Constants.FIVE);
        Button six = new Button(Constants.SIX);
        Button seven = new Button(Constants.SEVEN);
        Button eight = new Button(Constants.EIGHT);
        Button nine = new Button(Constants.NINE);  




        // add buttons to numPad
        //collumn 1
        numPad.add(one,0,0);
        numPad.add(four,0,1);
        numPad.add(seven,0,2);
        numPad.add(empty,0,3);

        // column 2
        numPad.add(two,1,0);
        numPad.add(five,1,1);
        numPad.add(eight,1,2);
        numPad.add(zero,1,3);

        // column 3
        numPad.add(three,2,0);
        numPad.add(six,2,1);
        numPad.add(nine,2,2);
        numPad.add(empty1,2,3);

        //  coulumn 4
        numPad.add(pageReturn,3,0);
        numPad.add(clear,3,1);
        numPad.add(enter,3,2);
        numPad.add(empty3,3,3);
        

        
//        // set button size  v2 Responsive
        empty.prefWidthProperty().bind(numPad.widthProperty());
        empty.prefHeightProperty().bind(numPad.heightProperty());        
        empty1.prefWidthProperty().bind(numPad.widthProperty());
        empty1.prefHeightProperty().bind(numPad.heightProperty());        
        empty2.prefWidthProperty().bind(numPad.widthProperty());
        empty2.prefHeightProperty().bind(numPad.heightProperty());
        empty3.prefWidthProperty().bind(numPad.widthProperty());
        empty3.prefHeightProperty().bind(numPad.heightProperty());    
        zero.prefWidthProperty().bind(numPad.widthProperty());
        zero.prefHeightProperty().bind(numPad.heightProperty());
        one.prefWidthProperty().bind(numPad.widthProperty());
        one.prefHeightProperty().bind(numPad.heightProperty());
        two.prefWidthProperty().bind(numPad.widthProperty());
        two.prefHeightProperty().bind(numPad.heightProperty());
        three.prefWidthProperty().bind(numPad.widthProperty());
        three.prefHeightProperty().bind(numPad.heightProperty());
        four.prefWidthProperty().bind(numPad.widthProperty());
        four.prefHeightProperty().bind(numPad.heightProperty());
        five.prefWidthProperty().bind(numPad.widthProperty());
        five.prefHeightProperty().bind(numPad.heightProperty());
        six.prefWidthProperty().bind(numPad.widthProperty());
        six.prefHeightProperty().bind(numPad.heightProperty());
        seven.prefWidthProperty().bind(numPad.widthProperty());
        seven.prefHeightProperty().bind(numPad.heightProperty());
        eight.prefWidthProperty().bind(numPad.widthProperty());
        eight.prefHeightProperty().bind(numPad.heightProperty());
        nine.prefWidthProperty().bind(numPad.widthProperty());
        nine.prefHeightProperty().bind(numPad.heightProperty());
        enter.prefWidthProperty().bind(numPad.widthProperty());
        enter.prefHeightProperty().bind(numPad.heightProperty());
        clear.prefWidthProperty().bind(numPad.widthProperty());
        clear.prefHeightProperty().bind(numPad.heightProperty());
        pageReturn.prefWidthProperty().bind(numPad.widthProperty());
        pageReturn.prefHeightProperty().bind(numPad.heightProperty());
        

        //Adding styles
        numPad.getStyleClass().add("nodeBkg");
        enter.getStyleClass().add("enterButton");
        clear.getStyleClass().add("clearButton");
        pageReturn.getStyleClass().add("pageReturn");
        zero.getStyleClass().add("genericButton");
        one.getStyleClass().add("genericButton");
        two.getStyleClass().add("genericButton");
        three.getStyleClass().add("genericButton");
        four.getStyleClass().add("genericButton");
        five.getStyleClass().add("genericButton");
        six.getStyleClass().add("genericButton");
        seven.getStyleClass().add("genericButton");
        eight.getStyleClass().add("genericButton");
        nine.getStyleClass().add("genericButton");
        empty.getStyleClass().add("genericButton");
        empty1.getStyleClass().add("genericButton");
        empty2.getStyleClass().add("genericButton");
        empty3.getStyleClass().add("genericButton");
        
        
        

        // set up button actions/events
        pageReturn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                changeStage(withdrawStage,pastStage);
            }
        });
        
        enter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                 String result = currentAccount.withdraw(Integer.parseInt(withdrawAmmount.getText())); // get text converted to double from textFiled
                 resultOutput.clear();
                 resultOutput.appendText(result);
            }
        });
        
        
        
         // add num button actions
        one.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                withdrawAmmount.appendText(one.getText());
            }
        });
        two.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                withdrawAmmount.appendText(two.getText());
            }
        });
        three.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                withdrawAmmount.appendText(three.getText());
            }
        });
        four.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                withdrawAmmount.appendText(four.getText());
            }
        });
        five.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                withdrawAmmount.appendText(five.getText());
            }
        });
        six.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                withdrawAmmount.appendText(six.getText());
            }
        });
        seven.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                withdrawAmmount.appendText(seven.getText());
            }
        });
        eight.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                withdrawAmmount.appendText(eight.getText());
            }
        });
        nine.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                withdrawAmmount.appendText(nine.getText());
            }
        });
        zero.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                withdrawAmmount.appendText(zero.getText());
            }
        });
        
        clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                withdrawAmmount.clear();
            }
        });
        
        
        
        
    }
    
    public void setBorderPaneWithdrawLimit(BorderPane bp){
        VBox userInfo = new VBox();
        HBox withdrawBox = new HBox();
        HBox resultBox = new HBox();
        bp.setCenter(userInfo);
        userInfo.getStyleClass().add("nodeBkg");
        userInfo.setPadding(new Insets(30));  // 30 beacuse dont want it to extend to far pushing bottom of borderpane off screen
        
        // borderPane Settings
        bp.setAlignment(userInfo, Pos.CENTER);
        
           
        //box settings
        userInfo.setAlignment(Pos.CENTER);
        withdrawBox.setAlignment(Pos.CENTER);
        resultBox.setAlignment(Pos.CENTER);
           
        
        // create labels
        Label accountName = new Label(currentAccount.getAccountType());
        Label emptyArea = new Label ("");
        Label currentWithdrawLimitText = new Label ("current withdraw limit = " + currentAccount.getWithdrawLimit());
        Label newWithdrawLimitText = new Label ("new withdraw limit = ");
        Label resultText = new Label ("transaction result = ");
        TextField newWithdrawLimitField = new TextField();
        TextField resultOutput = new TextField();
        
        //add to Hbox
        withdrawBox.getChildren().add(newWithdrawLimitText);
        withdrawBox.getChildren().add(newWithdrawLimitField);
        resultBox.getChildren().add(resultText);
        resultBox.getChildren().add(resultOutput);
           
        // add to VBOX
        userInfo.getChildren().add(accountName);
        userInfo.getChildren().add(currentWithdrawLimitText);
        userInfo.getChildren().add(emptyArea);
        userInfo.getChildren().add(withdrawBox);
        userInfo.getChildren().add(resultBox);
        
        
        
        
        
        // set BorderPane Bottom
        GridPane numPad = new GridPane();
        bp.setBottom(numPad); 

        
        //numPad setting for responsive 
        numPad.setAlignment(Pos.CENTER);
        numPad.prefWidthProperty().bind(bp.widthProperty());
        numPad.prefHeightProperty().bind(bp.heightProperty());
        numPad.setHgap(4.0);
        numPad.setVgap(4.0);
        numPad.setPadding(new Insets (15));
        

        // create columns and rows     // not sure why but it offsets it to the right?????
        for (int i = 0; i < 4; i++) {
            ColumnConstraints column = new ColumnConstraints();
            column.setPercentWidth(25);
            numPad.getColumnConstraints().add(column);
        }

        // essentialy i am altering it until it works 100% is below the screen (not an issue if numpad is set to centre of the borderPane)
        for (int i = 0; i <= 4; i++) {     // if set numpad to bottom of BorderPane added a row to fix it extending over bottom (if numpad was set to borderPane center this would not be included)
            RowConstraints row = new RowConstraints();
            if (i < 4){
                row.setPercentHeight(15);  //15 x 4 = 60
            }else{
                row.setPercentHeight(25);    // 25% for margin at the bottom row (invisable) leaves 15% somewhere
            }
            
            numPad.getRowConstraints().add(row);
        }
        
        
        
        
        // create buttons
        
        Button empty = new Button (Constants.EMPTY);
        Button empty1 = new Button (Constants.EMPTY);
        Button empty2 = new Button (Constants.EMPTY);
        Button empty3 = new Button (Constants.EMPTY);
        Button enter = new Button(Constants.ENTER);
        Button clear = new Button (Constants.CLEAR);
        Button pageReturn = new Button (Constants.RETURN);

        Button zero = new Button(Constants.ZERO);
        Button one = new Button(Constants.ONE);
        Button two = new Button(Constants.TWO);
        Button three = new Button(Constants.THREE);
        Button four = new Button(Constants.FOUR);
        Button five = new Button(Constants.FIVE);
        Button six = new Button(Constants.SIX);
        Button seven = new Button(Constants.SEVEN);
        Button eight = new Button(Constants.EIGHT);
        Button nine = new Button(Constants.NINE);  




        // add buttons to numPad
        //collumn 1
        numPad.add(one,0,0);
        numPad.add(four,0,1);
        numPad.add(seven,0,2);
        numPad.add(empty,0,3);

        // column 2
        numPad.add(two,1,0);
        numPad.add(five,1,1);
        numPad.add(eight,1,2);
        numPad.add(zero,1,3);

        // column 3
        numPad.add(three,2,0);
        numPad.add(six,2,1);
        numPad.add(nine,2,2);
        numPad.add(empty1,2,3);

        //  coulumn 4
        numPad.add(pageReturn,3,0);
        numPad.add(clear,3,1);
        numPad.add(enter,3,2);
        numPad.add(empty3,3,3);
        

        
//        // set button size  v2 Responsive
        empty.prefWidthProperty().bind(numPad.widthProperty());
        empty.prefHeightProperty().bind(numPad.heightProperty());        
        empty1.prefWidthProperty().bind(numPad.widthProperty());
        empty1.prefHeightProperty().bind(numPad.heightProperty());        
        empty2.prefWidthProperty().bind(numPad.widthProperty());
        empty2.prefHeightProperty().bind(numPad.heightProperty());
        empty3.prefWidthProperty().bind(numPad.widthProperty());
        empty3.prefHeightProperty().bind(numPad.heightProperty());    
        zero.prefWidthProperty().bind(numPad.widthProperty());
        zero.prefHeightProperty().bind(numPad.heightProperty());
        one.prefWidthProperty().bind(numPad.widthProperty());
        one.prefHeightProperty().bind(numPad.heightProperty());
        two.prefWidthProperty().bind(numPad.widthProperty());
        two.prefHeightProperty().bind(numPad.heightProperty());
        three.prefWidthProperty().bind(numPad.widthProperty());
        three.prefHeightProperty().bind(numPad.heightProperty());
        four.prefWidthProperty().bind(numPad.widthProperty());
        four.prefHeightProperty().bind(numPad.heightProperty());
        five.prefWidthProperty().bind(numPad.widthProperty());
        five.prefHeightProperty().bind(numPad.heightProperty());
        six.prefWidthProperty().bind(numPad.widthProperty());
        six.prefHeightProperty().bind(numPad.heightProperty());
        seven.prefWidthProperty().bind(numPad.widthProperty());
        seven.prefHeightProperty().bind(numPad.heightProperty());
        eight.prefWidthProperty().bind(numPad.widthProperty());
        eight.prefHeightProperty().bind(numPad.heightProperty());
        nine.prefWidthProperty().bind(numPad.widthProperty());
        nine.prefHeightProperty().bind(numPad.heightProperty());
        enter.prefWidthProperty().bind(numPad.widthProperty());
        enter.prefHeightProperty().bind(numPad.heightProperty());
        clear.prefWidthProperty().bind(numPad.widthProperty());
        clear.prefHeightProperty().bind(numPad.heightProperty());
        pageReturn.prefWidthProperty().bind(numPad.widthProperty());
        pageReturn.prefHeightProperty().bind(numPad.heightProperty());


        //Adding styles
        numPad.getStyleClass().add("nodeBkg");
        enter.getStyleClass().add("enterButton");
        clear.getStyleClass().add("clearButton");
        pageReturn.getStyleClass().add("pageReturn");
        zero.getStyleClass().add("genericButton");
        one.getStyleClass().add("genericButton");
        two.getStyleClass().add("genericButton");
        three.getStyleClass().add("genericButton");
        four.getStyleClass().add("genericButton");
        five.getStyleClass().add("genericButton");
        six.getStyleClass().add("genericButton");
        seven.getStyleClass().add("genericButton");
        eight.getStyleClass().add("genericButton");
        nine.getStyleClass().add("genericButton");
        empty.getStyleClass().add("genericButton");
        empty1.getStyleClass().add("genericButton");
        empty2.getStyleClass().add("genericButton");
        empty3.getStyleClass().add("genericButton");
        
        
        
        // set up button actions/events
        pageReturn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                changeStage(withdrawLimitStage,pastStage);
            }
        });
        
        enter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                if (currentAccount instanceof SavingAccount){
                    ((SavingAccount)currentAccount).changeWithdrawLimit(Integer.parseInt(newWithdrawLimitField.getText()));
                    String result = "Savings Withdraw Limit Changed";
                    resultOutput.clear();
                    resultOutput.appendText(result); 
                }
                else if (currentAccount instanceof NetSavingAccount){
                    ((NetSavingAccount)currentAccount).changeWithdrawLimit(Integer.parseInt(newWithdrawLimitField.getText()));
                    String result = "NetSavings withdrawLimit Changed";
                    resultOutput.clear();
                    resultOutput.appendText(result); 
                }
                else{
                   String result = "incomplete Action";  // no account was selected
                   resultOutput.clear();
                   resultOutput.appendText(result); 
                }
                
            }
        });
        
        
        
         // add num button actions
        one.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                newWithdrawLimitField.appendText(one.getText());
            }
        });
        two.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                newWithdrawLimitField.appendText(two.getText());
            }
        });
        three.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                newWithdrawLimitField.appendText(three.getText());
            }
        });
        four.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                newWithdrawLimitField.appendText(four.getText());
            }
        });
        five.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                newWithdrawLimitField.appendText(five.getText());
            }
        });
        six.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                newWithdrawLimitField.appendText(six.getText());
            }
        });
        seven.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                newWithdrawLimitField.appendText(seven.getText());
            }
        });
        eight.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                newWithdrawLimitField.appendText(eight.getText());
            }
        });
        nine.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                newWithdrawLimitField.appendText(nine.getText());
            }
        });
        zero.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                newWithdrawLimitField.appendText(zero.getText());
            }
        });
        
        clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                newWithdrawLimitField.clear();
            }
        });
        
        
        
        
    }
    
    
    
    
    // set BorderPane center content   
    public void setBorderPaneCenterMain(BorderPane bp){
           VBox userInfo = new VBox();
           bp.setCenter(userInfo);
           
           //style
           userInfo.getStyleClass().add("nodeBkg");
           userInfo.setPadding(new Insets(40));
           
           // borderPane Settings
           bp.setAlignment(userInfo, Pos.CENTER);
           
           
           //Vbox settings
           userInfo.setAlignment(Pos.CENTER);
           
           // create labels
           Label savings = new Label("1: Savings Account");
           Label netSavings = new Label("2: Net Savings Account");
           Label cheque = new Label("3: Cheque Account");
           Label fixed = new Label("4: Fixed Account");
           
           
           // add labels to VBOX
           userInfo.getChildren().add(savings);
           userInfo.getChildren().add(netSavings);
           userInfo.getChildren().add(cheque);
           userInfo.getChildren().add(fixed);
           
           
           
    }
        
    public void setBorderPaneCenterSavings(BorderPane bp){
        VBox userInfo = new VBox();
        bp.setCenter(userInfo);
       
        //style
        userInfo.getStyleClass().add("nodeBkg");
        userInfo.setPadding(new Insets(40));
        
        // borderPane Settings
        bp.setAlignment(userInfo, Pos.CENTER);
        
           
        //Vbox settings
        userInfo.setAlignment(Pos.CENTER);
        
       
        // create labels top
        Label checkBalance = new Label("Check Balance");
        Label withdraw = new Label("Withdraw ");
        Label deposite = new Label("Deposite");
        Label withdrawLimit = new Label("Change Withdraw Limit");
        Label spacer = new Label("----------------");
  
        
        // add labels to VBOX
        userInfo.getChildren().add(checkBalance);
        userInfo.getChildren().add(withdraw);
        userInfo.getChildren().add(deposite);
        userInfo.getChildren().add(withdrawLimit);
        userInfo.getChildren().add(spacer);
        
        
        // adds interest Rate
        HBox interestBox = new HBox();
        //HboxSettings
        interestBox.setAlignment(Pos.CENTER);
        // create labels bottom
        Label interestText = new Label("Interest = ");
        Label interestData = new Label(getAccountInterestRate()); // get current account interest rate
        // add to Hbox
        interestBox.getChildren().add(interestText);
        interestBox.getChildren().add(interestData);
        userInfo.getChildren().add(interestBox);

        
           
    }
    
    public void setBorderPaneCenterNetSavings(BorderPane bp){
        VBox userInfo = new VBox();
        bp.setCenter(userInfo);
        
        //style
        userInfo.getStyleClass().add("nodeBkg");
        userInfo.setPadding(new Insets(40));
        
        // borderPane Settings
        bp.setAlignment(userInfo, Pos.CENTER);
           
        //Vbox settings
        userInfo.setAlignment(Pos.CENTER);
           
        // create labels
        Label checkBalance = new Label("Check Balance");
        Label withdraw = new Label("Withdraw ");
        Label deposite = new Label("Deposite");
        Label withdrawLimit = new Label("Change Withdraw Limit");
        Label spacer = new Label("----------------");

           
        // add labels to VBOX
        userInfo.getChildren().add(checkBalance);
        userInfo.getChildren().add(withdraw);
        userInfo.getChildren().add(deposite);   
        userInfo.getChildren().add(withdrawLimit);
        userInfo.getChildren().add(spacer);
        
        // adds interest Rate
        HBox interestBox = new HBox();
        //HboxSettings
        interestBox.setAlignment(Pos.CENTER);
        // create labels bottom
        Label interestText = new Label("Interest = ");
        Label interestData = new Label(getAccountInterestRate()); // get current account interest rate
        // add to Hbox
        interestBox.getChildren().add(interestText);
        interestBox.getChildren().add(interestData);
        userInfo.getChildren().add(interestBox);
        
    }
            
    public void setBorderPaneCenterCheque(BorderPane bp){
        VBox userInfo = new VBox();
        bp.setCenter(userInfo);
        
        //style
        userInfo.getStyleClass().add("nodeBkg");
        userInfo.setPadding(new Insets(40));
                
        // borderPane Settings
        bp.setAlignment(userInfo, Pos.CENTER);
        
        //Vbox settings
        userInfo.setAlignment(Pos.CENTER);
           
        // create labels
        Label checkBalance = new Label("Check Balance");
        Label withdraw = new Label("Withdraw ");
        Label deposite = new Label("Deposite");
        Label spacer = new Label("----------------");

        
        // add labels to VBOX
        userInfo.getChildren().add(checkBalance);
        userInfo.getChildren().add(withdraw);
        userInfo.getChildren().add(deposite);
        userInfo.getChildren().add(spacer);
  
        // adds interest Rate
        HBox interestBox = new HBox();
        //HboxSettings
        interestBox.setAlignment(Pos.CENTER);
        // create labels bottom
        Label interestText = new Label("Interest = ");
        Label interestData = new Label(getAccountInterestRate()); // get current account interest rate
        // add to Hbox
        interestBox.getChildren().add(interestText);
        interestBox.getChildren().add(interestData);
        userInfo.getChildren().add(interestBox);
           
    }
                
    public void setBorderPaneCenterFixed(BorderPane bp){
        VBox userInfo = new VBox();
        bp.setCenter(userInfo);
        
        //style
        userInfo.getStyleClass().add("nodeBkg");
        userInfo.setPadding(new Insets(40));
        
        // borderPane Settings
        bp.setAlignment(userInfo, Pos.CENTER);
           
        //Vbox settings
        userInfo.setAlignment(Pos.CENTER);
           
        // create labels
        Label checkBalance = new Label("Check Balance");
        Label withdraw = new Label("Withdraw ");
        Label deposite = new Label("Deposite");
        Label interestRate = new Label("Interest Rate");
        Label spacer = new Label("----------------");


        // add labels to VBOX
        userInfo.getChildren().add(checkBalance);
        userInfo.getChildren().add(withdraw);
        userInfo.getChildren().add(deposite);
        userInfo.getChildren().add(interestRate);
        userInfo.getChildren().add(spacer);
        
        

    }
 
    public void setBorderPaneCenterCheckBalance(BorderPane bp){
       VBox userInfo = new VBox();
        bp.setCenter(userInfo);
        
        //style
        userInfo.getStyleClass().add("nodeBkg");
        userInfo.setPadding(new Insets(40));
        
        // borderPane Settings
        bp.setAlignment(userInfo, Pos.CENTER);
           
        //Vbox settings
        userInfo.setAlignment(Pos.CENTER);
           
        
        // create labels
        Label accountName = new Label(currentAccount.getAccountType());
        Label emptyArea = new Label ("");
        TextField checkBalance = new TextField(currentAccount.checkBalance());
        
           
           
        // add labels to VBOX
        userInfo.getChildren().add(accountName);
        userInfo.getChildren().add(emptyArea);
        userInfo.getChildren().add(checkBalance);  
        
       
    }
    
    public void setBorderPaneCenterCheckFixedInterest(BorderPane bp){
        VBox userInfo = new VBox();
        bp.setCenter(userInfo);
        
        //style
        userInfo.getStyleClass().add("nodeBkg");
        userInfo.setPadding(new Insets(40));
        
        // borderPane Settings
        bp.setAlignment(userInfo, Pos.CENTER);
           
        //Vbox settings
        userInfo.setAlignment(Pos.CENTER);
           
        Boolean withdrawnEarly = ((FixedAccount)currentAccount).getHasWithdrawnEarly(); // need it to be an object of the boolean class to get acces to .toString()
        
        // create labels
        Label accountName = new Label(currentAccount.getAccountType());
        Label hasWithdrawnEarlyText = new Label("Withdrawn early = " + withdrawnEarly.toString());
        Label emptyArea = new Label ("");
        TextField checkInterestRate = new TextField();
        if (withdrawnEarly){
            checkInterestRate.clear();
            checkInterestRate.appendText("0");
        }
        else{ // has not withdrawn early
            checkInterestRate.clear();
            checkInterestRate.appendText(getAccountInterestRate());
        }
        

        // add labels to VBOX
        userInfo.getChildren().add(accountName);
        userInfo.getChildren().add(emptyArea);
        userInfo.getChildren().add(hasWithdrawnEarlyText);
        userInfo.getChildren().add(checkInterestRate);
        
       
    }
        
    
 
        

    // set borderPane bottom section
    public void setBorderPaneBottomMain(BorderPane bp){
        GridPane numPad = new GridPane();
        bp.setBottom(numPad); 
        numPad.getStyleClass().add("nodeBkg");
        
        //numPad setting for responsive 
        numPad.setAlignment(Pos.CENTER);
        numPad.prefWidthProperty().bind(bp.widthProperty());
        numPad.prefHeightProperty().bind(bp.heightProperty());
        numPad.setHgap(4.0);
        numPad.setVgap(4.0);
        numPad.setPadding(new Insets (15));
        

        // create columns and rows     // not sure why but it offsets it to the right?????
        for (int i = 0; i < 4; i++) {
            ColumnConstraints column = new ColumnConstraints();
            column.setPercentWidth(25);
            numPad.getColumnConstraints().add(column);
        }

        // essentialy i am altering it until it works 100% is below the screen (not an issue if numpad is set to centre of the borderPane)
        for (int i = 0; i <= 4; i++) {     // if set numpad to bottom of BorderPane added a row to fix it extending over bottom (if numpad was set to borderPane center this would not be included)
            RowConstraints row = new RowConstraints();
            if (i < 4){
                row.setPercentHeight(15);  //15 x 4 = 60
            }else{
                row.setPercentHeight(25);    // 25% for margin at the bottom row (invisable) leaves 15% somewhere
            }
            
            numPad.getRowConstraints().add(row);
        }
        
        
        
        
        // create buttons
        
        Button empty = new Button (Constants.EMPTY);
        Button empty1 = new Button (Constants.EMPTY);
        Button empty2 = new Button (Constants.EMPTY);
        Button empty3 = new Button (Constants.EMPTY);
        Button enter = new Button(Constants.ENTER);
        Button clear = new Button (Constants.CLEAR);
        Button pageReturn = new Button (Constants.RETURN);

        Button zero = new Button(Constants.ZERO);
        Button one = new Button(Constants.ONE);
        Button two = new Button(Constants.TWO);
        Button three = new Button(Constants.THREE);
        Button four = new Button(Constants.FOUR);
        Button five = new Button(Constants.FIVE);
        Button six = new Button(Constants.SIX);
        Button seven = new Button(Constants.SEVEN);
        Button eight = new Button(Constants.EIGHT);
        Button nine = new Button(Constants.NINE);  




        // add buttons to numPad
        //collumn 1
        numPad.add(one,0,0);
        numPad.add(four,0,1);
        numPad.add(seven,0,2);
        numPad.add(empty,0,3);

        // column 2
        numPad.add(two,1,0);
        numPad.add(five,1,1);
        numPad.add(eight,1,2);
        numPad.add(zero,1,3);

        // column 3
        numPad.add(three,2,0);
        numPad.add(six,2,1);
        numPad.add(nine,2,2);
        numPad.add(empty1,2,3);

        //  coulumn 4
        numPad.add(empty2,3,0);
        numPad.add(clear,3,1);
        numPad.add(enter,3,2);
        numPad.add(empty3,3,3);
        

        
//        // set button size  v2 Responsive
        empty.prefWidthProperty().bind(numPad.widthProperty());
        empty.prefHeightProperty().bind(numPad.heightProperty());        
        empty1.prefWidthProperty().bind(numPad.widthProperty());
        empty1.prefHeightProperty().bind(numPad.heightProperty());        
        empty2.prefWidthProperty().bind(numPad.widthProperty());
        empty2.prefHeightProperty().bind(numPad.heightProperty());
        empty3.prefWidthProperty().bind(numPad.widthProperty());
        empty3.prefHeightProperty().bind(numPad.heightProperty());    
        zero.prefWidthProperty().bind(numPad.widthProperty());
        zero.prefHeightProperty().bind(numPad.heightProperty());
        one.prefWidthProperty().bind(numPad.widthProperty());
        one.prefHeightProperty().bind(numPad.heightProperty());
        two.prefWidthProperty().bind(numPad.widthProperty());
        two.prefHeightProperty().bind(numPad.heightProperty());
        three.prefWidthProperty().bind(numPad.widthProperty());
        three.prefHeightProperty().bind(numPad.heightProperty());
        four.prefWidthProperty().bind(numPad.widthProperty());
        four.prefHeightProperty().bind(numPad.heightProperty());
        five.prefWidthProperty().bind(numPad.widthProperty());
        five.prefHeightProperty().bind(numPad.heightProperty());
        six.prefWidthProperty().bind(numPad.widthProperty());
        six.prefHeightProperty().bind(numPad.heightProperty());
        seven.prefWidthProperty().bind(numPad.widthProperty());
        seven.prefHeightProperty().bind(numPad.heightProperty());
        eight.prefWidthProperty().bind(numPad.widthProperty());
        eight.prefHeightProperty().bind(numPad.heightProperty());
        nine.prefWidthProperty().bind(numPad.widthProperty());
        nine.prefHeightProperty().bind(numPad.heightProperty());
        enter.prefWidthProperty().bind(numPad.widthProperty());
        enter.prefHeightProperty().bind(numPad.heightProperty());
        clear.prefWidthProperty().bind(numPad.widthProperty());
        clear.prefHeightProperty().bind(numPad.heightProperty());
        pageReturn.prefWidthProperty().bind(numPad.widthProperty());
        pageReturn.prefHeightProperty().bind(numPad.heightProperty());
        
        
        //Adding styles
        numPad.getStyleClass().add("nodeBkg");
        enter.getStyleClass().add("enterButton");
        clear.getStyleClass().add("clearButton");
        
        zero.getStyleClass().add("genericButton");
        one.getStyleClass().add("genericButton");
        two.getStyleClass().add("genericButton");
        three.getStyleClass().add("genericButton");
        four.getStyleClass().add("genericButton");
        five.getStyleClass().add("genericButton");
        six.getStyleClass().add("genericButton");
        seven.getStyleClass().add("genericButton");
        eight.getStyleClass().add("genericButton");
        nine.getStyleClass().add("genericButton");
        empty.getStyleClass().add("genericButton");
        empty1.getStyleClass().add("genericButton");
        empty2.getStyleClass().add("genericButton");
        empty3.getStyleClass().add("genericButton");
        
        
        
        // set up button actions/events
            // under buttons
                //currentAccount == choosen Account
                // create the account stage
                // change stage

        
        one.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                currentAccount = new SavingAccount();
                createSavingsStage();
                changeStage(mainStage,savingsStage);
            }
        });
        
        two.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                currentAccount = new NetSavingAccount();
                createNetSavingsStage();
                changeStage(mainStage,netSavingsStage);
            }
        });
        
        three.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                currentAccount = new ChequeAccount();
                createChequeStage();
                changeStage(mainStage,chequeStage);
            }
        });
        
        four.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                currentAccount = new FixedAccount();
                createFixedStage();
                changeStage(mainStage,fixedStage);
            }
        });
        
    } 

    public void setBorderPaneBottomSavings(BorderPane bp,Stage myStage){
        VBox userChoices = new VBox();
        bp.setBottom(userChoices);
        bp.setAlignment(userChoices, Pos.CENTER);
        userChoices.setPadding(new Insets(40));
        userChoices.getStyleClass().add("nodeBkg");
        
        
        // Vbox Settings
        userChoices.setAlignment(Pos.CENTER);
         

        // create buttons
        Button checkBalance = new Button (Constants.CHECKBALANCE);
        Button deposite = new Button (Constants.DEPOSITE);
        Button withdraw = new Button (Constants.WITHDRAW);
        Button pageReturn = new Button (Constants.RETURN);

        
        //set button size
        Double minWidth = 200.00;
        Double minHeight = 50.00;
        
        checkBalance.setMinSize(minWidth, minHeight);
        deposite.setMinSize(minWidth, minHeight);
        withdraw.setMinSize(minWidth, minHeight);
        pageReturn.setMinSize(minWidth, minHeight);

        
        // assign buttons 
        userChoices.getChildren().add(checkBalance);
        userChoices.getChildren().add(deposite);
        userChoices.getChildren().add(withdraw);
        userChoices.getChildren().add(pageReturn);



        // set up button actions/events
        pageReturn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                changeStage(myStage, mainStage);
            }
        });
        checkBalance.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                createCheckBalanceStage(myStage);
            }
        });
        deposite.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                createDepositeStage(myStage);
            }
        });
        withdraw.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                createWithdrawStage(myStage);
            }
        });
        System.out.println(getAccountHasWithdrawLimit());
        if (getAccountHasWithdrawLimit()){  // if it has withdraw limit add withdraw limit change button at bottom
            // create and set up Button
            Button changeWithdrawLimit = new Button (Constants.WITHDRAWLIMIT);
            changeWithdrawLimit.setMinSize(minWidth, minHeight);
            userChoices.getChildren().add(changeWithdrawLimit);
            
            // button event
            changeWithdrawLimit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                createChangeWithdrawLimitStage(myStage);
            }
        });
        }
        
    }
    
    public void setBorderPaneBottomNetSavings(BorderPane bp,Stage myStage){
        VBox userChoices = new VBox();
        bp.setBottom(userChoices);
        bp.setAlignment(userChoices, Pos.CENTER);
        userChoices.setPadding(new Insets(40));
        userChoices.getStyleClass().add("nodeBkg");
        
        // Vbox Settings
        userChoices.setAlignment(Pos.CENTER);
         

        // create buttons
        Button checkBalance = new Button (Constants.CHECKBALANCE);
        Button deposite = new Button (Constants.DEPOSITE);
        Button withdraw = new Button (Constants.WITHDRAW);
        Button pageReturn = new Button (Constants.RETURN);

        //set button size
        Double minWidth = 200.00;
        Double minHeight = 50.00;
        
        checkBalance.setMinSize(minWidth, minHeight);
        deposite.setMinSize(minWidth, minHeight);
        withdraw.setMinSize(minWidth, minHeight);
        pageReturn.setMinSize(minWidth, minHeight);

        
        // assign buttons 
        userChoices.getChildren().add(checkBalance);
        userChoices.getChildren().add(deposite);
        userChoices.getChildren().add(withdraw);
        userChoices.getChildren().add(pageReturn);



        // set up button actions/events
        pageReturn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                changeStage(myStage, mainStage);
            }
        });
        checkBalance.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                createCheckBalanceStage(myStage);
            }
        });
        deposite.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                createDepositeStage(myStage);
            }
        });
        withdraw.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                createWithdrawStage(myStage);
            }
        });
        
        if (getAccountHasWithdrawLimit()){  // if true add withdraw limit change button
            // create and set up Button
            Button changeWithdrawLimit = new Button (Constants.WITHDRAWLIMIT);
            changeWithdrawLimit.setMinSize(minWidth, minHeight);
            userChoices.getChildren().add(changeWithdrawLimit);
            
            // button event
            changeWithdrawLimit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                createChangeWithdrawLimitStage(myStage);
            }
        });
        }
        
    }
    
    public void setBorderPaneBottomCheque(BorderPane bp,Stage myStage){
        VBox userChoices = new VBox();
        bp.setBottom(userChoices);
        bp.setAlignment(userChoices, Pos.CENTER);
        userChoices.setPadding(new Insets(40));
        userChoices.getStyleClass().add("nodeBkg");
        
        // Vbox Settings
        userChoices.setAlignment(Pos.CENTER);
         

        // create buttons
        Button checkBalance = new Button (Constants.CHECKBALANCE);
        Button deposite = new Button (Constants.DEPOSITE);
        Button withdraw = new Button (Constants.WITHDRAW);
        Button pageReturn = new Button (Constants.RETURN);

        //set button size
        Double minWidth = 200.00;
        Double minHeight = 50.00;
        
        checkBalance.setMinSize(minWidth, minHeight);
        deposite.setMinSize(minWidth, minHeight);
        withdraw.setMinSize(minWidth, minHeight);
        pageReturn.setMinSize(minWidth, minHeight);

        
        // assign buttons 
        userChoices.getChildren().add(checkBalance);
        userChoices.getChildren().add(deposite);
        userChoices.getChildren().add(withdraw);
        userChoices.getChildren().add(pageReturn);



        // set up button actions/events
        pageReturn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                changeStage(myStage, mainStage);
            }
        });
        checkBalance.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                createCheckBalanceStage(myStage);
            }
        });
        deposite.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                createDepositeStage(myStage);
            }
        });
        withdraw.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                createWithdrawStage(myStage);
            }
        });
        
        if (getAccountHasWithdrawLimit()){  // if it has withdraw limit add withdraw limit cjange button
            // create and set up Button
            Button changeWithdrawLimit = new Button (Constants.WITHDRAWLIMIT);
            changeWithdrawLimit.setMinSize(minWidth, minHeight);
            userChoices.getChildren().add(changeWithdrawLimit);
            
            // button event
            changeWithdrawLimit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                createChangeWithdrawLimitStage(myStage);
            }
        });
        }
        
    }
    
    public void setBorderPaneBottomFixed(BorderPane bp,Stage myStage){
        VBox userChoices = new VBox();
        bp.setBottom(userChoices);
        bp.setAlignment(userChoices, Pos.CENTER);
        userChoices.setPadding(new Insets(40));
        userChoices.getStyleClass().add("nodeBkg");
        
        // Vbox Settings
        userChoices.setAlignment(Pos.CENTER);
         

        // create buttons
        Button checkBalance = new Button (Constants.CHECKBALANCE);
        Button deposite = new Button (Constants.DEPOSITE);
        Button withdraw = new Button (Constants.WITHDRAW);
        Button pageReturn = new Button (Constants.RETURN);

        //set button size
        Double minWidth = 200.00;
        Double minHeight = 50.00;
        
        checkBalance.setMinSize(minWidth, minHeight);
        deposite.setMinSize(minWidth, minHeight);
        withdraw.setMinSize(minWidth, minHeight);
        pageReturn.setMinSize(minWidth, minHeight);

        
        // assign buttons 
        userChoices.getChildren().add(checkBalance);
        userChoices.getChildren().add(deposite);
        userChoices.getChildren().add(withdraw);
        userChoices.getChildren().add(pageReturn);



        // set up button actions/events
        pageReturn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                changeStage(myStage, mainStage);
            }
        });
        checkBalance.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                createCheckBalanceStage(myStage);
            }
        });
        deposite.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                createDepositeStage(myStage);
            }
        });
        withdraw.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                createWithdrawStage(myStage);
            }
        });
        if (getAccountHasWithdrawLimit()){  // if it has withdraw limit add withdraw limit cjange button
            // create and set up Button
            Button changeWithdrawLimit = new Button (Constants.WITHDRAWLIMIT);
            changeWithdrawLimit.setMinSize(minWidth, minHeight);
            userChoices.getChildren().add(changeWithdrawLimit);
            
            // button event
            changeWithdrawLimit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                createChangeWithdrawLimitStage(myStage);
            }
            });
            
        }
        
        //ONLY FOR FIXED ACCOUNT 
        // create and set up Button to see fixed interest change
        Button interestRate = new Button (Constants.FIXEDINTERESTRATE);
        interestRate.setMinSize(minWidth, minHeight);
        userChoices.getChildren().add(interestRate);
        // button event
        interestRate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                createFixedInterestStage(myStage);
            }
        });
        
        
        
    }
    
    public void setBorderPaneBottomCheckBalance(BorderPane bp){
        VBox userChoices = new VBox();
        bp.setBottom(userChoices);
        bp.setAlignment(userChoices, Pos.CENTER);
        userChoices.setPadding(new Insets(40));
        userChoices.getStyleClass().add("nodeBkg");
        
        
        // Vbox Settings
        userChoices.setAlignment(Pos.CENTER);
         

        // create buttons
        Button pageReturn = new Button (Constants.RETURN);

        //set button size
        Double minWidth = 200.00;
        Double minHeight = 50.00;
        
        pageReturn.setMinSize(minWidth, minHeight);

        
        // assign buttons 
        userChoices.getChildren().add(pageReturn);



        // set up button actions/events
        pageReturn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                changeStage(checkBalanceStage,pastStage);
            }
        });
        
    }
    
    public void setBorderPaneBottomFixedInterest(BorderPane bp){
        VBox userChoices = new VBox();
        bp.setBottom(userChoices);
        bp.setAlignment(userChoices, Pos.CENTER);
        userChoices.setPadding(new Insets(40));
        userChoices.getStyleClass().add("nodeBkg");
        
        // Vbox Settings
        userChoices.setAlignment(Pos.CENTER);
         

        // create buttons
        Button pageReturn = new Button (Constants.RETURN);

        //set button size
        Double minWidth = 200.00;
        Double minHeight = 50.00;
        
        pageReturn.setMinSize(minWidth, minHeight);

        
        // assign buttons 
        userChoices.getChildren().add(pageReturn);



        // set up button actions/events
        pageReturn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                changeStage(fixedAccInterestRateStage,pastStage);
            }
        });
        
    }
    
    
    
    
    
    
    
    
    // find the instance of the account
    // get acces to account and return its value 
    
    public boolean getAccountHasWithdrawLimit(){
        if (currentAccount instanceof SavingAccount){
            return ((SavingAccount)currentAccount).getHasWithdrawLimit();
            
        }
        else if (currentAccount instanceof NetSavingAccount){
            return ((NetSavingAccount)currentAccount).getHasWithdrawLimit();
        }
        else if (currentAccount instanceof ChequeAccount){
            return ((ChequeAccount)currentAccount).getHasWithdrawLimit(); 
        }
        else if (currentAccount instanceof FixedAccount){
            return ((FixedAccount)currentAccount).getHasWithdrawLimit();
        }
        else{
            System.out.println("Get Account WithdrawLimit (Bool) Account not found");
            return false;
        }
    }
    
    
    // returns a string of its value not the value itself
    public String getAccountInterestRate(){
        if (currentAccount instanceof SavingAccount){
            Float myFloat;
            myFloat = ((SavingAccount)currentAccount).getInterestRate();
            return myFloat.toString();
        }
        else if (currentAccount instanceof NetSavingAccount){
            Float myFloat;
            myFloat = ((NetSavingAccount)currentAccount).getInterestRate();
            return myFloat.toString();
        }
        else if (currentAccount instanceof ChequeAccount){
            Float myFloat;
            myFloat = ((ChequeAccount)currentAccount).getInterestRate();
            return myFloat.toString();
        }
        else if (currentAccount instanceof FixedAccount){
            Float myFloat;
            myFloat = ((FixedAccount)currentAccount).getInterestRate();
            return myFloat.toString();
        }
        else{
            System.out.println("Get Account interestRate not found");
            return "error";
        }
    }
    
    
    // work but are not used
    public String getAccountDailySpent(){
        if (currentAccount instanceof SavingAccount){
            Integer myInt = ((SavingAccount)currentAccount).getDailySpentCounter();
            return myInt.toString();
            
        }
        else if (currentAccount instanceof NetSavingAccount){
            Integer myInt = ((NetSavingAccount)currentAccount).getDailySpentCounter();
            return myInt.toString();
        }
        else if (currentAccount instanceof ChequeAccount){
            Integer myInt = ((ChequeAccount)currentAccount).getDailySpentCounter();
            return myInt.toString();
        }
        else if (currentAccount instanceof FixedAccount){
            Integer myInt = ((FixedAccount)currentAccount).getDailySpentCounter();
            return myInt.toString();
        }
        else{
            System.out.println("Get Account Daily spent count not found");
            return "error";
        }
    }
    public String getAccountWithdrawLimit(){
        if (currentAccount instanceof SavingAccount){
            Integer myInt = ((SavingAccount)currentAccount).getWithdrawLimit();
            return myInt.toString();
        }
        else if (currentAccount instanceof NetSavingAccount){
            Integer myInt = ((NetSavingAccount)currentAccount).getWithdrawLimit();
            return myInt.toString();
        }
        else if (currentAccount instanceof ChequeAccount){
            Integer myInt = ((ChequeAccount)currentAccount).getWithdrawLimit(); 
            return myInt.toString();
        }
        else if (currentAccount instanceof FixedAccount){
            Integer myInt = ((FixedAccount)currentAccount).getWithdrawLimit();
            return myInt.toString();
        }
        else{
            System.out.println("Get Account WithdrawLimit (Int) Account not found");
            return "error";
        }
    }
    

}
    
    
    

    
    
    
    

    


