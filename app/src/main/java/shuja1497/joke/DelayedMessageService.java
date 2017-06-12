package shuja1497.joke;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.util.Log;

import static android.provider.AlarmClock.EXTRA_MESSAGE;
public class DelayedMessageService extends IntentService {

    public static final String EXTRA_MESSAGE = "message";

    public DelayedMessageService() {
        super("DelayedMessageService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        synchronized (this) {
            try {
                wait(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String text = intent.getStringExtra(EXTRA_MESSAGE);
        showText(text);
        
    }

    private void showText(final String text) {
        Log.v("DelayedMessageService", "The message is: " + text);
    }


}
