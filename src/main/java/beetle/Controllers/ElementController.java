package beetle.Controllers;

import beetle.Entities.Element;
import beetle.Services.MainServise;
import beetle.json.UpdateInputJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ElementController {
    @Autowired
    private MainServise mainServise;

    @RequestMapping("/")
    public String showElements(Model model) {

        List<Element> elements = getElements();
        elements.sort(Element::compareTo);
        model.addAttribute("elements", elements );
        return "index";
    }

//    @RequestMapping("/update-table")
//    public String updateElements(Model model) {
//
//        List<Element> elements = getElements();
//        elements.sort(Element::compareTo);
//        model.addAttribute("elements", elements );
//        return "table";
//    }
    @RequestMapping(value="/save",  method = RequestMethod.POST)
    public ResponseEntity<Void> saveElement( @RequestBody String text) {
        mainServise.saveElement(text);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(value="/update", method = RequestMethod.POST)
    public ResponseEntity<Void> updateElement(Model model,UpdateInputJSON input) {

        mainServise.updateElement(input.getId(), input.getText());

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(value="/delete/{id}",  method = RequestMethod.POST)
    public ResponseEntity<Void> deleteElement(@PathVariable(value = "id") Long id ) {

        mainServise.deleteElement(id);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(value="/move-up/{id}",  method = RequestMethod.POST)
    public ResponseEntity<Void> moveUp(@PathVariable(value = "id") Long id ) {

        mainServise.changeOrder(id, true);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(value="/move-down/{id}",  method = RequestMethod.POST)
    public String moveDown(Model model,@PathVariable(value = "id") Long id ) {

        mainServise.changeOrder(id, false);
        List<Element> elements = getElements();
        elements.sort(Element::compareTo);
        elements.get(2).setText("PISKAAAAAAAAAAAA");
        model.addAttribute("elements", elements );
        return "table";
    }

    private List<Element> getElements(){
        return mainServise.findAllElements();
    }

}
