package com.rstudio.carroapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Carro carro = null;
    Byte imgAtual = 0;

    String[] nomesCarros = {
            "Mercedes",
            "Zodiac",
            "Ford GT",
            "Corsair",
            "Mustang",
            "Mercury Cougar",
            "Lincoln Continental"
    };

    String[] marcasCarros = {
            "Mercedes-Benz",
            "Ford Motor Company",
            "Lincoln"
    };

    private EditText nomeCarro;
    private EditText marcaCarro;
    private EditText modeloCarro;
    private TextView velocimetro;
    private TextView marcha;
    private Button btnParar;
    private Button btnTurbo;
    private Button btnCriarCarro;
    private Button btnAcelerar;
    private Button btnFrear;
    private ImageView img;
    private EditText ano;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nomeCarro = findViewById(R.id.carNameId);
        marcaCarro = findViewById(R.id.brandId);
        modeloCarro = findViewById(R.id.modelId);
        velocimetro = findViewById(R.id.speedometerId);
        btnParar = findViewById(R.id.btnStopId);
        btnTurbo = findViewById(R.id.btnTurboId);
        btnCriarCarro = findViewById(R.id.btnCriarCarro);
        btnAcelerar = findViewById(R.id.btnAcelerarId);
        btnFrear = findViewById(R.id.btnFrearId);
        img = findViewById(R.id.imageId);
        marcha = findViewById(R.id.marchaId);
        ano = findViewById(R.id.anoId);

        nomeCarro.setText(nomesCarros[0]);
        marcaCarro.setText(marcasCarros[0]);

        btnCriarCarro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (carro == null) {
                    carro = new Carro();
                    carro.setName(nomeCarro.getText().toString());
                    carro.setMarca(marcaCarro.getText().toString());
                    carro.setModelo(modeloCarro.getText().toString());

                    if (!ano.getText().toString().isEmpty()) {
                        carro.setAno(Short.parseShort(ano.getText().toString()));
                    }

                    Toast.makeText(getBaseContext(), R.string.carro_criado_sucesso,
                            Toast.LENGTH_LONG).show();

                    velocimetro.append(" " + carro.getVelocidade());
                    marcha.append(" " + carro.getMarcha());
                    velocimetro.setVisibility(View.VISIBLE);
                    marcha.setVisibility(View.VISIBLE);

                    btnCriarCarro.setText(R.string.deletar_carro);
                } else {
                    deleteCar();
                }
            }
        });

        btnTurbo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (carro != null) {
                    if (carro.turbo()) {
                        velocimetro.setText(R.string.velocimetro);
                        velocimetro.append(" " + carro.getVelocidade());
                        marcha.setText(R.string.marcha);
                        marcha.append(" " + carro.getMarcha());
                    } else {
                        Toast.makeText(getBaseContext(), R.string.carro_esta_na_velocidade_maxima,
                                Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getBaseContext(), R.string.crie_um_carro,
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnParar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (carro != null) {
                    if (carro.stop()) {
                        velocimetro.setText(R.string.velocimetro);
                        velocimetro.append(" " + carro.getVelocidade());
                        marcha.setText(R.string.marcha);
                        marcha.append(" " + carro.getMarcha());
                    } else {
                        Toast.makeText(getBaseContext(), R.string.carro_parado,
                                Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getBaseContext(), R.string.crie_um_carro,
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnFrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (carro != null) {
                    if (carro.brake()) {
                        velocimetro.setText(R.string.velocimetro);
                        velocimetro.append(" " + carro.getVelocidade());
                        marcha.setText(R.string.marcha);
                        marcha.append(" " + carro.getMarcha());
                    } else {
                        Toast.makeText(MainActivity.this, R.string.carro_parado,
                                Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getBaseContext(), R.string.crie_um_carro,
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnAcelerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (carro != null) {
                    if (carro.speedUp()) {
                        velocimetro.setText(R.string.velocimetro);
                        velocimetro.append(" " + carro.getVelocidade());
                        marcha.setText(R.string.marcha);
                        marcha.append(" " + carro.getMarcha());
                    } else {
                        Toast.makeText(getBaseContext(), R.string.carro_esta_na_velocidade_maxima,
                                Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getBaseContext(), R.string.crie_um_carro,
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        img.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
                return false;
            }
        });
    }

    private void deleteCar() {
        new AlertDialog.Builder(MainActivity.this)
                .setTitle(R.string.aviso)
                .setIcon(R.mipmap.ic_warning)
                .setMessage("Deseja excluir o carro " + carro.getName() + "?")
                .setNegativeButton(R.string.cancelar, null)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        carro = null;
                        velocimetro.setText(R.string.velocimetro);
                        marcha.setText(R.string.marcha);
                        btnCriarCarro.setText(R.string.criar_carro);
                        velocimetro.setVisibility(View.INVISIBLE);
                        marcha.setVisibility(View.INVISIBLE);
                    }
                })
                .create()
                .show();
    }

    public void imgClick(View view) {

        byte totalImg = 7;
        Drawable drawable;
        Random random = new Random();
        int proximaImg = random.nextInt(totalImg);

        if (imgAtual == proximaImg) {
            do {
                proximaImg = random.nextInt(totalImg);
            } while (imgAtual == proximaImg);
        }
        imgAtual = (byte) proximaImg;

        if (proximaImg == 0) {
            drawable = getResources().getDrawable(R.drawable.mercedes);
        } else if (proximaImg == 1) {
            drawable = getResources().getDrawable(R.drawable.ford_zodiac);
        } else if (proximaImg == 2) {
            drawable = getResources().getDrawable(R.drawable.ford_gt);
        } else if (proximaImg == 3) {
            drawable = getResources().getDrawable(R.drawable.ford_corsair_with_boat);
        } else if (proximaImg == 4) {
            drawable = getResources().getDrawable(R.drawable.ford_mustang_fastback);
        } else if (proximaImg == 5) {
            drawable = getResources().getDrawable(R.drawable.mercury_cougar);
        } else {
            drawable = getResources().getDrawable(R.drawable.lincoln_continental);
        }
        img.setImageDrawable(drawable);
        setCarDetails(proximaImg);
    }

    private void setCarDetails(int pos) {
        if (pos == 0) {
            nomeCarro.setText(nomesCarros[0]);
            marcaCarro.setText(marcasCarros[0]);
        } else if (pos == 1) {
            nomeCarro.setText(nomesCarros[1]);
            marcaCarro.setText(marcasCarros[1]);
        } else if (pos == 2) {
            nomeCarro.setText(nomesCarros[2]);
            marcaCarro.setText(marcasCarros[1]);
        } else if (pos == 3) {
            nomeCarro.setText(nomesCarros[3]);
            marcaCarro.setText(marcasCarros[1]);
        } else if (pos == 4) {
            nomeCarro.setText(nomesCarros[4]);
            marcaCarro.setText(marcasCarros[1]);
        } else if (pos == 5) {
            nomeCarro.setText(nomesCarros[5]);
            marcaCarro.setText(marcasCarros[1]);
        } else {
            nomeCarro.setText(nomesCarros[6]);
            marcaCarro.setText(marcasCarros[2]);
        }
    }
}
