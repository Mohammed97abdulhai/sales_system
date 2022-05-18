package application.persistence.jpa;

import application.exceptions.ResourceNotFound;
import application.persistence.crud.SaleCrud;
import application.persistence.entities.Sale;
import application.persistence.repositories.SaleRepo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class JpaSaleRepoImp implements SaleRepo {

    SaleCrud saleCrud;


    @Override
    public Sale add(Sale sale) {
        return saleCrud.save(sale);
    }

    @Override
    public Sale find(Long id) {
        return saleCrud.findById(id).orElseThrow(() -> new ResourceNotFound("sale doesn't exist"));
    }

    @Override
    public List<Sale> findAll(Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return saleCrud.findAll(pageable).getContent();
    }
}
