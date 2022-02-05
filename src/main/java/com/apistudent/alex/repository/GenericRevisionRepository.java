package com.apistudent.alex.repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.apistudent.alex.model.entity.EntityWithRevisions;
import com.apistudent.alex.model.entity.RevisionCustom;

@Repository
@Transactional
public class GenericRevisionRepository<T> {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<EntityWithRevisions<T>> listRevisions(Long id, Class<T> tipo){
		
		AuditReader auditReader = AuditReaderFactory.get(entityManager);
		List<Number> idRevisions = auditReader.getRevisions(tipo, id);
		List<EntityWithRevisions<T>> allRevisions = new ArrayList<>();
		
		Map<Number, RevisionCustom> revisions = auditReader.findRevisions(RevisionCustom.class, new HashSet<Number>(idRevisions));
		
		for (Number revision : idRevisions) {
			T listRevisions = auditReader.find(tipo, id, revision);
			RevisionCustom rev = revisions.get(revision);
			auditReader.findRevisions(RevisionCustom.class, new HashSet<Number>(idRevisions));
			allRevisions.add(new EntityWithRevisions(new RevisionCustom(rev.getRevidionId(), rev.getRevisionDate()), listRevisions));
		}		
		return allRevisions;
	}

}
