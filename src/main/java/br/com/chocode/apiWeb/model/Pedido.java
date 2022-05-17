package br.com.chocode.apiWeb.model;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_pedido")
    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    public Pedido() {}

    public Pedido(Long id, LocalDate data, Cliente cliente) {
        this.id = id;
        this.data = data;
        this.cliente = cliente;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId(){
        return id;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalDate getData(){
        return data;
    }

    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }

    public Cliente getCliente(){
        return cliente;
    }

}

