package com.infnet.ghproperty.handler;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiError {
    private Integer status;
    private Date dataHora;
    private String titulo;
    private List<Campo> campos;

    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public Date getDataHora() {
        return dataHora;
    }
    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public List<Campo> getCampos() {
        return campos;
    }
    public void setCampos(List<Campo> campos) {
        this.campos = campos;
    }



    public static class Campo {

        private String nome;
        private String mensagem;

        public Campo(String nome, String mensagem) {
            this.nome = nome;
            this.mensagem = mensagem;
        }
        public String getNome() {
            return nome;
        }
        public String getMensagem() {
            return mensagem;
        }
    }
}
