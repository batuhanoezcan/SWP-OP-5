package infidb.AufgabeJPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class App 
{
    public static void main(String[] args)
    {
    // Create
//    	Person p = new Person();
//    	p.setAge(18);
//    	p.setFirstname("Alexander");
//    	p.setLastName("Widerin");
        EntityManagerFactory f = Persistence.createEntityManagerFactory("MyUnit");
        EntityManager manager = f.createEntityManager();
   //     manager.getTransaction().begin();
   //     manager.persist(p);
   //     manager.getTransaction().commit();        
        
   // Update and Read
//        Person p = manager.find(Person.class, 1L);
//        p.setFirstname("Alexander");
//        System.out.println(p.toString());
       
   // Delete     
//        Person p = manager.find(Person.class, 2L);
//        manager.getTransaction().begin();
//        manager.remove(p);
//        manager.getTransaction().commit();\
        
        Person p = manager.find(Person.class, 1L);
        System.out.println(p);
/*        Hobby h = new Hobby("Fussball", 10, 20.5);
       
        p.setHobby(h);
      
        System.out.println("New Hobby - before persist");
        System.out.println(h);
        
        manager.getTransaction().begin();
        manager.persist(h);
        manager.getTransaction().commit();
        
        System.out.println("New Hobby - after persist");
        System.out.println(h);
  */      
        
    }
}