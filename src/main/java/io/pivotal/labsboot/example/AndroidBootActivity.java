package io.pivotal.labsboot.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import javax.inject.Inject;

import io.pivotal.labsboot.AndroidBootApplication;
import io.pivotal.labsboot.R;

public class AndroidBootActivity extends Activity {

    @Inject
    protected AndroidBootDelegate mAndroidBootDelegate;
    private EditText mEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final AndroidBootApplication application = (AndroidBootApplication) getApplication();
        application.inject(this);
        setContentView(R.layout.search_page);
        mEdit = (EditText) findViewById(R.id.search_input);
    }

    @Override
    protected void onStart() {
        super.onStart();
        final String result = mAndroidBootDelegate.doSomething("what am i doing?");
        final TextView textView = (TextView) findViewById(R.id.text);
        textView.setText(result);
    }

    public void search(View view) {
        String input = mEdit.getText().toString();
    }
}
