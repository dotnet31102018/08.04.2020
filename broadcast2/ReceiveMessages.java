package hello.itay.com.boradcast2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;

/**
 * Created by Itay kan on 4/8/2020.
 */

public class ReceiveMessages extends BroadcastReceiver
{
    private MainActivity main;
    private Handler mHandlerThread;

    public ReceiveMessages(MainActivity main, Handler mHandlerThread)
    {
        this.main = main;
        this.mHandlerThread = mHandlerThread;
    }

    @Override
    public void onReceive(Context context, Intent intent)
    {

        String data1 = intent.getStringExtra("message");

        // 1
        main.invokeMe(data1);

        // 2
        Message msg = new Message();
        msg.obj = "message from service handler " + data1;
        mHandlerThread.dispatchMessage(msg);
    }
}
