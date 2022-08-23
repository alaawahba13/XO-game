package Project;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Team Leader : Roaa Ayman
 */
public class TicTacToe extends Application {
 int count =1;
    //Declartion of variables
    //A variable that indicates the last player who played
    private char playerTurn;
    // variables of calculating the score
    private int scoreTie = 0;
    private int scoreX = 0;
    private int scoreO = 0;
    //a variable that indicate which one is the winner: X or O or no winner(tie)
    private String winner;
    // set of Buttons represent the game board 3*3
    Button[][] btns = new Button[3][3];
    //Font size should increase to 25
    Font font = new Font(25);
    // Label to describe and guide the game
    Label lbl = new Label("");
    //Labels to display the score of each player, the score intially equals zero
    Label lblX = new Label("Player X");
    Label lblO = new Label("Player O");
    Label lblTie = new Label("Tie");
    Label lblScoreX = new Label("0");
    Label lblScoreO = new Label("0");
    Label lblScoreTie = new Label("0");
    //Label to ask the user who will start ?
    Label lblChoosePlayer = new Label("Choose player to start with ....");
    // Label in the second stage to display who won
    Label lblPop = new Label();
    //Label in the second Stage ask the players if they want to continue and play a new game or not
    Label lblNewGame = new Label("New Game?");
    //Button to start with player x 
    Button btnX = new Button(" Player X");
    // Button to start with player O
    Button btnO = new Button(" Player O");
    // Button to zeroing the result
    Button btnReset = new Button("Reset");
    // Button to continue and start new game 
    Button btnYes = new Button("Yes");
    // Button to end the game 
    Button btnNo = new Button("No");
    // stage to display the winner and ask the user if he wants to continue a new game
    Stage stage2 = new Stage();
    //icon(XO) in the Title bar
    Image icon = new Image("unnamed.png");
    //To set background photo
    Image gameBack = new Image("image.jpg");
    // To show the background photo 
    ImageView viewGameBack = new ImageView(gameBack);
    ImageView viewStartBack = new ImageView(gameBack);
    ImageView viewStage2Back = new ImageView(gameBack);
    //grid for the Board
    GridPane pane = new GridPane();
    //grid for the labels
    GridPane pane2 = new GridPane();
    //pane contains the name lable,the two grids , reset button
    VBox root = new VBox(10);
    // pane contains btnX and btnO 
    HBox hBox = new HBox(80);
    // pane contains the choose lable and the pane of two bttons 
    VBox vBox = new VBox(10);
    // pane to add the game background and the other nodes 
    StackPane gameAll = new StackPane();
    // pane to add the start background and the other nodes
    StackPane startAll = new StackPane();
   
 

