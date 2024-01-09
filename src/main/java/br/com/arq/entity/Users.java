package br.com.arq.entity;



import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class Users {

	private static DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUser;
	private String username;
	@Column(unique = true)
	private String email;
	private String password;
	private LocalDate birthDate;

	@OneToMany(mappedBy = "users",cascade= {CascadeType.ALL})
	private List<Perfil> perfis;	

	public Users(UsersBuilder builder) {
		this.idUser = builder.idUser;
		this.username = builder.username;
		this.email = builder.email;
		this.password = builder.password;
		this.birthDate = builder.birthDate;
		this.perfis = builder.perfis;
	}

	@Override
	public String toString() {
		return "Users [idUser=" + idUser + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", birthDate=" + dateFormat.format(birthDate) + "]";
	}

	public Long getIdUser() {
		return idUser;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}
	
	
	

	public List<Perfil> getPerfis() {
		return perfis;
	}




	public static class UsersBuilder {

		private Long idUser;
		private String username;
		private String email;
		private String password;
		private LocalDate birthDate;
		private List<Perfil> perfis;	
		
		public UsersBuilder idUser(Long idUser) {
			this.idUser = idUser;
			return this;
		}

		public UsersBuilder username(String username) {
			this.username = username;
			return this;
		}

		public UsersBuilder email(String email) {
			this.email = email;
			return this;
		}

		public UsersBuilder password(String password) {
			this.password = password;
			return this;
		}

		public UsersBuilder birthDate(LocalDate birthDate) {
			this.birthDate = birthDate;
			return this;
		}
		
		public UsersBuilder perfis(List<Perfil> perfis) {
			if (perfis ==null) {
				this.perfis = new ArrayList<Perfil>();
			}
			this.perfis.addAll(perfis);
			return this;
		}
		

		public Users build() {
			return new Users(this);
		}

	}

}
