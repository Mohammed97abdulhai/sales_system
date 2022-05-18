package application.persistence.repositories;

import application.persistence.entities.Sale;

import java.util.List;

public interface SaleRepo {

    Sale add(Sale sale);

    Sale find(Long id);

    List<Sale> findAll(Integer pageNo, Integer pageSize);
}
