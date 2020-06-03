package com.example.alertdialog30032020;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button mButton, mCustomDialog;
    public Button mBtnTryAgain;
    private DialogMethod mDialogMethod;
    private Dialog mDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = findViewById(R.id.btn_showDialog);
        mCustomDialog = findViewById(R.id.btn_custom_dialog);


        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] arrayAnimals = {"Mèo", "cá", "voi", "heo", "ngựa"};
                boolean[] arrayChoice = {false, false, false, false, false};
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("Có tin nhắn thông báo mới")
                        .setIcon(R.mipmap.ic_launcher)
//                        .setNegativeButton("Không", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                Toast.makeText(MainActivity.this, "Nút không", Toast.LENGTH_SHORT).show();
//                            }
//                        })
//                        .setPositiveButton("Có", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                Toast.makeText(MainActivity.this, "Nút có", Toast.LENGTH_SHORT).show();
//                            }
//                        })
//                        .setNeutralButton("Huỷ", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                Toast.makeText(MainActivity.this, "Nút huỷ", Toast.LENGTH_SHORT).show();
//                            }
//                        })

                        //Single Choice
//                        .setSingleChoiceItems(arrayAnimals, -1, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                Toast.makeText(MainActivity.this, arrayAnimals[which], Toast.LENGTH_SHORT).show();
//                            }
//                        })

                        //Multiple Choice
                        .setMultiChoiceItems(arrayAnimals, arrayChoice, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                if (isChecked) {
                                    Toast.makeText(MainActivity.this, "Đã Chọn", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(MainActivity.this, "Bỏ chọn", Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .setCancelable(true);
                alertDialog.show();

            }
        });

        mCustomDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                final Dialog dialog = new Dialog(MainActivity.this);
//                dialog.setContentView(R.layout.dialog_connection);
//                dialog.setCanceledOnTouchOutside(false);
//
//                try {
//                    dialog.getWindow().getAttributes().windowAnimations = android.R.style.Animation_Dialog;
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//                mBtnTryAgain = dialog.findViewById(R.id.bt_try_again);
//                mBtnTryAgain.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        dialog.dismiss();
//                    }
//                });
//                dialog.show();
                mDialog = new Dialog(MainActivity.this);
                mDialogMethod = new DialogMethod(mDialog, mBtnTryAgain);
                mDialogMethod.createDialogMethod();

            }
        });
    }
}