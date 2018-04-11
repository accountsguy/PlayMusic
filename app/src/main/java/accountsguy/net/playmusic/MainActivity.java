package accountsguy.net.playmusic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener{
    Intent startIntent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startButton = (Button) findViewById(R.id.start);
        Button stopButton = (Button) findViewById(R.id.stop);

        startButton.setOnClickListener(this);
        stopButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.start:
                startIntent = new Intent(this, PlayerService.class);
                startService(startIntent);

                break;
            case R.id.stop:
                if(startIntent!=null)   stopService(startIntent);
                else Toast.makeText(this, "No Music Playing Click on Start Music", Toast
                        .LENGTH_LONG).show();
                break;
        }
    }
}
