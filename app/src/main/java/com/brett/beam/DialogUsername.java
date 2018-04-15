package com.brett.beam;

import android.app.DialogFragment;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

/**
 * Created by Ermano
 * on 4/15/2018.
 */

public class DialogUsername extends DialogFragment implements View.OnClickListener {

    EditText edt_username;


    public interface DialogUsernameListener{
        void onUsernameSet(String username);
    }

    public DialogUsername(){}

    public static DialogUsername newInstance(String username){
        DialogUsername dialogUsername = new DialogUsername();
        Bundle args = new Bundle();
        args.putString("USERNAME", username);
        dialogUsername.setArguments(args);
        return dialogUsername;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_username, container);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        edt_username = (EditText) view.findViewById(R.id.dialog_edt_username);
        view.findViewById(R.id.dialog_btn_ok).setOnClickListener(this);

        try {

            edt_username.setText(getArguments().getString("USERNAME", ""));

        }catch (Exception e){
            e.printStackTrace();
        }

        getDialog().setTitle("Set username");


    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.dialog_btn_ok){
            String username = edt_username.getText().toString();
            if (username.length() >= 2){
                DialogUsernameListener listener = (DialogUsernameListener) getActivity();
                listener.onUsernameSet(username);
                dismiss();
            }else{
                edt_username.setError("Username not valid!");
            }

        }
    }

    @Override
    public void onResume() {
        // Store access variables for window and blank point
        Window window = getDialog().getWindow();
        Point size = new Point();
        // Store dimensions of the screen in `size`
        Display display = window.getWindowManager().getDefaultDisplay();
        display.getSize(size);
        // Set the width of the dialog proportional to 75% of the screen width
        window.setLayout((int) (size.x * 0.97), WindowManager.LayoutParams.WRAP_CONTENT);
        window.setGravity(Gravity.CENTER);
        // Call super onResume after sizing
        super.onResume();
    }
}
