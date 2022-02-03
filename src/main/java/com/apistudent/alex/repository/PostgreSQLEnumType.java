package com.apistudent.alex.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.type.EnumType;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;

/*
 * Classe de configuração de conexão de coluna do tipo ENUM Java Hibernate com PostgresSQL
 */
public class PostgreSQLEnumType extends EnumType  {

	private static final long serialVersionUID = 1L;

	public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session) 
        throws HibernateException, SQLException {
		
        if(value == null) {
            st.setNull(index, Types.OTHER);
        }
        else {
            st.setObject(index, value.toString(), Types.OTHER);
        }
    }

}
