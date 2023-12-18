package cm.welltechafrica.saconet.model;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import cm.welltechafrica.saconet.R;

public class ShowDialogCommand extends AppCompatDialogFragment {

    private GetShowInputDialogListenner getShowInputDialogListenner;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder  builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_confirm_command, null);
        builder.setView(view);

        view.findViewById(R.id.btn_close_dialog_id).setOnClickListener((e) -> dismiss());

        view.findViewById(R.id.txt_annuler_dialog_id).setOnClickListener((e) -> dismiss());

        view.findViewById(R.id.txt_continuer_dialog_id).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(requireContext(), "Email de commande envoyer Merci...", Toast.LENGTH_SHORT).show();
                        dismiss();
                    }
                }
        );
        return builder.create();
    }



    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            getShowInputDialogListenner = (GetShowInputDialogListenner) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement GetShowInputDialogListenner");
        }
    }

    public interface GetShowInputDialogListenner{

        void applyTexts(Object code);

    }




}
