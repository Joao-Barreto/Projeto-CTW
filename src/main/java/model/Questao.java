package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Questao {

	@Id
	@GeneratedValue
	private long id;
	
	private String questao;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getQuestao() {
		return questao;
	}

	public void setQuestao(String questao) {
		this.questao = questao;
	}
	
}
