package com.fileStorage.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "fileStorage")
public class FileEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "s_no")
	private int id;
	@Column(name = "DATA_INFO")
	private String dataInfo;
	@Column(name = "COST_INFO")
	private int costInfo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDataInfo() {
		return dataInfo;
	}

	public void setDataInfo(String dataInfo) {
		this.dataInfo = dataInfo;
	}

	public int getCostInfo() {
		return costInfo;
	}

	public void setCostInfo(int costInfo) {
		this.costInfo = costInfo;
	}

	@Override
	public String toString() {
		return "FileEntity [id=" + id + ", dataInfo=" + dataInfo + ", costInfo=" + costInfo + "]";
	}
}