    @Override
    public void start(Stage primaryStage) {
        // creating, editing & adding Buttons to pane
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                btns[i][j] = new Button();
                pane.add(btns[i][j], j, i);
                btns[i][j].setMinSize(90, 90);
                // to remove the focus line around the button 
                btns[i][j].setFocusTraversable(false);
                btns[i][j].setFont(font);
                btns[i][j].setTextFill(Color.BLUE);
            }
        }

        //setting styling for the hBox 
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(40));
        //setting styling for the VBox 
        vBox.setAlignment(Pos.CENTER);

        //alignmentig the board pane in center
        pane.setAlignment(Pos.CENTER);
        pane2.setHgap(50);
        pane2.setVgap(5);
        //alignmentig the labels pane in center
        pane2.setAlignment(Pos.CENTER);
        // setting text fill & style  for labels 
        lblChoosePlayer.setTextFill(Color.DARKBLUE);
        lbl.setTextFill(Color.DARKBLUE);
        lblPop.setTextFill(Color.DARKBLUE);
        // setting labels font
        lblChoosePlayer.setFont(new Font(30));
        lbl.setFont(font);
        lblX.setFont(font);
        lblO.setFont(font);
        lblTie.setFont(font);
        lblScoreO.setFont(font);
        lblScoreTie.setFont(font);
        lblScoreX.setFont(font);
        lblNewGame.setFont(font);
        lblPop.setFont(font);
        //setting buttons font
        btnX.setFont(font);
        btnO.setFont(font);
        btnReset.setFont(font);
        btnYes.setFont(font);
        btnNo.setFont(font);
        // adding and locating labels on pane2 
        pane2.add(lblX, 0, 0);
        pane2.add(lblTie, 1, 0);
        pane2.add(lblO, 2, 0);
        pane2.add(lblScoreX, 0, 1);
        pane2.add(lblScoreTie, 1, 1);
        pane2.add(lblScoreO, 2, 1);
        //adding nodes to the HBox
        hBox.getChildren().addAll(btnX, btnO);
        //adding nodes to the HBox
        vBox.getChildren().addAll(lblChoosePlayer, hBox);
        //adding background photo and nodes 
        startAll.getChildren().addAll(viewGameBack, vBox);
        // Setting spacing from top,right,bottom&left
        root.setPadding(new Insets(50));
        //alignmentig the VBox in center
        root.setAlignment(Pos.CENTER);
        //adding nodes and panes on vBox "root"
        root.getChildren().addAll(lbl, pane, pane2, btnReset);
        //adding background photo and nodes 
        gameAll.getChildren().addAll(viewStartBack, root);
        // calling this method to start the game
        setUpButton();
        //create a scene and place it on the stage 
        Scene sceneGame = new Scene(gameAll, 500, 500);
        //create a scene and place it on the stage 
        Scene sceneStart = new Scene(startAll, 500, 500);
        // adding icon on the stage 
        primaryStage.getIcons().add(icon);
        // disable resizing for the stage 
        primaryStage.setResizable(false);
        //primary stage title as the game name 
        primaryStage.setTitle("Tic Tac Toe Game");
        //add scene to stage
        primaryStage.setScene(sceneStart);
        // display stage
        primaryStage.show();

        //button to start the game with player X
        btnX.setOnAction(e -> {
            // set label text 
            lbl.setText("X player's turn");
            //set player turn to O 
               playerTurn = 'O';
            //hide the start scene and show game scene 
            primaryStage.setScene(sceneGame);
        });
        //button to start the game with player O
        btnO.setOnAction(e -> {
            // set label text 
            lbl.setText("O player's turn");
            //set player turn to O 
            playerTurn = 'X';
            //hide the start scene and show game scene 
            primaryStage.setScene(sceneGame);
        });
    }

    // Method to set up the buttons to recieve X or O according to the player turn
    public void setUpButton() {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                final int col = i;
                final int rows = j;
                btns[i][j].setOnAction(e -> {
                    //when you click on the button,the event started to call the setPlayerTurn method ,to know which player should play
                    setPlayerTurn(btns[col][rows]);
                   
                    // To make sure that the button no longer recieves a value until the new game
                    btns[col][rows].setDisable(true);
                    // Call checkWinner Method to know if there's a winner or not yet
                    checkWinner();
                    // Call the disableBtn Method to make sure that the buttons no langer recieve a value until the new game
                    disableBtn();
                    // Call calcScore Method to know how many times X or O won
                    calcScore();
                    // When the game is ended ,stage2 started to popup with the winner's name
                    popUp();
                    btns[col][rows].setOpacity(500);
                    
                });
            }
        }
        //Action to Restart the game without finishing the present game and reset all the scores (back to 0)
        btnReset.setOnAction(e -> {
        
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    // To make sure that all buttons are Enabled again for a new game
                    btns[i][j].setDisable(false);
                    // To make sure that the buttons are empty to recieve new X and O 
                    btns[i][j].setText("");
                    btns[i][j].setStyle("");
                }
            }
            scoreX = 0;
            scoreO = 0;
            scoreTie = 0;
            
            lblScoreTie.setText("" + scoreTie);
            lblScoreX.setText("" + scoreX);
            lblScoreO.setText("" + scoreO);
        });
        //Action to start a new game
        btnYes.setOnAction(e -> {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    // To make sure that all buttons are Enabled again for a new game
                    btns[i][j].setDisable(false);
                    // To make sure that the buttons are empty to recieve new X and O 
                    btns[i][j].setText("");
                    btns[i][j].setStyle("");
                    // To hide the winner stage
                    stage2.hide();
                    // If there's no winner , the last one who didn't play start the new game 
                    if ("No winner".equals(winner)) {
                        if (playerTurn == 'X') {
                            lbl.setText("O player's turn");
                        } else if (playerTurn == 'O') {
                            lbl.setText("X player's turn");
                        }
                        winner = "";

                    }// If there's a winner then he'll start the new game 
                    else if (!"".equals(winner)) {
                        lbl.setText(winner + " player's turn");
                    }
                }
            }
        });
        //Action to end the game
        btnNo.setOnAction(e -> {
            Platform.exit();
        });
    }

    public void setPlayerTurn(Button btn) {

        if (playerTurn == 'X') {
            // Player X starts the game if he won the last game
            // Comparing strings
            if ("X".equals(winner)) {
                btn.setText("X");
                // The last player is X
                playerTurn = 'X';
                // Change turn after X has played
                lbl.setText("O player's turn");
                // assign winner to null for the new game
               winner = "";
            } // if X  is not winner then change turns 
            else {
                btn.setText("O");
                playerTurn = 'O';
                lbl.setText("X player's turn");
            }
        } else if (playerTurn == 'O') {
            // Player O starts the game if he won the last game
            // Comparing strings
            if ("O".equals(winner)) {
                btn.setText("O");
                // Last player is O
                playerTurn = 'O';
                // Change turn after O has played
                lbl.setText("X player's turn");
                // assign winner to null for the new game
                winner = "";
            } // if O is not winner then change turns  
            else {
                btn.setText("X");
                playerTurn = 'X';
                lbl.setText("O player's turn");
            }
        }
    }

    public boolean checkWinner() {
        //variable to set that the game is ended, with winner if flag = true ,and without winner if flag = false
        boolean flag = false;
        // loop to check the rows
        for (int i = 0; i < 3; i++) {
            // to check if there are three buttons in the same row has the same char
            if (btns[i][0].getText() == btns[i][1].getText() && btns[i][0].getText() == btns[i][2].getText() && btns[i][0].getText() != "") {
                winner = btns[i][0].getText();
                // To set the buttons color green after won 
                btns[i][0].setStyle("-fx-background-color: #00FF00; ");
                btns[i][2].setStyle("-fx-background-color: #00FF00; ");
                btns[i][1].setStyle("-fx-background-color: #00FF00; ");
                // the game ended and we have winner
                flag = true;
            }
        }
        // loop to check the columns
        for (int j = 0; j < 3; j++) {
            // to check if there are three buttons in the same columns has the same char
            if (btns[0][j].getText() == btns[1][j].getText() && btns[1][j].getText() == btns[2][j].getText() && btns[1][j].getText() != "") {
                winner = btns[0][j].getText();
                // To set the buttons color green after won 
                btns[0][j].setStyle("-fx-background-color: #00FF00; ");
                btns[1][j].setStyle("-fx-background-color: #00FF00; ");
                btns[2][j].setStyle("-fx-background-color: #00FF00; ");
                // the game ended and we have winner
                flag = true;
            }
        }
        // To check the diagonals
        // to check if there are three buttons in the left diagonal has the same char
        if (btns[0][0].getText() == btns[1][1].getText() && btns[0][0].getText() == btns[2][2].getText() && btns[0][0].getText() != "") {
            winner = btns[0][0].getText();
            // To set the buttons color green after won 
            btns[2][2].setStyle("-fx-background-color: #00FF00; ");
            btns[1][1].setStyle("-fx-background-color: #00FF00; ");
            btns[0][0].setStyle("-fx-background-color: #00FF00; ");
            flag = true;// the game ended and we have winner 
        } // to check if there are three buttons in the right diagonal has the same char 
        else if (btns[0][2].getText() == btns[1][1].getText() && btns[2][0].getText() == btns[0][2].getText() && btns[0][2].getText() != "") {
            winner = btns[0][2].getText();
            // To set the buttons color green after won 
            btns[0][2].setStyle("-fx-background-color: #00FF00; ");
            btns[1][1].setStyle("-fx-background-color: #00FF00; ");
            btns[2][0].setStyle("-fx-background-color: #00FF00; ");
            // the game ended and we have winner
            flag = true;
        }
        // all the buttons have been choosen and no empty buttons and the last button doesn't make a winner 
        else if (isFull()) {
            winner = "No winner";
            // flag is false so there is no winner
        }
        //the game ended
        return flag;
    }

    public void disableBtn() {
        // disable All the buttons after the game ended
        if (checkWinner()) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    btns[i][j].setDisable(true);
                }
            }
        }
    }

