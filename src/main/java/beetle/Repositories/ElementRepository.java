package beetle.Repositories;

import beetle.Entities.Element;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ElementRepository extends JpaRepository<Element,Long> {

    @Query("Select max(f.orderNo) from Element f")
    int getMaxOrderNo();

    Element findElementByOrderNo(int orderNo);

    List<Element> findAllByOrderNoAfter(int orderNo);

}
