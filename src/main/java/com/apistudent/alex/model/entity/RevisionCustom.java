package com.apistudent.alex.model.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

import com.apistudent.alex.domain.AuditListener;

/*
 * Classe base do sistema de tabela de auditoria (Database)
 */
@Entity(name = "revinfo_custom")
@RevisionEntity(AuditListener.class)
public class RevisionCustom{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "revision_sequence")
	@SequenceGenerator(name = "revision_sequence", sequenceName = "REVISION_SEQ")
	@RevisionNumber
	private Long revidionId;
	
	@RevisionTimestamp
	Date revisionDate;

	public RevisionCustom(Long revidionId, Date revisionDate) {
		this.revidionId = revidionId;
		this.revisionDate = revisionDate;
	}

	public RevisionCustom() {
		
	}

	public Long getRevidionId() {
		return revidionId;
	}

	public void setRevidionId(Long revidionId) {
		this.revidionId = revidionId;
	}

	public Date getRevisionDate() {
		return revisionDate;
	}

	public void setRevisionDate(Date revisionDate) {
		this.revisionDate = revisionDate;
	}

}
