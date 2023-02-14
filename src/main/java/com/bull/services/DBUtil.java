
package com.bull.services;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author gilles
 */
public class DBUtil {

    public static EntityManager getEntityManager(String s) {

        return Persistence.createEntityManagerFactory(s).
                createEntityManager();

    }

}
