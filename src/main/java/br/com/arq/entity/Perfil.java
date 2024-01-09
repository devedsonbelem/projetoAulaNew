package br.com.arq.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "perfil")
public class Perfil {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPerfil;
	private String role;
	private String status;
	@ManyToOne
	@JoinColumn(columnDefinition ="user_id",referencedColumnName = "idUser")
	private Users users;
	
	
	public Perfil() {
		 
	}
	
	
	public Perfil(Long idPerfil, String role, String status) {
		super();
		this.idPerfil = idPerfil;
		this.role = role;
		this.status = status;
	}
	

	@Override
	public String toString() {
		return "Perfil [idPerfil=" + idPerfil + ", role=" + role + ", status=" + status + "]";
	}


	public Long getIdPerfil() {
		return idPerfil;
	}
	public void setIdPerfil(Long idPerfil) {
		this.idPerfil = idPerfil;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
