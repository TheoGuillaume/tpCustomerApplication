/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import fr.grin.tpcustomerapplication.Customer;
import java.util.List;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

/**
 *Façade pour gérer les Customers.
 * @author theo
 */
@RequestScoped
public class CustomerManager {
    
    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;
    
    /**
     * get customers
     * @return 
     */
    public List<Customer> getAllCustomers() {
        Query query = em.createNamedQuery("Customer.findAll");
        return query.getResultList();  
    }  

    /**
     * Mise à jour customer 
     * @param customer les champs a metre jour 
     * @return 
     */
    @Transactional
    public Customer update(Customer customer) {
      return em.merge(customer);  
    } 
    
    @Transactional
    public void persist(Customer customer) {
       em.persist(customer);
    }
}
