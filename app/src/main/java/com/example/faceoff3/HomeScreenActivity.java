package com.example.faceoff3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
/* Our home screen once the user has logged in. */
public class HomeScreenActivity extends AppCompatActivity
{





    DatabaseHelper myDB;


    TextView textView_AHS_randomTip, textView_AHS_touchedFace, textView_AHS_washedHands;

    Button button_AHS_increaseWashedHands;

    ImageButton imageButton_AHS_informativeTab, imageButton_AHS_settings;




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);


        myDB = new DatabaseHelper(this);


        textView_AHS_randomTip = (TextView)findViewById(R.id.textView_AHS_randomTip);
        textView_AHS_touchedFace = (TextView)findViewById(R.id.textView_AHS_touchedFace);
        textView_AHS_washedHands = (TextView)findViewById(R.id.textView_AHS_washedHands);

        imageButton_AHS_informativeTab = (ImageButton)findViewById(R.id.imageButton_AHS_informativeTab);
        imageButton_AHS_settings = (ImageButton)findViewById(R.id.imageButton_AHS_settings);
        button_AHS_increaseWashedHands = (Button)findViewById(R.id.button_AHS_increaseWashedHands);



        textView_AHS_randomTip.setText(myDB.getRandomTip());
        textView_AHS_touchedFace.setText("You have touched your face "+myDB.getfTouches(MainActivity.currentActiveUser).toString()+" times today.");
        textView_AHS_washedHands.setText("You have washed your hands "+MainActivity.washedHands + " times today.");


        goToInformativeTab();
        goToSettings();

        increaseWashedHands();


    }


    public void goToSettings()
    {
        imageButton_AHS_settings.setOnClickListener
                (
                        new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View v)
                            {
                                Intent intent = new Intent(HomeScreenActivity.this, SettingsActivity.class);
                                startActivity(intent);

                            }
                        }
                );
    }


    public void increaseWashedHands()
    {
        button_AHS_increaseWashedHands.setOnClickListener
                (
                        new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View v)
                            {
                                MainActivity.washedHands = MainActivity.washedHands + 1;
                                textView_AHS_washedHands.setText("You have washed your hands "+MainActivity.washedHands + " times today.");
                            }
                        }
                );
    }



    // For now this is tied to a button, but we might want to make it look nicer.
public void goToInformativeTab()
{
    imageButton_AHS_informativeTab.setOnClickListener
            (
                    new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                        {
                            Intent intent = new Intent(HomeScreenActivity.this, InformativeTabActivity.class);
                            startActivity(intent);

                        }
                    }
            );
}






}