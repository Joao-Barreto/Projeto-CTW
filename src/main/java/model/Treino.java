package model;

import java.sql.Date;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Treino {

	@Id
	@GeneratedValue
	private long id;
	
	private String titulo;
	private String local;
	private Date duracao;
	private int lotacao;
	private Collection<String> preRequisitos;
	private long formadorId;
}
