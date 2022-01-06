package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void replaceText(View view){
        EditText replaceByET=findViewById(R.id.replaceByET);
        EditText messageET=findViewById(R.id.messageET);
        TextView displayTV=findViewById(R.id.displayTV);
        TextView displayOperationTV=findViewById(R.id.displayOperationTV);
        if( replaceByET.getText().toString()!="" && messageET.getText().toString().contains("*") ) {
            int indexOfStar = messageET.getText().toString().indexOf("*");
            displayTV.setText(messageET.getText().toString().substring(0, indexOfStar) +
                    replaceByET.getText().toString() + messageET.getText().toString().substring(indexOfStar + 1));
            displayOperationTV.setText("Replaced * with " + replaceByET.getText().toString() + " at position " + indexOfStar);
        }
        else{
            displayTV.setText(messageET.getText().toString());
        }
    }

    public void replaceAll(View view){
        EditText replaceByET=findViewById(R.id.replaceByET);
        EditText messageET=findViewById(R.id.messageET);
        TextView displayTV=findViewById(R.id.displayTV);
        TextView displayOperationTV=findViewById(R.id.displayOperationTV);
        if(replaceByET.getText().toString()!="" && messageET.getText().toString().contains("*") ) {
            displayTV.setText(messageET.getText().toString().replaceAll("\\*", replaceByET.getText().toString()));
            displayOperationTV.setText("Replaced all *'s with " + replaceByET.getText().toString());
        }
        else{
            displayTV.setText(messageET.getText().toString());
        }
    }

    public void swap(View view){
        EditText srhET=findViewById(R.id.srhET);
        TextView srhTV=findViewById(R.id.srhTV);
        String originalString= srhET.getText().toString();
        int middleIndex=originalString.length()/2;
        String finalString=originalString.substring(middleIndex)+originalString.substring(0,middleIndex);
        srhTV.setText(finalString);
        TextView displayOperationTV=findViewById(R.id.displayOperationTV);
        displayOperationTV.setText("Swaped the String "+originalString+" to "+ finalString );
    }

    public void rotate(View view){
        EditText srhET=findViewById(R.id.srhET);
        TextView srhTV=findViewById(R.id.srhTV);
        String originalString = srhET.getText().toString();
        String finalString="";
        for(int i=1;i<=originalString.length()-1;i+=2 ){
                finalString = finalString + originalString.charAt(i) + originalString.charAt(i - 1);
        }
        if(originalString.length()%2!=0) {
            finalString=finalString+originalString.substring(originalString.length()-1);
        }
        srhTV.setText(finalString);
        TextView displayOperationTV=findViewById(R.id.displayOperationTV);
        displayOperationTV.setText("Rotated the String "+originalString+" to "+ finalString);
    }

    public void hash(View view){
        EditText srhET=findViewById(R.id.srhET);
        TextView srhTV=findViewById(R.id.srhTV);
        String originalString= srhET.getText().toString();
        int hash=originalString.hashCode();
        srhTV.setText(String.valueOf(hash));
        TextView displayOperationTV=findViewById(R.id.displayOperationTV);
        displayOperationTV.setText("Hashed the String "+originalString+" to "+ String.valueOf(hash) );
    }

    public void encode(View view){
        EditText srhET=findViewById(R.id.srhET);
        TextView srhTV=findViewById(R.id.srhTV);
        String originalString= srhET.getText().toString();
        byte[] bytes = originalString.getBytes(StandardCharsets.UTF_8);
        String finalString="";
        for (byte b : bytes) {
            finalString=finalString+b;
        }
        srhTV.setText(finalString);
        TextView displayOperationTV=findViewById(R.id.displayOperationTV);
        displayOperationTV.setText("Encoded the String "+originalString+" to "+ finalString );
    }




}