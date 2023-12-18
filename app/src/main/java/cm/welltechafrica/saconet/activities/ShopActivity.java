package cm.welltechafrica.saconet.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

import java.util.ArrayList;

import cm.welltechafrica.saconet.R;
import cm.welltechafrica.saconet.model.Product;
import cm.welltechafrica.saconet.model.ProductAdapter;
import cm.welltechafrica.saconet.model.ShowDialogCommand;

public class ShopActivity extends AppCompatActivity implements ShowDialogCommand.GetShowInputDialogListenner {

    private RecyclerView recyclerView;
    private ArrayList<Product> products;
    private ProductAdapter productAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        recyclerView = findViewById(R.id.recycler_view);
        products = new ArrayList<>();

        for(int i= 0; i< 5; i++){
            products.add(new Product(R.drawable.phone, "THURAYA XT-PRO DUAL", "XAF 850 000", "XAF 965 000.00"));
            products.add(new Product(R.drawable.phone2, "THURAYA X5-TOUCH", "XAF 850 000", "XAF 965 000.00"));
            products.add(new Product(R.drawable.compteuse, "Kisan K5", "XAF 80 000", "XAF 76 000"));
            products.add(new Product(R.drawable.compteuse2, "Kisan Newton A", "XAF 1 650 000", "XAF 1 350 000"));
            products.add(new Product(R.drawable.compteuse3, "G&D ProNote 1.5", "XAF 80 000", "XAF 76 000"));
        }


        productAdapter = new ProductAdapter(products, getSupportFragmentManager());

        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.setAdapter(productAdapter);

        findViewById(R.id.btn_back).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onBackPressed();
                    }
                }
        );


    }

    @Override
    public void applyTexts(Object code) {

    }
}