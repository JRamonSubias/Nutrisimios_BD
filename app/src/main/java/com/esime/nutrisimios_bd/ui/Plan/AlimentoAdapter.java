package com.esime.nutrisimios_bd.ui.Plan;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.esime.nutrisimios_bd.Data.model.Alimento;
import com.esime.nutrisimios_bd.MyApp.MyApp;
import com.esime.nutrisimios_bd.R;

import java.util.ArrayList;
import java.util.List;

public class AlimentoAdapter extends RecyclerView.Adapter<AlimentoAdapter.ViewHolder> {
    List<Alimento> listAlimentoRecycler;
    FragmentManager fragmentManager;




   public  AlimentoAdapter (FragmentManager fragmentManager){
        this.fragmentManager = fragmentManager;
        listAlimentoRecycler = new ArrayList<>();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater
               .from(parent.getContext())
               .inflate(R.layout.item_alimento,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       Alimento alimento = listAlimentoRecycler.get(position);
       holder.tvAlimento.setText(alimento.getNombre());
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

       holder.cardViewAlimento.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String informationAliment[] =
                       {       listAlimentoRecycler.get(position).getNombre(),
                               listAlimentoRecycler.get(position).getGrupo(),
                               listAlimentoRecycler.get(position).getPorcion(),
                               listAlimentoRecycler.get(position).getProteina(),
                               listAlimentoRecycler.get(position).getSodio(),
                               listAlimentoRecycler.get(position).getCalorias(),
                               listAlimentoRecycler.get(position).getGrasas(),
                               listAlimentoRecycler.get(position).getCarbohidratos()};

               Alimento_description alimentoDescription = new Alimento_description(informationAliment);
               alimentoDescription.show(fragmentManager, "alimentoDescription");

           }
       });

    }

    @Override
    public int getItemCount() {
        return listAlimentoRecycler.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvAlimento;
        CardView cardViewAlimento;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvAlimento = itemView.findViewById(R.id.plan_alimento);
            cardViewAlimento = itemView.findViewById(R.id.plan_cardView);

        }
    }

    public void addListAlimento (List<Alimento> listAlimento){
       this.listAlimentoRecycler.addAll(listAlimento);
       notifyDataSetChanged();
    }

    public void setFilter(List<Alimento> listAlimento){
       this.listAlimentoRecycler.addAll(listAlimento);
       notifyDataSetChanged();
    }

}
