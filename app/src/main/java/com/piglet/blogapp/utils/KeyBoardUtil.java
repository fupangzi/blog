package com.piglet.blogapp.utils;


import android.app.Activity;
import android.content.Context;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.text.Editable;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.piglet.blogapp.R;

public class KeyBoardUtil {

    private KeyboardView keyboardView;
    private EditText editText;
    private Keyboard k1;// 自定义键盘

    public KeyBoardUtil(KeyboardView keyboardView, EditText editText) {
        //setInputType为InputType.TYPE_NULL   不然会弹出系统键盘
        editText.setInputType(InputType.TYPE_NULL);
        k1 = new Keyboard(editText.getContext(), R.xml.num_keyboard_normal);
        this.keyboardView = keyboardView;
        this.editText = editText;
        this.keyboardView.setOnKeyboardActionListener(listener);
        this.keyboardView.setKeyboard(k1);
        this.keyboardView.setEnabled(true);
        this.keyboardView.setPreviewEnabled(false);
    }

    private KeyboardView.OnKeyboardActionListener listener = new KeyboardView.OnKeyboardActionListener() {

        @Override
        public void swipeUp() {
        }

        @Override
        public void swipeRight() {

        }

        @Override
        public void swipeLeft() {
        }

        @Override
        public void swipeDown() {
        }

        @Override
        public void onText(CharSequence text) {
        }

        @Override
        public void onRelease(int primaryCode) {
        }

        @Override
        public void onPress(int primaryCode) {
        }

        @Override
        public void onKey(int primaryCode, int[] keyCodes) {
            Editable editable = editText.getText();
            int start = editText.getSelectionStart();
            switch (primaryCode) {
                case Keyboard.KEYCODE_DELETE:
                    if (editable != null && editable.length() > 0) {
                        if (start > 0) {
                            editable.delete(start - 1, start);
                        }
                    }
                    break;
                case Keyboard.KEYCODE_CANCEL:
                    keyboardView.setVisibility(View.GONE);
                    break;
                default:
                    editable.insert(start, Character.toString((char) primaryCode));
                    break;
            }
        }
    };

    // Activity中获取焦点时调用，显示出键盘
    public void showKeyboard() {
        int visibility = keyboardView.getVisibility();
        if (visibility == View.GONE || visibility == View.INVISIBLE) {
            keyboardView.setVisibility(View.VISIBLE);
        }
    }

    // 隐藏键盘
    public void hideKeyboard() {
        int visibility = keyboardView.getVisibility();
        if (visibility == View.VISIBLE|| visibility == View.INVISIBLE) {
            keyboardView.setVisibility(View.GONE);
        }
    }



    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        if(activity.getCurrentFocus()!=null&&activity.getCurrentFocus().getWindowToken()!=null){
            imm.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
        }

    }
    public static void hideSystemKeyboard(Activity context){
        InputMethodManager inputMethodManager= (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if(inputMethodManager!=null){
            if(context.getCurrentFocus()!=null){
                ((InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(context.getCurrentFocus().getWindowToken(), InputMethodManager.SHOW_IMPLICIT);
            }

        }

    }

    public static void showKeyBorad(Activity context,EditText editText){
        editText.setImeOptions(EditorInfo.IME_ACTION_DONE);
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {

            editText.requestFocus();
            imm.showSoftInput(editText, 0);
        }
    }
}
