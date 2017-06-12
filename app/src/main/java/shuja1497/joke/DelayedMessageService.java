package shuja1497.joke;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import static android.provider.AlarmClock.EXTRA_MESSAGE;
public class DelayedMessageService extends IntentService {

    public static final String EXTRA_MESSAGE = "message";

    private Handler handler;

/*
    This method runs on the main thread, so it
    creates a new handler on the main thread.*/
    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        handler = new Handler();
        return super.onStartCommand(intent, flags, startId);
    }

    public DelayedMessageService() {

        super("DelayedMessageService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        synchronized (this) {
            try {
                wait(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String text = intent.getStringExtra(EXTRA_MESSAGE);
        showText(text);
        
    }

    private void showText(final String text) {
        //Log.v("DelayedMessageService", "The message is: " + text);
        handler.post(new Runnable() {
            public void run() {
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();
            }
        });
    }


}