//method to calculate each time player X or player O wins or if its a tie.
    public void calcScore() {
        // no winner condition is valid below proceeds to register score for tie
        if ("No winner".equals(winner)) {
            scoreTie++;
            lbl.setText(" ");
        } // check winner condition check out if  X or O player is winner  
        else if (checkWinner()) {
            lbl.setText(" ");
            // if X player is winner records score each time "X" wins   
            if ("X".equals(winner)) {
                scoreX++;
            } // if O player is winner records score each time "O" win   
            else if ("O".equals(winner)) {
                scoreO++;
            }
        }
        //  display score     
        lblScoreTie.setText("" + scoreTie);
        lblScoreX.setText("" + scoreX);
        lblScoreO.setText("" + scoreO);
    }

    public boolean isFull() {
        //check if Board is occupied or not
        //using nested for loop to check each row and each column
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (btns[i][j].getText() == "") {
                    //return false if the button text is empty            
                    return false;
                }
            }
        }//return true if the button text is not empty
        return true;
    }

//this stage opens up when the game ends and one or no player wins
    public void popUp() {
        //checking if game ended
        if (checkWinner() || isFull()) {
            //show the new stage showing which player has won
            if ("No winner".equals(winner)) {
                lblPop.setText("No winner");
            } else {
                lblPop.setText("Player " + winner + " won");
            }
            VBox box = new VBox(30);
            box.setAlignment(Pos.CENTER);
            HBox butns = new HBox(50);
            //adding the "yes" and "No" buttons to the scene
            butns.getChildren().addAll(btnYes, btnNo);
            butns.setAlignment(Pos.CENTER);
            //adding the label showing the winner 
            //adding the label asking if the player wants a new game
            box.getChildren().addAll(lblPop, lblNewGame, butns);
            Scene scene2 = new Scene(box, 300, 300);
            // disable resizing for the stage 
            stage2.setResizable(false);
            //set stage title as the game name 
            stage2.setTitle("Tic Tac Toe Game");
            //adding the image icon to this stage
            stage2.getIcons().add(icon);
            stage2.setScene(scene2);
            stage2.show();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
