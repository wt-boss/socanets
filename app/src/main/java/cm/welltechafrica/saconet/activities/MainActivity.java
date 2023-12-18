package cm.welltechafrica.saconet.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.transition.MaterialElevationScale;

import cm.welltechafrica.saconet.R;
import cm.welltechafrica.saconet.fragments.DetailFragment;
import cm.welltechafrica.saconet.fragments.HomeFragment;
import cm.welltechafrica.saconet.model.PageData;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;


    FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

         PageData pageDataVSAT = new PageData(R.drawable.vsat, getResources().getString(R.string.vsat_title), getResources().getString(R.string.vsat_description));
         PageData pageDataFibreOptique = new PageData(R.drawable.fibre_optique,getResources().getString(R.string.fibre_optique_title) , getResources().getString(R.string.vsat_description));
         PageData pageDatavideosurveillance = new PageData(R.drawable.video_suveillance, "Videosurveillance", getResources().getString(R.string.videosurveillance_description));
         PageData pageDataControle_acces_description = new PageData(R.drawable.controle_access, "Contrôle d’accès", getResources().getString(R.string.controle_acces_description));
         PageData pageDataAlarmeAntiIntrusion = new PageData(R.drawable.alarme_anti_intrusion, "Alarme Anti intrusion", getResources().getString(R.string.alarme_intrusion_description));
         PageData pageDataSecuriteIncendie = new PageData(R.drawable.securite_incendie, "Système de Sécurité Incendie", getResources().getString(R.string.securite_incendie_description));
         PageData pageDataTelphonie_par_satellite = new PageData(R.drawable.telephonie_mobile_par_satellite, "Téléphonie mobile par satellite", getResources().getString(R.string.telephonie_satellite_description));
         PageData pageDataTracking = new PageData(R.drawable.tracking, "Tracking", getResources().getString(R.string.tracking_description));
         PageData pageData_reseau_conseils = new PageData(R.drawable.reseaux_informatiques_conseils, "Réseaux informatiques et Conseils", getResources().getString(R.string.reseaux_informatiques));
         PageData pageDataVisioconference = new PageData(R.drawable.visio_conference, "Visioconférence", getResources().getString(R.string.visioconference));
         PageData pageDataCompteuseTrieuses = new PageData(R.drawable.compteuses_trieuses_de_billets_de_banque, "Compteuses et Trieuses de Billets de Banque", getResources().getString(R.string.compteuses_billets));


         //initialement lancer le HomeFragment
        replaceFragment(new HomeFragment(MainActivity.this));


        // Récupération de l'Intent
        Intent intent = getIntent();
        // Récupération de la chaîne de caractères (String) de l'Intent
        String data = intent.getStringExtra(MenuActivity.KEY_DATA_INTENT);
        // Utilisation de la chaîne de caractères (String)
        if (data != null) {
            // Effectuez ici les opérations nécessaires avec la chaîne de caractères (String) récupérée
            if(data.equals(MenuActivity.listTitleButton.get(0))){
                replaceFragment(new DetailFragment(pageDataVSAT));
            }else if(data.equals(MenuActivity.listTitleButton.get(1))){
                replaceFragment(new DetailFragment(pageDataFibreOptique));

            }else if(data.equals(MenuActivity.listTitleButton.get(2))){
                replaceFragment(new DetailFragment(pageDatavideosurveillance));

            }else if(data.equals(MenuActivity.listTitleButton.get(3))){
                replaceFragment(new DetailFragment(pageDataControle_acces_description));

            }else if(data.equals(MenuActivity.listTitleButton.get(4))){
                replaceFragment(new DetailFragment(pageDataAlarmeAntiIntrusion));

            }else if(data.equals(MenuActivity.listTitleButton.get(5))){
                replaceFragment(new DetailFragment(pageDataSecuriteIncendie));

            }else if(data.equals(MenuActivity.listTitleButton.get(6))){
                replaceFragment(new DetailFragment(pageDataTelphonie_par_satellite));

            }else if(data.equals(MenuActivity.listTitleButton.get(7))){
                replaceFragment(new DetailFragment(pageDataTracking));

            }else if(data.equals(MenuActivity.listTitleButton.get(8))){
                replaceFragment(new DetailFragment(pageData_reseau_conseils));

            }else if(data.equals(MenuActivity.listTitleButton.get(9))){
                replaceFragment(new DetailFragment(pageDataVisioconference));

            }else if(data.equals(MenuActivity.listTitleButton.get(10))){
                replaceFragment(new DetailFragment(pageDataCompteuseTrieuses));
            }


        }







        drawerLayout= findViewById(R.id.main);
        frameLayout = findViewById(R.id.main_frame);
         findViewById(R.id.btn_menu).setOnClickListener((e) -> {
            drawerLayout.openDrawer(GravityCompat.START);
        });

        findViewById(R.id.btn_shop).setOnClickListener((e) -> {
            startActivity(new Intent(MainActivity.this, ShopActivity.class));
        });

       NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.setItemIconTintList(null);

        if(navigationView != null){

            View headerLayout = navigationView.getHeaderView(0);

            navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    // Handle navigation view item clicks here.
                    int id = item.getItemId();
                    String msg = "[ " +item.getTitle() + " ]" + " selectionnée ...";

                    if (id == R.id.menu_item_boutique) {
                        startActivity(new Intent(MainActivity.this, ShopActivity.class));
                    }

                    else if (id == R.id.menu_item_vsat){
                        replaceFragment(new DetailFragment(pageDataVSAT));
                    }
                    else if (id == R.id.menu_item_fibre_optique){
                        replaceFragment(new DetailFragment(pageDataFibreOptique));
                    }
                    else if (id == R.id.menu_item_videosurveillance){
                        replaceFragment(new DetailFragment(pageDatavideosurveillance));
                    }
                    else if (id == R.id.menu_item_controle_acces){
                        replaceFragment(new DetailFragment(pageDataControle_acces_description));
                    }
                    else if (id == R.id.menu_item_alarme_intrusion){
                        replaceFragment(new DetailFragment(pageDataAlarmeAntiIntrusion));
                    }
                    else if (id == R.id.menu_item_securite_incendie){
                        replaceFragment(new DetailFragment(pageDataSecuriteIncendie));
                    }
                    else if (id == R.id.menu_item_telephonie_satellite){
                        replaceFragment(new DetailFragment(pageDataTelphonie_par_satellite));
                    }
                    else if (id == R.id.menu_item_tracking){
                        replaceFragment(new DetailFragment(pageDataTracking));
                    }
                    else if (id == R.id.menu_item_reseaux_conseils){
                        replaceFragment(new DetailFragment(pageData_reseau_conseils));
                    }
                    else if (id == R.id.menu_item_visioconference){
                        replaceFragment(new DetailFragment(pageDataVisioconference));
                    }
                    else if (id == R.id.menu_item_compteuses_billets){
                        replaceFragment(new DetailFragment(pageDataCompteuseTrieuses));
                    }
                    else if (id == R.id.menu_item_emplois){
                        startActivity(new Intent(MainActivity.this, CarriereActivity.class));
                    }
                    else if (id == R.id.menu_item_sav){
                        startActivity(new Intent(MainActivity.this, SavActivity.class));
                    }
                    else if (id == R.id.menu_item_about){
                        startActivity(new Intent(MainActivity.this, ContactActivity.class));
                    }
                    else {

                    }
                    drawerLayout.closeDrawers();
                    return false;
                }
            });
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
    private void replaceFragment(Fragment fragment) {
        fragment.setEnterTransition(createTransition());
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_frame, fragment)
                .commit();
    }
    private static MaterialElevationScale createTransition(){
        MaterialElevationScale fadeThrough = new MaterialElevationScale(true);
        fadeThrough.addTarget(R.id.fragment_home_id);
        return fadeThrough;
    }
}