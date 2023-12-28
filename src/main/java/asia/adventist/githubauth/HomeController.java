package asia.adventist.githubauth;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.stream.Collectors;

@Controller
public class HomeController {

    @GetMapping(path = "/")
    public String home(){
        return "home";
    }
    @GetMapping(path = "/webapp")
    public String webapp(Model model, Authentication auth){

        var roleNames = auth.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        model.addAttribute("roleNames", roleNames);
        //return "index";
        return "webapp";
    }

}
