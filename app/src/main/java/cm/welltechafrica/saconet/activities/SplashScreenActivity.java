package cm.welltechafrica.saconet.activities;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import cm.welltechafrica.saconet.databinding.ActivitySplashScreenBinding;


public class SplashScreenActivity extends AppCompatActivity {


    Runnable runnable ;
    Thread myThread;

    private ActivitySplashScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivitySplashScreenBinding.inflate(getLayoutInflater());
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN|View.SYSTEM_UI_FLAG_IMMERSIVE);
        setContentView(binding.getRoot());

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        runnable = () -> {
            try {
                Thread.sleep(2000);
                launchActivity();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        myThread = new Thread(runnable);
        myThread.start();

    }

    private void launchActivity() {
        startActivity(new Intent(this, MenuActivity.class));
        finish();
    }
}