package com.rstudio.carroapp;

public class Carro {
    private String name;
    private String marca;
    private String modelo;
    private Double velocidade;
    private Byte marcha;
    private Short ano;

    public Carro() {
        this.velocidade = 0d;
        this.marcha = 0;
    }

    public Carro(String name, String marca, String modelo) {
        this.name = name;
        this.marca = marca;
        this.modelo = modelo;
        this.velocidade = 0d;
    }

    public Boolean turbo() {
        if (this.getVelocidade() <= 90.0) {
            do {
                this.setVelocidade(this.getVelocidade() + 10);
                mudarMarcha();
            } while (this.getVelocidade() <= 90.0);
            return true;
        } else {
            return false;
        }
    }

    public Boolean stop() {
        if (this.getVelocidade() > 0) {
            do {
                this.setVelocidade(this.getVelocidade() - 10);
                mudarMarcha();
            } while (this.getVelocidade() > 0);
            return true;
        } else {
            return false;
        }
    }

    public Boolean speedUp() {
        if (this.getVelocidade() < 100) {
            this.setVelocidade(this.getVelocidade() + 10);
            mudarMarcha();
            return true;
        } else {
            return false;
        }
    }

    public Boolean brake() {
        if (this.getVelocidade() > 0) {
            this.setVelocidade(this.getVelocidade() - 10);
            mudarMarcha();
            return true;
        } else {
            this.setVelocidade(0d);
            return false;
        }
    }

    private void mudarMarcha() {
        if (this.velocidade == 0) {
            this.setMarcha((byte) 0);
        } else if (this.getVelocidade() <= 20) {
            this.setMarcha((byte) 1);
        } else if (this.getVelocidade() > 20 && this.getVelocidade() <= 40) {
            this.setMarcha((byte) 2);
        } else if (this.getVelocidade() > 40 && this.getVelocidade() <= 60) {
            this.setMarcha((byte) 3);
        } else if (this.getVelocidade() > 60 && this.getVelocidade() <= 80) {
            this.setMarcha((byte) 4);
        } else {
            this.setMarcha((byte) 5);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Double getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(Double velocidade) {
        this.velocidade = velocidade;
    }

    public Byte getMarcha() {
        return marcha;
    }

    public void setMarcha(Byte marcha) {
        this.marcha = marcha;
    }

    public Short getAno() {
        return ano;
    }

    public void setAno(Short ano) {
        this.ano = ano;
    }
}
