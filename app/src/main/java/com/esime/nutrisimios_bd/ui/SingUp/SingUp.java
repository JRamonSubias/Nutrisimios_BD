package com.esime.nutrisimios_bd.ui.SingUp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.esime.nutrisimios_bd.R;
import com.google.android.material.chip.Chip;
import com.google.android.material.textfield.TextInputLayout;


public class SingUp extends Fragment {
    View view;
    TextInputLayout etEmail,etNombre,etApPaterno,etApMaterno,etPasword,etConfirmPassword, etCedula,etDireccion,etTelefono;
    Chip chClinica1, chClinica2;
    Button btnSingUp;
    SingUpViewModel singUpViewModel;
    String correo, nombre,apPaterno, apMaterno,password,cedula,direccion,telefono,id_clinica;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        singUpViewModel = new ViewModelProvider(this).get(SingUpViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_sing_up, container, false);
        getById(view);
        btnSingUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateData();
            }
        });
        return view;
    }

    private void validateData() {
        String email,nombre, apPaterno,apMaterno,password,confirmPassword;
        if(chClinica1.isChecked()){
            id_clinica="1";
        }else{
            id_clinica="2";
        }

        //Ponemos todos los setError a null para reiniciarlo.
        etEmail.setError(null);
        etNombre.setError(null);
        etApPaterno.setError(null);
        etApMaterno.setError(null);
        etPasword.setError(null);
        etConfirmPassword.setError(null);

        //Pasamos lo que hay en los EditText a los String
        email = etEmail.getEditText().getText().toString();
        nombre = etNombre.getEditText().getText().toString();
        apPaterno = etApPaterno.getEditText().getText().toString();
        apMaterno = etApMaterno.getEditText().getText().toString();
        password = etPasword.getEditText().getText().toString();
        confirmPassword = etConfirmPassword.getEditText().getText().toString();
        cedula = etCedula.getEditText().getText().toString();
        direccion = etDireccion.getEditText().getText().toString();
        telefono = etTelefono.getEditText().getText().toString();

        //compramos si algun String esta vacio y si es asi mandamos un setError
        if(email.isEmpty())
            etEmail.setError("Ingrese un correo");
        else if(nombre.isEmpty())
            etNombre.setError("Ingrese un nombre");
        else if(apPaterno.isEmpty())
            etApPaterno.setError("se requiere un apellido paterno");
        else if(apMaterno.isEmpty())
            etApMaterno.setError("se requiere un apellido materno");
        else if(password.isEmpty())
            etPasword.setError("Ingrese una contraseña");
        else if (!confirmPassword.equals(password))
            etConfirmPassword.setError("Las contraseñas no coinciden");
        else{
            //si todo es correcto lo mandaremos a la funcion para poder hacer el insert a la BD.
            insertInformation(email,nombre,apPaterno,apMaterno,password,id_clinica,cedula,direccion,telefono);
        }


    }

    private void insertInformation(String email, String nombre, String apPaterno, String apMaterno, String password,String id_clinica,String cedula, String direccion,String telefono) {
            singUpViewModel.insertNutriologo(email, nombre, apPaterno, apMaterno, password, id_clinica, cedula, direccion, telefono);
    }

    private void getById(View view) {
        btnSingUp = view.findViewById(R.id.singUpBtn);
        etEmail = view.findViewById(R.id.singUpETUser);
        etNombre = view.findViewById(R.id.addAlimento_EtNombre);
        etApPaterno = view.findViewById(R.id.addPaciente_EtApPaterno);
        etApMaterno = view.findViewById(R.id.addPaciente_EtAp_Materno);
        etPasword = view.findViewById(R.id.singUpEtpassword);
        etConfirmPassword = view.findViewById(R.id.singUpEtConfirmPassword);
        etCedula = view.findViewById(R.id.singUpEt_Cedula);
        etDireccion = view.findViewById(R.id.singUpEtDirecion);
        etTelefono = view.findViewById(R.id.singUpEtTelefono);
        chClinica1 = view.findViewById(R.id.singUpchClinica1);
        chClinica2 = view.findViewById(R.id.singUpchClinica2);

    }
}