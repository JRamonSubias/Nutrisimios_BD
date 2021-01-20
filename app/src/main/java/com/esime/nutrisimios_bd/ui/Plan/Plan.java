package com.esime.nutrisimios_bd.ui.Plan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.esime.nutrisimios_bd.Data.model.Alimento;
import com.esime.nutrisimios_bd.MyApp.MyApp;
import com.esime.nutrisimios_bd.R;
import com.esime.nutrisimios_bd.ui.Pacientes.AddPaciente;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Plan extends Fragment {

    private PlanViewModel planViewModel;
    private MaterialToolbar materialToolbar;
    private RecyclerView recyclerView;
    private AlimentoAdapter alimentoAdapter;
    public static  List<Alimento> listAlimentos;
    private FloatingActionButton floatingActionButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        planViewModel =
                new ViewModelProvider(this).get(PlanViewModel.class);
        View view = inflater.inflate(R.layout.fragment_plan, container, false);
       getByID(view);

       floatingActionButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               AddAlimento addAlimento = new AddAlimento();
               addAlimento.show(getChildFragmentManager(),"AddPaciente");
           }
       });

       recyclerView.setAdapter(alimentoAdapter);
       recyclerView.setHasFixedSize(true);

     final GridLayoutManager layoutManager = new GridLayoutManager(getContext(),3);
       recyclerView.setLayoutManager(layoutManager);
        getListalimento();

        MenuItem item = materialToolbar.getMenu().findItem(R.id.action_search);
       SearchView searchView = (SearchView) item.getActionView();
       searchView.setQueryHint("Buscar Alimento...");
       searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
           @Override
           public boolean onQueryTextSubmit(String query) {
               Toast.makeText(MyApp.getContext(), "Buscando...", Toast.LENGTH_SHORT).show();
               //Se oculta el EditText
               searchView.setQuery("",false);
               searchView.setIconified(true);
               return true;
           }

           @Override
           public boolean onQueryTextChange(String newText) {
               List<Alimento> alimentoList = filter(listAlimentos,newText);
               alimentoAdapter.setFilter(alimentoList);
               return true;
           }
       });

       item.setOnActionExpandListener(new MenuItem.OnActionExpandListener() {
           @Override
           public boolean onMenuItemActionExpand(MenuItem item) {
               return true;
           }

           @Override
           public boolean onMenuItemActionCollapse(MenuItem item) {
               alimentoAdapter.setFilter(listAlimentos);
               return true;
           }
       });
          return view;
    }

    public void getListalimento (){
        planViewModel.getListAlimentos().observe(getActivity(), new Observer<List<Alimento>>() {
            @Override
            public void onChanged(List<Alimento> alimentos) {
                listAlimentos = alimentos;
                alimentoAdapter.addListAlimento(listAlimentos);
            }
        });
    }

    private void getByID(View view) {
        materialToolbar = view.findViewById(R.id.plan_toolbar);
        alimentoAdapter = new AlimentoAdapter(getChildFragmentManager());
        recyclerView = view.findViewById(R.id.plan_recyclerView);
        floatingActionButton = view.findViewById(R.id.plan_floatingButtom);
    }


    private List<Alimento> filter (List<Alimento> list,String texto){
        List<Alimento> listaFiltrada = new ArrayList<>();
        try {
            texto = texto.toLowerCase();
            for(Alimento alimento: list){
                String Alimento2 = alimento.getNombre().toLowerCase();
                if(Alimento2.contains(texto)){
                    listaFiltrada.add(alimento);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return listaFiltrada;
    }

}