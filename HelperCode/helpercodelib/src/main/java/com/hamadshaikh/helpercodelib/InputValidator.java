package com.hamadshaikh.helpercodelib;

import android.text.TextUtils;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Hamad Shaikh on 04/08/2017.
 */

public class InputValidator {
    final String INPUT="Input!";
    final String INVALID = "Please Enter Valid ";
    final String PLEASE_ENTER = "Please Enter ";
    final String PLEASE_CHECK = "Please Mark this as checked!";

    public boolean isChecked(CheckBox checkBox,String errorMsg){
        if(checkBox==null)return false;
        else if(checkBox.isChecked()){checkBox.setError(null);return true;}
        else {
            if (errorMsg == null) checkBox.setError(PLEASE_CHECK);
            else
            checkBox.setError(errorMsg);
        }
        return false;
    }
    public boolean isValidEmail(EditText editText,String customErrorMsg){
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        if(!isNullOrEmptyEditText(editText,customErrorMsg)){
        Matcher matcher = pattern.matcher(editText.getText().toString());
        if(matcher.matches()){
            editText.setError(null); return true;
        }
            setError(editText,INVALID+customErrorMsg);
            return false;
        }
        return false;
    }

    public boolean isValidPassword(EditText editText,String customErrorMsg, boolean allowSpecialChars){
        String PATTERN;
        if(allowSpecialChars){
            //PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
            PATTERN = "^[a-zA-Z@#$%]\\w{5,19}$";
            customErrorMsg="Password!";
        }else{
            //PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,20})";
            PATTERN = "^[a-zA-Z]\\w{5,19}$";
            customErrorMsg="Password! \nA-Z a-z 0-9  allowed only";
        }
        Pattern pattern = Pattern.compile(PATTERN);
        // validate length
        if(!isNullOrEmptyEditText(editText,customErrorMsg)){
        Matcher matcher = pattern.matcher(editText.getText().toString());
            if(matcher.matches()){
                editText.setError(null); return true;
            }
            setError(editText,INVALID+customErrorMsg);
            return false;
        }

        return false;
    }

    public boolean isNullOrEmptyString(String string){
        return TextUtils.isEmpty(string);
    }

    //Check that is edit text empty or has valid length or not
    public boolean isNullOrEmptyEditText(EditText editText,String customErrorMsg){

        if(editText!=null &&  editText.length()>0){
            // has valid length that is above 2
            if(editText.length()<3){
                if(customErrorMsg!=null)
                    setError(editText,INVALID+customErrorMsg);
                //else
                    setError(editText,INVALID+INPUT);
                return true;
            }
            editText.setError(null);
            return false;
        }
            if(customErrorMsg!=null)
                setError(editText,PLEASE_ENTER+customErrorMsg);
            //else
                setError(editText,PLEASE_ENTER+INPUT);
        return true;
    }
    //print error message if it is not null
    public void setError(EditText editText,String error){
        if(editText!=null)
        editText.setError(error);
    }
    public boolean isPass_n_CPass_Same(EditText editText,EditText editText2) {
        if(editText.getText().toString().equals(editText2.getText().toString())){
            editText2.setError(null);
            return true;}
        else {setError(editText2,"Password and Confirm Password doesn't match");
            return false;}
    }



        public boolean isNumeric(EditText editText,String customErrorMsg){
        if(!isNullOrEmptyEditText(editText,customErrorMsg))
            if (TextUtils.isDigitsOnly(editText.getText().toString())){
            editText.setError(null);
            return true;
        }
        else setError(editText,INVALID+INPUT);

        return false;
    }

    //Add more validators here if necessary

}