package cm.welltechafrica.saconet.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import cm.welltechafrica.saconet.R;
import cm.welltechafrica.saconet.model.SliderAdapter;
import cm.welltechafrica.saconet.model.SliderItem;

public class MenuActivity extends AppCompatActivity {

    LinearLayout dotsLayout;
    SliderAdapter adapter;
    ArrayList<SliderItem> data;
    ViewPager2 viewPager2;
    ImageView[] image;
    Runnable runnable;
    Handler handler = new Handler();
    Timer timer = new Timer();
    private Snackbar snackbar;
    public static String KEY_DATA_INTENT = "LAUNCH_DATA";
    public static List<String> listTitleButton = Arrays.asList(
            "VSAT",
            "Fibre Optique",
            "Vidéo Surveillance",
            "Contrôle d'accès",
            "Alarme Anti intrusion",
            "Système de Sécurité Incendie",
            "Téléphonie mobile par satellite",
            "Tracking",
            "Réseaux informatiques et Conseils",
            "Visio Conférence",
            "Compteuses de Billets"
    );
    ConstraintLayout constraintLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        constraintLayout = findViewById(R.id.main);

        snackbar = Snackbar.make(constraintLayout,"",3000);

        findViewById(R.id.button_boutique).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuActivity.this, ShopActivity.class));
            }
        });
        findViewById(R.id.button_home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuActivity.this, MainActivity.class));
            }
        });

        findViewById(R.id.button_contact).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuActivity.this, ContactActivity.class));
            }
        });
        findViewById(R.id.button_emploi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuActivity.this, CarriereActivity.class));
            }
        });
        findViewById(R.id.button_sav).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuActivity.this, SavActivity.class));
            }
        });
        findViewById(R.id.button_website).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuActivity.this, WebViewActivity.class));
            }
        });

        findViewById(R.id.button_service).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        View custom = getLayoutInflater().inflate(R.layout.snackbar_custorm,null);

                        LinearLayout linearLayout = custom.findViewById(R.id.linearLayoutItems);

                        ImageButton buttonClose = custom.findViewById(R.id.buttonClose);
                        buttonClose.setOnClickListener(
                                new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        snackbar.dismiss();
                                    }
                                }
                        );
                        Button buttonVSAT = generateButtonForSnackBar("VSAT");
                        Button buttonFibreOptique = generateButtonForSnackBar("Fibre Optique");
                        Button buttonVideoSurveillance = generateButtonForSnackBar("Vidéo Surveillance");
                        Button buttonControleAcces = generateButtonForSnackBar("Contrôle d'accès");
                        Button buttonAlarmeAntiIntrusion = generateButtonForSnackBar("Alarme Anti intrusion");
                        Button buttonSystemeSecuriteIncendie = generateButtonForSnackBar("Système de Sécurité Incendie");
                        Button buttonTelephonieMobileSatellite = generateButtonForSnackBar("Téléphonie mobile par satellite");
                        Button buttonTracking = generateButtonForSnackBar("Tracking");
                        Button buttonReseauxInformatiques = generateButtonForSnackBar("Réseaux informatiques et Conseils");
                        Button buttonVisioConference = generateButtonForSnackBar("Visio Conférence");
                        Button buttonCompteusesBillets = generateButtonForSnackBar("Compteuses de Billets");

                        ArrayList<Button> listBoutons = new ArrayList<>();

                        listBoutons.add(buttonVSAT);
                        listBoutons.add(buttonFibreOptique);
                        listBoutons.add(buttonVideoSurveillance);
                        listBoutons.add(buttonControleAcces);
                        listBoutons.add(buttonAlarmeAntiIntrusion);
                        listBoutons.add(buttonSystemeSecuriteIncendie);
                        listBoutons.add(buttonTelephonieMobileSatellite);
                        listBoutons.add(buttonTracking);
                        listBoutons.add(buttonReseauxInformatiques);
                        listBoutons.add(buttonVisioConference);
                        listBoutons.add(buttonCompteusesBillets);

                        for (int i = 0; i< listBoutons.size() ; i++) {
                            linearLayout.addView(listBoutons.get(i));
                        }

                        for (int i = 0; i< listBoutons.size() ; i++) {

                            int finalI = i;
                            listBoutons.get(i).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent = new Intent(MenuActivity.this, MainActivity.class);
                                    intent.putExtra(KEY_DATA_INTENT, listTitleButton.get(finalI));
                                    startActivity(intent);
                                }
                            });

                        }


                        snackbar.getView().setBackgroundColor(Color.TRANSPARENT);
                        Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) snackbar.getView();
                        snackbarLayout.setPadding(0,0,0,0);
                        snackbarLayout.addView(custom,0);
                        snackbar.show();
                    }
                }
        );

        carrouselImage();

    }

    private Button generateButtonForSnackBar(String value){

        Button button = new Button(MenuActivity.this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(0, 16, 0, 0);
        button.setLayoutParams(layoutParams);
        button.setText(value);
        button.setTextColor(ContextCompat.getColor(MenuActivity.this, R.color.white));
        button.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        button.setTypeface(ResourcesCompat.getFont(MenuActivity.this, R.font.poppins_bold));
        button.setBackgroundResource(R.drawable.background_button_primary);
        button.setBackgroundTintList(ContextCompat.getColorStateList(MenuActivity.this, R.color.color_primary));
        button.setPadding(
                getResources().getDimensionPixelSize(R.dimen.small_margin),
                0,
                getResources().getDimensionPixelSize(R.dimen.small_margin),
                0
        );

        return button;

    }

    private void selectionImage(int position) {
        for (int i = 0; i < image.length; i++) {
            if (i == position) {
                image[i].setImageDrawable(ContextCompat.getDrawable(MenuActivity.this, R.drawable.selected_dot));
            } else {
                image[i].setImageDrawable(ContextCompat.getDrawable(MenuActivity.this, R.drawable.unselected_dot));
            }
        }
    }

    private void careerImagesRond() {
        for (int i = 0; i < image.length; i++) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(4, 0, 4, 0);
            image[i] = new ImageView(MenuActivity.this);
            image[i].setImageDrawable(ContextCompat.getDrawable(MenuActivity.this, R.drawable.unselected_dot));
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

    private void carrouselImage(){
        dotsLayout = findViewById(R.id.dots_layout);
        viewPager2 = findViewById(R.id.viewPager2);
        data = new ArrayList<>();
        data.add(new SliderItem(R.drawable.reseau_informatique, "Réseau informatique"));
        data.add(new SliderItem(R.drawable.connexion_internet_satellite, "Connexion internet par satellite"));
        data.add(new SliderItem(R.drawable.fibre_boucle_optique, "Boucle Fibre Optiques"));

        data.add(new SliderItem(R.drawable.controle_acces, "Contrôle d\'accès"));
        data.add(new SliderItem(R.drawable.installation_videosurveillance, "Installation des vidéosurveillances"));
        data.add(new SliderItem(R.drawable.restez_contact, "Restez en contact Avec vos proches"));
        adapter = new SliderAdapter(data);
        viewPager2.setAdapter(adapter);
        image = new ImageView[6];
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
    }

    @Override
    public void onBackPressed() {

        if(!snackbar.isShown()){
            super.onBackPressed();
        }else{
            snackbar.dismiss();
        }
    }
}