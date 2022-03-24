package org.tensorflow.lite.examples.detection;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

public class TestActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_testlayout);

        MyActivity myActivity = (MyActivity) this.getParent();
        String currentTab = myActivity.getTabHost().getCurrentTabTag();
    //    ((Button)findViewById(R.id.button_Test)).setText(currentTab);

    }
}