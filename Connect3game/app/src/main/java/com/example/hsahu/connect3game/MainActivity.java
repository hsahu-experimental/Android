package com.example.hsahu.connect3game;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.media.Image;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    int activePlayer = 0;

    int imageResourceToDrop = R.drawable.red;

    int playerWon = -1;

    boolean gameDraw = false;

    boolean gameActive = true;

    String winnerName = null;

    // -1 means empty
    int[] gameState = {-1,-1,-1,-1,-1,-1,-1,-1,-1};

    int[][] winningPositions = {
            {0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}
    };

    private synchronized void setAndTogglePlayer(int gridClicked) {
        gameState[gridClicked] = activePlayer;
        if (activePlayer == 0) {
            imageResourceToDrop = R.drawable.yellow;
            activePlayer = 1;
            (findViewById(R.id.gridLayout)).setBackgroundTintList(ColorStateList.valueOf(Color.YELLOW));
            ((TextView)findViewById(R.id.mainTextColor)).setTextColor(Color.YELLOW);
        } else {
            imageResourceToDrop = R.drawable.red;
            (findViewById(R.id.gridLayout)).setBackgroundTintList(ColorStateList.valueOf(Color.RED));
            ((TextView)findViewById(R.id.mainTextColor)).setTextColor(Color.RED);
            activePlayer = 0;
        }
    }

    private Boolean isEmptyGrid(int gridClicked) {
        return gameState[gridClicked] == -1;
    }

    private synchronized void checkWinningScenario() {
        for(int[] winningPosition : winningPositions) {
            int a = gameState[winningPosition[0]];
            int b = gameState[winningPosition[1]];
            int c = gameState[winningPosition[2]];
            if (a == b && b == c && a != -1) {
                playerWon = a;
                if (playerWon == 0) {
                    winnerName = "Red";
                } else {
                    winnerName = "Yellow";
                }
                gameActive = false;
                break;
            }
        }

        boolean isGameOver = true;

        for (int counterState: gameState) {
            if (counterState == -1) {
                isGameOver = false;
            }
        }

        if (isGameOver) {
            gameDraw = true;
        }
    }

    public synchronized void dropin(View view) {

        Log.d("sdfgfhfhf", "" + activePlayer);
        ImageView counter = (ImageView) view;
        Integer gridClicked = Integer.parseInt(counter.getTag().toString());
        if (isEmptyGrid(gridClicked) && gameActive) {
            counter.setTranslationY(-1000f);
            counter.setImageResource(imageResourceToDrop);
            setAndTogglePlayer(gridClicked);
            counter.animate().translationYBy(1000f).setDuration(300);

            checkWinningScenario();

            if (playerWon != -1 || gameDraw == true) {
                TextView winnerMessage = findViewById(R.id.message);
                if (gameDraw) {
                    winnerMessage.setText("It's a draw !!!");
                } else {
                    winnerMessage.setText(winnerName + " has won !!!");
                }
                GridLayout gridLayout = findViewById(R.id.gridLayout);
                gridLayout.setAlpha(0.2f);
                LinearLayout linearLayout  = findViewById(R.id.playAgainLayout);
                linearLayout.setZ(3);
                linearLayout.setVisibility(View.VISIBLE);
            }
        }
    }

    public void quitGame(View view) {
        this.finishAndRemoveTask();
    }

    public void playAgain(View view) {
        LinearLayout linearLayout  = findViewById(R.id.playAgainLayout);
        linearLayout.setVisibility(View.INVISIBLE);

        for (int i = 0 ; i < gameState.length ; i++) {
            gameState[i] = -1;
        }

        GridLayout gridLayout = findViewById(R.id.gridLayout);
        gridLayout.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
        ((TextView)findViewById(R.id.mainTextColor)).setTextColor(Color.RED);
        gridLayout.setAlpha(1f);

        for (int i = 0 ; i < gridLayout.getChildCount() ; i++) {
            View childView = gridLayout.getChildAt(i);
            if (childView instanceof ImageView) {
                ((ImageView) childView).setImageResource(0);
            }
        }

        gameDraw = false;
        gameActive = true;
        playerWon = -1;
        activePlayer = 0;
        winnerName = null;
        imageResourceToDrop = R.drawable.red;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
    }
}
