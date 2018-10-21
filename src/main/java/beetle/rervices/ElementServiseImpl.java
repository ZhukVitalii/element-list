package beetle.rervices;

import beetle.entities.Element;
import beetle.repositories.ElementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
public class ElementServiseImpl implements ElementServise {
    @Autowired
    private ElementRepository elementRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Element> findAllElements() {
        return elementRepository.findAll();
    }

    @Override
    @Transactional
    public void saveElement(String text) {
        elementRepository.save(new Element(text, elementRepository.getMaxOrderNo()!= null ?elementRepository.getMaxOrderNo() + 1 : 1));
    }

    @Override
    @Transactional
    public void updateElement(Long id, String text) {
        Element element = elementRepository.getOne(id);
        element.setText(text);
        elementRepository.save(element);
    }

    @Override
    @Transactional
    public void changeOrder(Long id, boolean isUp) {
        Element element = elementRepository.getOne(id);
        Element subElement = elementRepository.findElementByOrderNo(isUp ? element.getOrderNo() - 1 : element.getOrderNo() + 1);
        if (subElement != null) {
            element.setOrderNo(isUp ? element.getOrderNo() - 1 : element.getOrderNo() + 1);
            subElement.setOrderNo(isUp ? subElement.getOrderNo() + 1 : subElement.getOrderNo() - 1);
            elementRepository.save(Arrays.asList(element, subElement));
        }
    }

    @Override
    @Transactional
    public void deleteElement(Long id) {
        List<Element> elements = elementRepository.findAllByOrderNoAfter(elementRepository.findOne(id).getOrderNo());
        for (Element element : elements) {
            element.setOrderNo(element.getOrderNo() - 1);
        }
        elementRepository.save(elements);
        elementRepository.delete(id);
    }

}
