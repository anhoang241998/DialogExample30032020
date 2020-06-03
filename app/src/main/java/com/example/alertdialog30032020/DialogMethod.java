package com.example.alertdialog30032020;

import android.app.Dialog;
import android.view.View;
import android.widget.Button;

public class DialogMethod {
    public Dialog dialog;
    public Button mTryAgainButton;

    public DialogMethod(Dialog dialog, Button tryAgainButton) {
        this.dialog = dialog;
        this.mTryAgainButton = tryAgainButton;
    }

    public void createDialogMethod() {
        dialog.setContentView(R.layout.dialog_connection);
        mTryAgainButton = dialog.findViewById(R.id.bt_try_again);
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().getAttributes().windowAnimations = android.R.style.Animation_Dialog;

        mTryAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
