package com.esime.nutrisimios_bd.Data;

import com.esime.nutrisimios_bd.Data.model.Nutriologo;
import com.esime.nutrisimios_bd.Data.model.Paciente;
import com.esime.nutrisimios_bd.Data.model.Response.AlimentoResponse;
import com.esime.nutrisimios_bd.Data.model.Response.CitaResponse;
import com.esime.nutrisimios_bd.Data.model.Response.MedidaResponse;
import com.esime.nutrisimios_bd.Data.model.Response.NombrePacienteResponse;
import com.esime.nutrisimios_bd.Data.model.Response.NutriologoResponse;
import com.esime.nutrisimios_bd.Data.model.Response.PacienteResponse;
import com.esime.nutrisimios_bd.Data.model.Response.PadecimientoResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiServices {
    //ALIMENTO
        @GET("getListAlimento.php")
        Call<AlimentoResponse> getListAliment();

        @GET("getListAlimentoPaciente.php?")
        Call<AlimentoResponse> getAlimentoPaciente(@Query("ID_Paciente") String id_paciente);

        @GET("InsertAlimento.php?")
        Call<AlimentoResponse> insertAlimento(
                @Query("ID_Alimento") String ID_Alimento,
                @Query("Nombre") String Nombre,
                @Query("Porcion") String Porcion,
                @Query("Proteina") String Proteina,
                @Query("Grasas") String Grasas,
                @Query("Sodio") String Sodio,
                @Query("Carbohidratos") String Carbohidratos,
                @Query("Calorias") String Calorias,
                @Query("ID_Nv_Ali") String ID_Nv_Ali,
                @Query("ID_Gr_Ali") String ID_Gr_Ali);


    //NUTRIOLOGO
        @GET("validateNutriologo.php?")
        Call<NutriologoResponse> validateNutriologo (@Query("ID_Nutriologo") String nutriologo);

        @GET("getListNutriologos.php")
        Call<NutriologoResponse> getListNutriologo ();

        @GET("nameNutriologo.php")
        Call<NombrePacienteResponse> getListNameNutriologo();

        @GET("insertNameNutriologo.php?")
        Call<NutriologoResponse> insertNameNutriologo(
                @Query("ID_Nom_nut") String ID_Nom_nut,
                @Query("Nombre_nut") String Nombre_nut,
                @Query("Ape_pat_nut") String Ape_pat_nut,
                @Query("Ape_mat_nut") String Ape_mat_nut
        );

        @GET("insertNutriologo.php?")
        Call<NutriologoResponse> insertNutriologo(
                @Query("ID_Nutriologo") String ID_Nutriologo,
                @Query("ID_Nom_nut_nut") String ID_Nom_nut_nut,
                @Query("Cedula") String Cedula,
                @Query("Direccion") String Direccion,
                @Query("Telefono") String Telefono,
                @Query("correo") String correo,
                @Query("password") String password,
                @Query("ID_Cli_nut") String ID_Cli_nut
        );

    //CITAS
        @GET("getListCitas.php")
        Call<CitaResponse> getListCitas();

        @GET("getListCitasNutriologo.php?")
        Call<CitaResponse> getListCitasNutriologo(@Query("ID_Nutriologo") String id_nutriologo);


  //PACIENTES
        @GET("user.php")
        Call<PacienteResponse> getListPaciente();

        @GET("getListUser_Clinica.php?")
        Call<PacienteResponse> getListPacienteClinica(@Query("ID_Clinica") String id_clinica);

        @GET("InsertUser.php?")
        Call<Paciente> insertPaciente (
                @Query("ID_Pacientes") String id_Pacientes,
                @Query("ID_Nom_pac_pac") String ID_Nom_pac_pac,
                @Query("Sexo") String Sexo,
                @Query("Edad") String Edad,
                @Query("Correo") String Correo,
                @Query("Telefono") String Telefono,
                @Query("ID_Pad_Pac") String ID_Pad_Pac,
                @Query("ID_Cli_Pac") String ID_Cli_Pac,
                @Query("ID_Med_Pac") String ID_Med_Pac,
                @Query("ID_Ava_Pac") String ID_Ava_Pac
        );

        @GET("ListNameUser.php")
         Call<NombrePacienteResponse> getListNamePacientes();

        @GET("InsertNameUser.php?")
        Call<NombrePacienteResponse> insertNamePaciente
                (@Query("ID_Nom_pac") String id_nombrepaciente, @Query("Nombre_pac") String Nombre,
                 @Query("Ape_pat_pac") String apPaterno, @Query("Ape_mat_pac") String apMaterno);
 //MEDIDAS
        @GET("medidas.php")
         Call<MedidaResponse> getListMedidas ();

        @GET("InsertMedidas.php?")
        Call<MedidaResponse> insertMedidas (
                @Query("ID_Medidas") String id_medidas,
                @Query("Peso") String peso,
                @Query("Cadera") String cadera,
                @Query("Cintura") String cintura,
                @Query("Talla") String talla,
                @Query("IMC") String IMC,
                @Query("ICC") String ICC
        );

    @GET("getMedidaPaciente.php?")
    Call<MedidaResponse> getMedidapaciente (@Query("ID_Medida") String id_Medida);

  //PADECIMIENTOS
        @GET("padecimientos.php")
        Call<PadecimientoResponse> getListPadecimientos ();


}
