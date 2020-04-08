package hello.itay.com.boradcast2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ReceiveMessages myReceiver = null;
    Boolean myReceiverIsRegistered = false;

    Handler mHandlerThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHandlerThread = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                TextView textTV = findViewById(R.id.textmsghandle);
                textTV.setText(msg.obj.toString());
            }
        };

        myReceiver = new ReceiveMessages(this, mHandlerThread);

        findViewById(R.id.startBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(getBaseContext(), HelloService.class);
                startService(inte);
            }
        });
        findViewById(R.id.stopBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(getBaseContext(), HelloService.class);
                stopService(inte);
            }
        });
    }

    public void invokeMe(String text)
    {
        TextView textTV = findViewById(R.id.textmsg);
        textTV.setText(text);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (myReceiverIsRegistered) {
            unregisterReceiver(myReceiver);
            myReceiverIsRegistered = false;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!myReceiverIsRegistered) {
            registerReceiver(myReceiver, new IntentFilter("hello.itay.com.boradcast2.SOME_MESSAGE"));
            myReceiverIsRegistered = true;
        }
    }


}


