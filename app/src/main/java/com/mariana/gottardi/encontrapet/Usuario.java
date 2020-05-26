package com.mariana.gottardi.encontrapet;

import android.util.Log;

public class Usuario {


        private long idUsuario;
        private String nome;
        private String nomePet;
        private String racaPet;

        public Usuario() {
        }

        public Usuario(Long idUsuario, String nome, String nomePet, String racaPet) {
            this.idUsuario = idUsuario;
            this.nome = nome;
            this.nomePet= nomePet;
            this.racaPet=racaPet;
        }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

    public String getNomePet() {
        return nomePet;
    }

    public void setNomePet(String nomePet) {
        this.nomePet = nomePet;
    }

    public String getRacaPet() {
        return racaPet;
    }

    public void setRacaPet(String racaPet) {
        this.racaPet = racaPet;
    }

    @Override
        public String toString() {
            return
                    "nome=" + nome +
                            "idUsuario=" + idUsuario +
                            "\nnomePet=" + nomePet +
                            "\nracaPet=" + racaPet;
        }
}
