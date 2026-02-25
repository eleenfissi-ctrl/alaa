package com.alaa.parfum.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alaa.entities.Parfum;
import com.alaa.parfum.service.ParfumService;

@Controller
public class ParfumController {
   
   @Autowired
ParfumService parfumService;
@RequestMapping("/ListeProduits")
public String listeProduits(ModelMap modelMap,
@RequestParam (name="page",defaultValue = "0") int page,
@RequestParam (name="size", defaultValue = "2") int size)
{ Page<Parfum> prods = parfumService.getAllParfumsParPage(page, size);
modelMap.addAttribute("parfums", prods);
modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
modelMap.addAttribute("currentPage", page);
return "listeParfums";
}
@RequestMapping("/showCreate")
public String showCreate()
{
return "createParfum";
}
@RequestMapping("/saveParfum")
public String saveParfum(@ModelAttribute("parfum") Parfum parfum,
@RequestParam("date") String date,
ModelMap modelMap) throws ParseException
{
//conversion de la date
SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
Date dateCreation = dateformat.parse(String.valueOf(date));
parfum.setDateCreation(dateCreation);
Parfum saveParfum = parfumService.saveParfum(parfum);
String msg ="parfum enregistré avec Id "+saveParfum.getIdParfum();
modelMap.addAttribute("msg", msg);
return "createParfum";
}
@RequestMapping("/supprimerParfum")
public String supprimerParfum(@RequestParam("id") Long id,
ModelMap modelMap)
{
parfumService.deleteParfumById(id);
List<Parfum> p = parfumService.getAllParfums();
modelMap.addAttribute("parfums", p);
return "listeParfums";
}
@RequestMapping("/modifierParfum")
public String editerParfum(@RequestParam("id") Long id,
ModelMap modelMap)
{
Parfum p= parfumService.getParfum(id);
modelMap.addAttribute("parfum", p);
return "editerParfum";
}
@RequestMapping("/updateParfum")
public String updateParfum(@ModelAttribute("parfum") Parfum parfum, @RequestParam("date") String date,
ModelMap modelMap) throws ParseException
{
//conversion de la date
SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
Date dateCreation = dateformat.parse(String.valueOf(date));
parfum.setDateCreation(dateCreation);
parfumService.updateParfum(parfum);
List<Parfum> prods = parfumService.getAllParfums();
modelMap.addAttribute("parfums", prods);
return "listeParfums";
}
}
