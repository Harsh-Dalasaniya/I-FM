package com.example.indiasforestmatrix.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.example.indiasforestmatrix.R;

public class OTP extends AppCompatActivity {

    EditText EnterOTP1, EnterOTP2, EnterOTP3, EnterOTP4;
    EditText[] editTexts;
    Button Verify;
    KeyEvent k;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        EnterOTP1 = (EditText) findViewById(R.id.enter_otp1);
        EnterOTP2 = (EditText) findViewById(R.id.enter_otp2);
        EnterOTP3 = (EditText) findViewById(R.id.enter_otp3);
        EnterOTP4 = (EditText) findViewById(R.id.enter_otp4);


        editTexts = new EditText[]{EnterOTP1, EnterOTP2,EnterOTP3, EnterOTP4};

        EnterOTP1.addTextChangedListener(new PinTextWatcher(0));
        EnterOTP2.addTextChangedListener(new PinTextWatcher(1));
        EnterOTP3.addTextChangedListener(new PinTextWatcher(2));
        EnterOTP4.addTextChangedListener(new PinTextWatcher(3));

        EnterOTP1.setOnKeyListener(new PinOnKeyListener(0));
        EnterOTP2.setOnKeyListener(new PinOnKeyListener(1));
        EnterOTP3.setOnKeyListener(new PinOnKeyListener(2));
        EnterOTP4.setOnKeyListener(new PinOnKeyListener(3));

//       tosttext1=(TextView) findViewById(R.id.toasttext);
    }

    public class PinTextWatcher implements TextWatcher {

        private int currentIndex;
        private boolean isFirst = false, isLast = false;
        private String newTypedString = "";

        PinTextWatcher(int currentIndex) {
            this.currentIndex = currentIndex;

            if (currentIndex == 0)
                this.isFirst = true;
            else if (currentIndex == editTexts.length - 1)
                this.isLast = true;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            newTypedString = s.subSequence(start, start + count).toString().trim();
        }

        @Override
        public void afterTextChanged(Editable s) {

            String text = newTypedString;

            /* Detect paste event and set first char */
            if (text.length() > 1)
                text = String.valueOf(text.charAt(0)); // TODO: We can fill out other EditTexts

            editTexts[currentIndex].removeTextChangedListener(this);
            editTexts[currentIndex].setText(text);
            editTexts[currentIndex].setSelection(text.length());
            editTexts[currentIndex].addTextChangedListener(this);

            if (text.length() == 1)
                moveToNext();
            else if (text.length() == 0)
                moveToPrevious();
        }

        private void moveToNext() {
            if (!isLast)
                editTexts[currentIndex + 1].requestFocus();

            if (isAllEditTextsFilled() && isLast) { // isLast is optional
                editTexts[currentIndex].clearFocus();
                hideKeyboard();
            }
        }

        private void moveToPrevious() {
            if (!isFirst)
                editTexts[currentIndex - 1].requestFocus();
        }

        private boolean isAllEditTextsFilled() {
            for (EditText editText : editTexts)
                if (editText.getText().toString().trim().length() == 0)
                    return false;
            return true;
        }

        private void hideKeyboard() {
            if (getCurrentFocus() != null) {
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
            }
        }

    }

    public class PinOnKeyListener implements View.OnKeyListener {

        private int currentIndex;

        PinOnKeyListener(int currentIndex) {
            this.currentIndex = currentIndex;
        }

        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            if (keyCode == KeyEvent.KEYCODE_DEL && event.getAction() == KeyEvent.ACTION_DOWN) {
                if (editTexts[currentIndex].getText().toString().isEmpty() && currentIndex != 0)
                    editTexts[currentIndex - 1].requestFocus();
            }
            return false;
        }

    }


    public void btnVerify(View view) {
        Intent OTP = new Intent(OTP.this,Loginactivity.class);
        startActivity(OTP);
        finish();
    }

}












