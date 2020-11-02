package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Partida {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int mandanteId;
	private int golsMandante;
	private int visitanteId;
	private int golsVisitante;
	private int campeonatoId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getMandanteId() {
		return mandanteId;
	}

	public void setMandanteId(int mandanteId) {
		this.mandanteId = mandanteId;
	}

	public int getGolsMandante() {
		return golsMandante;
	}

	public void setGolsMandante(int golsMandante) {
		this.golsMandante = golsMandante;
	}

	public int getVisitanteId() {
		return visitanteId;
	}

	public void setVisitanteId(int visitanteId) {
		this.visitanteId = visitanteId;
	}

	public int getGolsVisitante() {
		return golsVisitante;
	}

	public void setGolsVisitante(int golsVisitante) {
		this.golsVisitante = golsVisitante;
	}

	public int getCampeonatoId() {
		return campeonatoId;
	}

	public void setCampeonatoId(int campeonatoId) {
		this.campeonatoId = campeonatoId;
	}

	@Override
	public String toString() {
		return "Partida [id=" + id + ", mandanteId=" + mandanteId + ", golsMandante=" + golsMandante + ", visitanteId="
				+ visitanteId + ", golsVisitante=" + golsVisitante + ", campeonatoId=" + campeonatoId + "]";
	}

}
