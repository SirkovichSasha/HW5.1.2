package com.example.engineercalculator;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    public final static int REQUEST_CODE=1001;
    double input1 = 0, input2 = 0;
    TextView edt1;
    TextView edt2;
    boolean Addition, Subtract, Multiplication, Division, mPercent, decimal;
    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonAdd, buttonSub;
    Button buttonMul, buttonDivision, buttonPercent,buttonEqual,buttonDot,buttonCancel,buttonSwitch,buttonSwitch2,buttonSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);



        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        buttonDot = (Button) findViewById(R.id.buttonDot);
        buttonAdd = (Button) findViewById(R.id.buttonadd);
        buttonSub = (Button) findViewById(R.id.buttonsub);
        buttonMul = (Button) findViewById(R.id.buttonmul);
        buttonDivision = (Button) findViewById(R.id.buttondiv);
        buttonPercent=(Button) findViewById(R.id.buttonPercent);
        buttonCancel=(Button) findViewById(R.id.buttonCancel);
        buttonSwitch=(Button) findViewById(R.id.buttonSwitch);
        buttonSwitch2=(Button) findViewById(R.id.buttonSwitch2);
        buttonSettings=(Button)findViewById(R.id.buttonSettings);


        buttonEqual = (Button) findViewById(R.id.buttoneql);

        edt1 = (TextView) findViewById(R.id.nodisplay);
        edt2 = (TextView) findViewById(R.id.display);


        buttonSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.simpleCalclator).setVisibility(View.GONE);
                findViewById(R.id.engineerCalclator).setVisibility(View.VISIBLE);
            }
        });
        buttonSwitch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.simpleCalclator).setVisibility(View.VISIBLE);
                findViewById(R.id.engineerCalclator).setVisibility(View.GONE);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "1");
                edt2.setText(edt2.getText() + "1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "2");
                edt2.setText(edt2.getText() + "2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "3");
                edt2.setText(edt2.getText() + "3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "4");
                edt2.setText(edt2.getText() + "4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "5");
                edt2.setText(edt2.getText() + "5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "6");
                edt2.setText(edt2.getText() + "6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "7");
                edt2.setText(edt2.getText() + "7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "8");
                edt2.setText(edt2.getText() + "8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "9");
                edt2.setText(edt2.getText() + "9");
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "0");
                edt2.setText(edt2.getText() + "0");
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt1.getText().length() != 0) {
                    input1 = Float.parseFloat(edt1.getText() + "");
                    Addition = true;
                    decimal = false;
                    edt1.setText(null);
                    edt2.setText(edt2.getText() + "+");
                }
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt1.getText().length() != 0) {
                    input1 = Float.parseFloat(edt1.getText() + "");
                    Subtract = true;
                    decimal = false;
                    edt1.setText(null);
                    edt2.setText(edt2.getText() + "-");
                }
            }
        });

        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt1.getText().length() != 0) {
                    input1 = Float.parseFloat(edt1.getText() + "");
                    Multiplication = true;
                    decimal = false;
                    edt1.setText(null);
                    edt2.setText(edt2.getText() + "x");
                }
            }
        });

        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt1.getText().length() != 0) {
                    input1 = Float.parseFloat(edt1.getText() + "");
                    Division = true;
                    decimal = false;
                    edt1.setText(null);
                    edt2.setText(edt2.getText() + ":");
                }
            }
        });

        buttonPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt1.getText().length() != 0) {
                    input1 = Float.parseFloat(edt1.getText() + "");
                    mPercent = true;
                    decimal = false;
                    edt1.setText(null);
                    edt2.setText(edt2.getText() + "%");
                }
            }
        });


        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Addition || Subtract || Multiplication || Division || mPercent) {
                    input2 = Float.parseFloat(edt1.getText() + "");
                }

                if (Addition) {

                    edt2.setText(input1 + input2 + "");
                    Addition = false;
                }

                if (Subtract) {

                    edt2.setText(input1 - input2 + "");
                    Subtract = false;
                }

                if (Multiplication) {
                    edt2.setText(input1 * input2 + "");
                    Multiplication = false;
                }

                if (Division) {
                    edt2.setText(input1 / input2 + "");
                    Division = false;
                }
                if (mPercent) {
                    edt2.setText(input1 % input2 + "");
                    mPercent = false;
                }
            }
        });

        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (decimal) {
                } else {
                    edt1.setText(edt1.getText() + ".");
                    edt2.setText(edt2.getText() + ".");

                    decimal = true;
                }

            }
        });

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText("");
                edt2.setText("");
            }
        });

        buttonSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivityForResult(intent,REQUEST_CODE);

            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        ImageView pictureView = (ImageView) findViewById(R.id.pictureView);

        if (requestCode == REQUEST_CODE) {
            String picture = data.getStringExtra(SettingsActivity.PICTURE)+".jpg";
            if (resultCode == RESULT_OK) {

                File file = new File(Environment.getExternalStoragePublicDirectory(
                        Environment.DIRECTORY_DOWNLOADS), picture);
                Bitmap b = BitmapFactory.decodeFile(file.getAbsolutePath());
                pictureView.setImageBitmap(b);
            }else {
                Toast.makeText(this, "Didn't find picture "+picture, Toast.LENGTH_LONG).show();
            }
        }
    }
}

