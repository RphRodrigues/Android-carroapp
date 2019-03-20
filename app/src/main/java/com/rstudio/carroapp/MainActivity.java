package com.rstudio.carroapp;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Carro car = null;
    Random random = new Random();
    Integer currentImg = 0;

    private EditText name;
    private EditText brand;
    private EditText model;
    private TextView speedometer;
    private Button stop;
    private Button turbo;
    private Button criarCarro;
    private Button speedUp;
    private Button brake;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.carNameId);
        brand = findViewById(R.id.brandId);
        model = findViewById(R.id.modelId);
        speedometer = findViewById(R.id.speedometerId);
        stop = findViewById(R.id.btnStopId);
        turbo = findViewById(R.id.btnTurboId);
        criarCarro = findViewById(R.id.btnCriarCarro);
        speedUp = findViewById(R.id.btnAcelerarId);
        brake = findViewById(R.id.btnFrearId);
        img = findViewById(R.id.imageId);

        criarCarro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (car == null) {
                    if (!name.getText().toString().isEmpty()) {
                        car = new Carro();
                        car.setName(name.getText().toString());
                        car.setMarca(brand.getText().toString());
                        car.setModelo(model.getText().toString());

                        Toast.makeText(getBaseContext(), "Car created successfully",
                                Toast.LENGTH_LONG).show();

                        speedometer.setText(R.string.speedometer);
                        speedometer.append(" " + car.getVelocidade() + "                                               " +
                                "Marcha: " + car.getMarcha());
                        speedometer.setVisibility(View.VISIBLE);
                    } else {
                        Toast.makeText(getApplicationContext(), "Car name is empty",
                                Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "The car " + car.getName() +
                            " has already been created", Toast.LENGTH_SHORT).show();
                }
            }
        });

        turbo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (car != null) {
                    if (car.turbo()) {
                        speedometer.setText(R.string.speedometer);
                        speedometer.append(" " + car.getVelocidade() + "                                               " +
                                "Marcha: " + car.getMarcha());
                    } else {
                        Toast.makeText(getBaseContext(), "The car is at full speed",
                                Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getBaseContext(), "Enter the car data",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (car != null) {
                    if (car.stop()) {
                        speedometer.setText(R.string.speedometer);
                        speedometer.append(" " + car.getVelocidade() + "                                               " +
                                "Marcha: " + car.getMarcha());
                    } else {
                        Toast.makeText(getBaseContext(), "The car is stopped",
                                Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getBaseContext(), "Enter the car data",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        brake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (car != null) {
                    if (car.brake()) {
                        speedometer.setText(R.string.speedometer);
                        speedometer.append(" " + car.getVelocidade() + "                                               " +
                                "Marcha: " + car.getMarcha());
                    } else {
                        Toast.makeText(MainActivity.this, "The car is stopped",
                                Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getBaseContext(), "Enter the car data",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        speedUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (car != null) {
                    if (car.speedUp()) {
                        speedometer.setText(R.string.speedometer);
                        speedometer.append(" " + car.getVelocidade() + "                                               " +
                                "Marcha: " + car.getMarcha());
                    } else {
                        Toast.makeText(getBaseContext(), "The car is at full speed",
                                Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getBaseContext(), "Enter the car data",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void imgClick(View view) {

        Drawable drawable;
        int nextImg = random.nextInt(7);

        if (currentImg == nextImg) {
            do {
                nextImg = random.nextInt(4);
            } while (currentImg == nextImg);
        }
        currentImg = nextImg;

        if (nextImg == 0) {
            drawable = getResources().getDrawable(R.drawable.mercedes);
        } else if (nextImg == 1) {
            drawable = getResources().getDrawable(R.drawable.ford_zodiac);
        } else if (nextImg == 2) {
            drawable = getResources().getDrawable(R.drawable.ford_gt);
        } else if (nextImg == 3) {
            drawable = getResources().getDrawable(R.drawable.ford_corsair_with_boat);
        } else if (nextImg == 4) {
            drawable = getResources().getDrawable(R.drawable.ford_mustang_fastback);
        } else if (nextImg == 5) {
            drawable = getResources().getDrawable(R.drawable.mercury_cougar);
        } else {
            drawable = getResources().getDrawable(R.drawable.lincoln_continental);
        }
        img.setImageDrawable(drawable);
    }
}
