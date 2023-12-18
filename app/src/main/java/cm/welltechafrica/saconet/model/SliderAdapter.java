package cm.welltechafrica.saconet.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;

import cm.welltechafrica.saconet.R;

public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.SliderViewHolder> {

    ArrayList<SliderItem> listData;

    public SliderAdapter(ArrayList<SliderItem> listData) {
        this.listData = listData;
    }

    @NonNull
    @Override
    public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_slider, parent, false);


        return new SliderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SliderViewHolder holder, int position) {

        holder.roundedImageView.setImageResource(listData.get(position).getImageRessource());
        holder.textViewLabel.setText(listData.get(position).getLabel());

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    class SliderViewHolder  extends RecyclerView.ViewHolder{

        RoundedImageView roundedImageView;
        TextView textViewLabel;

        public SliderViewHolder(@NonNull View itemView) {
            super(itemView);

            roundedImageView = itemView.findViewById(R.id.imageView);
            textViewLabel = itemView.findViewById(R.id.textView);
        }

    }

}

