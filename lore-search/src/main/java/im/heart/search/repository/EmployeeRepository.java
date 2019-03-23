package im.heart.search.repository;

import im.heart.search.entity.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface EmployeeRepository extends  ElasticsearchCrudRepository<Employee, Long> ,ElasticsearchRepository<Employee, Long> {
}
