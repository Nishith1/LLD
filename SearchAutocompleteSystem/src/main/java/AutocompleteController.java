import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AutocompleteController {
    @Autowired
    AutocompleteService autocompleteService;

    @GetMapping("/suggest")
    public List<String> getSuggestions(@RequestParam String prefix) {
        return autocompleteService.getSuggestions(prefix);
    }
}
