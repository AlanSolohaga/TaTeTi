package com.example.tateti;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class JuegoActivity extends AppCompatActivity {
    ImageView image11,image12,image13,image21,image22,image23,image31,image32,image33;
    int jugadorPar, jugadorImpar;
    int contador;
    boolean gana;
    String[] jugadores;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        image11 = findViewById(R.id.image11);
        image12 = findViewById(R.id.image12);
        image13 = findViewById(R.id.image13);
        image21 = findViewById(R.id.image21);
        image22 = findViewById(R.id.image22);
        image23 = findViewById(R.id.image23);
        image31 = findViewById(R.id.image31);
        image32 = findViewById(R.id.image32);
        image33 = findViewById(R.id.image33);
        jugadorPar = 0;
        jugadorImpar = 1;
        gana=false;
        contador=1;

        Bundle recibido = getIntent().getExtras();
        jugadores = recibido.getStringArray("jugadores");

        if(contador==1){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("EMPIEZA "+jugadores[0]).setTitle(" ").setIcon(R.drawable.circuloiron);
            AlertDialog dialog = builder.create();
            dialog.show();
        }


    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.image11:
                if(((BitmapDrawable)image11.getDrawable()).getBitmap()==((BitmapDrawable)getDrawable(R.drawable.fondo)).getBitmap()){
                    if(contador%2 == 0) {
                        image11.setImageDrawable(getResources().getDrawable(R.drawable.thanos));
                        contador++;
                       // Toast.makeText(this,"Turno de jugar impar mov:"+contador,Toast.LENGTH_SHORT).show();
                    }else{
                        image11.setImageDrawable(getResources().getDrawable(R.drawable.circuloiron));
                        contador++;
                     //   Toast.makeText(this,"Turno de jugar par mov:"+contador,Toast.LENGTH_SHORT).show();
                    }

                    if(contador>=5){
                        if ( //primera fila imagen11 = imagen 12 = imagen13
                                ((BitmapDrawable) image11.getDrawable()).getBitmap() == ((BitmapDrawable) image12.getDrawable()).getBitmap() &&
                                        ((BitmapDrawable) image11.getDrawable()).getBitmap() == ((BitmapDrawable) image13.getDrawable()).getBitmap()) {
                            gana = true;
                        } else {
                            if ( //DIAGONONAL imagen11 = imagen 22 = imagen 33
                                    ((BitmapDrawable) image11.getDrawable()).getBitmap() == ((BitmapDrawable) image22.getDrawable()).getBitmap() &&
                                            ((BitmapDrawable) image11.getDrawable()).getBitmap() == ((BitmapDrawable) image33.getDrawable()).getBitmap()) {
                                gana = true;
                            } else {
                                if ( //PRIEMRA COLUMNA imagen11=imagen21=imagen31
                                        ((BitmapDrawable) image11.getDrawable()).getBitmap() == ((BitmapDrawable) image21.getDrawable()).getBitmap() &&
                                                ((BitmapDrawable) image11.getDrawable()).getBitmap() == ((BitmapDrawable) image31.getDrawable()).getBitmap()) {
                                    gana = true;
                                }
                            }
                        }
                    }


                    if(gana==true){
                        contador--;
                        if(contador%2==0){
                            ganador(jugadorPar);
                        }else{
                            ganador(jugadorImpar);
                        }
                        //Toast.makeText(this,"GANO",Toast.LENGTH_LONG).show();
                        //finish();
                    }else{
                        if(contador==10){
                            empate();
                        }
                    }


                }
                break;

            case R.id.image12:
                if(((BitmapDrawable)image12.getDrawable()).getBitmap()==((BitmapDrawable)getDrawable(R.drawable.fondo)).getBitmap()) {
                    if(contador%2 == 0) {
                        image12.setImageDrawable(getResources().getDrawable(R.drawable.thanos));
                        contador++;
                        //Toast.makeText(this,"Turno de jugar impar mov:"+contador,Toast.LENGTH_SHORT).show();
                    }else{
                        image12.setImageDrawable(getResources().getDrawable(R.drawable.circuloiron));
                        contador++;
                       // Toast.makeText(this,"Turno de jugar par mov:"+contador,Toast.LENGTH_SHORT).show();
                    }


                    if(contador>=5){
                        // SI EL IMAGEN 11 ES DISTINTO DE VACIO
                        if(((BitmapDrawable)image11.getDrawable()).getBitmap()!=((BitmapDrawable)getDrawable(R.drawable.fondo)).getBitmap()){

                                //COLUMNA DEL MEDIO imagen12 imagen 22 imagen 23
                            if (((BitmapDrawable) image12.getDrawable()).getBitmap() == ((BitmapDrawable) image22.getDrawable()).getBitmap() &&
                                ((BitmapDrawable) image12.getDrawable()).getBitmap() == ((BitmapDrawable) image32.getDrawable()).getBitmap()) {
                                gana = true;
                            }else{      //primera fila imagen11 = imagen 12 = imagen13
                                if (((BitmapDrawable) image11.getDrawable()).getBitmap() == ((BitmapDrawable) image12.getDrawable()).getBitmap() &&
                                   ((BitmapDrawable) image11.getDrawable()).getBitmap() == ((BitmapDrawable) image13.getDrawable()).getBitmap()) {
                                    gana = true;
                                }
                            }
                        }else{ //COLUMNA DEL MEDIO UNICAMENTE
                            if (((BitmapDrawable) image12.getDrawable()).getBitmap() == ((BitmapDrawable) image22.getDrawable()).getBitmap() &&
                                    ((BitmapDrawable) image12.getDrawable()).getBitmap() == ((BitmapDrawable) image32.getDrawable()).getBitmap()) {
                                gana = true;
                            }

                        }
                    }

                    if(gana==true){
                        contador--;
                        if(contador%2==0){
                            ganador(jugadorPar);
                        }else{
                            ganador(jugadorImpar);
                        }
                        //Toast.makeText(this,"GANO",Toast.LENGTH_LONG).show();
                        //finish();
                    }else{
                        if(contador==10){
                            empate();
                        }
                    }

                }

                break;

             case R.id.image13:
                if(((BitmapDrawable)image13.getDrawable()).getBitmap()==((BitmapDrawable)getDrawable(R.drawable.fondo)).getBitmap()) {
                    if(contador%2 == 0) {
                        image13.setImageDrawable(getResources().getDrawable(R.drawable.thanos));
                        contador++;
                        //Toast.makeText(this,"Turno de jugar impar mov:"+contador,Toast.LENGTH_SHORT).show();
                    }else{
                        image13.setImageDrawable(getResources().getDrawable(R.drawable.circuloiron));
                        contador++;
                       // Toast.makeText(this,"Turno de jugar par mov:"+contador,Toast.LENGTH_SHORT).show();
                    }

                    if(contador>=5){
                        //SI IMAGE11 ES DISTINTO DE VACIO
                        if(((BitmapDrawable)image11.getDrawable()).getBitmap()!=((BitmapDrawable)getDrawable(R.drawable.fondo)).getBitmap()){
                            //TERCERA COLUMNA imagen 13 = imagen 23 = imagen 33
                            if (((BitmapDrawable) image13.getDrawable()).getBitmap() == ((BitmapDrawable) image23.getDrawable()).getBitmap() &&
                                            ((BitmapDrawable) image13.getDrawable()).getBitmap() == ((BitmapDrawable) image33.getDrawable()).getBitmap()) {
                                gana = true;
                            } else {
                                if ( //TERCERA DIAGONAL imagen 13 = imagen 22 = imagen 31
                                        ((BitmapDrawable) image13.getDrawable()).getBitmap() == ((BitmapDrawable) image22.getDrawable()).getBitmap() &&
                                                ((BitmapDrawable) image13.getDrawable()).getBitmap() == ((BitmapDrawable) image31.getDrawable()).getBitmap()) {
                                    gana = true;
                                }else{//PRIMERA FILA
                                    if (((BitmapDrawable) image11.getDrawable()).getBitmap() == ((BitmapDrawable) image12.getDrawable()).getBitmap() &&
                                            ((BitmapDrawable) image11.getDrawable()).getBitmap() == ((BitmapDrawable) image13.getDrawable()).getBitmap()) {
                                        gana = true;
                                    }

                                }
                            }

                        }
                        else{
                            //TERCERA COLUMNA imagen 13 = imagen 23 = imagen 33
                            if (((BitmapDrawable) image13.getDrawable()).getBitmap() == ((BitmapDrawable) image23.getDrawable()).getBitmap() &&
                                    ((BitmapDrawable) image13.getDrawable()).getBitmap() == ((BitmapDrawable) image33.getDrawable()).getBitmap()) {
                                gana = true;
                            } else {
                                if ( //TERCERA DIAGONAL imagen 13 = imagen 22 = imagen 31
                                        ((BitmapDrawable) image13.getDrawable()).getBitmap() == ((BitmapDrawable) image22.getDrawable()).getBitmap() &&
                                                ((BitmapDrawable) image13.getDrawable()).getBitmap() == ((BitmapDrawable) image31.getDrawable()).getBitmap()) {
                                    gana = true;
                                }
                            }

                        }
                        }

                    if(gana==true){
                        contador--;
                        if(contador%2==0){

                            ganador(jugadorPar);
                        }else{

                            ganador(jugadorImpar);
                        }
                        //Toast.makeText(this,"GANO",Toast.LENGTH_LONG).show();
                        //finish();
                    }else{
                        if(contador==10){
                            empate();
                        }
                    }
                }
                break;

            case R.id.image21:
                if(((BitmapDrawable)image21.getDrawable()).getBitmap()==((BitmapDrawable)getDrawable(R.drawable.fondo)).getBitmap()) {
                    if(contador%2 == 0) {
                        image21.setImageDrawable(getResources().getDrawable(R.drawable.thanos));
                        contador++;
                        //Toast.makeText(this,"Turno de jugar impar mov:"+contador,Toast.LENGTH_SHORT).show();
                    }else{
                        image21.setImageDrawable(getResources().getDrawable(R.drawable.circuloiron));
                        contador++;
                       // Toast.makeText(this,"Turno de jugar par mov:"+contador,Toast.LENGTH_SHORT).show();
                    }

                    if(contador>=5) {
                        //SI IMAGEN11 ES DISTINTO DE VACIO
                        if (((BitmapDrawable) image11.getDrawable()).getBitmap() != ((BitmapDrawable) getDrawable(R.drawable.fondo)).getBitmap()) {
                            //PRIMERA COLUMNA
                            if (((BitmapDrawable) image11.getDrawable()).getBitmap() == ((BitmapDrawable) image21.getDrawable()).getBitmap() &&
                                            ((BitmapDrawable) image11.getDrawable()).getBitmap() == ((BitmapDrawable) image31.getDrawable()).getBitmap()) {
                                gana = true;
                            } else {
                                if ( //FILA DEL MEDIO
                                        ((BitmapDrawable) image21.getDrawable()).getBitmap() == ((BitmapDrawable) image22.getDrawable()).getBitmap() &&
                                                ((BitmapDrawable) image21.getDrawable()).getBitmap() == ((BitmapDrawable) image23.getDrawable()).getBitmap()) {
                                    gana = true;
                                }
                            }
                        }else{
                            if ( //FILA DEL MEDIO
                                    ((BitmapDrawable) image21.getDrawable()).getBitmap() == ((BitmapDrawable) image22.getDrawable()).getBitmap() &&
                                            ((BitmapDrawable) image21.getDrawable()).getBitmap() == ((BitmapDrawable) image23.getDrawable()).getBitmap()) {
                                gana = true;
                            }

                        }
                    }

                    if(gana==true){
                        contador--;
                        if(contador%2==0){

                            ganador(jugadorPar);
                        }else{

                            ganador(jugadorImpar);
                        }
                        //Toast.makeText(this,"GANO",Toast.LENGTH_LONG).show();
                        //finish();
                    }else{
                        if(contador==10){
                            empate();
                        }
                    }
                }
                break;

            case R.id.image22:
                if(((BitmapDrawable)image22.getDrawable()).getBitmap()==((BitmapDrawable)getDrawable(R.drawable.fondo)).getBitmap()) {
                    if(contador%2 == 0) {
                        image22.setImageDrawable(getResources().getDrawable(R.drawable.thanos));
                        contador++;
                       // Toast.makeText(this,"Turno de jugar impar mov:"+contador,Toast.LENGTH_SHORT).show();
                    }else{
                        image22.setImageDrawable(getResources().getDrawable(R.drawable.circuloiron));
                        contador++;
                      //  Toast.makeText(this,"Turno de jugar par mov:"+contador,Toast.LENGTH_SHORT).show();
                    }


                    if(contador>=5){
                        if (((BitmapDrawable) image21.getDrawable()).getBitmap() == ((BitmapDrawable) image22.getDrawable()).getBitmap() &&
                                        ((BitmapDrawable) image21.getDrawable()).getBitmap() == ((BitmapDrawable) image23.getDrawable()).getBitmap()) {
                            gana = true;
                        } else {
                            if (((BitmapDrawable) image12.getDrawable()).getBitmap() == ((BitmapDrawable) image22.getDrawable()).getBitmap() &&
                                            ((BitmapDrawable) image12.getDrawable()).getBitmap() == ((BitmapDrawable) image32.getDrawable()).getBitmap()) {
                                gana = true;
                            }
                        }

                    }

                    if(gana==true){
                        contador--;
                        if(contador%2==0){

                            ganador(jugadorPar);
                        }else{

                            ganador(jugadorImpar);
                        }
                        //Toast.makeText(this,"GANO",Toast.LENGTH_LONG).show();
                        //finish();
                    }else{
                        if(contador==10){
                            empate();
                        }
                    }
                }
                break;

            case R.id.image23:
                if(((BitmapDrawable)image23.getDrawable()).getBitmap()==((BitmapDrawable)getDrawable(R.drawable.fondo)).getBitmap()) {
                    if(contador%2 == 0) {
                        image23.setImageDrawable(getResources().getDrawable(R.drawable.thanos));
                        contador++;
                       // Toast.makeText(this,"Turno de jugar impar mov:"+contador,Toast.LENGTH_SHORT).show();
                    }else{
                        image23.setImageDrawable(getResources().getDrawable(R.drawable.circuloiron));
                        contador++;
                       // Toast.makeText(this,"Turno de jugar par mov:"+contador,Toast.LENGTH_SHORT).show();
                    }

                    if(contador>=5){//TERCERA COLUMNA
                        if (((BitmapDrawable) image13.getDrawable()).getBitmap() == ((BitmapDrawable) image23.getDrawable()).getBitmap() &&
                                        ((BitmapDrawable) image13.getDrawable()).getBitmap() == ((BitmapDrawable) image33.getDrawable()).getBitmap()) {
                            gana = true;
                        } else {//FILA DEL MEDIO
                            if (((BitmapDrawable) image21.getDrawable()).getBitmap() == ((BitmapDrawable) image22.getDrawable()).getBitmap() &&
                                            ((BitmapDrawable) image21.getDrawable()).getBitmap() == ((BitmapDrawable) image23.getDrawable()).getBitmap()) {
                                gana = true;
                            }
                        }
                    }

                    if(gana==true){
                        contador--;
                        if(contador%2==0){

                            ganador(jugadorPar);
                        }else{

                            ganador(jugadorImpar);
                        }
                        //Toast.makeText(this,"GANO",Toast.LENGTH_LONG).show();
                        //finish();
                    }else{
                        if(contador==10){
                            empate();
                        }
                    }
                }
                break;

            case R.id.image31:
                if(((BitmapDrawable)image31.getDrawable()).getBitmap()==((BitmapDrawable)getDrawable(R.drawable.fondo)).getBitmap()) {
                    if(contador%2 == 0) {
                        image31.setImageDrawable(getResources().getDrawable(R.drawable.thanos));
                        contador++;
                       // Toast.makeText(this,"Turno de jugar impar mov:"+contador,Toast.LENGTH_SHORT).show();
                    }else{
                        image31.setImageDrawable(getResources().getDrawable(R.drawable.circuloiron));
                        contador++;
                       // Toast.makeText(this,"Turno de jugar par mov:"+contador,Toast.LENGTH_SHORT).show();
                    }

                    if(contador>=5){
                        //SI LA IMAGEN11 ES DISTINTO DE VACIO
                        if(((BitmapDrawable) image11.getDrawable()).getBitmap() != ((BitmapDrawable) getDrawable(R.drawable.fondo)).getBitmap()){
                            if ( //primera COLUMNA
                                    ((BitmapDrawable) image11.getDrawable()).getBitmap() == ((BitmapDrawable) image21.getDrawable()).getBitmap() &&
                                            ((BitmapDrawable) image11.getDrawable()).getBitmap() == ((BitmapDrawable) image31.getDrawable()).getBitmap()) {
                                gana = true;
                            } else { //TERCERA DIAGONAL
                                if (((BitmapDrawable) image13.getDrawable()).getBitmap() == ((BitmapDrawable) image22.getDrawable()).getBitmap() &&
                                                ((BitmapDrawable) image13.getDrawable()).getBitmap() == ((BitmapDrawable) image31.getDrawable()).getBitmap()) {
                                    gana = true;
                                } else {//ULTIMA FILA
                                    if (((BitmapDrawable) image31.getDrawable()).getBitmap() == ((BitmapDrawable) image32.getDrawable()).getBitmap() &&
                                                    ((BitmapDrawable) image31.getDrawable()).getBitmap() == ((BitmapDrawable) image33.getDrawable()).getBitmap()) {
                                        gana = true;
                                    }
                                }
                            }

                        }else{
                            //TERCERA DIAGONAL
                            if (((BitmapDrawable) image13.getDrawable()).getBitmap() == ((BitmapDrawable) image22.getDrawable()).getBitmap() &&
                                    ((BitmapDrawable) image13.getDrawable()).getBitmap() == ((BitmapDrawable) image31.getDrawable()).getBitmap()) {
                                gana = true;
                            } else {//ULTIMA FILA
                                if (((BitmapDrawable) image31.getDrawable()).getBitmap() == ((BitmapDrawable) image32.getDrawable()).getBitmap() &&
                                        ((BitmapDrawable) image31.getDrawable()).getBitmap() == ((BitmapDrawable) image33.getDrawable()).getBitmap()) {
                                    gana = true;
                                }
                            }
                        }

                    }


                    if(gana==true){
                        contador--;
                        if(contador%2==0){

                            ganador(jugadorPar);
                        }else{

                            ganador(jugadorImpar);
                        }
                        //Toast.makeText(this,"GANO",Toast.LENGTH_LONG).show();
                        //finish();
                    }else{
                        if(contador==10){
                            empate();
                        }
                    }
                }
                break;

            case R.id.image32:
                if(((BitmapDrawable)image32.getDrawable()).getBitmap()==((BitmapDrawable)getDrawable(R.drawable.fondo)).getBitmap()) {
                    if(contador%2 == 0) {
                        image32.setImageDrawable(getResources().getDrawable(R.drawable.thanos));
                        contador++;
                        //Toast.makeText(this,"Turno de jugar impar mov:"+contador,Toast.LENGTH_SHORT).show();
                    }else{
                        image32.setImageDrawable(getResources().getDrawable(R.drawable.circuloiron));
                        contador++;
                        //Toast.makeText(this,"Turno de jugar par mov:"+contador,Toast.LENGTH_SHORT).show();
                    }

                    if(contador>=5){
                        //SI LA IMAGEN31 ES DISTINTO DE VACIO
                        if(((BitmapDrawable) image31.getDrawable()).getBitmap() != ((BitmapDrawable) getDrawable(R.drawable.fondo)).getBitmap()){
                            //ultima fila
                            if (((BitmapDrawable) image31.getDrawable()).getBitmap() == ((BitmapDrawable) image32.getDrawable()).getBitmap() &&
                                    ((BitmapDrawable) image31.getDrawable()).getBitmap() == ((BitmapDrawable) image33.getDrawable()).getBitmap()) {
                                gana = true;
                            } else { //COLUMNA DEL MEDIO
                                if (((BitmapDrawable) image12.getDrawable()).getBitmap() == ((BitmapDrawable) image22.getDrawable()).getBitmap() &&
                                        ((BitmapDrawable) image12.getDrawable()).getBitmap() == ((BitmapDrawable) image32.getDrawable()).getBitmap()) {
                                    gana = true;
                                }
                            }

                        }else{ //COLUMNA DEL MEDIO
                            if (((BitmapDrawable) image12.getDrawable()).getBitmap() == ((BitmapDrawable) image22.getDrawable()).getBitmap() &&
                                    ((BitmapDrawable) image12.getDrawable()).getBitmap() == ((BitmapDrawable) image32.getDrawable()).getBitmap()) {
                                gana = true;
                            }

                        }

                    }


                    if(gana==true){
                        contador--;
                        if(contador%2==0){
                            ganador(jugadorPar);
                        }else{

                            ganador(jugadorImpar);
                        }
                        //Toast.makeText(this,"GANO",Toast.LENGTH_LONG).show();
                        //finish();
                    }else{
                        if(contador==10){
                            empate();
                        }
                    }
                }
                break;

            case R.id.image33:
                if(((BitmapDrawable)image33.getDrawable()).getBitmap()==((BitmapDrawable)getDrawable(R.drawable.fondo)).getBitmap()) {
                    if(contador%2 == 0) {
                        image33.setImageDrawable(getResources().getDrawable(R.drawable.thanos));
                        contador++;
                        //Toast.makeText(this,"Turno de jugar impar mov:"+contador,Toast.LENGTH_SHORT).show();
                    }else{
                        image33.setImageDrawable(getResources().getDrawable(R.drawable.circuloiron));
                        contador++;
                        //Toast.makeText(this,"Turno de jugar par mov:"+contador,Toast.LENGTH_SHORT).show();
                    }
                    if(contador>=5){
                        //ULTIMA FILA
                        if (((BitmapDrawable) image31.getDrawable()).getBitmap() == ((BitmapDrawable) image32.getDrawable()).getBitmap() &&
                                        ((BitmapDrawable) image31.getDrawable()).getBitmap() == ((BitmapDrawable) image33.getDrawable()).getBitmap()) {
                            gana = true;
                        } else {
                            if ( //DIAGONONAL imagen11 = imagen 22 = imagen 33
                                    ((BitmapDrawable) image11.getDrawable()).getBitmap() == ((BitmapDrawable) image22.getDrawable()).getBitmap() &&
                                            ((BitmapDrawable) image11.getDrawable()).getBitmap() == ((BitmapDrawable) image33.getDrawable()).getBitmap()) {
                                gana = true;
                            } else {
                                if ( //ULTIMA COLUMNA
                                        ((BitmapDrawable) image13.getDrawable()).getBitmap() == ((BitmapDrawable) image23.getDrawable()).getBitmap() &&
                                                ((BitmapDrawable) image13.getDrawable()).getBitmap() == ((BitmapDrawable) image33.getDrawable()).getBitmap()) {
                                    gana = true;
                                }
                            }
                        }

                    }



                    if(gana==true){
                        contador--;
                        if(contador%2==0){
                            ganador(jugadorPar);
                        }else{
                            ganador(jugadorImpar);
                        }
                        //Toast.makeText(this,"GANO",Toast.LENGTH_LONG).show();
                        //finish();
                    }else{
                        if(contador==10){
                            empate();
                        }
                    }
                }
                break;

        }
    }

    private void empate() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("EMPATE");
        AlertDialog alert = builder.create();
        alert.show();
        limpiar();
    }

    private void limpiar() {
        image11.setImageDrawable(getResources().getDrawable(R.drawable.fondo));
        image12.setImageDrawable(getResources().getDrawable(R.drawable.fondo));
        image13.setImageDrawable(getResources().getDrawable(R.drawable.fondo));
        image21.setImageDrawable(getResources().getDrawable(R.drawable.fondo));
        image22.setImageDrawable(getResources().getDrawable(R.drawable.fondo));
        image23.setImageDrawable(getResources().getDrawable(R.drawable.fondo));
        image31.setImageDrawable(getResources().getDrawable(R.drawable.fondo));
        image32.setImageDrawable(getResources().getDrawable(R.drawable.fondo));
        image33.setImageDrawable(getResources().getDrawable(R.drawable.fondo));
        contador=1;
        gana =false;
    }

    private void ganador(int jugador) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        if(jugador == 0){
            builder.setMessage("\t THE WINNER IS "+jugadores[1]).setTitle(" ").setIcon(R.drawable.thanos);
        }else{
            builder.setMessage("\t THE WINNER IS "+jugadores[0]).setTitle(" ").setIcon(R.drawable.circuloiron);
        }
        builder.setPositiveButton("VOLVER", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

}