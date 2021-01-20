package com.esime.nutrisimios_bd.ui.Pacientes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.esime.nutrisimios_bd.Data.model.Paciente;
import com.esime.nutrisimios_bd.MyApp.MyApp;
import com.esime.nutrisimios_bd.R;

import java.util.List;

public class PacienteAdapter extends RecyclerView.Adapter<PacienteAdapter.ViewHolder> {
   List<Paciente> listPaciente;
    FragmentManager fragmentManager;

    public PacienteAdapter(FragmentManager fragmentManager, List<Paciente> listPaciente){
        this.listPaciente = listPaciente;
        this.fragmentManager = fragmentManager;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_paciente,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Paciente paciente = listPaciente.get(position);
        String fullName = paciente.getNombrePac() +" "+paciente.getApePatPac()+" "+paciente.getApeMatPac();
        String padecimiento = paciente.getPadecimientos()+" "+paciente.getTipo()+" "+paciente.getGrado();
        if(paciente.getSexo().equals("H")){
            holder.cardView.setCardBackgroundColor(ContextCompat.getColor(MyApp.getContext(),R.color.blue));
        }else{
            holder.cardView.setCardBackgroundColor(ContextCompat.getColor(MyApp.getContext(),R.color.pink));
        }
        holder.tvNombre.setText(fullName);
        holder.tvEdad.setText(paciente.getEdad()+" años");
        holder.tvSexo.setText(paciente.getSexo());
        holder.tvCorreo.setText(paciente.getCorreo());
        holder.tvPadecimiento.setText(padecimiento);

        holder.cardView.setOnClickListener(v -> {
            PacienteInformation pacienteInformation = new PacienteInformation(
                    fullName,
                    paciente.getCorreo(),
                    paciente.getTelefono(),
                    padecimiento,
                    paciente.getEdad(),
                    paciente.getSexo(),
                    paciente.getIDMedPac(),
                    paciente.getID_Pacientes());
            pacienteInformation.show(fragmentManager,"PacienteInformation");
        });

    }

    @Override
    public int getItemCount() {
        return listPaciente.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombre, tvEdad, tvPadecimiento, tvCorreo, tvSexo;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.paciente_tvName);
            tvEdad = itemView.findViewById(R.id.paciente_tvEdad);
            tvPadecimiento = itemView.findViewById(R.id.paciente_tvPadecimiento);
            tvCorreo = itemView.findViewById(R.id.paciente_tvcorreo);
            tvSexo = itemView.findViewById(R.id.paciente_tvSexo);
            cardView = itemView.findViewById(R.id.paciente_cardView);
        }
    }
}
