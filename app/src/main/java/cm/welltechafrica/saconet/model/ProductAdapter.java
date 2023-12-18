package cm.welltechafrica.saconet.model;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import cm.welltechafrica.saconet.R;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    ArrayList<Product> listProducts;
    private FragmentManager fragmentManager;

    public ProductAdapter(ArrayList<Product> listProducts, FragmentManager fragmentManager) {
        this.listProducts = listProducts;
        this.fragmentManager = fragmentManager;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shop, parent,  false);

        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {

        holder.textViewPrice.setPaintFlags(holder.textViewPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        holder.textViewPrice.setText(listProducts.get(position).getPrice());
        holder.textViewSpecialPrice.setText(listProducts.get(position).getSpecialPrice());
        holder.imageView.setImageResource(listProducts.get(position).getImageRessource());

        holder.buttonCommander.setPaintFlags(holder.buttonCommander.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);


        holder.buttonCommander.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ShowDialogCommand getShowInputDialog = new ShowDialogCommand();
                getShowInputDialog.show(fragmentManager, "get show input dialog ");
            }
        });

    }

    @Override
    public int getItemCount() {
        return listProducts.size();
    }

    class ProductViewHolder extends  RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textViewName, textViewPrice,  textViewSpecialPrice;
        TextView buttonCommander;


        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewPrice = itemView.findViewById(R.id.textViewPrix);
            textViewSpecialPrice = itemView.findViewById(R.id.textViewSpecialPrix);
            buttonCommander = itemView.findViewById(R.id.btn_commander);

        }


    }

}

