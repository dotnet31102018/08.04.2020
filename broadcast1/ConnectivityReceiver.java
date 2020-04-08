package hello.itay.com.broadcast1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Itay kan on 4/8/2020.
 */

public class ConnectivityReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context, final Intent intent) {
        Toast.makeText(context, "Flight mode Changed!", Toast.LENGTH_SHORT).show();
    }
}