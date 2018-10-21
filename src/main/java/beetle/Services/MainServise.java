package beetle.Services;

import beetle.Entities.Element;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MainServise {

    List<Element> findAllElements();

    void saveElement(String text);

    void updateElement(Long id, String text);

    void changeOrder(Long id, boolean isUp);

    void deleteElement(Long id);
}