    package com.jax.solucionactividadm2;

    import android.content.Intent;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.Button;
    import android.widget.EditText;

    import androidx.appcompat.app.AppCompatActivity;

    public class MainActivity extends AppCompatActivity {
        private EditText nombreEditText;
        private EditText fechaNacimientoEditText;
        private EditText telefonoEditText;
        private EditText emailEditText;
        private EditText descripcionEditText;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            // Obtener referencias de los campos de texto y botón
            nombreEditText = findViewById(R.id.editTextNombre);
            fechaNacimientoEditText = findViewById(R.id.editTextFechaNacimiento);
            telefonoEditText = findViewById(R.id.editTextTelefono);
            emailEditText = findViewById(R.id.editTextEmail);
            descripcionEditText = findViewById(R.id.editTextDescripcion);
            Button enviarButton = findViewById(R.id.buttonEnviar);

            // Obtener los datos ingresados del intent (si existen)
            Intent intent = getIntent();
            String nombre = intent.getStringExtra("nombre");
            String fechaNacimiento = intent.getStringExtra("fechaNacimiento");
            String telefono = intent.getStringExtra("telefono");
            String email = intent.getStringExtra("email");
            String descripcion = intent.getStringExtra("descripcion");

            // Si los datos existen, mostrarlos en los campos de texto
            if (nombre != null) {
                nombreEditText.setText(nombre);
            }
            if (fechaNacimiento != null) {
                fechaNacimientoEditText.setText(fechaNacimiento);
            }
            if (telefono != null) {
                telefonoEditText.setText(telefono);
            }
            if (email != null) {
                emailEditText.setText(email);
            }
            if (descripcion != null) {
                descripcionEditText.setText(descripcion);
            }

            enviarButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Obtener los datos ingresados por el usuario
                    String nombre = nombreEditText.getText().toString();
                    String fechaNacimiento = fechaNacimientoEditText.getText().toString();
                    String telefono = telefonoEditText.getText().toString();
                    String email = emailEditText.getText().toString();
                    String descripcion = descripcionEditText.getText().toString();

                    // Crear el intent para iniciar la ConfirmacionActivity
                    Intent intent = new Intent(MainActivity.this, ConfirmacionActivity.class);

                    // Pasar los datos ingresados como extras en el intent
                    intent.putExtra("nombre", nombre);
                    intent.putExtra("fechaNacimiento", fechaNacimiento);
                    intent.putExtra("telefono", telefono);
                    intent.putExtra("email", email);
                    intent.putExtra("descripcion", descripcion);

                    // Iniciar la ConfirmacionActivity
                    startActivity(intent);
                }
            });
        }
    }
