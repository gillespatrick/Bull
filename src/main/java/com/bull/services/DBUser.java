/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bull.services;

import com.bull.models.Bhuser;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author gilles
 */
public class DBUser {

    /**
     * Get a user from database
     *
     * @param userID is a primary key
     * @return
     */
    public static Bhuser getUser(long userID) {
        EntityManager em = DBUtil.getEntityManager("Bullhorn");
        Bhuser user = em.find(Bhuser.class, userID);
        return user;

    }

    public static void insert(Bhuser bhUser) {
        EntityManager em = DBUtil.getEntityManager("Bullhorn");
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(bhUser);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();

        } finally {
            em.close();

        }

    }

    /**
     * Gets a Gravatar URL given the email and size          * in accordance
     * with Gravatar's requirements the email will be hashed with the MD5 hash
     * and returned as part of the url The url will also include the s=xx
     * attribute to request a Gravatar of a particular size. References:
     * <a href="http://www.gravatar.com">http://www.gravatar.com</>
     *
     * @param email - email of the user who's gravatar you want          
     *
     * @param size - indicates pixel height of the image to be returned. Height
     * and Width are same.          
     * @return - the gravatar URL. You can test it in a browser.
     *
     *          
     
    
    public static String getGravatarURL(String email,
            Integer size) {
        StringBuilder url = new StringBuilder();
        url.append("http://www.gravatar.com/avatar/");
         url.append(MD5Util.md5Hex(email));
        url.append("?s=" + size.toString());
        return url.toString();
    }
    
    */
    
     
    /**
     * Update the dataBHUser
     *
     * @param bhUser
     */
    public static void update(Bhuser bhUser) {
        EntityManager em = DBUtil.getEntityManager("Bullhorn");
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(bhUser);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void delete(Bhuser bhUser) {

        EntityManager em = DBUtil.getEntityManager("Bullhorn");
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.remove(em.merge(bhUser));
            trans.commit();

        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }

    }

    public static Bhuser getUserByEmail(String email) {
        EntityManager em = DBUtil.getEntityManager("Bullhorn");
        String qString = "Select u from Bhuser uwhere u.useremail=:useremail";
        TypedQuery<Bhuser> q = em.createQuery(qString,
                Bhuser.class
        );
        q.setParameter("useremail", email);
        Bhuser user = null;
        try {
            System.out.println("Getting single user");
            user = q.getSingleResult();
            System.out.println(user.getUsername());
        } catch (NoResultException e) {
            System.out.println(e);
        } finally {
            em.close();
        }
        return user;
    }

    public static boolean isValidUser(String userEmail,
            String userPassword) {
        EntityManager em = DBUtil.getEntityManager("Bullhorn");
        String qString = "Select count(b.bhuserid) fromBhuser b where b.useremail = :useremail and b.userpassword = :userpass";
        TypedQuery<Long> q
                = em.createQuery(qString, Long.class
                );
        boolean result = false;
        q.setParameter("useremail", userEmail);
        q.setParameter("userpass", userPassword);
        try {
            long userId = q.getSingleResult();
            if (userId > 0) {
                result = true;
            }
        } catch (Exception e) {
            result = false;
        } finally {
            em.close();
        }
        return result;
    }

}
