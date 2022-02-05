package com.apistudent.alex.domain;

import org.hibernate.envers.RevisionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.apistudent.alex.model.entity.RevisionCustom;

/*
 * Classe encarregada de adicionar atributos na tabela de auditoria (Database)
 */
public class AuditListener implements RevisionListener {
	
	Logger logger = LoggerFactory.getLogger(AuditListener.class);

	@Override
	public void newRevision(Object revisionEntity) {
		
		RevisionCustom revEntity = (RevisionCustom) revisionEntity;		
		logger.info(revEntity.toString());
	}

}
