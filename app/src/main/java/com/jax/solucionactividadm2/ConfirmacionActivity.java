package com.jax.solucionactividadm2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class ConfirmacionActivity extends AppCompatActivity {
    private TextView nombreTextView;
    private TextView fechaNacimientoTextView;
    private TextView telefonoTextView;
    private TextView emailTextView;
    private TextView descripcionTextView;
    private Button editarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion);

        // Obtener referencias de los campos de texto y botón
        nombreTextView = findViewById(R.id.textViewNombre);
        fechaNacimientoTextView = findViewById(R.id.textViewFechaNacimiento);
        telefonoTextView = findViewById(R.id.textViewTelefono);
        emailTextView = findViewById(R.id.textViewEmail);
        descripcionTextView = findViewById(R.id.textViewDescripcion);
        editarButton = findViewById(R.id.buttonEditar);

        // Obtener los datos ingresados del intent
        Intent intent = getIntent();
        String nombre = intent.getStringExtra("nombre");
        String fechaNacimiento = intent.getStringExtra("fechaNacimiento");
        String telefono = intent.getStringExtra("telefono");
        String email = intent.getStringExtra("email");
        String descripcion = intent.getStringExtra("descripcion");

        // Mostrar los datos en los campos de texto
        nombreTextView.setText(nombre);
        fechaNacimientoTextView.setText(fechaNacimiento);
        telefonoTextView.setText(telefono);
        emailTextView.setText(email);
        descripcionTextView.setText(descripcion);

        editarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear el intent para regresar a la actividad anterior (MainActivity)
                Intent intent = new Intent(ConfirmacionActivity.this, MainActivity.class);

                // Pasar los datos ingresados como extras en el intent
                intent.putExtra("nombre", nombre);
                intent.putExtra("fechaNacimiento", fechaNacimiento);
                intent.putExtra("telefono", telefono);
                intent.putExtra("email", email);
                intent.putExtra("descripcion", descripcion);

                // Iniciar la actividad MainActivity con los datos precargados en los campos
                startActivity(intent);
            }
        });
    }
}

