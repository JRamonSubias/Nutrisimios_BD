package com.esime.nutrisimios_bd.Data;

import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.esime.nutrisimios_bd.Data.model.Alimento;
import com.esime.nutrisimios_bd.Data.model.Cita;
import com.esime.nutrisimios_bd.Data.model.Medida;
import com.esime.nutrisimios_bd.Data.model.Nutriologo;
import com.esime.nutrisimios_bd.Data.model.Paciente;
import com.esime.nutrisimios_bd.Data.model.Padecimiento;
import com.esime.nutrisimios_bd.Data.model.Response.AlimentoResponse;
import com.esime.nutrisimios_bd.Data.model.Response.CitaResponse;
import com.esime.nutrisimios_bd.Data.model.Response.MedidaResponse;
import com.esime.nutrisimios_bd.Data.model.Response.NombrePacienteResponse;
import com.esime.nutrisimios_bd.Data.model.Response.NutriologoResponse;
import com.esime.nutrisimios_bd.Data.model.Response.PacienteResponse;
import com.esime.nutrisimios_bd.Data.model.Response.PadecimientoResponse;
import com.esime.nutrisimios_bd.MyApp.Constants;
import com.esime.nutrisimios_bd.MyApp.MyApp;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Repository {
    ApiServices apiServices;
    MutableLiveData<List<Alimento>> listAlimentoLiveData;
    MutableLiveData<List<Cita>> listCitasLiveData;
    MutableLiveData<Nutriologo> nutriologoLiveData;
    MutableLiveData<List<Paciente>> listPacienteLiveData;
    MutableLiveData<Medida> medidaLiveData;
    String sizeListMedidas, sizeListNamePac, sizeListPacientes;
    String IDPadecimiento;

    public Repository(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiServices = retrofit.create(ApiServices.class);
    }

    public MutableLiveData<List<Alimento>> getListAlimento(){
        if (listAlimentoLiveData == null){
            listAlimentoLiveData = new MutableLiveData<>();
        }
        Call<AlimentoResponse> alimentoResponseCall = apiServices.getListAliment();
        alimentoResponseCall.enqueue(new Callback<AlimentoResponse>() {
            @Override
            public void onResponse(Call<AlimentoResponse> call, Response<AlimentoResponse> response) {
                if(response.isSuccessful()){
                    listAlimentoLiveData.setValue(response.body().getAlimento());
                }else{
                    Toast.makeText(MyApp.getContext(), "Algo salio mal list alimento", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<AlimentoResponse> call, Throwable t) {
                Toast.makeText(MyApp.getContext(), "ERROR LIST ALIMENTO", Toast.LENGTH_SHORT).show();
            }
        });
        return listAlimentoLiveData;
    }

    public MutableLiveData<Nutriologo> validateNutriologo (String correo, String password){
        if(nutriologoLiveData == null){
            nutriologoLiveData = new MutableLiveData<>();
        }
        Call<NutriologoResponse> nutriologoResponseCall = apiServices.getListNutriologo();
        nutriologoResponseCall.enqueue(new Callback<NutriologoResponse>() {
            @Override
            public void onResponse(Call<NutriologoResponse> call, Response<NutriologoResponse> response) {
                if(response.isSuccessful()){
                    List<Nutriologo> list = response.body().getNutriologo();
                    for( int i=0; i<list.size();i++){
                        if(correo.equals(list.get(i).getCorreo()) && password.equals(list.get(i).getPassword())){
                            String a = list.get(i).getiDNutriologo();
                            Call<NutriologoResponse> responseCall = apiServices.validateNutriologo(list.get(i).getiDNutriologo());
                            responseCall.enqueue(new Callback<NutriologoResponse>() {
                                @Override
                                public void onResponse(Call<NutriologoResponse> call, Response<NutriologoResponse> response) {
                                    if(response.isSuccessful()){
                                        nutriologoLiveData.setValue(response.body().getNutriologo().get(0));

                                    }else{
                                        Toast.makeText(MyApp.getContext(), "algo salio mal, validate nutriologo", Toast.LENGTH_SHORT).show();
                                    }
                                }

                                @Override
                                public void onFailure(Call<NutriologoResponse> call, Throwable t) {
                                    Toast.makeText(MyApp.getContext(), "ERROR validateNutriologo", Toast.LENGTH_SHORT).show();
                                }
                            });
                            break;
                        }
                    }

                }else{
                    Toast.makeText(MyApp.getContext(), "Algo salio mal ", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<NutriologoResponse> call, Throwable t) {
                Toast.makeText(MyApp.getContext(), "ERROR GETLISTNUTRIOLOGO", Toast.LENGTH_SHORT).show();
            }
        });
            return nutriologoLiveData;
    }

    public MutableLiveData<List<Cita>> getListCitasNutriologo (String id_nutriologo){
        if(listCitasLiveData == null){
            listCitasLiveData = new MutableLiveData<>();
        }
        Call<CitaResponse> citalistResponseCall = apiServices.getListCitasNutriologo(id_nutriologo);
        citalistResponseCall.enqueue(new Callback<CitaResponse>() {
            @Override
            public void onResponse(Call<CitaResponse> call, Response<CitaResponse> response) {
                if(response.isSuccessful()){
                    listCitasLiveData.setValue(response.body().getCita());

                }else{
                    Toast.makeText(MyApp.getContext(), "Algo salio mal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CitaResponse> call, Throwable t) {
                Toast.makeText(MyApp.getContext(), "ERROR CITA NUTRIOLOGO", Toast.LENGTH_SHORT).show();
            }
        });
        return listCitasLiveData;
    }

    public MutableLiveData<List<Paciente>> getListPacientesClinica(String id_clinica){
        if(listPacienteLiveData == null){
            listPacienteLiveData = new MutableLiveData<>();
        }
        Call<PacienteResponse> pacienteResponseCall = apiServices.getListPacienteClinica(id_clinica);
        pacienteResponseCall.enqueue(new Callback<PacienteResponse>() {
            @Override
            public void onResponse(Call<PacienteResponse> call, Response<PacienteResponse> response) {
                if(response.isSuccessful()){
                    listPacienteLiveData.setValue(response.body().getPaciente());
                }else{
                    Toast.makeText(MyApp.getContext(), "Algo salio mal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<PacienteResponse> call, Throwable t) {
                Toast.makeText(MyApp.getContext(), "ERROR LIST PACIENTESCLINICA", Toast.LENGTH_SHORT).show();
            }
        });
        return listPacienteLiveData;
    }

    public MutableLiveData<Medida> getMedidaPaciente (String id_medida){
        if(medidaLiveData == null){
            medidaLiveData = new MutableLiveData<>();
        }
        Call<MedidaResponse> medidaResponseCall = apiServices.getMedidapaciente(id_medida);
        medidaResponseCall.enqueue(new Callback<MedidaResponse>() {
            @Override
            public void onResponse(Call<MedidaResponse> call, Response<MedidaResponse> response) {
                if(response.isSuccessful()){
                    medidaLiveData.setValue(response.body().getMedida().get(0));
                }else{
                    Toast.makeText(MyApp.getContext(), "Algo salio mal medida", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MedidaResponse> call, Throwable t) {
                    Toast.makeText(MyApp.getContext(), "ERROR MEDIDA", Toast.LENGTH_SHORT).show();
            }
        });
        return medidaLiveData;
    }

    public MutableLiveData<List<Alimento>> getListAlimentoPaciente (String id_paciente){
        if (listAlimentoLiveData == null){
            listAlimentoLiveData = new MutableLiveData<>();
        }
        Call<AlimentoResponse> alimentoResponseCall = apiServices.getAlimentoPaciente(id_paciente);
        alimentoResponseCall.enqueue(new Callback<AlimentoResponse>() {
            @Override
            public void onResponse(Call<AlimentoResponse> call, Response<AlimentoResponse> response) {
                if (response.isSuccessful()){
                        listAlimentoLiveData.setValue(response.body().getAlimento());
                }else {
                    Toast.makeText(MyApp.getContext(), "Algo salio mal listAlimentosPaciente", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<AlimentoResponse> call, Throwable t) {
                Toast.makeText(MyApp.getContext(), "ERROR listAlimentosPaciente", Toast.LENGTH_SHORT).show();
            }
        });
        return listAlimentoLiveData;
    }

    public void InsertPaciente(String nombre, String apPaterno, String apMaterno, String sexo,
                               String edad, String correo, String telefono, String padecimiento, String tipo,
                               String grado, String peso, String altura, String cintura, String cadera, String clinica){

      //GET ID_PACIENTE
        Call<PacienteResponse> pacienteResponseCall = apiServices.getListPaciente();
        pacienteResponseCall.enqueue(new Callback<PacienteResponse>() {
            @Override
            public void onResponse(Call<PacienteResponse> call, Response<PacienteResponse> response) {
                if(response.isSuccessful()){
                    int i = response.body().getPaciente().size()+1;
                    sizeListPacientes = Integer.toString(i);
                    String idPacientes = sizeListPacientes;
                    insertNamePac(sizeListPacientes,nombre,apPaterno,apMaterno,sexo,edad,correo,telefono,padecimiento,tipo,grado,peso,altura,cintura,cadera,
                            clinica);

                }
            }

            @Override
            public void onFailure(Call<PacienteResponse> call, Throwable t) {

            }
        });




    }

    private void insertNamePac(String idPaciente,String nombre, String apPaterno, String apMaterno, String sexo, String edad, String correo, String telefono, String padecimiento, String tipo, String grado, String peso, String altura, String cintura, String cadera, String clinica) {
        //GET ID_NAME_PACIENTE
        Call<NombrePacienteResponse> listResponseCall = apiServices.getListNamePacientes();
        listResponseCall.enqueue(new Callback<NombrePacienteResponse>() {
            @Override
            public void onResponse(Call<NombrePacienteResponse> call, Response<NombrePacienteResponse> response) {
                if(response.isSuccessful()){
                    sizeListNamePac = Integer.toString(response.body().getListName().size()+1);
                    String idNombrePac = sizeListNamePac;
                    String y = sizeListNamePac;
                    //INSERT PACIENTE
                    Call<NombrePacienteResponse> responseCall = apiServices.insertNamePaciente(sizeListNamePac,nombre,apPaterno,apMaterno);
                    responseCall.enqueue(new Callback<NombrePacienteResponse>() {
                        @Override
                        public void onResponse(Call<NombrePacienteResponse> call, Response<NombrePacienteResponse> response) {
                            if(response.isSuccessful()){
                                insertMedidas(idPaciente,sizeListNamePac,sexo,edad,correo,telefono,padecimiento,tipo,grado,peso,altura,cintura,cadera,
                                        clinica);
                            }else{
                                Toast.makeText(MyApp.getContext(), "algo salio mal insertNamePac", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<NombrePacienteResponse> call, Throwable t) {
                            Toast.makeText(MyApp.getContext(), "ERROR insertNamePac", Toast.LENGTH_SHORT).show();
                        }
                    });

                }else{
                    Toast.makeText(MyApp.getContext(), "sizeListName", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<NombrePacienteResponse> call, Throwable t) {
                Toast.makeText(MyApp.getContext(), " ERROR sizeListName", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void insertMedidas(String idPaciente, String idNamepac, String sexo, String edad, String correo, String telefono, String padecimiento, String tipo, String grado, String peso, String altura, String cintura, String cadera, String clinica) {
        // GET ID_MEDIDA
        Call<MedidaResponse> getSizeListName = apiServices.getListMedidas();
        getSizeListName.enqueue(new Callback<MedidaResponse>() {
            @Override
            public void onResponse(Call<MedidaResponse> call, Response<MedidaResponse> response) {
                if (response.isSuccessful()){
                    sizeListMedidas = Integer.toString(response.body().getMedida().size()+1);
                    // INSERT MEDIDA
                    String IMC = "00.00";
                    String ICC = "00.00";
                    Call<MedidaResponse> medidaResponseCall = apiServices.insertMedidas(sizeListMedidas,peso,cadera,cintura,altura,IMC,ICC);
                    medidaResponseCall.enqueue(new Callback<MedidaResponse>() {
                        @Override
                        public void onResponse(Call<MedidaResponse> call, Response<MedidaResponse> response) {
                            if (response.isSuccessful()){

                                getIdPadecimientos(idPaciente,idNamepac,sexo,edad,correo,telefono,padecimiento,tipo,grado,sizeListMedidas,clinica);

                            }else{
                                Toast.makeText(MyApp.getContext(), "algo sali mla insertMedida", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<MedidaResponse> call, Throwable t) {
                            Toast.makeText(MyApp.getContext(), "ERROR insertMedida", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
            @Override
            public void onFailure(Call<MedidaResponse> call, Throwable t) {

            }
        });

    }

    private void getIdPadecimientos(String idPaciente,String idPacPaciente, String sexo, String edad, String correo, String telefono, String padecimiento, String tipo, String grado, String sizeListMedidas, String clinica) {
        //ID_PADECIMIENTOS
        Call<PadecimientoResponse> padecimientoCall = apiServices.getListPadecimientos();
        padecimientoCall.enqueue(new Callback<PadecimientoResponse>() {
            @Override
            public void onResponse(Call<PadecimientoResponse> call, Response<PadecimientoResponse> response) {
                if (response.isSuccessful()) {
                    List<Padecimiento> listPadecimiento = response.body().getPadecimiento();
                    for (int i = 0; i < listPadecimiento.size(); i++) {
                        if (padecimiento.equals(listPadecimiento.get(i).getPadecimientos()) &&
                                tipo.equals(listPadecimiento.get(i).getTipo()) &&
                                grado.equals(listPadecimiento.get(i).getGrado())) {
                            IDPadecimiento = listPadecimiento.get(i).getIDPadecimiento();
                            break;
                        }

                    }

                    insertPaciente(idPaciente,idPacPaciente,sexo,edad,correo,telefono,IDPadecimiento,clinica,sizeListMedidas);

                }
            }
            @Override
            public void onFailure(Call<PadecimientoResponse> call, Throwable t) {

            }
        });

    }

    private void insertPaciente (String idPaciente, String idnombrePac, String sexo, String edad,
                              String correo, String telefono, String id_padecimiento, String id_clinica, String idMedidas){

     Call<Paciente> insertResponseCall = apiServices.insertPaciente(idPaciente,idnombrePac,sexo,
             edad,correo,telefono,id_padecimiento,id_clinica,
             idMedidas,"2");
     insertResponseCall.enqueue(new Callback<Paciente>() {
         @Override
         public void onResponse(Call<Paciente> call, Response<Paciente> response) {
             if (response.isSuccessful()){
                 Toast.makeText(MyApp.getContext(), "Paciente "+idPaciente+" agregado", Toast.LENGTH_SHORT).show();
             }else{
                 Toast.makeText(MyApp.getContext(), "algo salio mal INSERT PACIENTE", Toast.LENGTH_SHORT).show();
             }
         }
         @Override
         public void onFailure(Call<Paciente> call, Throwable t) {

         }
     });

 }

    public void insertAlimento(String nombre, String proteina, String grasa, String sodio, String carbos, String calorias,
                               String porcion, String grupoAlimenticio){

        Call<AlimentoResponse> alimentoResponseCall = apiServices.getListAliment();
        alimentoResponseCall.enqueue(new Callback<AlimentoResponse>() {
            @Override
            public void onResponse(Call<AlimentoResponse> call, Response<AlimentoResponse> response) {
                if(response.isSuccessful()){
                    String idAlimentos = Integer.toString(response.body().getAlimento().size()+1) ;
                    String Nivel ="2";
                    Call<AlimentoResponse> insertResponseCall = apiServices.insertAlimento(idAlimentos,nombre,porcion,proteina,grasa,sodio,carbos,calorias,Nivel,grupoAlimenticio);
                    insertResponseCall.enqueue(new Callback<AlimentoResponse>() {
                        @Override
                        public void onResponse(Call<AlimentoResponse> call, Response<AlimentoResponse> response) {
                            if (response.isSuccessful()){
                                Toast.makeText(MyApp.getContext(), "Alimento "+nombre+" agregado.", Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(MyApp.getContext(), "algo salio mal insertAlimento", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<AlimentoResponse> call, Throwable t) {
                            Toast.makeText(MyApp.getContext(), "ERROR insertAlimento", Toast.LENGTH_SHORT).show();
                        }
                    });
                }else{
                    Toast.makeText(MyApp.getContext(), "Algo salio mal list alimento", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<AlimentoResponse> call, Throwable t) {
                Toast.makeText(MyApp.getContext(), "ERROR LIST ALIMENTO", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void insertNutriologo(String email, String nombre, String apPaterno, String apMaterno, String password,String id_clinica,String cedula, String direccion,String telefono){
        Call<NutriologoResponse> nutriologoResponseCall = apiServices.getListNutriologo();
        nutriologoResponseCall.enqueue(new Callback<NutriologoResponse>() {
            @Override
            public void onResponse(Call<NutriologoResponse> call, Response<NutriologoResponse> response) {
                if (response.isSuccessful()){
                    String idNutriologo = Integer.toString(response.body().getNutriologo().size() + 1);
                    InsertNameNutriologo(idNutriologo,email,nombre,apPaterno,apMaterno,password,id_clinica,cedula,direccion,telefono);
                }
            }

            @Override
            public void onFailure(Call<NutriologoResponse> call, Throwable t) {

            }
        });
    }

    private void InsertNameNutriologo(String idNutriologo, String email, String nombre, String apPaterno, String apMaterno, String password, String id_clinica, String cedula, String direccion, String telefono) {
        Call<NombrePacienteResponse> nombreNutriologoResponseCall = apiServices.getListNameNutriologo();
        nombreNutriologoResponseCall.enqueue(new Callback<NombrePacienteResponse>() {
            @Override
            public void onResponse(Call<NombrePacienteResponse> call, Response<NombrePacienteResponse> response) {
                if(response.isSuccessful()){
                    String idNombreNutriologo = Integer.toString(response.body().getListName().size()+1);
                    Call<NutriologoResponse> nutriologoResponseCall = apiServices.insertNutriologo(idNutriologo,idNombreNutriologo,cedula,direccion,telefono,email,password,id_clinica);
                    nutriologoResponseCall.enqueue(new Callback<NutriologoResponse>() {
                        @Override
                        public void onResponse(Call<NutriologoResponse> call, Response<NutriologoResponse> response) {
                            if(response.isSuccessful()){
                                Toast.makeText(MyApp.getContext(), "Nutriologo agregado", Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(MyApp.getContext(), "algo salio mal insertNutriologo", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<NutriologoResponse> call, Throwable t) {

                        }
                    });
                    Call<NutriologoResponse> call1 = apiServices.insertNameNutriologo(idNombreNutriologo,nombre,apPaterno,apMaterno);
                    call1.enqueue(new Callback<NutriologoResponse>() {
                        @Override
                        public void onResponse(Call<NutriologoResponse> call, Response<NutriologoResponse> response) {
                            if(response.isSuccessful()){

                            }else{
                                Toast.makeText(MyApp.getContext(), "ERROR name", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<NutriologoResponse> call, Throwable t) {
                            Toast.makeText(MyApp.getContext(), "ERROR nameInsert", Toast.LENGTH_SHORT).show();
                        }
                    });
                }else{
                    Toast.makeText(MyApp.getContext(), "ERROR insertNutriologo", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<NombrePacienteResponse> call, Throwable t) {
                Toast.makeText(MyApp.getContext(), "ERROR getListNameNutriologo", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void insertNu(){

    }


    public void deleteNutriologo(String idNutriologo){
        Call<NutriologoResponse> nutriologoResponseCall = apiServices.deleteNutriologo(idNutriologo);
        nutriologoResponseCall.enqueue(new Callback<NutriologoResponse>() {
            @Override
            public void onResponse(Call<NutriologoResponse> call, Response<NutriologoResponse> response) {
                if (response.isSuccessful()){
                    Toast.makeText(MyApp.getContext(), "Nutriologo borrado", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MyApp.getContext(), "algo salio mal, deleteNutriologo", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<NutriologoResponse> call, Throwable t) {
                Toast.makeText(MyApp.getContext(), "ERROR deleteNutriologo", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void deleteNameNutriologo(String idNameNutriologo){
            Call<NombrePacienteResponse> nameResponseCall = apiServices.deleteNameNutriologo(idNameNutriologo);
            nameResponseCall.enqueue(new Callback<NombrePacienteResponse>() {
                @Override
                public void onResponse(Call<NombrePacienteResponse> call, Response<NombrePacienteResponse> response) {
                    if(response.isSuccessful()){

                    }else{
                        Toast.makeText(MyApp.getContext(), "algo salio mal deleteName", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<NombrePacienteResponse> call, Throwable t) {
                    Toast.makeText(MyApp.getContext(), "ERROR deleteName", Toast.LENGTH_SHORT).show();
                }
            });
    }

}
