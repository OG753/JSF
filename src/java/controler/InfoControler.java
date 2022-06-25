/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import bean.Info;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import service.InfoFacade;

/**
 *
 * @author Ghizlane
 */
@Named
@RequestScoped
public class InfoControler {
    @EJB
    private InfoFacade If;
    
    private Integer id;
    private String nom;
    private String prenom;
    private int age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void save(){
    try
    {
    If.Save(id,nom, prenom, age);
    }catch(Exception e){
     throw new EJBException(e.getMessage());
    } 
   }
  
   public List<Info> findAll(){
     return If.findAll(); 
   }
   public Info find(){
     return If.find(id);
   }
   public void remove(Info i){
      If.remove(i);
   }
   public String updateView(Info i){
      this.id=i.getId();
      this.nom=i.getNom();
      this.prenom=i.getPrenom();
      this.age=i.getAge();
      return "Update";
   }
   public String update(){
       Info in=new Info(id,nom,prenom,age);
       If.edit(in);
       return "Form";
   }
  
}
