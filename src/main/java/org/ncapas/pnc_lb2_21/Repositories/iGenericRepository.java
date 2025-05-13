package org.ncapas.pnc_lb2_21.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;


@NoRepositoryBean
public interface iGenericRepository<T,ID> extends JpaRepository<T, ID> {

/**EN T, va el nombre de la clase completa)**/
/** EN ID, va el TIPO DE DATO del id de la tabla(char,int,string,etc)**/

}
