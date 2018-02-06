package br.com.athens.services;

import java.util.Calendar;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.athens.domains.AbstractEntity;


public abstract class AbstractService<T extends AbstractEntity> {

	public abstract CrudRepository<T, Long> getRepository();
	
	public Iterable<T> getAll(){
		return  getRepository().findAll();
	}
	
	public T findById(Long id){
		return getRepository().findOne(id);
	}
	
	@Transactional
	public T save(T entity){		
		if (entity.getDataCadastro() == null){
			entity.setDataCadastro(Calendar.getInstance().getTime());
		}		
		if (entity.getId() != null && entity.getId() > 0) {
			T entity_ = this.findById(entity.getId());
			entity.setVersion(entity_.getVersion());
			entity.setId(entity_.getId());
		}
		
		return getRepository().save(entity);
	}
	
	@Transactional
	public Boolean delete(Long id){
		if (id > 0){
			T entity = getRepository().findOne(id);
			entity.setStatusExcluido(true);
			getRepository().save(entity);
			return true;
		}
		return false;
	}
}
