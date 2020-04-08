package hello.itay.com.boradcast2;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

/**
 * Created by Itay kan on 4/8/2020.
 */

public class HelloService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //return super.onStartCommand(intent, flags, startId);

        Toast.makeText(this, "Service started!", Toast.LENGTH_SHORT).show();

        Intent i = new Intent("hello.itay.com.boradcast2.SOME_MESSAGE");
        i.putExtra("message", "hello from service");
        sendBroadcast(i);

        return Service.START_STICKY;
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "Service destroyed!", Toast.LENGTH_SHORT).show();

        super.onDestroy();

    }
}