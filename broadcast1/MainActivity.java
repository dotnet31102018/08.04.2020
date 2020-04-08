package hello.itay.com.broadcast1;

import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        IntentFilter intentFilter = new IntentFilter("android.intent.action.AIRPLANE_MODE");

        getBaseContext().registerReceiver(new ConnectivityReceiver(), intentFilter);
    }


}
