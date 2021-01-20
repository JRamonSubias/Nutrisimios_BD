package com.esime.nutrisimios_bd.ui.Profile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.esime.nutrisimios_bd.Data.model.Cita;
import com.esime.nutrisimios_bd.R;

import java.util.List;

public class ProfileAdapter  extends RecyclerView.Adapter<ProfileAdapter.ViewHolder> {
    List<Cita> listCita;

    public ProfileAdapter(FragmentManager fragmentManager, List<Cita> listCita){
        this.listCita = listCita;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_cita,parent,false);
        return new ProfileAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Cita cita = listCita.get(position);
        String fullnamePaciente = cita.getNombrePac()+" "+cita.getApePatPac()+" "+ cita.getApeMatPac();
        String fullNameNutriologo = cita.getNombreNut()+" "+cita.getApePatNut();

        holder.tvNamePaciente.setText(fullnamePaciente);
        holder.tvNameNutriologo.setText(fullNameNutriologo);
        holder.tvCosto.setText("$"+cita.getCosto()+".00");
        holder.tvClinica.setText(cita.getNombreCli());
    }

    @Override
    public int getItemCount() {
        return listCita.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cdCita;
        TextView tvNamePaciente, tvNameNutriologo, tvClinica, tvCosto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNamePaciente = itemView.findViewById(R.id.cita_tvPacienteName);
            tvNameNutriologo = itemView.findViewById(R.id.cita_tvNutriologoName);
            tvClinica = itemView.findViewById(R.id.cita_tvClinica);
            tvCosto = itemView.findViewById(R.id.cita_tvCost);
        }
    }
}
