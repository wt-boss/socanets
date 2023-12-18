package cm.welltechafrica.saconet.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import cm.welltechafrica.saconet.R;
import cm.welltechafrica.saconet.model.PageData;

public class DetailFragment extends Fragment {

    PageData pageData;
    private ImageView imageViewField;
    private TextView title, subTitle, body;



    public DetailFragment(PageData pageData) {
        this.pageData = pageData;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        imageViewField = view.findViewById(R.id.imageViewField);
        title = view.findViewById(R.id.title);
        subTitle = view.findViewById(R.id.subTitle);
        body = view.findViewById(R.id.textViewDescription);

        imageViewField.setImageResource(pageData.getImageRessource());
        title.setText("Service : "+ pageData.getTitle());
        subTitle.setText(pageData.getTitle());
        body.setText(pageData.getBody());
        return view;
    }
}