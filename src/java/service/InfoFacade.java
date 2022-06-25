/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import bean.Info;

/**
 *
 * @author Ghizlane
 */
@Stateless
public class InfoFacade extends AbstractFacade<Info> {

    @PersistenceContext(unitName = "ExamplePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InfoFacade() {
        super(Info.class);
    }
    
    public void Save(Integer id,String nom, String prenom, int age){
        try{
         Info inf=new Info(id,nom,prenom,age);
         em.persist(inf);
        }catch(Exception e){
            throw new EJBException(e.getMessage());
        }
    }
    
}
