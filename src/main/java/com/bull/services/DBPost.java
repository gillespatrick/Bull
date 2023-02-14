/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bull.services;

import com.bull.models.Bhpost;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

/**
 *
 * @author gilles
 */
public class DBPost {

    public static void insert(Bhpost bhpost) {
        EntityManager em = DBUtil.getEntityManager("Bullhorn");
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(bhpost);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            trans.rollback();
        } finally {
            em.close();
        }

    }

    public static void update(Bhpost bhpost) {

        EntityManager em = DBUtil.getEntityManager("Bullhorn");
        EntityTransaction trans = em.getTransaction();

        try {
            trans.begin();
            em.merge(bhpost);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void delete(Bhpost bhpost) {

        EntityManager em = DBUtil.getEntityManager("Bullhorn");
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.remove(bhpost);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }

    }

    public static List<Bhpost> bhPost() {

        EntityManager em = DBUtil.getEntityManager("Bullhorn");
        
        
        String qString ="select b from Bhpost b";
        List<Bhpost> posts = null;

        try {
           TypedQuery<Bhpost> query = em.createQuery(qString,Bhpost.class);
           posts = query.getResultList();
        } catch (Exception e) {
            System.out.println(e);
           e.printStackTrace();
        } finally {
            em.close();
        }
        return posts;

    }
    
    
    
    
    public static List<Bhpost> postsOfUser(long userid){
        
         EntityManager em = DBUtil.getEntityManager("Bullhorn");
       
        
        String qString ="select b from Bhpost b where b.bhuser.bhuserid = :userid";
        List<Bhpost> userposts = null;

        try {
           TypedQuery<Bhpost> query = em.createQuery(qString,Bhpost.class);
           query.setParameter("userid",userid);
          userposts = query.getResultList();
        } catch (Exception e) {
            System.out.println(e);
           e.printStackTrace();
        } finally {
            em.close();
        }
        return userposts;

    }
    
    
    
    public static List<Bhpost> postsOfUser(String useremail){
        
         EntityManager em = DBUtil.getEntityManager("Bullhorn");
       
        
        String qString ="select b from Bhpost b where b.bhuser.useremail = :useremail";
        List<Bhpost> userposts = null;

        try {
           TypedQuery<Bhpost> query = em.createQuery(qString,Bhpost.class);
           query.setParameter("useremail",useremail);
          userposts = query.getResultList();
        } catch (Exception e) {
            System.out.println(e);
           e.printStackTrace();
        } finally {
            em.close();
        }
        return userposts;

    }
    
    
    
     public static List<Bhpost> searchPosts(String search){
        
         EntityManager em = DBUtil.getEntityManager("Bullhorn");
       
        
        String qString ="select b from Bhpost b where b.posttext like :search";
        List<Bhpost> searchposts = null;

        try {
           TypedQuery<Bhpost> query = em.createQuery(qString,Bhpost.class);
           query.setParameter("search","%"+ search+ "%");
          searchposts  = query.getResultList();
        } catch (Exception e) {
            System.out.println(e);
           e.printStackTrace();
        } finally {
            em.close();
        }
        return searchposts;

    }
    
        
    
}
