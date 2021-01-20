package com.esime.nutrisimios_bd.ui.SingIn;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.esime.nutrisimios_bd.Data.model.Nutriologo;
import com.esime.nutrisimios_bd.MyApp.Constants;
import com.esime.nutrisimios_bd.MyApp.SharedPreferenceManager;
import com.esime.nutrisimios_bd.ui.NutriActivity;
import com.esime.nutrisimios_bd.R;
import com.google.android.material.textfield.TextInputLayout;


public class SignIn extends Fragment {
    private Button btnSingIn;
    private TextInputLayout etUser, etPassword;
    private String user, password;
    private SinginViewModel singinViewModel;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        singinViewModel = new ViewModelProvider(this).get(SinginViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sing_in, container, false);
        getFindById(view);

        btnSingIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateData();
            }
        });
        return view;

    }

    private void validateData() {
        etUser.setError(null);
        etPassword.setError(null);
        user = etUser.getEditText().getText().toString();
        password = etPassword.getEditText().getText().toString();

        if(user.isEmpty())
            etUser.setError("Ingrese un usuario");
        else if(password.isEmpty())
            etPassword.setError("Ingrese contraseña");
        else{
                validateUser(user,password);
        }
    }

    private void validateUser(String user, String password) {
        singinViewModel.validateNutriologo(user,password).observe(getActivity(), new Observer<Nutriologo>() {
            @Override
            public void onChanged(Nutriologo nutriologo) {
                if(nutriologo == null){
                    etUser.setError("");
                    etPassword.setError("El correo o contraseña no coinciden");
                }
                SharedPreferenceManager
                        .setSomeStringValue(Constants.ID_NUTRIOGOLO,nutriologo.getiDNutriologo());
                SharedPreferenceManager.
                        setSomeStringValue(Constants.NUTRIOLOGO_NOMBRE,nutriologo.getNombreNut());

                SharedPreferenceManager
                        .setSomeStringValue(Constants.NUTRIOLOGO_APPaterno, nutriologo.getApePatNut());

                SharedPreferenceManager
                        .setSomeStringValue(Constants.NUTRIOLOGO_APMATERNO, nutriologo.getApeMatNut());

                SharedPreferenceManager
                        .setSomeStringValue(Constants.NUTRIOLOGO_TELEFONO, nutriologo.getTelefono());

                SharedPreferenceManager
                        .setSomeStringValue(Constants.NUTRIOLOGO_DIRECCION, nutriologo.getDireccion());

                SharedPreferenceManager
                        .setSomeStringValue(Constants.NUTRIOLOGO_CORREO, nutriologo.getCorreo());

                SharedPreferenceManager
                        .setSomeStringValue(Constants.NUTRIOLOGO_CLINICA, nutriologo.getNombreCli());

                Intent intent = new Intent(getActivity(), NutriActivity.class);
                startActivity(intent);

            }
        });
    }


    private void getFindById(View view) {
        btnSingIn = view.findViewById(R.id.singInBtn);
        etUser = view.findViewById(R.id.singInETUser);
        etPassword = view.findViewById(R.id.singInEtpassword);
    }
}