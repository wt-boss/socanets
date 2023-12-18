package cm.welltechafrica.saconet.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import cm.welltechafrica.saconet.R;
import cm.welltechafrica.saconet.model.SliderAdapter;
import cm.welltechafrica.saconet.model.SliderItem;

public class HomeFragment extends Fragment {
    LinearLayout dotsLayout;
    SliderAdapter adapter;
    ArrayList<SliderItem> data;
    ViewPager2 viewPager2;
    ImageView[] image;
    Runnable runnable;
    Handler handler = new Handler();
    Timer timer = new Timer();

    private Context mContext;

    public HomeFragment(Context context){
        this.mContext = context;
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context; // Enregistrement du contexte de l'activité
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        dotsLayout = view.findViewById(R.id.dots_layout);
        viewPager2 = view.findViewById(R.id.viewPager2);
        data = new ArrayList<>();
        data.add(new SliderItem(R.drawable.vsat, "Services de VSAT"));
        data.add(new SliderItem(R.drawable.fibre_optique, "Services de Fibre Optique"));
        data.add(new SliderItem(R.drawable.video_suveillance, "Services de Video Surveillance"));
        adapter = new SliderAdapter(data);
        viewPager2.setAdapter(adapter);
        image = new ImageView[3];
        careerImagesRond();
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                selectionImage(position);
            }
        });
        // init runnable.
        runnable = () -> {
            int i = viewPager2.getCurrentItem();
            if (i == image.length - 1) {
                i = 0;
            } else {
                i++;
            }
            viewPager2.setCurrentItem(i, true);
        };
        slideAutomatic();
        return view;
    }

    private void selectionImage(int position) {
        for (int i = 0; i < image.length; i++) {
            if (i == position) {
                image[i].setImageDrawable(ContextCompat.getDrawable(mContext, R.drawable.selected_dot));
            } else {
                image[i].setImageDrawable(ContextCompat.getDrawable(mContext, R.drawable.unselected_dot));
            }
        }
    }

    private void careerImagesRond() {
        for (int i = 0; i < image.length; i++) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(4, 0, 4, 0);
            image[i] = new ImageView(mContext);
            image[i].setImageDrawable(ContextCompat.getDrawable(mContext, R.drawable.unselected_dot));
            image[i].setLayoutParams(params);
            dotsLayout.addView(image[i]);
        }
    }

    private void slideAutomatic() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(runnable);
            }
        }, 4000, 3000);
    }
}