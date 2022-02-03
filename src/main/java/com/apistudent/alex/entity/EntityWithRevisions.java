package com.apistudent.alex.entity;

public class EntityWithRevisions<T> {
	
	private RevisionCustom revision;
	
	private T entidade;

	public EntityWithRevisions(RevisionCustom revision, T entidade) {
		this.revision = revision;
		this.entidade = entidade;
	}

	public EntityWithRevisions() {
		
	}

	public RevisionCustom getRevision() {
		return revision;
	}

	public void setRevision(RevisionCustom revision) {
		this.revision = revision;
	}

	public T getEntidade() {
		return entidade;
	}

	public void setEntidade(T entidade) {
		this.entidade = entidade;
	}	

}
