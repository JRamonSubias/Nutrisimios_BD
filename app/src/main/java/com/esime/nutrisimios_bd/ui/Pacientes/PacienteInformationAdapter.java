package com.esime.nutrisimios_bd.ui.Pacientes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.esime.nutrisimios_bd.Data.model.Alimento;
import com.esime.nutrisimios_bd.MyApp.MyApp;
import com.esime.nutrisimios_bd.R;
import com.esime.nutrisimios_bd.ui.Plan.AlimentoAdapter;
import com.esime.nutrisimios_bd.ui.Plan.Alimento_description;

import java.util.List;

public class PacienteInformationAdapter extends RecyclerView.Adapter<PacienteInformationAdapter.ViewHold> {
    private List<Alimento> listAlimento;
    private FragmentManager fragmentManager;

    public PacienteInformationAdapter(FragmentManager fragmentManager, List<Alimento> listAlimento){
        this.fragmentManager = fragmentManager;
        this.listAlimento = listAlimento;
    }

    @NonNull
    @Override
    public ViewHold onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_alimento,parent,false);
        return new ViewHold(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHold holder, int position) {
        Alimento alimento = listAlimento.get(position);
        if(alimento.getGrupo().equals("Verduras"))
            holder.cardViewAlimento.setCardBackgroundColor(ContextCompat.getColor(MyApp.getContext(),R.color.greenDark));
        else if(alimento.getGrupo().equals("Frutas"))
            holder.cardViewAlimento.setCardBackgroundColor(ContextCompat.getColor(MyApp.getContext(),R.color.green));
        else if(alimento.getGrupo().equals("Cereales y tuberculos"))
            holder.cardViewAlimento.setCardBackgroundColor(ContextCompat.getColor(MyApp.getContext(),R.color.brown));
        else if(alimento.getGrupo().equals("Leguminosas"))
            holder.cardViewAlimento.setCardBackgroundColor(ContextCompat.getColor(MyApp.getContext(),R.color.brownDark));
        else if(alimento.getGrupo().equals("Leche"))
            holder.cardViewAlimento.setCardBackgroundColor(ContextCompat.getColor(MyApp.getContext(),R.color.cardBackground));
        else if(alimento.getGrupo().equals("Alimentos de origen animal"))
            holder.cardViewAlimento.setCardBackgroundColor(ContextCompat.getColor(MyApp.getContext(),R.color.red));
        else if(alimento.getGrupo().equals("Aceites y Grasas"))
            holder.cardViewAlimento.setCardBackgroundColor(ContextCompat.getColor(MyApp.getContext(),R.color.yellow));
        else if(alimento.getGrupo().equals("Azucares"))
            holder.cardViewAlimento.setCardBackgroundColor(ContextCompat.getColor(MyApp.getContext(),R.color.blue));
        else if(alimento.getGrupo().equals("Alimentos libres en energia"))
            holder.cardViewAlimento.setCardBackgroundColor(ContextCompat.getColor(MyApp.getContext(),R.color.pink));
        else
            holder.cardViewAlimento.setCardBackgroundColor(ContextCompat.getColor(MyApp.getContext(),R.color.purple_200));
        String informationAliment[] =
                {       listAlimento.get(position).getNombre(),
                        listAlimento.get(position).getGrupo(),
                        listAlimento.get(position).getPorcion(),
                        listAlimento.get(position).getProteina(),
                        listAlimento.get(position).getSodio(),
                        listAlimento.get(position).getCalorias(),
                        listAlimento.get(position).getGrasas(),
                        listAlimento.get(position).getCarbohidratos()};

        holder.tvAlimentoName.setText(alimento.getNombre());
        holder.cardViewAlimento.setOnClickListener(v -> {
            Alimento_description alimentoDescription = new Alimento_description(informationAliment);
            alimentoDescription.show(fragmentManager,"AlimentoDesciption");
        });

    }

    @Override
    public int getItemCount() {
        return listAlimento.size();
    }

    public class ViewHold extends RecyclerView.ViewHolder {
        TextView tvAlimentoName;
        CardView cardViewAlimento;
        public ViewHold(@NonNull View itemView) {
            super(itemView);
            tvAlimentoName = itemView.findViewById(R.id.plan_alimento);
            cardViewAlimento = itemView.findViewById(R.id.plan_cardView);
        }
    }
}
