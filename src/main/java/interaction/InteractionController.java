package interaction;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InteractionController
{
    private long counter = 0;
    private static final String template = "Hello, %s!";

    @RequestMapping("/greeting")
    public Startup startup(@RequestParam(value="name", defaultValue="World") String name)
    {
        return new Startup(counter++, String.format(template, name));
    }
}